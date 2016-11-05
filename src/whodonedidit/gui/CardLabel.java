package whodonedidit.gui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Brittany Berlanga
 */
public class CardLabel extends JLabel
{
    private Object card;

    public CardLabel(Object card)
    {
        super();
        this.card = card;
        setIcon(new ImageIcon(getClass().getResource((String) card)));
        setBorder(new EmptyBorder(4, 4, 4, 4));
    }

    public void changeCard(String fileName)
    {
        if (fileName.equals("")) 
        {
            setIcon(new ImageIcon(getClass().getResource("TempImages/back.png")));
        }
        else
        {
            setIcon(new ImageIcon(getClass().getResource(fileName)));
        }
    }
}
