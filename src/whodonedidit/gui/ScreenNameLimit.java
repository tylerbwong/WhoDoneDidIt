/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package whodonedidit.gui;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Tyler Wong
 */
public class ScreenNameLimit extends PlainDocument
{

    private int limit;

    public ScreenNameLimit(int limit)
    {
        super();
        this.limit = limit;
    }

    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException
    {
        if (str == null)
        {
            return;
        }

        if ((getLength() + str.length()) <= limit)
        {
            super.insertString(offset, str, attr);
        }
    }
}
