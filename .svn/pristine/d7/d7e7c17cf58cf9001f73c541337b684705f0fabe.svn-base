package whodonedidit.gui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Brittany Berlanga
 */
public class CardButton extends JButton
{
    private String cardName;
    private String fileName;
    private int cardNumber;
    private ImageIcon image;

    public CardButton(String cardName, String fileName, int cardNumber)
    {
        super();
        this.fileName = fileName;
        this.cardNumber = cardNumber;
        this.cardName = cardName;
        setBorder(new EmptyBorder(4, 4, 4, 4));
        if (fileName == null)
        {
            this.image = new ImageIcon(getClass().getResource("GreeceImages/Action-SuggestionCurrent.jpg"));
            setIcon(this.image);
        }
        else
        {
            this.image = new ImageIcon(getClass().getResource(this.fileName));
            setIcon(this.image);
        }
    }

    public String getCardName()
    {
        return this.cardName;
    }
    
    public int getCardNumber()
    {
        return this.cardNumber;
    }
    
    public ImageIcon getCardImage()
    {
        return this.image;
    }
}