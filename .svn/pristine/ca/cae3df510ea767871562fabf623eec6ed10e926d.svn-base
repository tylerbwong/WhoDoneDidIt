package whodonedidit.gui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

/**
 *
 * @author Tyler Wong
 */
public class ScreenNamePanel extends javax.swing.JPanel
{

    private MainFrame frame;
    private String name;
    private static final int numButtons = 2;
    private JButton[] buttons = new JButton[2];
    private int currIndex = 0;
    private boolean isOnline;
    private String language;

    /**
     * Creates new form ScreenName
     */
    public ScreenNamePanel(MainFrame frame, boolean isOnline)
    {
        this.frame = frame;
        this.isOnline = isOnline;
        initComponents();
        this.buttons[0] = this.backButton;
        this.buttons[1] = this.okButton;
        this.nameField.requestFocus();
        this.buttons[1].setEnabled(false);
        LobbyAction okAction = new LobbyAction(this);
        this.nameField.setDocument(new ScreenNameLimit(15));
        Document document = this.nameField.getDocument();
        document.addDocumentListener(new JButtonStateController(this.buttons[1]));
        this.okButton.getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "ok");
        this.okButton.getActionMap().put("ok", okAction);
    }
    
    class LobbyAction extends AbstractAction
    {
        private ScreenNamePanel panel;
        
        public LobbyAction(ScreenNamePanel panel)
        {
            this.panel = panel;
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            frame.removePanel(this.panel);
            frame.createLobbyPanel(isOnline, getScreenName());
        }
    }
    
    public String getLanguage()
    {
        return this.language;
    }
    
    public void setLanguage(String lang)
    {
        this.language = lang;
        
        if (this.language.equals("Español"))
        {
            this.titleLabel.setText("Introduzca su nombre de usuario");
            this.subTitleLabel.setText("* Su nombre de pantalla te hará "
                    + "identificable a otros jugadores en línea");
            this.charMax.setText("(15 caracteres como máximo)");
            this.backButton.setText("Regresa");
            this.okButton.setText("Confirmar");
            this.revalidate();
            this.repaint();
            this.frame.refactor();
        }
        else if(this.language.equals("中文"))
        {
            this.titleLabel.setText("輸入您的網名");
            this.subTitleLabel.setText("*您的網名會令你識別到網上的其他玩家");
            this.charMax.setText("(15個字符)");
            this.backButton.setText("回去");
            this.okButton.setText("確認");
            this.revalidate();
            this.repaint();
            this.frame.refactor();
        }
    }

    public void setOnline(boolean isOnline)
    {
        this.isOnline = isOnline;
    }

    public String getName()
    {
        return this.name;
    }

    public JTextField getTextField()
    {
        return this.nameField;
    }
    
    public String getScreenName()
    {
        return this.nameField.getText();
    }
    
    class JButtonStateController implements DocumentListener 
    {
        JButton button;
  
        JButtonStateController(JButton button) 
        {
            this.button = button ;
        }

        public void changedUpdate(DocumentEvent e) 
        {
            try
            {
                disableIfEmpty(e);
            }
            catch (BadLocationException ex)
            {
                Logger.getLogger(ScreenNamePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        public void insertUpdate(DocumentEvent e) 
        {
            try
            {
                disableIfEmpty(e);
            }
            catch (BadLocationException ex)
            {
                Logger.getLogger(ScreenNamePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        public void removeUpdate(DocumentEvent e) 
        {
            try
            {
                disableIfEmpty(e);
            }
            catch (BadLocationException ex)
            {
                Logger.getLogger(ScreenNamePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        public void disableIfEmpty(DocumentEvent e) throws BadLocationException 
        {
            int length = e.getDocument().getLength();
            button.setEnabled(length > 0 
                && !e.getDocument().getText(0, length).trim().isEmpty());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        namePanel = new javax.swing.JPanel();
        nameField = new javax.swing.JTextField();
        titleLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        subTitleLabel = new javax.swing.JLabel();
        charMax = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 800, 600));
        setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        setMaximumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));

        namePanel.setBackground(new java.awt.Color(255, 255, 255));
        namePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        namePanel.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        namePanel.setMaximumSize(new java.awt.Dimension(400, 247));
        namePanel.setSize(new java.awt.Dimension(400, 247));

        nameField.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N

        titleLabel.setBackground(new java.awt.Color(255, 255, 255));
        titleLabel.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Enter your screen name");
        titleLabel.setSize(new java.awt.Dimension(189, 22));

        backButton.setBackground(new java.awt.Color(255, 255, 255));
        backButton.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        backButton.setText("Back");
        backButton.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                backButtonMouseEntered(evt);
            }
        });
        backButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                backButtonActionPerformed(evt);
            }
        });
        backButton.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                backButtonKeyPressed(evt);
            }
        });

        okButton.setBackground(new java.awt.Color(255, 255, 255));
        okButton.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        okButton.setText("OK");
        okButton.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                okButtonMouseEntered(evt);
            }
        });
        okButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                okButtonActionPerformed(evt);
            }
        });
        okButton.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                okButtonKeyPressed(evt);
            }
        });

        subTitleLabel.setBackground(new java.awt.Color(255, 255, 255));
        subTitleLabel.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        subTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subTitleLabel.setText("*Your screen name will make you identifiable to other players online");
        subTitleLabel.setSize(new java.awt.Dimension(291, 13));

        charMax.setBackground(new java.awt.Color(255, 255, 255));
        charMax.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        charMax.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        charMax.setText("(15 character limit)");
        charMax.setSize(new java.awt.Dimension(80, 13));

        org.jdesktop.layout.GroupLayout namePanelLayout = new org.jdesktop.layout.GroupLayout(namePanel);
        namePanel.setLayout(namePanelLayout);
        namePanelLayout.setHorizontalGroup(
            namePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, namePanelLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .add(namePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, namePanelLayout.createSequentialGroup()
                        .add(namePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(titleLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 291, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(namePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                .add(org.jdesktop.layout.GroupLayout.LEADING, nameField)
                                .add(namePanelLayout.createSequentialGroup()
                                    .add(backButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 101, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 81, Short.MAX_VALUE)
                                    .add(okButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 99, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                        .add(57, 57, 57))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, namePanelLayout.createSequentialGroup()
                        .add(subTitleLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 338, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(31, 31, 31))))
            .add(namePanelLayout.createSequentialGroup()
                .add(94, 94, 94)
                .add(charMax, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 208, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, Short.MAX_VALUE))
        );
        namePanelLayout.setVerticalGroup(
            namePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(namePanelLayout.createSequentialGroup()
                .add(34, 34, 34)
                .add(titleLabel)
                .add(18, 18, 18)
                .add(subTitleLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(charMax)
                .add(18, 18, 18)
                .add(nameField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(31, 31, 31)
                .add(namePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(backButton)
                    .add(okButton))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(195, 195, 195)
                .add(namePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(205, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(171, 171, 171)
                .add(namePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(182, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.frame.removePanel(this);
        this.frame.createMainMenuPanel();
    }//GEN-LAST:event_backButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        this.frame.removePanel(this);
        this.frame.createLobbyPanel(this.isOnline, getScreenName());
    }//GEN-LAST:event_okButtonActionPerformed

    private void backButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_backButtonKeyPressed
        switch (evt.getKeyCode())
        {
            case KeyEvent.VK_LEFT:
                if (this.currIndex == 0)
                {
                    this.buttons[this.currIndex].requestFocus();
                }
                else
                {
                    this.currIndex--;
                    this.buttons[this.currIndex].requestFocus();
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (this.currIndex == numButtons - 1)
                {
                    this.buttons[this.currIndex].requestFocus();
                }
                else
                {
                    this.currIndex++;
                    this.buttons[this.currIndex].requestFocus();
                }
                break;
        }
    }//GEN-LAST:event_backButtonKeyPressed

    private void okButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_okButtonKeyPressed
        switch (evt.getKeyCode())
        {
            case KeyEvent.VK_LEFT:
                if (this.currIndex == 0)
                {
                    this.buttons[this.currIndex].requestFocus();
                }
                else
                {
                    this.currIndex--;
                    this.buttons[this.currIndex].requestFocus();
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (this.currIndex == numButtons - 1)
                {
                    this.buttons[this.currIndex].requestFocus();
                }
                else
                {
                    this.currIndex++;
                    this.buttons[this.currIndex].requestFocus();
                }
                break;
        }
    }//GEN-LAST:event_okButtonKeyPressed

    private void backButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseEntered
        this.buttons[0].requestFocus();
    }//GEN-LAST:event_backButtonMouseEntered

    private void okButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_okButtonMouseEntered
        this.buttons[1].requestFocus();
    }//GEN-LAST:event_okButtonMouseEntered

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel charMax;
    private javax.swing.JTextField nameField;
    private javax.swing.JPanel namePanel;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel subTitleLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
