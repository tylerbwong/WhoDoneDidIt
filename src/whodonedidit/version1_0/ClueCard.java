package whodonedidit.version1_0;

import java.io.Serializable;
import java.util.List;
/**
 * ClueCard serves to hold the name and description of one of the clue card
 * objects that will make up the deck.
 *
 * @author Hayden - skeleton, javadocs, pseudocode
 * @version 0.0
 * @since 25-Oct-2015
 */
public class ClueCard implements Serializable
{
    /**Name of the ClueCard*/
    private String name;
    /**Attributes of the clue card such as if it is a red vehicle or N/E location etc.*/
    private List<String> description;

    /**
     * Creates a ClueCard object with the passed in name and description.
     *
     * @param name name of the ClueCard being created.
     * @param description list of attributes for the ClueCard.
     */
    public ClueCard(String name, List<String> description)
    {
        //SET the name of this clue card to the name passed through the parameters
        this.name = name;
        //SET the description of this clue card to the one given in the parameters
        this.description = description;
    }

    /**
     * Returns the name of this ClueCard.
     *
     * @return name of this ClueCard
     */
    public String getName()
    {
        //RETURN name of the clue card
        return name;
    }

    /**
     * Returns the list of strings that describe this ClueCard.
     *
     * @return descriptor list stored by this ClueCard.
     */
    public List<String> getDescription()
    {
        //RETURN description list of this clue card
        return description;
    }
}
