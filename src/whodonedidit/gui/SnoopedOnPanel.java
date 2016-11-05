package whodonedidit.gui;

import java.util.ArrayList;
import javax.swing.JLayeredPane;

/**
 *
 * @author Tyler Wong
 */
public class SnoopedOnPanel extends javax.swing.JPanel
{
    private MainFrame frame;
    private JLayeredPane layerPane;
    private TablePanel tablePanel;
    private ArrayList<CardButton> cards;
    private String cardName;
    private String userName;
    private String receivingName;
    private boolean isAllSnoop;
    
    /**
     * Creates new form SnoopedOnPanel
     */
    public SnoopedOnPanel(MainFrame frame, JLayeredPane layerPane)
    {
        this.frame = frame;
        this.layerPane = layerPane;
        initComponents();
    }
    
    public void setReceivingName(String receiverName)
    {
        this.receivingName = receiverName;
    }
    
    public void setIsAllSnoop(boolean isAllSnoop)
    {
        this.isAllSnoop = isAllSnoop;
    }
    
    public void setCardName(String name)
    {
        this.cardName = name;
        this.cardPanel.add(new CardLabel(this.frame.getTable().clueCardImages.get(this.cardName)));
        this.cardPanel.revalidate();
        this.cardPanel.repaint();
    }
    
    public void setUserName(String name)
    {
        this.userName = name;
        this.subTitleLabel.setText(this.userName + " saw this card.");
    }
    
    public void setTablePanel(TablePanel tablePanel)
    {
        this.tablePanel = tablePanel;
    }
    
    public void setCards(ArrayList<CardButton> cards)
    {
        this.cards = cards;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        titleLabel = new javax.swing.JLabel();
        cardPanel = new javax.swing.JPanel();
        subTitleLabel = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        setBounds(new java.awt.Rectangle(0, 0, 500, 300));
        setMaximumSize(new java.awt.Dimension(500, 300));
        setPreferredSize(new java.awt.Dimension(500, 300));

        titleLabel.setBackground(new java.awt.Color(255, 255, 255));
        titleLabel.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        titleLabel.setText("You Were Snooped On!");

        cardPanel.setBackground(new java.awt.Color(255, 255, 255));
        cardPanel.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        cardPanel.setMaximumSize(new java.awt.Dimension(166, 255));
        cardPanel.setSize(new java.awt.Dimension(166, 255));
        cardPanel.setLayout(new java.awt.GridBagLayout());

        subTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subTitleLabel.setText("Computer 1 saw this card.");

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

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(titleLabel)
                .add(119, 119, 119)
                .add(cancelButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 37, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(0, 19, Short.MAX_VALUE)
                .add(cardPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 461, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(16, 16, 16))
            .add(layout.createSequentialGroup()
                .add(165, 165, 165)
                .add(subTitleLabel)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(cancelButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 37, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(titleLabel))
                .add(18, 18, 18)
                .add(cardPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 176, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(subTitleLabel)
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cancelButtonActionPerformed
    {//GEN-HEADEREND:event_cancelButtonActionPerformed
        this.frame.removeDialog(this);
        this.validate();
        this.layerPane.repaint();
        this.layerPane.validate();
    }//GEN-LAST:event_cancelButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel cardPanel;
    private javax.swing.JLabel subTitleLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
