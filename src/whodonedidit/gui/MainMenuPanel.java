package whodonedidit.gui;

import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 *
 * @author Tyler Wong
 */
public class MainMenuPanel extends javax.swing.JPanel
{

    private MainFrame frame;
    private static final int numButtons = 4;
    private JButton[] buttons = new JButton[numButtons];
    private int currIndex = 0;
    private String language;
    private String theme;

    /**
     * Creates new form MainMenu
     */
    public MainMenuPanel(MainFrame frame)
    {
        this.frame = frame;
        initComponents();
        this.singlePlayerButton.requestFocus();
        this.buttons[0] = this.singlePlayerButton;
        this.buttons[1] = this.multiPlayerButton;
        this.buttons[2] = this.rulesButton;
        this.buttons[3] = this.exitButton;
    }

    public JButton getSinglePlayerButton()
    {
        return this.singlePlayerButton;
    }
    
    public String getLanguage()
    {
        return this.language;
    }
    
    public void setLanguage(String lang)
    {
        this.language = lang;
        this.languageBox.setSelectedItem(this.language);
        
        if (this.language.equals("Español"))
        {
            this.titleLabel.setText("¿Quién Lo Hizo?");
            this.singlePlayerButton.setText("Jugar Juego de un Solo Jugador");
            this.multiPlayerButton.setText("Jugar Juego Multijugador");
            this.rulesButton.setText("Mostrar Reglas");
            this.exitButton.setText("Salida");
            this.revalidate();
            this.repaint();
            this.frame.refactor();
        }
        else if(this.language.equals("中文"))
        {
            this.titleLabel.setText("         誰幹的?");
            this.singlePlayerButton.setText("玩單人遊戲");
            this.multiPlayerButton.setText("玩多人遊戲");
            this.rulesButton.setText("顯示規則");
            this.exitButton.setText("出口");
            this.revalidate();
            this.repaint();
            this.frame.refactor();
        }
    }
    
    public String getTheme()
    {
        return this.theme;
    }
    
    public void setTheme(String theme)
    {
        this.theme = theme;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        titleLabel = new javax.swing.JLabel();
        singlePlayerButton = new javax.swing.JButton();
        multiPlayerButton = new javax.swing.JButton();
        rulesButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        languageBox = new javax.swing.JComboBox();
        themeBox = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 800, 600));
        setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));

        titleLabel.setBackground(new java.awt.Color(255, 255, 255));
        titleLabel.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Who Done Did It?");
        titleLabel.setSize(new java.awt.Dimension(368, 57));

        singlePlayerButton.setBackground(new java.awt.Color(255, 255, 255));
        singlePlayerButton.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        singlePlayerButton.setText(" Play Single Player Game");
        singlePlayerButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        singlePlayerButton.setRolloverEnabled(true);
        singlePlayerButton.setSize(new java.awt.Dimension(241, 30));
        singlePlayerButton.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                singlePlayerButtonMouseEntered(evt);
            }
        });
        singlePlayerButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                singlePlayerButtonActionPerformed(evt);
            }
        });
        singlePlayerButton.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                singlePlayerButtonKeyPressed(evt);
            }
        });

        multiPlayerButton.setBackground(new java.awt.Color(255, 255, 255));
        multiPlayerButton.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        multiPlayerButton.setText("Play Multiplayer Game");
        multiPlayerButton.setRolloverEnabled(true);
        multiPlayerButton.setSize(new java.awt.Dimension(241, 30));
        multiPlayerButton.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                multiPlayerButtonMouseEntered(evt);
            }
        });
        multiPlayerButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                multiPlayerButtonActionPerformed(evt);
            }
        });
        multiPlayerButton.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                multiPlayerButtonKeyPressed(evt);
            }
        });

        rulesButton.setBackground(new java.awt.Color(255, 255, 255));
        rulesButton.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        rulesButton.setText("Display Rules");
        rulesButton.setRolloverEnabled(true);
        rulesButton.setSize(new java.awt.Dimension(241, 30));
        rulesButton.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                rulesButtonMouseEntered(evt);
            }
        });
        rulesButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                rulesButtonActionPerformed(evt);
            }
        });
        rulesButton.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                rulesButtonKeyPressed(evt);
            }
        });

        exitButton.setBackground(new java.awt.Color(255, 255, 255));
        exitButton.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        exitButton.setText("Exit");
        exitButton.setRolloverEnabled(true);
        exitButton.setSize(new java.awt.Dimension(241, 30));
        exitButton.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                exitButtonMouseEntered(evt);
            }
        });
        exitButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                exitButtonActionPerformed(evt);
            }
        });
        exitButton.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                exitButtonKeyPressed(evt);
            }
        });

        languageBox.setBackground(new java.awt.Color(255, 255, 255));
        languageBox.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        languageBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "English", "Español", "中文" }));
        languageBox.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                languageBoxActionPerformed(evt);
            }
        });

        themeBox.setBackground(new java.awt.Color(255, 255, 255));
        themeBox.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        themeBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Greek Mythology", "Presidential", "Pirates" }));
        themeBox.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                themeBoxActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(215, 215, 215)
                        .add(titleLabel)
                        .add(0, 211, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .add(themeBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(languageBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .add(layout.createSequentialGroup()
                .add(253, 253, 253)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(exitButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 292, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(rulesButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 292, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(multiPlayerButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 292, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(singlePlayerButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 292, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(languageBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(themeBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 177, Short.MAX_VALUE)
                .add(titleLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(singlePlayerButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(multiPlayerButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(rulesButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(exitButton)
                .add(189, 189, 189))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void singlePlayerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singlePlayerButtonActionPerformed
        this.frame.removePanel(this);
        this.frame.createScreenNamePanel(false);
    }//GEN-LAST:event_singlePlayerButtonActionPerformed

    private void multiPlayerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multiPlayerButtonActionPerformed
        this.frame.removePanel(this);
        this.frame.createScreenNamePanel(true);
    }//GEN-LAST:event_multiPlayerButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void rulesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rulesButtonActionPerformed
        this.frame.removePanel(this);
        this.frame.createRulesPanel(false, null);
    }//GEN-LAST:event_rulesButtonActionPerformed

    private void singlePlayerButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_singlePlayerButtonKeyPressed
        switch (evt.getKeyCode())
        {
            case KeyEvent.VK_UP:
                if (this.currIndex == 0)
                {
                    this.currIndex = numButtons - 1;
                    this.buttons[this.currIndex].requestFocus();
                }
                else
                {
                    this.currIndex--;
                    this.buttons[this.currIndex].requestFocus();
                }
                break;
            case KeyEvent.VK_DOWN:
                if (this.currIndex == numButtons - 1)
                {
                    this.currIndex = 0;
                    this.buttons[this.currIndex].requestFocus();
                }
                else
                {
                    this.currIndex++;
                    this.buttons[this.currIndex].requestFocus();
                }
                break;
        }
    }//GEN-LAST:event_singlePlayerButtonKeyPressed

    private void multiPlayerButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_multiPlayerButtonKeyPressed
        switch (evt.getKeyCode())
        {
            case KeyEvent.VK_UP:
                if (this.currIndex == 0)
                {
                    this.currIndex = numButtons - 1;
                    this.buttons[this.currIndex].requestFocus();
                }
                else
                {
                    this.currIndex--;
                    this.buttons[this.currIndex].requestFocus();
                }
                break;
            case KeyEvent.VK_DOWN:
                if (this.currIndex == numButtons - 1)
                {
                    this.currIndex = 0;
                    this.buttons[this.currIndex].requestFocus();
                }
                else
                {
                    this.currIndex++;
                    this.buttons[this.currIndex].requestFocus();
                }
                break;
        }
    }//GEN-LAST:event_multiPlayerButtonKeyPressed

    private void rulesButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rulesButtonKeyPressed
        switch (evt.getKeyCode())
        {
            case KeyEvent.VK_UP:
                if (this.currIndex == 0)
                {
                    this.currIndex = numButtons - 1;
                    this.buttons[this.currIndex].requestFocus();
                }
                else
                {
                    this.currIndex--;
                    this.buttons[this.currIndex].requestFocus();
                }
                break;
            case KeyEvent.VK_DOWN:
                if (this.currIndex == numButtons - 1)
                {
                    this.currIndex = 0;
                    this.buttons[this.currIndex].requestFocus();
                }
                else
                {
                    this.currIndex++;
                    this.buttons[this.currIndex].requestFocus();
                }
                break;
        }
    }//GEN-LAST:event_rulesButtonKeyPressed

    private void exitButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_exitButtonKeyPressed
        switch (evt.getKeyCode())
        {
            case KeyEvent.VK_UP:
                if (this.currIndex == 0)
                {
                    this.currIndex = numButtons - 1;
                    this.buttons[this.currIndex].requestFocus();
                }
                else
                {
                    this.currIndex--;
                    this.buttons[this.currIndex].requestFocus();
                }
                break;
            case KeyEvent.VK_DOWN:
                if (this.currIndex == numButtons - 1)
                {
                    this.currIndex = 0;
                    this.buttons[this.currIndex].requestFocus();
                }
                else
                {
                    this.currIndex++;
                    this.buttons[this.currIndex].requestFocus();
                }
                break;
        }
    }//GEN-LAST:event_exitButtonKeyPressed

    private void singlePlayerButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_singlePlayerButtonMouseEntered
        this.currIndex = 0;
        this.buttons[this.currIndex].requestFocus();
    }//GEN-LAST:event_singlePlayerButtonMouseEntered

    private void multiPlayerButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_multiPlayerButtonMouseEntered
        this.currIndex = 1;
        this.buttons[this.currIndex].requestFocus();
    }//GEN-LAST:event_multiPlayerButtonMouseEntered

    private void rulesButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rulesButtonMouseEntered
        this.currIndex = 2;
        this.buttons[this.currIndex].requestFocus();
    }//GEN-LAST:event_rulesButtonMouseEntered

    private void exitButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseEntered
        this.currIndex = 3;
        this.buttons[this.currIndex].requestFocus();
    }//GEN-LAST:event_exitButtonMouseEntered

    private void languageBoxActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_languageBoxActionPerformed
    {//GEN-HEADEREND:event_languageBoxActionPerformed
        this.language = String.valueOf(this.languageBox.getSelectedItem());
        this.frame.setLanguage(this.language);
        
        if (this.language.equals("Español"))
        {
            this.titleLabel.setText("¿Quién Lo Hizo?");
            this.singlePlayerButton.setText("Jugar Juego de un Solo Jugador");
            this.multiPlayerButton.setText("Jugar Juego Multijugador");
            this.rulesButton.setText("Mostrar Reglas");
            this.exitButton.setText("Salida");
            this.themeBox.removeAllItems();
            this.themeBox.addItem("La Mitología Griega");
            this.themeBox.addItem("Presidencial");
            this.themeBox.addItem("Piratas");
            this.revalidate();
            this.repaint();
            this.frame.refactor();
        }
        else if(this.language.equals("中文"))
        {
            this.titleLabel.setText("         誰幹的?");
            this.singlePlayerButton.setText("玩單人遊戲");
            this.multiPlayerButton.setText("玩多人遊戲");
            this.rulesButton.setText("顯示規則");
            this.exitButton.setText("出口");
            this.themeBox.removeAllItems();
            this.themeBox.addItem("希臘神話");
            this.themeBox.addItem("總統");
            this.themeBox.addItem("海盜");
            this.revalidate();
            this.repaint();
            this.frame.refactor();
        }
        else
        {
            this.titleLabel.setText("Who Done Did It?");
            this.singlePlayerButton.setText("Play Single Player Game");
            this.multiPlayerButton.setText("Play Multiplayer Game");
            this.rulesButton.setText("Display Rules");
            this.exitButton.setText("Exit");
            this.themeBox.removeAllItems();
            this.themeBox.addItem("Greek Mythology");
            this.themeBox.addItem("Presidential");
            this.themeBox.addItem("Pirates");
            this.revalidate();
            this.repaint();
            this.frame.refactor();
        }
    }//GEN-LAST:event_languageBoxActionPerformed

    private void themeBoxActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_themeBoxActionPerformed
    {//GEN-HEADEREND:event_themeBoxActionPerformed
        this.theme = String.valueOf(this.themeBox.getSelectedItem());
        if (!this.language.equals("English"))
        {
            if (this.language.equals("Español"))
            {
                switch (this.theme)
                {
                    case "La Mitología Griega":
                        this.frame.setTheme("Greek Mythology");
                        break;
                    case "Presidencial":
                        this.frame.setTheme("Presidential");
                        break;
                    case "Piratas":
                        this.frame.setTheme("Pirates");
                        break;
                    default:
                        break;
                }
            }
            else if (this.language.equals("中文"))
            {
                switch (this.theme)
                {
                    case "希臘神話":
                        this.frame.setTheme("Greek Mythology");
                        break;
                    case "總統":
                        this.frame.setTheme("Presidential");
                        break;
                    case "海盜":
                        this.frame.setTheme("Pirates");
                        break;
                    default:
                        break;
                }
            }
        }
        else
        {
            this.frame.setTheme(this.theme);
        }
    }//GEN-LAST:event_themeBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitButton;
    private javax.swing.JComboBox languageBox;
    private javax.swing.JButton multiPlayerButton;
    private javax.swing.JButton rulesButton;
    private javax.swing.JButton singlePlayerButton;
    private javax.swing.JComboBox themeBox;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
