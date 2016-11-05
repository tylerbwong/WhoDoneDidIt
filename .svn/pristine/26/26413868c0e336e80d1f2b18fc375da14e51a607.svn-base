package whodonedidit.gui;

import java.util.ArrayList;
import javax.swing.JLayeredPane;

/**
 *
 * @author Tyler Wong
 */
public class PrivateTipWaitPanel extends javax.swing.JPanel
{
    private MainFrame frame;
    private JLayeredPane layerPane;
    private ArrayList<CardButton> cards;
    private TablePanel tablePanel;
    
    /**
     * Creates new form PrivateTipWaitPanel
     */
    public PrivateTipWaitPanel(MainFrame frame, JLayeredPane layerPane)
    {
        this.frame = frame;
        this.layerPane = layerPane;
        initComponents();
    }
    
    public void setCards(ArrayList<CardButton> cards)
    {
        this.cards = cards;
    }
    
    public void setTablePanel(TablePanel tablePanel)
    {
        this.tablePanel = tablePanel;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        titleLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        tempButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        setBounds(new java.awt.Rectangle(0, 0, 600, 350));
        setMaximumSize(new java.awt.Dimension(600, 350));
        setMinimumSize(new java.awt.Dimension(600, 350));
        setPreferredSize(new java.awt.Dimension(600, 350));

        titleLabel.setBackground(new java.awt.Color(255, 255, 255));
        titleLabel.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        titleLabel.setText("Waiting for a tip from Computer 1...");

        tempButton.setBackground(new java.awt.Color(255, 255, 255));
        tempButton.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        tempButton.setText("Click");
        tempButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                tempButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .add(tempButton)
                .add(44, 44, 44))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(97, 97, 97)
                .add(tempButton)
                .addContainerGap(123, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap(120, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(titleLabel)
                        .add(102, 102, 102))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(213, 213, 213))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(19, 19, 19)
                .add(titleLabel)
                .add(18, 18, 18)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tempButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_tempButtonActionPerformed
    {//GEN-HEADEREND:event_tempButtonActionPerformed
        PrivateTipResultPanel resultPanel = new PrivateTipResultPanel(this.frame, this.layerPane);
        this.tablePanel.getEndTurnButton().setEnabled(true);
        resultPanel.setTablePanel(this.tablePanel);
        resultPanel.setLocation(212, 209);
        resultPanel.setCards(cards);
        this.validate();
        this.layerPane.add(resultPanel, JLayeredPane.DRAG_LAYER);
        this.layerPane.remove(this);
        this.layerPane.validate();
    }//GEN-LAST:event_tempButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton tempButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
