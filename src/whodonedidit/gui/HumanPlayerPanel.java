package whodonedidit.gui;

/**
 *
 * @author Tyler Wong
 */
public class HumanPlayerPanel extends javax.swing.JPanel
{
    private String userName;
    private boolean isOnline;
    private LobbyPanel lobbyPanel;
    private boolean isHost;
    
    /**
     * Creates new form HumanPlayerPanel
     */
    public HumanPlayerPanel(LobbyPanel lobbyPanel, String userName, boolean isHost)
    {
        this.lobbyPanel = lobbyPanel;
        this.userName = userName;
        this.isHost = isHost;
        initComponents();
        
        if (!this.isHost)
            this.hostLabel.setText("    ");
    }
    
    public void setHostLabelVisible(boolean isHost)
    {
        this.hostLabel.setVisible(isHost);
    }
    
    public String getUserName()
    {
        return this.userName;
    }
    
    public void setOnline(boolean isOnline)
    {
        this.isOnline = isOnline;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        hostLabel = new javax.swing.JLabel();
        playerName = new javax.swing.JLabel();
        readyLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 592, 50));
        setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        setMaximumSize(new java.awt.Dimension(592, 50));
        setPreferredSize(new java.awt.Dimension(592, 50));

        hostLabel.setBackground(new java.awt.Color(255, 255, 255));
        hostLabel.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        hostLabel.setText("(Host)");

        playerName.setBackground(new java.awt.Color(255, 255, 255));
        playerName.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        playerName.setText(this.userName);

        readyLabel.setBackground(new java.awt.Color(255, 255, 255));
        readyLabel.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        readyLabel.setText("Ready!");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(16, 16, 16)
                .add(hostLabel)
                .add(30, 30, 30)
                .add(playerName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 360, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 58, Short.MAX_VALUE)
                .add(readyLabel)
                .add(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(hostLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(playerName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(readyLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 37, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel hostLabel;
    private javax.swing.JLabel playerName;
    private javax.swing.JLabel readyLabel;
    // End of variables declaration//GEN-END:variables
}
