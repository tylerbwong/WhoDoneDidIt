package whodonedidit.gui;

import javax.swing.JLayeredPane;
import whodonedidit.version1_0.ActionCardType;

/**
 *
 * @author Tyler Wong
 */
public class ReceivedCardsPanel extends javax.swing.JPanel
{
    private MainFrame frame;
    private JLayeredPane layerPane;
    private String[] cardNames;
    private String userName;
    private ActionCardType type;
    
    public ReceivedCardsPanel(MainFrame frame, JLayeredPane layerPane, ActionCardType type)
    {
        this.frame = frame;
        this.layerPane = layerPane;
        this.type = type;
        initComponents();
        if (this.type == ActionCardType.SuggestFromAny || 
                this.type == ActionCardType.SuggestFromCurrent)
        {
            this.frame.enableEndTurnButton();
            this.frame.enableArrestButton();
        }
    }
    
    public void setCardNames(String[] names)
    {
        this.cardNames = names;
        if (this.cardNames.length == 0)
        {
            this.titleLabel.setText("You Got No Cards!");
        } 
        else
        {
            for (int i = 0; i < names.length; i++)
            {
                this.cardPanel.add(new CardLabel(
                    this.frame.getTable().clueCardImages.get(names[i])));
                this.cardPanel.revalidate();
            }
        }
        this.cardPanel.repaint();
    }
    
    public void setUserName(String name)
    {
        this.userName = name;
        String verb = "";
        String plural = "";
        if (this.cardNames.length > 1)
        {
            verb = "Are ";
            plural = "s!";
        }
        else if (this.cardNames.length == 1)
        {
            verb = "Is ";
            plural = "!";
        }
        this.titleLabel.setText("Here " + verb + this.userName + "'s Card" + plural);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        cardPanel = new javax.swing.JPanel();
        cancelButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        setBounds(new java.awt.Rectangle(0, 0, 500, 300));
        setMaximumSize(new java.awt.Dimension(500, 300));
        setMinimumSize(new java.awt.Dimension(500, 300));
        setPreferredSize(new java.awt.Dimension(500, 300));

        cardPanel.setBackground(new java.awt.Color(255, 255, 255));
        cardPanel.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        cardPanel.setMaximumSize(new java.awt.Dimension(537, 244));
        cardPanel.setMinimumSize(new java.awt.Dimension(537, 244));
        cardPanel.setLayout(new java.awt.GridBagLayout());

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

        titleLabel.setBackground(new java.awt.Color(255, 255, 255));
        titleLabel.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(titleLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 404, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(cancelButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 37, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .add(layout.createSequentialGroup()
                .add(30, 30, 30)
                .add(cardPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 435, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(titleLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 45, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cancelButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 37, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(cardPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 199, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
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
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
