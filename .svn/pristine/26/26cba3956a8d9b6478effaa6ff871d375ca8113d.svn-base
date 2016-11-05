package whodonedidit.gui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Brittany Berlanga
 */
public class DestinationMarkerLabel extends JLabel
{

    private String marker;

    public DestinationMarkerLabel(String marker)
    {
        super();
        this.marker = marker;
        setBorder(new EmptyBorder(4, 4, 4, 4));
    }

    public void changeMarker(String fileName)
    {
        this.marker = fileName;
        setIcon(new ImageIcon(getClass().getResource(this.marker)));
    }
}
