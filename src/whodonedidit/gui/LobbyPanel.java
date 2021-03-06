package whodonedidit.gui;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JPanel;
import whodonedidit.version1_0.ClientLobby;
import whodonedidit.version1_0.LobbyPlayer;
import whodonedidit.version1_0.OfflineClientLobby;
import whodonedidit.version1_0.OnlineClientLobby;
import whodonedidit.version1_0.Player;
import whodonedidit.version1_0.Table;
import whodonedidit.version1_0.ViewBuilder;

/**
 *
 * @author Tyler Wong
 */
public class LobbyPanel extends javax.swing.JPanel implements Observer
{

    private String title;
    private MainFrame frame;
    private static final int numButtons = 2;
    private JButton[] buttons = new JButton[2];
    private ArrayList<JPanel> panels = new ArrayList<JPanel>();
    private ArrayList<ComputerPlayerPanel> computerPanels = new ArrayList<ComputerPlayerPanel>();
    private ArrayList<HumanPlayerPanel> humanPanels = new ArrayList<HumanPlayerPanel>();
    private int currIndex = 0;
    private boolean isOnline;
    private String userName;
    private boolean isHost;
    private int playerCount = 0;
    private int computerCount = 0;
    private static final int kCompCountOffline = 4;
    private ClientLobby clientLobby;
    private static final Color kRed = new Color(255, 0, 0);

    /**
     * Creates new form LobbyPanel
     */
    public LobbyPanel(MainFrame frame, String userName, boolean isOnline)
    {
        this.userName = userName;
        this.isOnline = isOnline;
        this.frame = frame;
        if (this.isOnline) 
        {
            this.clientLobby = new OnlineClientLobby(this.userName);
            ((OnlineClientLobby) clientLobby).addObserver(this);
        }
        else 
        {
            this.clientLobby = new OfflineClientLobby(this.userName);
            ((OfflineClientLobby) clientLobby).addObserver(this);
        }
        
        setTitle();
        initComponents();
        packComponents();
        singlePlayerAddPlayers();
        multiPlayerAddPlayers();
        this.connectionLabel.setText("No Connection.");
        this.connectionLabel.setForeground(kRed);
        clientLobby.addPlayer(LobbyPlayer.Descriptor.Human);
    }

    private void packComponents()
    {
        this.buttons[0] = this.backButton;
        this.buttons[1] = this.startButton;
        this.panels.add(this.player1Panel);
        this.panels.add(this.player2Panel);
        this.panels.add(this.player3Panel);
        this.panels.add(this.player4Panel);
        this.panels.add(this.player5Panel);
    }

    private void singlePlayerAddPlayers()
    {
        if (!this.isOnline) 
        {
            this.panels.get(0).add(new HumanPlayerPanel(this, this.userName, false));
            for (int i = 0; i < kCompCountOffline; i++)
                this.computerPanels.add(new ComputerPlayerPanel(this, "Computer " + (i + 1), false, false, true, "Beginner"));
            this.panels.get(1).add(this.computerPanels.get(0));
            this.panels.get(2).add(this.computerPanels.get(1));
            this.panels.get(3).add(this.computerPanels.get(2));
            this.panels.get(4).add(this.computerPanels.get(3));
            this.startButton.setEnabled(false);
        }
    }

    private void multiPlayerAddPlayers()
    {
        if (this.isOnline) 
        {
            this.panels.get(0).add(new HumanPlayerPanel(this, this.userName, this.isHost));
            for (int i = 0; i < kCompCountOffline; i++)
                this.computerPanels.add(new ComputerPlayerPanel(this, "Computer " + (i + 1), false, false, this.isHost, "Beginner"));
            this.panels.get(1).add(this.computerPanels.get(0));
            this.panels.get(2).add(this.computerPanels.get(1));
            this.panels.get(3).add(this.computerPanels.get(2));
            this.panels.get(4).add(this.computerPanels.get(3));
            this.startButton.setEnabled(false);
        }
    }

    private void setTitle()
    {
        if (this.isOnline) 
        {
            this.title = "Multiplayer Lobby";
        }
        else 
        {
            this.title = "Single Player Lobby";
        }
    }

    public void addComputerPlayer(String difficulty, String userName)
    {
        LobbyPlayer.Descriptor descriptor =
                               LobbyPlayer.Descriptor.ComputerBeginner;

        switch (difficulty) 
        {
            case "Beginner":
                descriptor = LobbyPlayer.Descriptor.ComputerBeginner;
                break;
            case "Intermediate":
                descriptor = LobbyPlayer.Descriptor.ComputerIntermediate;
                break;
            case "Advanced":
                descriptor = LobbyPlayer.Descriptor.ComputerAdvanced;
                break;
            default:
                break;
        }
        this.clientLobby.addComputerPlayer(descriptor, userName);
    }

    public void removeComputerPlayer(String name)
    {
        this.clientLobby.removePlayer(name);
    }

    public void setIsHost(boolean isHost)
    {
        this.isHost = isHost;
    }

    public void setOnline(boolean isOnline)
    {
        this.isOnline = isOnline;
    }

    public void setName(String name)
    {
        this.userName = name;
    }

    public String getScreenName()
    {
        return this.userName;
    }

    public JButton getStartButton()
    {
        return this.startButton;
    }

    public JButton getBackButton()
    {
        return this.backButton;
    }

    public void setStartEnabled(boolean isEnabled)
    {
        this.startButton.setEnabled(isEnabled);
    }

    /**
     * This is called when there is a change to the list of lobby players or the
     * game has started.
     *
     * @param obs the ClientLobby object that is observed
     * @param arg the object that has changed for the lobby panel. This can be
     * either a table which will mean the game is starting or a list of players
     * which means the list has been updated
     */
    @Override
    public void update(Observable obs, Object arg)
    {
        this.connectionLabel.setText("");
        //IF arg is a list of lobbyPlayers
        if (arg instanceof List<?>) 
        {
            int computerIndex = 0;
            this.computerCount = 0;
            
            List<LobbyPlayer> lobbyPlayers = (List<LobbyPlayer>) arg;
            
            if (lobbyPlayers.size() == 1) 
            {
                this.isHost = true;
            }
            //remove the current list of lobbyPlayer panels
            for (int i = 0; i < this.panels.size(); i++) 
            {
                this.panels.get(i).removeAll();
                this.panels.get(i).revalidate();
                this.panels.get(i).repaint();
                this.revalidate();
                this.repaint();
                if (lobbyPlayers.size() > i) 
                {                 
                    //create a new list of lobbyPlayer panels based on arg
                    LobbyPlayer tempPlayer = lobbyPlayers.get(i);

                    //add this list to the GUI
                    if (tempPlayer.getDescriptor() == LobbyPlayer.Descriptor.Human) 
                    {
                        boolean hostTag = false;
                        if (i == 0 && this.isOnline)
                            hostTag = true;

                        this.panels.get(i).add(new HumanPlayerPanel(
                            this, tempPlayer.getUserName(), hostTag));
                    }
                    else 
                    {
                        String difficulty = "Beginner";
                        switch (tempPlayer.getDescriptor())
                        {
                            case ComputerBeginner:
                                difficulty = "Beginner";
                                break;
                            case ComputerIntermediate:
                                difficulty = "Intermediate";
                                break;
                            case ComputerAdvanced:
                                difficulty = "Advanced";
                                break;
                            default:
                                break;
                        }
                        this.computerCount++;
                        String computerName = tempPlayer.getUserName();
                        computerIndex = Integer.parseInt(computerName.substring(9));
                        this.panels.get(i).add(new ComputerPlayerPanel(
                            this, computerName, true, this.isOnline, this.isHost, difficulty));                   
                    }
                }
                else 
                {
                    computerIndex++;
                    this.panels.get(i).add(new ComputerPlayerPanel(
                        this, "Computer " + computerIndex, false, this.isOnline, this.isHost, "Beginner"));              
                }
                this.panels.get(i).revalidate();
                this.panels.get(i).repaint();
                this.revalidate();
                this.repaint();
            }
            
            if (this.isHost && lobbyPlayers.size() > 2) 
            {
                this.startButton.setEnabled(true);
            }
            else
            {
                this.startButton.setEnabled(false);
            }
            this.playerCount = lobbyPlayers.size();
            this.frame.refactor();
        }
        else if (arg instanceof Player)
        {
            Player player = (Player) arg;
            this.frame.removePanel(this);
            this.frame.createTablePanel(this.userName, this.playerCount - 1);
            ViewBuilder builder = new ViewBuilder(this.frame);
            this.frame.setViewBuilder(builder);
            player.addObserver(builder);

        }
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        titleLabel = new javax.swing.JLabel();
        playersPanel = new javax.swing.JPanel();
        player1Panel = new javax.swing.JPanel();
        player2Panel = new javax.swing.JPanel();
        player3Panel = new javax.swing.JPanel();
        player4Panel = new javax.swing.JPanel();
        player5Panel = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        startButton = new javax.swing.JButton();
        connectionLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 800, 600));
        setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        setMaximumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));

        titleLabel.setBackground(new java.awt.Color(255, 255, 255));
        titleLabel.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        titleLabel.setText(this.title);

        playersPanel.setBackground(new java.awt.Color(255, 255, 255));
        playersPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        player1Panel.setBackground(new java.awt.Color(255, 255, 255));
        player1Panel.setMaximumSize(new java.awt.Dimension(842, 50));
        player1Panel.setSize(new java.awt.Dimension(842, 50));

        org.jdesktop.layout.GroupLayout player1PanelLayout = new org.jdesktop.layout.GroupLayout(player1Panel);
        player1Panel.setLayout(player1PanelLayout);
        player1PanelLayout.setHorizontalGroup(
            player1PanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 0, Short.MAX_VALUE)
        );
        player1PanelLayout.setVerticalGroup(
            player1PanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 50, Short.MAX_VALUE)
        );

        player2Panel.setBackground(new java.awt.Color(255, 255, 255));
        player2Panel.setMaximumSize(new java.awt.Dimension(842, 50));
        player2Panel.setPreferredSize(new java.awt.Dimension(842, 50));
        player2Panel.setRequestFocusEnabled(false);
        player2Panel.setSize(new java.awt.Dimension(842, 50));

        org.jdesktop.layout.GroupLayout player2PanelLayout = new org.jdesktop.layout.GroupLayout(player2Panel);
        player2Panel.setLayout(player2PanelLayout);
        player2PanelLayout.setHorizontalGroup(
            player2PanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 592, Short.MAX_VALUE)
        );
        player2PanelLayout.setVerticalGroup(
            player2PanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 50, Short.MAX_VALUE)
        );

        player3Panel.setBackground(new java.awt.Color(255, 255, 255));
        player3Panel.setMaximumSize(new java.awt.Dimension(842, 50));
        player3Panel.setPreferredSize(new java.awt.Dimension(842, 50));

        org.jdesktop.layout.GroupLayout player3PanelLayout = new org.jdesktop.layout.GroupLayout(player3Panel);
        player3Panel.setLayout(player3PanelLayout);
        player3PanelLayout.setHorizontalGroup(
            player3PanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 0, Short.MAX_VALUE)
        );
        player3PanelLayout.setVerticalGroup(
            player3PanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 50, Short.MAX_VALUE)
        );

        player4Panel.setBackground(new java.awt.Color(255, 255, 255));
        player4Panel.setMaximumSize(new java.awt.Dimension(842, 50));
        player4Panel.setPreferredSize(new java.awt.Dimension(842, 50));

        org.jdesktop.layout.GroupLayout player4PanelLayout = new org.jdesktop.layout.GroupLayout(player4Panel);
        player4Panel.setLayout(player4PanelLayout);
        player4PanelLayout.setHorizontalGroup(
            player4PanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 0, Short.MAX_VALUE)
        );
        player4PanelLayout.setVerticalGroup(
            player4PanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 50, Short.MAX_VALUE)
        );

        player5Panel.setBackground(new java.awt.Color(255, 255, 255));
        player5Panel.setMaximumSize(new java.awt.Dimension(842, 50));
        player5Panel.setMinimumSize(new java.awt.Dimension(842, 50));
        player5Panel.setPreferredSize(new java.awt.Dimension(842, 50));
        player5Panel.setSize(new java.awt.Dimension(842, 50));

        org.jdesktop.layout.GroupLayout player5PanelLayout = new org.jdesktop.layout.GroupLayout(player5Panel);
        player5Panel.setLayout(player5PanelLayout);
        player5PanelLayout.setHorizontalGroup(
            player5PanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 0, Short.MAX_VALUE)
        );
        player5PanelLayout.setVerticalGroup(
            player5PanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 50, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout playersPanelLayout = new org.jdesktop.layout.GroupLayout(playersPanel);
        playersPanel.setLayout(playersPanelLayout);
        playersPanelLayout.setHorizontalGroup(
            playersPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(playersPanelLayout.createSequentialGroup()
                .add(32, 32, 32)
                .add(playersPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(player5Panel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 592, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(playersPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                        .add(player1Panel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(player2Panel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                        .add(player3Panel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                        .add(player4Panel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        playersPanelLayout.setVerticalGroup(
            playersPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(playersPanelLayout.createSequentialGroup()
                .add(26, 26, 26)
                .add(player1Panel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(player2Panel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(player3Panel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(player4Panel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(player5Panel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        backButton.setBackground(new java.awt.Color(255, 255, 255));
        backButton.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        backButton.setText("Back");
        backButton.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                backButtonMouseEntered(evt);
            }
        });
        backButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                backButtonActionPerformed(evt);
            }
        });
        backButton.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                backButtonKeyPressed(evt);
            }
        });

        startButton.setBackground(new java.awt.Color(255, 255, 255));
        startButton.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        startButton.setText("Start");
        startButton.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                startButtonMouseEntered(evt);
            }
        });
        startButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                startButtonActionPerformed(evt);
            }
        });
        startButton.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                startButtonKeyPressed(evt);
            }
        });

        connectionLabel.setBackground(new java.awt.Color(255, 255, 255));
        connectionLabel.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(71, 71, 71)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(titleLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 480, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 60, Short.MAX_VALUE)
                        .add(connectionLabel)
                        .add(189, 189, 189))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(layout.createSequentialGroup()
                                .add(backButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 85, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(471, 471, 471)
                                .add(startButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 104, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(playersPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(76, 76, 76)
                        .add(connectionLabel))
                    .add(layout.createSequentialGroup()
                        .add(48, 48, 48)
                        .add(titleLabel)))
                .add(32, 32, 32)
                .add(playersPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(35, 35, 35)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(backButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 35, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(startButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 35, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_startButtonActionPerformed
    {//GEN-HEADEREND:event_startButtonActionPerformed
        //call ClientLobby.startGame();
        this.clientLobby.startGame();
    }//GEN-LAST:event_startButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_backButtonActionPerformed
    {//GEN-HEADEREND:event_backButtonActionPerformed
        //IF this is online game
        //CALL OnlineClientLobby.quit()
        try
        {

            ((OnlineClientLobby) this.clientLobby).quit();
            this.frame.removePanel(this);
            this.frame.createScreenNamePanel(this.isOnline);
        }
        catch (Exception e)
        {
            this.frame.removePanel(this);
            this.frame.createScreenNamePanel(this.isOnline);
        }
    }//GEN-LAST:event_backButtonActionPerformed

    private void backButtonKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_backButtonKeyPressed
    {//GEN-HEADEREND:event_backButtonKeyPressed
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                if (this.currIndex == 0) {
                    this.buttons[this.currIndex].requestFocus();
                }
                else {
                    this.currIndex--;
                    this.buttons[this.currIndex].requestFocus();
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (this.currIndex == this.numButtons - 1) {
                    this.buttons[this.currIndex].requestFocus();
                }
                else {
                    this.currIndex++;
                    this.buttons[this.currIndex].requestFocus();
                }
                break;
        }
    }//GEN-LAST:event_backButtonKeyPressed

    private void startButtonKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_startButtonKeyPressed
    {//GEN-HEADEREND:event_startButtonKeyPressed
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                if (this.currIndex == 0) {
                    this.buttons[this.currIndex].requestFocus();
                }
                else {
                    this.currIndex--;
                    this.buttons[this.currIndex].requestFocus();
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (this.currIndex == this.numButtons - 1) {
                    this.buttons[this.currIndex].requestFocus();
                }
                else {
                    this.currIndex++;
                    this.buttons[this.currIndex].requestFocus();
                }
                break;
        }
    }//GEN-LAST:event_startButtonKeyPressed

    private void backButtonMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_backButtonMouseEntered
    {//GEN-HEADEREND:event_backButtonMouseEntered
        this.buttons[0].requestFocus();
    }//GEN-LAST:event_backButtonMouseEntered

    private void startButtonMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_startButtonMouseEntered
    {//GEN-HEADEREND:event_startButtonMouseEntered
        this.buttons[1].requestFocus();
    }//GEN-LAST:event_startButtonMouseEntered
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel connectionLabel;
    private javax.swing.JPanel player1Panel;
    private javax.swing.JPanel player2Panel;
    private javax.swing.JPanel player3Panel;
    private javax.swing.JPanel player4Panel;
    private javax.swing.JPanel player5Panel;
    private javax.swing.JPanel playersPanel;
    private javax.swing.JButton startButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
