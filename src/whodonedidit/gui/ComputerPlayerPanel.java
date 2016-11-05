package whodonedidit.gui;

import java.awt.Color;

/**
 *
 * @author Tyler Wong
 */
public class ComputerPlayerPanel extends javax.swing.JPanel
{
    private String compName;
    private String compLevel;
    private int compCount;
    private boolean isActive;
    private boolean isOnline;
    private boolean isHost;
    private boolean setSelectedInConstructor;
    private LobbyPanel lobbyPanel;
    private static final int kMinPlayers = 0;
    private static final int kMaxPlayers = 4;
    private static final Color kGrey = new Color(163, 167, 168);
    private static final Color kBlack = new Color(0, 0, 0);

    /**
     * Creates new form ComputerPlayerPanel
     */
    public ComputerPlayerPanel(LobbyPanel lobbyPanel, String compName, 
        boolean isActive, boolean isOnline, boolean isHost, String difficulty)
    {
        this.isOnline = isOnline;
        this.lobbyPanel = lobbyPanel;
        this.compName = compName;
        this.isActive = isActive;
        this.isHost = isHost;
        initComponents();
        setSelectedInConstructor = true;
        this.compCombo.setSelectedItem(difficulty);
        if (!this.isHost)
        {
            this.compCheck.setEnabled(false);
            this.compCombo.setEnabled(false); 
        }
        if (this.isActive)
        {
            this.compCheck.setSelected(this.isActive);
            this.compCheck.setForeground(kBlack);          
        }
        else
        {
            this.compCheck.setForeground(kGrey);
            this.compCombo.setEnabled(false); 
        }
              
    }

    public void setCompCount(int compCount)
    {
        this.compCount = compCount;
    }

    public String getCompLevel()
    {
        return this.compLevel;
    }

    public boolean getCheckStatus()
    {
        return this.compCheck.isSelected();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        compCheck = new javax.swing.JCheckBox();
        compCombo = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 592, 50));
        setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        setMaximumSize(new java.awt.Dimension(592, 50));
        setPreferredSize(new java.awt.Dimension(592, 50));

        compCheck.setBackground(new java.awt.Color(255, 255, 255));
        compCheck.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        compCheck.setText(this.compName);
        compCheck.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                compCheckActionPerformed(evt);
            }
        });

        compCombo.setBackground(new java.awt.Color(255, 255, 255));
        compCombo.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        compCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Beginner", "Intermediate", "Advanced" }));
        compCombo.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                compLevelActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(34, 34, 34)
                .add(compCheck, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 191, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 193, Short.MAX_VALUE)
                .add(compCombo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(compCheck, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .add(compCombo))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void compCheckActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_compCheckActionPerformed
    {//GEN-HEADEREND:event_compCheckActionPerformed

        if (!this.compCheck.isSelected())
        {
            this.lobbyPanel.removeComputerPlayer(this.compName);
            this.compCombo.setEnabled(false);
            this.compCheck.setForeground(kGrey);
            this.validate();
        }
        else
        {
            this.lobbyPanel.addComputerPlayer(
                String.valueOf(this.compCombo.getSelectedItem()), this.compName);
            this.compCombo.setEnabled(true);
            this.compCheck.setForeground(kBlack);
            this.validate();
        }
    }//GEN-LAST:event_compCheckActionPerformed

    private void compLevelActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_compLevelActionPerformed
    {//GEN-HEADEREND:event_compLevelActionPerformed
        if (!setSelectedInConstructor)
        {    
            String difficulty = String.valueOf(this.compCombo.getSelectedItem());
            this.lobbyPanel.removeComputerPlayer(this.compName);
            this.lobbyPanel.addComputerPlayer(difficulty, this.compName);
        }
        else
        {
            setSelectedInConstructor = false;
        }
    }//GEN-LAST:event_compLevelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox compCheck;
    private javax.swing.JComboBox compCombo;
    // End of variables declaration//GEN-END:variables
}
