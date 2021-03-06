package whodonedidit.gui;

import javax.swing.JLayeredPane;

/**
 *
 * @author Brittany Berlanga
 */
public class EndGamePanel extends javax.swing.JPanel
{

    private MainFrame frame;
    private JLayeredPane layerPane;
    private boolean winner;
    private String winnerScreenName;
    private String yourScreenName;

    /**
     * Creates new form EndGamePanel
     */
    public EndGamePanel(MainFrame frame, JLayeredPane layerPane, String person, 
            String vehicle, String destination)
    {
        this.frame = frame;
        this.layerPane = layerPane;
        initComponents();
        addSolutionCards(person, vehicle, destination);
    }

    private void addSolutionCards(String person, String vehicle, String destination)
    {
        this.solutionPanel.add(new CardLabel(TablePanel.clueCardImages.get(person)));
        this.solutionPanel.add(new CardLabel(TablePanel.clueCardImages.get(vehicle)));
        this.solutionPanel.add(new CardLabel(TablePanel.clueCardImages.get(destination)));
        this.solutionPanel.validate();
    }
    
    public void setIsWinner(boolean winner)
    {
        this.winner = winner;
    }
    
    public void setYourName(String yourName)
    {
        this.yourScreenName = yourName;
    }
    
    public void setWinnerName(String winnerName)
    {
        this.winnerScreenName = winnerName;
        if(this.winnerScreenName.equals(""))
        {
            this.winLabel.setText("Everyone loses!");
        }
        else if (!this.winnerScreenName.equals(this.yourScreenName))
        {
            this.winLabel.setText(this.winnerScreenName + " wins!");
        }
        else
        {
            this.winLabel.setText("You win!");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        solutionPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        mainMenuButton = new javax.swing.JButton();
        winLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        setBounds(new java.awt.Rectangle(0, 0, 500, 300));
        setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        setMaximumSize(new java.awt.Dimension(500, 300));
        setMinimumSize(new java.awt.Dimension(500, 300));
        setPreferredSize(new java.awt.Dimension(500, 300));

        solutionPanel.setBackground(new java.awt.Color(255, 255, 255));
        solutionPanel.setPreferredSize(new java.awt.Dimension(588, 191));
        solutionPanel.setRequestFocusEnabled(false);
        solutionPanel.setSize(new java.awt.Dimension(588, 191));
        solutionPanel.setLayout(new java.awt.GridBagLayout());

        titleLabel.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Solution");

        mainMenuButton.setBackground(new java.awt.Color(255, 255, 255));
        mainMenuButton.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        mainMenuButton.setText("Back To Main Menu");
        mainMenuButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mainMenuButtonActionPerformed(evt);
            }
        });

        winLabel.setBackground(new java.awt.Color(255, 255, 255));
        winLabel.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        winLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        winLabel.setText("You Win!");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(33, 33, 33)
                        .add(winLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 430, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(168, 168, 168)
                        .add(mainMenuButton)))
                .addContainerGap(33, Short.MAX_VALUE))
            .add(layout.createSequentialGroup()
                .add(0, 0, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(solutionPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                    .add(titleLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(15, 15, 15)
                .add(titleLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(solutionPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 175, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(winLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(mainMenuButton)
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void mainMenuButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_mainMenuButtonActionPerformed
    {//GEN-HEADEREND:event_mainMenuButtonActionPerformed
        this.frame.removeAll();
        this.frame.createMainMenuPanel();
    }//GEN-LAST:event_mainMenuButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton mainMenuButton;
    private javax.swing.JPanel solutionPanel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel winLabel;
    // End of variables declaration//GEN-END:variables
}
