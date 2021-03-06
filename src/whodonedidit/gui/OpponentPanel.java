package whodonedidit.gui;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Brittany Berlanga
 */
public class OpponentPanel extends javax.swing.JPanel
{
    private String screenName;
    private boolean turnArrowShowing;
    private int playerID;
    private DestinationMarkerLabel markerLabel;
    private int cardCount;
    
    /**
     * OpponentPanel Constructor
     */
    public OpponentPanel(String screenName, int playerID)
    {
        initComponents();
        setBorder(new EmptyBorder(0, 0, 0, 0));
        this.playerID = playerID;
        this.screenName = screenName;
        this.turnArrow.setVisible(false);
        this.turnArrowShowing = false;
        this.markerLabel = new DestinationMarkerLabel("sup");
        this.destinationMarkerPanel.add(this.markerLabel);
        repaint();
        validate();
    }
    
    public int getPlayerID()
    {   
        return this.playerID;
    }
    
    public void enableTurnArrow() 
    {
        if (!this.turnArrowShowing) 
        {
            this.turnArrow.setVisible(true);
            this.turnArrowShowing = true;
        }
    }
    
    public void disableTurnArrow()
    {
        if (this.turnArrowShowing)
        {
            this.turnArrow.setVisible(false);
            this.turnArrowShowing = false;
        }
    }
    
    public void setScreenName(String userName) 
    {
        this.screenName = userName;
        this.username.setText(this.screenName);
    }
    
    public void setCardCount(int count)
    {
        this.cardCount = count;
        this.numberOfCards.setText(String.valueOf(this.cardCount));
        this.revalidate();
        this.repaint();
    }

    public String getScreenName()
    {
        return this.screenName;
    }
    
    public JLabel getDestinationMarker() 
    {
        return this.markerLabel;
    }
    
    public void setDestinationMarker(String marker) 
    {
        this.markerLabel.changeMarker(marker);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        username = new javax.swing.JLabel();
        opponentIcon = new javax.swing.JLabel();
        turnArrow = new javax.swing.JLabel();
        destinationMarkerPanel = new javax.swing.JPanel();
        numberOfCards = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        setMaximumSize(new java.awt.Dimension(192, 236));
        setSize(new java.awt.Dimension(192, 236));

        username.setBackground(new java.awt.Color(255, 255, 255));
        username.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        username.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        opponentIcon.setBackground(new java.awt.Color(255, 255, 255));
        opponentIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/whodonedidit/gui/TempImages/computer.png"))); // NOI18N

        turnArrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/whodonedidit/gui/TempImages/turnimage.png"))); // NOI18N

        destinationMarkerPanel.setBackground(new java.awt.Color(255, 255, 255));
        destinationMarkerPanel.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        destinationMarkerPanel.setMaximumSize(new java.awt.Dimension(90, 90));
        destinationMarkerPanel.setMinimumSize(new java.awt.Dimension(90, 90));
        destinationMarkerPanel.setPreferredSize(new java.awt.Dimension(90, 90));

        numberOfCards.setBackground(new java.awt.Color(255, 255, 255));
        numberOfCards.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        numberOfCards.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numberOfCards.setText("0");
        numberOfCards.setSize(new java.awt.Dimension(7, 17));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(numberOfCards, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(destinationMarkerPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(40, 40, 40)
                        .add(opponentIcon))
                    .add(layout.createSequentialGroup()
                        .add(27, 27, 27)
                        .add(username, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 130, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(75, 75, 75)
                        .add(turnArrow)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(opponentIcon)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(username, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(destinationMarkerPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(27, 27, 27)
                        .add(numberOfCards, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 39, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(turnArrow, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 33, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(12, 12, 12))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel destinationMarkerPanel;
    private javax.swing.JLabel numberOfCards;
    private javax.swing.JLabel opponentIcon;
    private javax.swing.JLabel turnArrow;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
