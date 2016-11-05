package whodonedidit.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLayeredPane;
import whodonedidit.version1_0.ActionCardType;
import whodonedidit.version1_0.Player;

/**
 *
 * @author Tyler Wong
 */
public class PrivateTipPanel extends javax.swing.JPanel
{
    private int playerCount;
    private MainFrame frame;
    private JLayeredPane layerPane;
    private ArrayList<CardButton> cards;
    private ArrayList<OpponentButton> opponents = new ArrayList<OpponentButton>();
    private int[] ids;
    private TablePanel tablePanel;
    private ActionCardType privateTipType;
    private List<String> description;
    private List<Player> otherPlayers;
    
    /**
     * Creates new form PrivateTipPanel
     */
    public PrivateTipPanel(MainFrame frame, JLayeredPane layerPane, 
            ActionCardType privateTipType, List<String> description,
            List<Player> otherPlayers)
    {
        this.frame = frame;
        this.layerPane = layerPane;
        this.otherPlayers = otherPlayers;
        this.description = description;
        this.privateTipType = privateTipType;
        this.playerCount = this.otherPlayers.size();
        this.ids = new int[this.playerCount];
        initComponents();
        setSubTitle();
        setPlayers();
        initializeOpponents();
    }
    
    public void setSubTitle()
    {
        String scope = "", type = "", plural = ""; 
        if (this.privateTipType == ActionCardType.PrivateTipOne)
        {
            scope = "a ";
            if (this.description.size() > 1)
            {
                type = this.description.get(1) + " " + this.description.get(0);
            }
            else
            {
                type = this.description.get(0);
            }
            plural = ".";
        }
        else if (this.privateTipType == ActionCardType.PrivateTipAll)
        {
            scope = "all their ";
            if (this.description.size() > 1)
            {
                type = this.description.get(1) + " " + this.description.get(0);
            }
            else
            {
                type = this.description.get(0);
            }
            plural = "s.";
        }
        
        this.subTitleLabel.setText("Choose a player to get " + scope + type + " card" + plural);
    }
    
    public void setTablePanel(TablePanel tablePanel)
    {
        this.tablePanel = tablePanel;
    }
    
    public void setCards(ArrayList<CardButton> cards)
    {
        this.cards = cards;
    }

    public void setPlayers()
    {
        int id;
        String userName;
        for (int i = 0; i < this.playerCount; i++)
        {
            id = this.otherPlayers.get(i).getPlayerID();
            userName = this.otherPlayers.get(i).getUsername();
            OpponentButton newOpponent = new OpponentButton(id, userName);
            this.ids[i] = id;
            this.opponents.add(newOpponent);
            this.opponentPanel.add(newOpponent);
        }
    }

    public void initializeOpponents()
    {
        for (int i = 0; i < this.playerCount; i++)
        {
            this.opponents.get(i).addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent evt)
                {
                    opponentChosen(evt, ((OpponentButton) evt.getSource()).getID());
                }
            });
        }
    }
    
    private void opponentChosen(ActionEvent evt, int id)
    {
        this.frame.getController().sendPrivateTipAction(this.privateTipType, id, this.description);
        this.frame.enableEndTurnButton();
        this.frame.enableArrestButton();
        this.frame.removeDialog(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        titleLabel = new javax.swing.JLabel();
        subTitleLabel = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        opponentPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        setBounds(new java.awt.Rectangle(0, 0, 500, 300));
        setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        setMaximumSize(new java.awt.Dimension(500, 300));
        setPreferredSize(new java.awt.Dimension(500, 300));

        titleLabel.setBackground(new java.awt.Color(255, 255, 255));
        titleLabel.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        titleLabel.setText("You Played Private Tip!");

        subTitleLabel.setBackground(new java.awt.Color(255, 255, 255));
        subTitleLabel.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        subTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        cancelButton.setBackground(new java.awt.Color(255, 255, 255));
        cancelButton.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        cancelButton.setText("X");
        cancelButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cancelButtonActionPerformed(evt);
            }
        });

        opponentPanel.setBackground(new java.awt.Color(255, 255, 255));
        opponentPanel.setMaximumSize(new java.awt.Dimension(533, 208));
        opponentPanel.setLayout(new java.awt.GridBagLayout());

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(titleLabel)
                        .add(118, 118, 118)
                        .add(cancelButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 37, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(67, 67, 67)
                        .add(subTitleLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 361, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .add(layout.createSequentialGroup()
                .add(14, 14, 14)
                .add(opponentPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 467, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(7, 7, 7)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cancelButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 37, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(titleLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(subTitleLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 19, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(opponentPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 193, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cancelButtonActionPerformed
    {//GEN-HEADEREND:event_cancelButtonActionPerformed
        this.frame.enableActionCards();
        this.frame.disableEndTurnButton();
        this.layerPane.remove(this.layerPane.getIndexOf(this));
        this.validate();
        this.layerPane.repaint();
        this.layerPane.validate();
    }//GEN-LAST:event_cancelButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel opponentPanel;
    private javax.swing.JLabel subTitleLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
