package whodonedidit.gui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.KeyStroke;

/**
 *
 * @author Tyler Wong
 */
public class NotesheetPanel extends javax.swing.JPanel
{

    JLayeredPane layerPane;
    JFrame frame;

    /**
     * Creates new form NoteSheet
     */
    public NotesheetPanel(JFrame frame, JLayeredPane pane)
    {
        this.frame = frame;
        this.layerPane = pane;
        initComponents();
        NotesheetAction noteAction = new NotesheetAction(this);
        this.backButton.getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), "pressed");
        this.backButton.getActionMap().put("pressed", noteAction);
    }

    class NotesheetAction extends AbstractAction
    {

        private NotesheetPanel panel;

        public NotesheetAction(NotesheetPanel panel)
        {
            this.panel = panel;
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("Closed notesheet");
            layerPane.remove(layerPane.getIndexOf(panel));
            layerPane.repaint();
            layerPane.validate();
        }
    }

    public JCheckBox getPerson1Check()
    {
        return this.person1Check;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        backButton = new javax.swing.JButton();
        peopleLabel = new javax.swing.JLabel();
        person1Check = new javax.swing.JCheckBox();
        person2Check = new javax.swing.JCheckBox();
        person3Check = new javax.swing.JCheckBox();
        person4Check = new javax.swing.JCheckBox();
        person5Check = new javax.swing.JCheckBox();
        person6Check = new javax.swing.JCheckBox();
        vehicleLabel = new javax.swing.JLabel();
        vehicle1Check = new javax.swing.JCheckBox();
        vehicle2Check = new javax.swing.JCheckBox();
        vehicle3Check = new javax.swing.JCheckBox();
        vehicle4Check = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        vehicle5Check = new javax.swing.JCheckBox();
        vehicle6Check = new javax.swing.JCheckBox();
        placesLabel = new javax.swing.JLabel();
        place1Check = new javax.swing.JCheckBox();
        place2Check = new javax.swing.JCheckBox();
        place3Check = new javax.swing.JCheckBox();
        place4Check = new javax.swing.JCheckBox();
        place5Check = new javax.swing.JCheckBox();
        place6Check = new javax.swing.JCheckBox();
        place7Check = new javax.swing.JCheckBox();
        place8Check = new javax.swing.JCheckBox();
        place9Check = new javax.swing.JCheckBox();
        commentsLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        setMaximumSize(new java.awt.Dimension(341, 600));
        setPreferredSize(new java.awt.Dimension(341, 600));
        setSize(new java.awt.Dimension(341, 600));

        backButton.setBackground(new java.awt.Color(255, 255, 255));
        backButton.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        backButton.setText("Close");
        backButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                backButtonActionPerformed(evt);
            }
        });

        peopleLabel.setBackground(new java.awt.Color(255, 255, 255));
        peopleLabel.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        peopleLabel.setText("Suspects");

        person1Check.setBackground(new java.awt.Color(255, 255, 255));
        person1Check.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        person1Check.setText("Aphrodite (female)");
        person1Check.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                person1CheckActionPerformed(evt);
            }
        });

        person2Check.setBackground(new java.awt.Color(255, 255, 255));
        person2Check.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        person2Check.setText("Ares (male)");
        person2Check.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                person2CheckActionPerformed(evt);
            }
        });

        person3Check.setBackground(new java.awt.Color(255, 255, 255));
        person3Check.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        person3Check.setText("Artemis (female)");
        person3Check.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                person3CheckActionPerformed(evt);
            }
        });

        person4Check.setBackground(new java.awt.Color(255, 255, 255));
        person4Check.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        person4Check.setText("Dionysus (male)");
        person4Check.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                person4CheckActionPerformed(evt);
            }
        });

        person5Check.setBackground(new java.awt.Color(255, 255, 255));
        person5Check.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        person5Check.setText("Hera (female)");
        person5Check.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                person5CheckActionPerformed(evt);
            }
        });

        person6Check.setBackground(new java.awt.Color(255, 255, 255));
        person6Check.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        person6Check.setText("Hermes (male)");
        person6Check.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                person6CheckActionPerformed(evt);
            }
        });

        vehicleLabel.setBackground(new java.awt.Color(255, 255, 255));
        vehicleLabel.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        vehicleLabel.setText("Vehicles");

        vehicle1Check.setBackground(new java.awt.Color(255, 255, 255));
        vehicle1Check.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        vehicle1Check.setText("Apollo's Chariot (blue)");
        vehicle1Check.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                vehicle1CheckActionPerformed(evt);
            }
        });

        vehicle2Check.setBackground(new java.awt.Color(255, 255, 255));
        vehicle2Check.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        vehicle2Check.setText("Athena's Horse (blue)");
        vehicle2Check.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                vehicle2CheckActionPerformed(evt);
            }
        });

        vehicle3Check.setBackground(new java.awt.Color(255, 255, 255));
        vehicle3Check.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        vehicle3Check.setText("Eros' Wings (blue)");
        vehicle3Check.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                vehicle3CheckActionPerformed(evt);
            }
        });

        vehicle4Check.setBackground(new java.awt.Color(255, 255, 255));
        vehicle4Check.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        vehicle4Check.setText("Hades' Dogs (red)");
        vehicle4Check.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                vehicle4CheckActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        vehicle5Check.setBackground(new java.awt.Color(255, 255, 255));
        vehicle5Check.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        vehicle5Check.setText("Hermes Sandals (red)");
        vehicle5Check.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                vehicle5CheckActionPerformed(evt);
            }
        });

        vehicle6Check.setBackground(new java.awt.Color(255, 255, 255));
        vehicle6Check.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        vehicle6Check.setText("Poseidon's Ship (red)");

        placesLabel.setBackground(new java.awt.Color(255, 255, 255));
        placesLabel.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        placesLabel.setText("Destinations");

        place1Check.setBackground(new java.awt.Color(255, 255, 255));
        place1Check.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        place1Check.setText("Athena's Forest (N/E)");
        place1Check.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                place1CheckActionPerformed(evt);
            }
        });

        place2Check.setBackground(new java.awt.Color(255, 255, 255));
        place2Check.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        place2Check.setText("Athens (N/E)");
        place2Check.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                place2CheckActionPerformed(evt);
            }
        });

        place3Check.setBackground(new java.awt.Color(255, 255, 255));
        place3Check.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        place3Check.setText("Atlas' Sky (N/W)");
        place3Check.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                place3CheckActionPerformed(evt);
            }
        });

        place4Check.setBackground(new java.awt.Color(255, 255, 255));
        place4Check.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        place4Check.setText("Dionysus Vineyard (N/W)");
        place4Check.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                place4CheckActionPerformed(evt);
            }
        });

        place5Check.setBackground(new java.awt.Color(255, 255, 255));
        place5Check.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        place5Check.setText("Hades Underworld (S/W)");
        place5Check.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                place5CheckActionPerformed(evt);
            }
        });

        place6Check.setBackground(new java.awt.Color(255, 255, 255));
        place6Check.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        place6Check.setText("Hephaestus Volcano (S/W)");
        place6Check.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                place6CheckActionPerformed(evt);
            }
        });

        place7Check.setBackground(new java.awt.Color(255, 255, 255));
        place7Check.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        place7Check.setText("Mount Olympus (S/W)");
        place7Check.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                place7CheckActionPerformed(evt);
            }
        });

        place8Check.setBackground(new java.awt.Color(255, 255, 255));
        place8Check.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        place8Check.setText("Phoebe's Moon (S/E)");
        place8Check.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                place8CheckActionPerformed(evt);
            }
        });

        place9Check.setBackground(new java.awt.Color(255, 255, 255));
        place9Check.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        place9Check.setText("Poseidon Ocean (S/E)");
        place9Check.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                place9CheckActionPerformed(evt);
            }
        });

        commentsLabel.setBackground(new java.awt.Color(255, 255, 255));
        commentsLabel.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        commentsLabel.setText("Comments");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jScrollPane1)
                            .add(layout.createSequentialGroup()
                                .add(commentsLabel)
                                .add(0, 267, Short.MAX_VALUE))
                            .add(layout.createSequentialGroup()
                                .add(peopleLabel)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(backButton))
                            .add(layout.createSequentialGroup()
                                .add(6, 6, 6)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(person3Check)
                                    .add(person5Check)
                                    .add(person1Check))
                                .add(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(vehicleLabel)
                            .add(placesLabel)
                            .add(layout.createSequentialGroup()
                                .add(6, 6, 6)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(layout.createSequentialGroup()
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(vehicle1Check)
                                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                                .add(vehicle6Check)
                                                .add(vehicle2Check))
                                            .add(place1Check)
                                            .add(place3Check)
                                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                .add(place2Check)
                                                .add(place9Check)))
                                        .add(25, 25, 25)
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(place8Check)
                                            .add(person2Check)
                                            .add(person4Check)
                                            .add(person6Check)
                                            .add(vehicle4Check)
                                            .add(vehicle3Check)
                                            .add(vehicle5Check)
                                            .add(place7Check)
                                            .add(place4Check)
                                            .add(place6Check)))
                                    .add(layout.createSequentialGroup()
                                        .add(1, 1, 1)
                                        .add(place5Check)))))
                        .add(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(peopleLabel)
                    .add(backButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(person1Check, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(person4Check, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(person2Check, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(person3Check, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 15, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(person5Check, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(person6Check, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(vehicleLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(vehicle1Check, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(vehicle4Check, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(vehicle2Check, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(vehicle3Check, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(vehicle6Check, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(vehicle5Check, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(placesLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(place1Check, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(place7Check, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(place3Check, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(place4Check, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(place6Check, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(place9Check, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(place8Check, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(place2Check, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(place5Check, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(commentsLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void person1CheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_person1CheckActionPerformed
    }//GEN-LAST:event_person1CheckActionPerformed

    private void person2CheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_person2CheckActionPerformed
    }//GEN-LAST:event_person2CheckActionPerformed

    private void person3CheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_person3CheckActionPerformed
    }//GEN-LAST:event_person3CheckActionPerformed

    private void person4CheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_person4CheckActionPerformed
    }//GEN-LAST:event_person4CheckActionPerformed

    private void person5CheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_person5CheckActionPerformed
    }//GEN-LAST:event_person5CheckActionPerformed

    private void person6CheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_person6CheckActionPerformed
    }//GEN-LAST:event_person6CheckActionPerformed

    private void vehicle1CheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehicle1CheckActionPerformed
    }//GEN-LAST:event_vehicle1CheckActionPerformed

    private void vehicle2CheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehicle2CheckActionPerformed
    }//GEN-LAST:event_vehicle2CheckActionPerformed

    private void vehicle3CheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehicle3CheckActionPerformed
    }//GEN-LAST:event_vehicle3CheckActionPerformed

    private void vehicle4CheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehicle4CheckActionPerformed
    }//GEN-LAST:event_vehicle4CheckActionPerformed

    private void vehicle5CheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehicle5CheckActionPerformed
    }//GEN-LAST:event_vehicle5CheckActionPerformed

    private void place1CheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place1CheckActionPerformed
    }//GEN-LAST:event_place1CheckActionPerformed

    private void place2CheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place2CheckActionPerformed
    }//GEN-LAST:event_place2CheckActionPerformed

    private void place3CheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place3CheckActionPerformed
    }//GEN-LAST:event_place3CheckActionPerformed

    private void place4CheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place4CheckActionPerformed
    }//GEN-LAST:event_place4CheckActionPerformed

    private void place5CheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place5CheckActionPerformed
    }//GEN-LAST:event_place5CheckActionPerformed

    private void place6CheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place6CheckActionPerformed
    }//GEN-LAST:event_place6CheckActionPerformed

    private void place7CheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place7CheckActionPerformed
    }//GEN-LAST:event_place7CheckActionPerformed

    private void place8CheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place8CheckActionPerformed
    }//GEN-LAST:event_place8CheckActionPerformed

    private void place9CheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_place9CheckActionPerformed
    }//GEN-LAST:event_place9CheckActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.layerPane.remove(this.layerPane.getIndexOf(this));
        this.layerPane.repaint();
        this.layerPane.validate();
    }//GEN-LAST:event_backButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel commentsLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel peopleLabel;
    private javax.swing.JCheckBox person1Check;
    private javax.swing.JCheckBox person2Check;
    private javax.swing.JCheckBox person3Check;
    private javax.swing.JCheckBox person4Check;
    private javax.swing.JCheckBox person5Check;
    private javax.swing.JCheckBox person6Check;
    private javax.swing.JCheckBox place1Check;
    private javax.swing.JCheckBox place2Check;
    private javax.swing.JCheckBox place3Check;
    private javax.swing.JCheckBox place4Check;
    private javax.swing.JCheckBox place5Check;
    private javax.swing.JCheckBox place6Check;
    private javax.swing.JCheckBox place7Check;
    private javax.swing.JCheckBox place8Check;
    private javax.swing.JCheckBox place9Check;
    private javax.swing.JLabel placesLabel;
    private javax.swing.JCheckBox vehicle1Check;
    private javax.swing.JCheckBox vehicle2Check;
    private javax.swing.JCheckBox vehicle3Check;
    private javax.swing.JCheckBox vehicle4Check;
    private javax.swing.JCheckBox vehicle5Check;
    private javax.swing.JCheckBox vehicle6Check;
    private javax.swing.JLabel vehicleLabel;
    // End of variables declaration//GEN-END:variables
}
