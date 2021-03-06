package whodonedidit.gui;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import whodonedidit.version1_0.ActionCard;
import whodonedidit.version1_0.ActionCardType;
import whodonedidit.version1_0.ViewBuilder;
import whodonedidit.version1_0.Controller;
import whodonedidit.version1_0.Player;
import whodonedidit.version1_0.Table;

/**
 *
 * @author Tyler Wong
 */
public class MainFrame extends javax.swing.JFrame
{

    private JFrame frame;
    private MainMenuPanel menuPanel;
    private ScreenNamePanel namePanel;
    private LobbyPanel lobbyPanel;
    private RulesPanel rulesPanel;
    private TablePanel tablePanel;
    private ArrayList<JPanel> dialogs;
    private JLayeredPane layerPane;
    private ViewBuilder viewBuilder;
    private Controller controller;
    private String language = "English";
    private String theme = "Greek Mythology";

    /**
     * Creates new form MainFrame
     */
    public MainFrame()
    {
        this.frame = new JFrame("Who Done Did It?");
        this.dialogs = new ArrayList<JPanel>();
        initComponents();
        createMainMenuPanel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 800, 600));
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 800, 600));
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public String getLanguage()
    {
        return this.language;
    }
    
    public void setLanguage(String lang)
    {
        this.language = lang;
    }
    
    public String getTheme()
    {
        return this.theme;
    }
    
    public void setTheme(String theme)
    {
        this.theme = theme;
    }
    
    public void showDialog(JPanel dialog)
    {
        if (!(dialog instanceof SuggestionPanel))
        {
            dialog.setLocation(150, 150);
        }
        this.dialogs.add(dialog);
        this.layerPane.add(dialog, JLayeredPane.DRAG_LAYER);
        this.layerPane.moveToFront(dialog);
        this.layerPane.validate();
        this.frame.pack();
    }
    
    public void removeDialog(JPanel dialog)
    {
        this.layerPane.remove(layerPane.getIndexOf(dialog));
        this.dialogs.remove(dialog);
        this.layerPane.repaint();
        this.layerPane.validate();
    }

    public void updateTable(String userName, String[] userNames, String[] destinations, ActionCardType
        discardPileCardType, String[] handClueCardNames, ActionCard[]
        handActionCard, String notification, Table table, Player player, String currentPlayer,
            ArrayList<Integer> numCards)
    {
        this.tablePanel.setTable(table);
        this.tablePanel.setPlayer(player);
        this.tablePanel.setUserNames(userNames, numCards);
        this.tablePanel.setDestinationMarkers(userNames, destinations);
        this.tablePanel.setClueCards(handClueCardNames);
        this.tablePanel.setActionCards(handActionCard);
        this.tablePanel.setDiscardPile(discardPileCardType);
        if (!notification.equals(""))
        {
            this.tablePanel.appendToHistoryLog(notification);
        }
    }
    
    public Controller getController()
    {
        return this.controller;
    }

    public void enableActionCards()
    {
        this.tablePanel.enableActionCards();
    }
    
    public void disableActionCards()
    {
        this.tablePanel.disableActionCards();
    }

    public void setTablePanel(TablePanel table)
    {
        this.tablePanel = table;
    }

    public ViewBuilder getViewBuilder()
    {
        return viewBuilder;
    }

    public JLayeredPane getLayerPane()
    {
        return this.layerPane;
    }

    public TablePanel getTable()
    {
        return this.tablePanel;
    }  

    public JPanel getLobby()
    {
        return this.lobbyPanel;
    }

    public JLayeredPane getLayers()
    {
        return this.layerPane;
    }

    public void setViewBuilder(ViewBuilder viewBuilder)
    {
        this.viewBuilder = viewBuilder;
    }

    public void setController(Player player)
    {
        if (this.controller == null) 
        {
            this.controller = new Controller(this, player);
        }
    }
    
    public void disableArrestButton()
    {
        this.tablePanel.getArrestButton().setEnabled(false);
    }
    
    public void enableArrestButton()
    {
        this.tablePanel.getArrestButton().setEnabled(true);
    }
    
    public void disableEndTurnButton()
    {
        this.tablePanel.getEndTurnButton().setEnabled(false);
    }
    
    public void enableEndTurnButton()
    {
        this.tablePanel.getEndTurnButton().setEnabled(true);
    }

    public void refactor()
    {
        this.frame.pack();
        this.frame.revalidate();
        this.frame.repaint();
    }

    @Override
    public void removeAll()
    {
        this.frame.getContentPane().removeAll();
    }

    public void removeTablePanel()
    {
        this.frame.getContentPane().remove(this.tablePanel);
    }

    public void removePanel(JPanel panel)
    {
        this.frame.getContentPane().remove(panel);
    }
    
    public SnoopPanel createSnoopPanel(List<Player> otherPlayers)
    {
        SnoopPanel snoopPanel = new SnoopPanel(this, this.layerPane, otherPlayers);
        return snoopPanel;
    }
    
    public PrivateTipPanel createPrivateTipPanel(List<Player> otherPlayers, List<String> description, ActionCardType actionCardType)
    {
        PrivateTipPanel privateTipPanel = new PrivateTipPanel(this, this.layerPane, actionCardType, description, otherPlayers);
        return privateTipPanel;
    }
    
    public SuggestionPanel createSuggestionPanel(ActionCardType actionCardType, 
            String currentDestination)
    {
        SuggestionPanel suggestionPanel = new SuggestionPanel(this, this.layerPane, 
                actionCardType, currentDestination);
        return suggestionPanel;
    }

    public SnoopedOnPanel createSnoopedOnPanel(String cardName, String userName)
    {
        SnoopedOnPanel snoopedOnPanel = new SnoopedOnPanel(this, this.layerPane);
        snoopedOnPanel.setCardName(cardName);
        snoopedOnPanel.setUserName(userName);
        return snoopedOnPanel;
    }

    public PrivateTipResponsePanel createPrivateTipResponsePanel(String[] cardNames,
        String userPlayerUsername, int playerId)
    {
        PrivateTipResponsePanel responsePanel = 
                new PrivateTipResponsePanel(this, this.layerPane, playerId, cardNames);
        responsePanel.setUserName(userPlayerUsername);
        return responsePanel;
    }
    
    public PrivateTipAllResultPanel createPrivateTipAllResultPanel(String[] cardNames,
            String userName)
    {
        PrivateTipAllResultPanel resultPanel = 
                new PrivateTipAllResultPanel(this, this.layerPane);
        resultPanel.setCardNames(cardNames);
        resultPanel.setUserName(userName);
        return resultPanel;
    }

    public SuperSleuthResponsePanel createSuperSleuthResponsePanel(String[] cardNames,
            String userPlayerUsername)
    {
        SuperSleuthResponsePanel responsePanel = new SuperSleuthResponsePanel(this, this.layerPane);
        responsePanel.setCardNames(cardNames);
        responsePanel.setUserName(userPlayerUsername);
        return responsePanel;
    }

    public SnoopedOnPanel createAllSnoopedOnPanel(boolean isRight, String cardName,
        String userPlayerUsername, String receivingPlayerUsername)
    {
        SnoopedOnPanel snoopedOnPanel = new SnoopedOnPanel(this, this.layerPane);
        snoopedOnPanel.setIsAllSnoop(true);
        snoopedOnPanel.setCardName(cardName);
        snoopedOnPanel.setUserName(userPlayerUsername);
        snoopedOnPanel.setReceivingName(receivingPlayerUsername);
        return snoopedOnPanel;
    }

    public DisproveSuggestionPanel createDisproveSuggestionPanel(String[] cardNames,
            String userPlayerUsername, int targetId)
    {
        DisproveSuggestionPanel sugPanel = new DisproveSuggestionPanel(this, this.layerPane, cardNames);
        sugPanel.setTargetPlayerId(targetId);
        sugPanel.setUserName(userPlayerUsername);
        return sugPanel;
    }

    public ReceivedCardsPanel createReceivedCardsPanel(String[] cardNames,
        String senderPlayerUsername, ActionCardType type)
    {
        ReceivedCardsPanel receivedPanel = new ReceivedCardsPanel(this, this.layerPane, type);
        receivedPanel.setCardNames(cardNames);
        receivedPanel.setUserName(senderPlayerUsername);
        return receivedPanel;
    }

    public EndGamePanel createEndGamePanel(boolean winner, String winnerScreenName, 
            String person, String vehicle, String destination)
    {
        EndGamePanel endPanel = new EndGamePanel(this, this.layerPane, person, vehicle, destination);
        endPanel.setYourName(this.tablePanel.getUserName());
        endPanel.setIsWinner(winner);
        endPanel.setWinnerName(winnerScreenName);
        return endPanel;
    }
    
    public IncorrectAccusationPanel createIncorrectAccusationPanel(String person, 
            String vehicle, String destination)
    {
        IncorrectAccusationPanel incorrectPanel = new IncorrectAccusationPanel(
                this, this.layerPane, person, vehicle, destination);
        
        return incorrectPanel;
    }

    public void createMainMenuPanel()
    {
        this.menuPanel = new MainMenuPanel(this);
        this.menuPanel.setLanguage(this.language);
        this.menuPanel.setTheme(this.theme);
        this.frame.getContentPane().add(this.menuPanel);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
        this.frame.setResizable(false);
        this.frame.pack();
        this.frame.revalidate();
        this.frame.repaint();
    }

    public void createScreenNamePanel(boolean isOnline)
    {
        this.namePanel = new ScreenNamePanel(this, isOnline);
        this.namePanel.setLanguage(this.language);
        this.frame.getContentPane().add(namePanel);
        this.namePanel.getTextField().requestFocusInWindow();
        this.frame.setVisible(true);
        this.frame.pack();
        this.frame.revalidate();
        this.frame.repaint();
    }

    public void createLobbyPanel(boolean isOnline, String name)
    {
        this.lobbyPanel = new LobbyPanel(this, name, isOnline);
        this.frame.getContentPane().add(this.lobbyPanel);
        this.lobbyPanel.getBackButton().requestFocusInWindow();
        this.frame.setVisible(true);
        this.frame.pack();
        this.frame.revalidate();
        this.frame.repaint();
    }

    public void createRulesPanel(boolean inGame, JLayeredPane pane)
    {
        this.rulesPanel = new RulesPanel(this, pane);
        this.rulesPanel.setLanguage(this.language);
        this.rulesPanel.setInGame(false);
        this.frame.getContentPane().add(this.rulesPanel);
        this.rulesPanel.getBackButton().requestFocusInWindow();
        this.frame.setVisible(true);
        this.frame.pack();
        this.frame.revalidate();
        this.frame.repaint();
    }

    public void createTablePanel(String userName, int computerCount)
    {
        this.layerPane = new JLayeredPane();
        this.tablePanel = new TablePanel(this, this.layerPane);
        this.tablePanel.setName(userName);
        this.tablePanel.setPlayerCount(computerCount);
        this.layerPane.setPreferredSize(new Dimension(800, 600));
        this.layerPane.add(this.tablePanel, JLayeredPane.DEFAULT_LAYER);
        this.layerPane.validate();
        this.frame.getContentPane().add(this.layerPane);
        this.tablePanel.getFirstCard().requestFocusInWindow();
        disableEndTurnButton();      
        this.frame.setVisible(true);
        this.frame.pack();
        this.frame.revalidate();
        this.frame.repaint();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                MainFrame newFrame = new MainFrame();
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
