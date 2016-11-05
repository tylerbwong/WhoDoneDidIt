package whodonedidit.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import whodonedidit.version1_0.ClueCard;

/**
 *
 * @author Tyler Wong
 */
public class PrivateTipResponsePanel extends javax.swing.JPanel
{
    private MainFrame frame;
    private JLayeredPane layerPane;
    private String[] cardNames;
    private ArrayList<CardButton> cardButtons;
    private String userName;
    private int playerId;
    
    public PrivateTipResponsePanel(MainFrame frame, JLayeredPane layerPane, 
            int playerId, String[] names)
    {
        this.frame = frame;
        this.layerPane = layerPane;
        this.cardButtons = new ArrayList<CardButton>();
        this.playerId = playerId;
        this.cardNames = names;
        initComponents();
        setCardNames(this.cardNames);
        initializeCards();
    }
    
    public void setCardNames(String[] names)
    {
        if (names.length == 0)
        {
            this.titleLabel.setText("You Have No Cards To Show!");
            JButton newButton = new JButton("Click To Continue!");
            newButton.setForeground(new Color(255, 255, 255));
            newButton.setPreferredSize(new Dimension(75, 29));
            newButton.setFont(new Font("Roboto", Font.PLAIN, 18));
            newButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent evt)
                {
                    frame.disableActionCards();
                    cardChosen(evt, null);
                }
            });
            this.cardPanel.add(newButton);
            this.cardPanel.revalidate();
            this.cardPanel.repaint();
        }
        else
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
        if (cardName != null)
        {
            clueCards.add(new ClueCard(cardName, null));
        }
        this.frame.removeDialog(this);
        this.layerPane.moveToFront(this.frame.getTable());
        this.layerPane.repaint();
        this.layerPane.validate();
        this.frame.refactor();
        this.frame.getController().sendSendClueCardsAction(clueCards, playerId);
    }
    
    public void setUserName(String name)
    {
        this.userName = name;
        if (this.cardNames.length == 0)
        {
            this.subTitleLabel.setText("You have nothing to show " + this.userName + ".");
        }
        else
        {
            this.subTitleLabel.setText("Choose which card to send " + this.userName + ".");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        titleLabel = new javax.swing.JLabel();
        subTitleLabel = new javax.swing.JLabel();
        cardPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        setBounds(new java.awt.Rectangle(0, 0, 500, 300));
        setMaximumSize(new java.awt.Dimension(500, 300));
        setPreferredSize(new java.awt.Dimension(500, 300));

        titleLabel.setBackground(new java.awt.Color(255, 255, 255));
        titleLabel.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("You Were Chosen For A Private Tip!");

        subTitleLabel.setBackground(new java.awt.Color(255, 255, 255));
        subTitleLabel.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        subTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        cardPanel.setBackground(new java.awt.Color(255, 255, 255));
        cardPanel.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        cardPanel.setMaximumSize(new java.awt.Dimension(503, 203));
        cardPanel.setMinimumSize(new java.awt.Dimension(503, 203));
        cardPanel.setPreferredSize(new java.awt.Dimension(503, 203));
        cardPanel.setLayout(new java.awt.GridBagLayout());

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(cardPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 484, Short.MAX_VALUE)
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(titleLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 370, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(63, 63, 63))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(titleLabel)
                .add(18, 18, 18)
                .add(cardPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cardPanel;
    private javax.swing.JLabel subTitleLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
