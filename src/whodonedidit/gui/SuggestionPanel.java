package whodonedidit.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLayeredPane;
import whodonedidit.version1_0.ActionCardType;

/**
 *
 * @author Tyler Wong
 */
public class SuggestionPanel extends javax.swing.JPanel
{

    private MainFrame frame;
    private JLayeredPane layerPane;
    private TablePanel tablePanel;
    private ArrayList<CardButton> cards;
    private ActionCardType suggestionType;
    private String currentDestination;
    private NotesheetPanel noteSheet;
    private boolean personSelected;
    private boolean vehicleSelected;
    private boolean destinationSelected;
    private ArrayList<CardButton> placeButtons;
    private ArrayList<CardButton> personButtons;
    private ArrayList<CardButton> vehicleButtons;
    private String person;
    private String vehicle;
    private String place;

    /**
     * Creates new form SuggestionPanel
     */
    public SuggestionPanel(MainFrame frame, JLayeredPane layerPane,
            ActionCardType suggestionType, String currentDestination)
    {
        this.frame = frame;
        this.layerPane = layerPane;
        this.suggestionType = suggestionType;
        this.currentDestination = currentDestination;
        initComponents();
        this.confirmButton.setEnabled(false);
        this.resetButton.setEnabled(false);
        this.placeButtons = new ArrayList<CardButton>();
        this.personButtons = new ArrayList<CardButton>();
        this.vehicleButtons = new ArrayList<CardButton>();
        this.noteSheet = this.frame.getTable().getNotesheet();
        this.tablePanel = this.frame.getTable();
        setupCards();
        if (this.suggestionType != ActionCardType.SuggestFromCurrent)
        {
            this.swapCheck.setVisible(false);
            this.suggestCheck.setVisible(false);
            this.revalidate();
            this.repaint();
        }
        else
        {
            this.titleLabel.setText("Make A Suggestion Or Swap Destination Markers!");
            this.place = this.currentDestination;
            this.swapCheck.setVisible(true);
            this.suggestCheck.setVisible(true);
            this.suggestCheck.setSelected(true);
            this.suggestCheck.setEnabled(false);
            for (int i = 0; i < this.vehicleButtons.size(); i++)
            {
                this.personButtons.get(i).setEnabled(true);
                this.vehicleButtons.get(i).setEnabled(true);
            }
            for (int i = 0; i < this.placeButtons.size(); i++)
            {
                if (!this.placeButtons.get(i).getCardName().equals(this.currentDestination))
                {
                    this.placeButtons.get(i).setEnabled(false);
                }
                else
                {
                    this.placeButtons.get(i).setEnabled(true);
                }
            }
            this.destinationSelected = true;
            this.revalidate();
            this.repaint();
        }
    }

    public void setupCards()
    {
        int i = 0;
        for (String cardName : this.tablePanel.clueCardImages.keySet())
        {
            CardButton button = new CardButton(cardName, this.tablePanel.clueCardImages.get(cardName), i);

            if (i < 9)
            {
                button.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent evt)
                    {
                        CardButton currentButton = ((CardButton) evt.getSource());
                        int number = currentButton.getCardNumber();
                        String name = currentButton.getCardName();
                        destinationSelected = true;
                        if (personSelected && vehicleSelected && destinationSelected)
                        {
                            confirmButton.setEnabled(true);
                        }
                        resetButton.setEnabled(true);
                        cardSelected(name, number);
                    }
                });
                this.placePanel.add(button);
                this.placeButtons.add(button);
                this.placePanel.revalidate();
                this.placePanel.repaint();
            }
            else if (i >= 9 && i < 15)
            {
                button.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent evt)
                    {
                        CardButton currentButton = ((CardButton) evt.getSource());
                        int number = currentButton.getCardNumber();
                        String name = currentButton.getCardName();
                        personSelected = true;
                        if (personSelected && vehicleSelected && destinationSelected)
                        {
                            confirmButton.setEnabled(true);
                        }
                        resetButton.setEnabled(true);
                        cardSelected(name, number);
                    }
                });
                this.personPanel.add(button);
                this.personButtons.add(button);
                this.personPanel.revalidate();
                this.personPanel.repaint();
            }
            else if (i >= 15)
            {
                button.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent evt)
                    {
                        CardButton currentButton = ((CardButton) evt.getSource());
                        int number = currentButton.getCardNumber();
                        String name = currentButton.getCardName();
                        vehicleSelected = true;
                        if (personSelected && vehicleSelected && destinationSelected)
                        {
                            confirmButton.setEnabled(true);
                        }
                        resetButton.setEnabled(true);
                        cardSelected(name, number);
                    }
                });
                this.vehiclePanel.add(button);
                this.vehicleButtons.add(button);
                this.vehiclePanel.revalidate();
                this.vehiclePanel.repaint();
            }
            i++;
        }
        this.revalidate();
        this.repaint();
        this.frame.refactor();
    }

    private void cardSelected(String cardName, int cardNumber)
    {
        if (cardNumber < 9)
        {
            this.place = cardName;
            for (int i = 0; i < this.placeButtons.size(); i++)
            {
                if (!this.placeButtons.get(i).getCardName().equals(cardName))
                {
                    this.placeButtons.get(i).setEnabled(false);
                }
            }
        }
        else if (cardNumber >= 9 && cardNumber < 15)
        {
            this.person = cardName;
            for (int i = 0; i < this.personButtons.size(); i++)
            {
                if (!this.personButtons.get(i).getCardName().equals(cardName))
                {
                    this.personButtons.get(i).setEnabled(false);
                }
            }
        }
        else if (cardNumber >= 15)
        {
            this.vehicle = cardName;
            for (int i = 0; i < this.vehicleButtons.size(); i++)
            {
                if (!this.vehicleButtons.get(i).getCardName().equals(cardName))
                {
                    this.vehicleButtons.get(i).setEnabled(false);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        titleLabel = new javax.swing.JLabel();
        confirmButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        cancelButton1 = new javax.swing.JButton();
        swapCheck = new javax.swing.JCheckBox();
        suggestCheck = new javax.swing.JCheckBox();
        notesheetButton = new javax.swing.JButton();
        personPanel = new javax.swing.JPanel();
        placePanel = new javax.swing.JPanel();
        resetButton = new javax.swing.JButton();
        vehiclePanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 800, 600));
        setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        setMaximumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));

        titleLabel.setBackground(new java.awt.Color(255, 255, 255));
        titleLabel.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Make A Suggestion!");

        confirmButton.setBackground(new java.awt.Color(255, 255, 255));
        confirmButton.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        confirmButton.setText("Submit");
        confirmButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                confirmButtonActionPerformed(evt);
            }
        });

        cancelButton.setBackground(new java.awt.Color(255, 255, 255));
        cancelButton.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cancelButtonActionPerformed(evt);
            }
        });

        cancelButton1.setBackground(new java.awt.Color(255, 255, 255));
        cancelButton1.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        cancelButton1.setText("X");
        cancelButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cancelButton1ActionPerformed(evt);
            }
        });

        swapCheck.setBackground(new java.awt.Color(255, 255, 255));
        swapCheck.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        swapCheck.setText("Swap Destination Markers");
        swapCheck.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                swapCheckActionPerformed(evt);
            }
        });

        suggestCheck.setBackground(new java.awt.Color(255, 255, 255));
        suggestCheck.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        suggestCheck.setText("Suggest From Current");
        suggestCheck.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                suggestCheckActionPerformed(evt);
            }
        });

        notesheetButton.setBackground(new java.awt.Color(255, 255, 255));
        notesheetButton.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        notesheetButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/whodonedidit/gui/buttons/notesheet.png"))); // NOI18N
        notesheetButton.setMaximumSize(new java.awt.Dimension(52, 70));
        notesheetButton.setMinimumSize(new java.awt.Dimension(52, 70));
        notesheetButton.setPreferredSize(new java.awt.Dimension(52, 70));
        notesheetButton.setRolloverEnabled(true);
        notesheetButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                notesheetButtonActionPerformed(evt);
            }
        });

        personPanel.setBackground(new java.awt.Color(255, 255, 255));
        personPanel.setBounds(new java.awt.Rectangle(0, 0, 558, 132));
        personPanel.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        personPanel.setMaximumSize(new java.awt.Dimension(558, 132));
        personPanel.setMinimumSize(new java.awt.Dimension(558, 132));
        personPanel.setPreferredSize(new java.awt.Dimension(558, 132));
        personPanel.setLayout(new java.awt.GridBagLayout());

        placePanel.setBackground(new java.awt.Color(255, 255, 255));
        placePanel.setBounds(new java.awt.Rectangle(0, 0, 665, 165));
        placePanel.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        placePanel.setMaximumSize(new java.awt.Dimension(665, 165));
        placePanel.setMinimumSize(new java.awt.Dimension(665, 165));
        placePanel.setPreferredSize(new java.awt.Dimension(665, 165));
        placePanel.setLayout(new java.awt.GridBagLayout());

        resetButton.setBackground(new java.awt.Color(255, 255, 255));
        resetButton.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                resetButtonActionPerformed(evt);
            }
        });

        vehiclePanel.setBackground(new java.awt.Color(255, 255, 255));
        vehiclePanel.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        vehiclePanel.setMaximumSize(new java.awt.Dimension(558, 132));
        vehiclePanel.setMinimumSize(new java.awt.Dimension(558, 132));
        vehiclePanel.setPreferredSize(new java.awt.Dimension(558, 132));
        vehiclePanel.setLayout(new java.awt.GridBagLayout());

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(78, 78, 78)
                .add(cancelButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(resetButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(confirmButton)
                .add(82, 82, 82))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(notesheetButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 49, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(20, 20, 20)
                                .add(titleLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 648, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(layout.createSequentialGroup()
                                .add(12, 12, 12)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(vehiclePanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                                    .add(personPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(cancelButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 37, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .add(layout.createSequentialGroup()
                        .add(176, 176, 176)
                        .add(suggestCheck)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(swapCheck)
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .add(layout.createSequentialGroup()
                .add(16, 16, 16)
                .add(placePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 768, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(6, 6, 6)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(notesheetButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(cancelButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 37, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(titleLabel))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(suggestCheck)
                            .add(swapCheck))))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 7, Short.MAX_VALUE)
                .add(personPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(vehiclePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(placePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 165, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cancelButton)
                    .add(confirmButton)
                    .add(resetButton))
                .add(23, 23, 23))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_confirmButtonActionPerformed
    {//GEN-HEADEREND:event_confirmButtonActionPerformed
        if (this.swapCheck.isSelected())
        {
            this.frame.getController().sendSwapDestinationMarkersAction(this.place);
        }
        else
        {
            this.frame.getController().sendMakeSuggestionAction(this.suggestionType,
                    this.person, this.vehicle, this.place);
        }
        this.layerPane.remove(this.layerPane.getIndexOf(this));
        this.frame.enableArrestButton();
        this.validate();
        this.layerPane.repaint();
        this.layerPane.validate();
    }//GEN-LAST:event_confirmButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cancelButtonActionPerformed
    {//GEN-HEADEREND:event_cancelButtonActionPerformed
        this.frame.enableActionCards();
        this.frame.disableEndTurnButton();
        this.layerPane.remove(layerPane.getIndexOf(this));
        this.layerPane.repaint();
        this.layerPane.validate();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void cancelButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cancelButton1ActionPerformed
    {//GEN-HEADEREND:event_cancelButton1ActionPerformed
        this.frame.enableActionCards();
        this.frame.disableEndTurnButton();
        this.layerPane.remove(this.layerPane.getIndexOf(this));
        this.layerPane.repaint();
        this.layerPane.validate();
    }//GEN-LAST:event_cancelButton1ActionPerformed

    private void notesheetButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_notesheetButtonActionPerformed
    {//GEN-HEADEREND:event_notesheetButtonActionPerformed
        this.layerPane.add(this.noteSheet, JLayeredPane.DRAG_LAYER);
        this.layerPane.moveToFront(this.noteSheet);
        this.layerPane.moveToBack(this);
        this.layerPane.validate();
        this.noteSheet.getPerson1Check().requestFocus();
    }//GEN-LAST:event_notesheetButtonActionPerformed

    private void swapCheckActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_swapCheckActionPerformed
    {//GEN-HEADEREND:event_swapCheckActionPerformed
        this.suggestCheck.setSelected(false);
        this.swapCheck.setEnabled(false);
        this.suggestCheck.setEnabled(true);
        
        for (int i = 0; i < this.vehicleButtons.size(); i++)
        {
            this.personButtons.get(i).setEnabled(false);
            this.vehicleButtons.get(i).setEnabled(false);
        }
        for (int i = 0; i < this.placeButtons.size(); i++)
        {
            if (!this.placeButtons.get(i).getCardName().equals(this.currentDestination))
            {
                this.placeButtons.get(i).setEnabled(true);
            }
            else
            {
                this.placeButtons.get(i).setEnabled(false);
            }
        }
        this.resetButton.setEnabled(false);
        this.confirmButton.setEnabled(false);
        this.personSelected = true;
        this.vehicleSelected = true;
        this.destinationSelected = false;
    }//GEN-LAST:event_swapCheckActionPerformed

    private void suggestCheckActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_suggestCheckActionPerformed
    {//GEN-HEADEREND:event_suggestCheckActionPerformed
        this.swapCheck.setSelected(false);
        this.suggestCheck.setEnabled(false);
        this.swapCheck.setEnabled(true);
        
        for (int i = 0; i < this.vehicleButtons.size(); i++)
        {
            this.personButtons.get(i).setEnabled(true);
            this.vehicleButtons.get(i).setEnabled(true);
        }
        for (int i = 0; i < this.placeButtons.size(); i++)
        {
            if (!this.placeButtons.get(i).getCardName().equals(this.currentDestination))
            {
                this.placeButtons.get(i).setEnabled(false);
            }
            else
            {
                this.placeButtons.get(i).setEnabled(true);
            }
        }       
        this.resetButton.setEnabled(false);
        this.confirmButton.setEnabled(false);
        this.personSelected = false;
        this.vehicleSelected = false;
        this.destinationSelected = true;
    }//GEN-LAST:event_suggestCheckActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_resetButtonActionPerformed
    {//GEN-HEADEREND:event_resetButtonActionPerformed
        if (this.swapCheck.isSelected())
        {
            for (int i = 0; i < this.vehicleButtons.size(); i++)
            {
                this.personButtons.get(i).setEnabled(false);
                this.vehicleButtons.get(i).setEnabled(false);
            }
            for (int i = 0; i < this.placeButtons.size(); i++)
            {
                if (!this.placeButtons.get(i).getCardName().equals(this.currentDestination))
                {
                    this.placeButtons.get(i).setEnabled(true);
                }
                else
                {
                    this.placeButtons.get(i).setEnabled(false);
                }
            }
            this.personSelected = true;
            this.vehicleSelected = true;
            this.destinationSelected = false;
        }
        else if (this.suggestCheck.isSelected())
        {
            for (int i = 0; i < this.vehicleButtons.size(); i++)
            {
                this.personButtons.get(i).setEnabled(true);
                this.vehicleButtons.get(i).setEnabled(true);
            }
            for (int i = 0; i < this.placeButtons.size(); i++)
            {
                if (!this.placeButtons.get(i).getCardName().equals(this.currentDestination))
                {
                    this.placeButtons.get(i).setEnabled(false);
                }
                else
                {
                    this.placeButtons.get(i).setEnabled(true);
                }
            }
            this.place = currentDestination;
            this.personSelected = false;
            this.vehicleSelected = false;
            this.destinationSelected = true;
        }
        else
        {
            for (int i = 0; i < this.vehicleButtons.size(); i++)
            {
                this.personButtons.get(i).setEnabled(true);
                this.vehicleButtons.get(i).setEnabled(true);
            }
            for (int i = 0; i < this.placeButtons.size(); i++)
            {
                this.placeButtons.get(i).setEnabled(true);
            }
            this.personSelected = false;
            this.vehicleSelected = false;
            this.destinationSelected = false;
        }
        this.person = null;
        this.vehicle = null;
        this.resetButton.setEnabled(false);
        this.confirmButton.setEnabled(false);
    }//GEN-LAST:event_resetButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton cancelButton1;
    private javax.swing.JButton confirmButton;
    private javax.swing.JButton notesheetButton;
    private javax.swing.JPanel personPanel;
    private javax.swing.JPanel placePanel;
    private javax.swing.JButton resetButton;
    private javax.swing.JCheckBox suggestCheck;
    private javax.swing.JCheckBox swapCheck;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel vehiclePanel;
    // End of variables declaration//GEN-END:variables
}
