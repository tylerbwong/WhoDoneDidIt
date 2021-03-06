package whodonedidit.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLayeredPane;
import whodonedidit.version1_0.Controller;
import whodonedidit.version1_0.ViewBuilder;

/**
 *
 * @author Tyler Wong
 */
public class ArrestPanel extends javax.swing.JPanel
{

    private MainFrame frame;
    private JLayeredPane layerPane;
    private TablePanel tablePanel;
    private ArrayList<CardButton> cards;
    private ArrayList<CardButton> placeButtons;
    private ArrayList<CardButton> personButtons;
    private ArrayList<CardButton> vehicleButtons;
    private Controller controller;
    private String person;
    private String vehicle;
    private String place;
    private boolean personSelected;
    private boolean vehicleSelected;
    private boolean destinationSelected;
    private NotesheetPanel noteSheet;

    /**
     * Creates new form ArrestPanel
     */
    public ArrestPanel(MainFrame frame, JLayeredPane layerPane, 
            NotesheetPanel noteSheet)
    {
        this.frame = frame;
        this.layerPane = layerPane;
        this.controller = this.frame.getController();
        this.placeButtons = new ArrayList<CardButton>();
        this.personButtons = new ArrayList<CardButton>();
        this.vehicleButtons = new ArrayList<CardButton>();
        this.noteSheet = noteSheet;
        initComponents();
        this.confirmButton.setEnabled(false);
        this.resetButton.setEnabled(false);
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
        cancelButton = new javax.swing.JButton();
        confirmButton = new javax.swing.JButton();
        personPanel = new javax.swing.JPanel();
        vehiclePanel = new javax.swing.JPanel();
        placePanel = new javax.swing.JPanel();
        resetButton = new javax.swing.JButton();
        notesheetButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 800, 600));
        setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));

        titleLabel.setBackground(new java.awt.Color(255, 255, 255));
        titleLabel.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        titleLabel.setText("Make An Arrest!");

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

        confirmButton.setBackground(new java.awt.Color(255, 255, 255));
        confirmButton.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        confirmButton.setText("Arrest!");
        confirmButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                confirmButtonActionPerformed(evt);
            }
        });

        personPanel.setBackground(new java.awt.Color(255, 255, 255));
        personPanel.setBounds(new java.awt.Rectangle(0, 0, 558, 132));
        personPanel.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        personPanel.setMaximumSize(new java.awt.Dimension(558, 132));
        personPanel.setMinimumSize(new java.awt.Dimension(558, 132));
        personPanel.setPreferredSize(new java.awt.Dimension(558, 132));
        personPanel.setLayout(new java.awt.GridBagLayout());

        vehiclePanel.setBackground(new java.awt.Color(255, 255, 255));
        vehiclePanel.setBounds(new java.awt.Rectangle(0, 0, 558, 132));
        vehiclePanel.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        vehiclePanel.setMaximumSize(new java.awt.Dimension(558, 132));
        vehiclePanel.setMinimumSize(new java.awt.Dimension(558, 132));
        vehiclePanel.setPreferredSize(new java.awt.Dimension(558, 132));
        vehiclePanel.setLayout(new java.awt.GridBagLayout());

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

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(77, 77, 77)
                .add(cancelButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(resetButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(confirmButton)
                .add(73, 73, 73))
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(notesheetButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 49, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(258, 258, 258)
                .add(titleLabel)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(placePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 763, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(17, 17, 17))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(vehiclePanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(personPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .add(120, 120, 120))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(13, 13, 13)
                        .add(titleLabel)
                        .add(18, 18, 18)
                        .add(personPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(notesheetButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(18, 18, 18)
                .add(vehiclePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 132, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(placePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 165, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cancelButton)
                    .add(resetButton)
                    .add(confirmButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public void setTablePanel(TablePanel tablePanel)
    {
        this.tablePanel = tablePanel;
    }

    public void setCards(ArrayList<CardButton> cards)
    {
        this.cards = cards;
    }

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cancelButtonActionPerformed
    {//GEN-HEADEREND:event_cancelButtonActionPerformed
        this.tablePanel.getArrestButton().setEnabled(true);
        this.layerPane.remove(layerPane.getIndexOf(this));
        this.layerPane.repaint();
        this.layerPane.validate();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_confirmButtonActionPerformed
    {//GEN-HEADEREND:event_confirmButtonActionPerformed
        this.controller.sendMakeAccusationAction(this.person, this.vehicle, this.place);
        this.frame.disableArrestButton();
        this.frame.disableActionCards();
        this.frame.disableEndTurnButton();
        this.frame.removeDialog(this);
    }//GEN-LAST:event_confirmButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_resetButtonActionPerformed
    {//GEN-HEADEREND:event_resetButtonActionPerformed
        for (int i = 0; i < this.placeButtons.size(); i++)
        {
            this.placeButtons.get(i).setEnabled(true);
        }
        for (int i = 0; i < this.personButtons.size(); i++)
        {
            this.personButtons.get(i).setEnabled(true);
        }
        for (int i = 0; i < this.vehicleButtons.size(); i++)
        {
            this.vehicleButtons.get(i).setEnabled(true);
        }
        this.person = null;
        this.vehicle = null;
        this.place = null;
        this.personSelected = this.vehicleSelected = this.destinationSelected = false;
        this.resetButton.setEnabled(false);
        this.confirmButton.setEnabled(false);
    }//GEN-LAST:event_resetButtonActionPerformed

    private void notesheetButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_notesheetButtonActionPerformed
    {//GEN-HEADEREND:event_notesheetButtonActionPerformed
        this.layerPane.add(this.noteSheet, JLayeredPane.DRAG_LAYER);
        this.layerPane.moveToFront(this.noteSheet);
        this.layerPane.moveToBack(this);
        this.layerPane.validate();
        this.noteSheet.getPerson1Check().requestFocus();
    }//GEN-LAST:event_notesheetButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton confirmButton;
    private javax.swing.JButton notesheetButton;
    private javax.swing.JPanel personPanel;
    private javax.swing.JPanel placePanel;
    private javax.swing.JButton resetButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel vehiclePanel;
    // End of variables declaration//GEN-END:variables
}
