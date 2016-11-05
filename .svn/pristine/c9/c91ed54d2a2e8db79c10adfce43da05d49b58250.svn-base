package whodonedidit.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLayeredPane;
import whodonedidit.version1_0.ClueCard;

/**
 *
 * @author Tyler Wong
 */
public class DisproveSuggestionPanel extends javax.swing.JPanel
{
    private MainFrame frame;
    private JLayeredPane layerPane;
    private String[] cardNames;
    private String userName;
    private ArrayList<CardButton> cardButtons;
    private int playerId;
    private int targetId;
    
    /**
     * Creates new form DisproveSuggestionPanel
     */
    public DisproveSuggestionPanel(MainFrame frame, JLayeredPane layerPane, 
            String[] names)
    {
        this.frame = frame;
        this.layerPane = layerPane;
        this.cardButtons = new ArrayList<CardButton>();
        this.cardNames = names;
        initComponents();
        setCardNames(this.cardNames);
        initializeCards();
    }
    
    public void setCardNames(String[] names)
    {
        for (int i = 0; i < names.length; i++)
        {
            CardButton newButton = new CardButton(names[i], this.frame.getTable().clueCardImages.get(names[i]), i);
            this.cardButtons.add(newButton);
            this.cardPanel.add(newButton);
            this.cardPanel.revalidate();
        }
        this.cardPanel.repaint();
    }
    
    public void initializeCards()
    {
        for (int i = 0; i < this.cardButtons.size(); i++)
        {
            this.cardButtons.get(i).addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent evt)
                {
                    cardChosen(evt, ((CardButton) (evt.getSource())).getCardName());
                }
            });
        }
    }
    
    private void cardChosen(ActionEvent evt, String cardName)
    {
        List<ClueCard> clueCards = new ArrayList<ClueCard>();
        clueCards.add(new ClueCard(cardName, null));
        this.frame.removeDialog(this);
        this.layerPane.moveToFront(this.frame.getTable());
        this.layerPane.revalidate();
        this.layerPane.repaint();
        
        this.frame.refactor();
        this.frame.getController().sendSendClueCardsAction(clueCards, this.targetId);
    }
    
    public void setUserName(String name)
    {
        this.userName = name;
        this.titleLabel.setText("You Can Disprove " + this.userName + "'s Suggestion!");
    }
    
    public void setTargetPlayerId(int targetId)
    {
        this.targetId = targetId;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        titleLabel = new javax.swing.JLabel();
        cardPanel = new javax.swing.JPanel();
        subTitleLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        setBounds(new java.awt.Rectangle(0, 0, 500, 300));
        setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        setMaximumSize(new java.awt.Dimension(500, 300));
        setMinimumSize(new java.awt.Dimension(500, 300));
        setPreferredSize(new java.awt.Dimension(500, 300));

        titleLabel.setBackground(new java.awt.Color(255, 255, 255));
        titleLabel.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        cardPanel.setBackground(new java.awt.Color(255, 255, 255));
        cardPanel.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        cardPanel.setMaximumSize(new java.awt.Dimension(503, 230));
        cardPanel.setMinimumSize(new java.awt.Dimension(503, 230));
        cardPanel.setPreferredSize(new java.awt.Dimension(503, 230));
        cardPanel.setSize(new java.awt.Dimension(503, 230));
        cardPanel.setLayout(new java.awt.GridBagLayout());

        subTitleLabel.setBackground(new java.awt.Color(255, 255, 255));
        subTitleLabel.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        subTitleLabel.setText("Choose a card to disprove them.");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(158, 158, 158)
                        .add(subTitleLabel))
                    .add(layout.createSequentialGroup()
                        .add(62, 62, 62)
                        .add(cardPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 375, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(0, 27, Short.MAX_VALUE)
                .add(titleLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 440, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(26, 26, 26)
                .add(titleLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 31, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(cardPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 168, Short.MAX_VALUE)
                .add(18, 18, 18)
                .add(subTitleLabel)
                .add(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cardPanel;
    private javax.swing.JLabel subTitleLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
