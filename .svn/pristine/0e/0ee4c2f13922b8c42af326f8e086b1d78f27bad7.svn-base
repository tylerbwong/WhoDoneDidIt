package whodonedidit.gui;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Brittany Berlanga
 */
public class OpponentButton extends JButton
{
    private int id;
    private String userName;
    
    public OpponentButton(int id, String userName)
    {
        super();
        this.id = id;
        this.userName = userName;
        setBorder(new EmptyBorder(4, 4, 4, 4));
        setIcon(new ImageIcon(getClass().getResource("TempImages/computer.png")));
        setText(userName);
        setVerticalTextPosition(SwingConstants.BOTTOM);
        setHorizontalTextPosition(SwingConstants.CENTER);
        setBackground(Color.WHITE);
    }
    
    public int getID()
    {
        return this.id;
    }
}
