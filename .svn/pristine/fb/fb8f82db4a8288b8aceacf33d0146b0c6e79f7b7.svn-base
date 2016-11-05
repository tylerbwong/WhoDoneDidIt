package whodonedidit.version1_0;

import java.io.Serializable;
import java.util.List;

/**
 * ActionCard serves to hold the type and description of one of the action card
 * objects that will make up the deck.
 *
 * @author Hayden - skeleton, javadocs, pseudocode
 * @version 0.0
 * @since 25-Oct-2015
 */
public class ActionCard implements Serializable
{
    /**Type of the action card created*/
    private ActionCardType type;
    /**Describes the specific action required by this action card*/
    private List<String> description;

    /**
     * Creates an ActionCard object with the given type and description.
     *
     * @param type the type action card being created
     * @param description the list describing the specific type of action card
     */
    public ActionCard(ActionCardType type, List<String> description)
    {
        //SET this action card's type to the given type parameter
        this.type = type;
        //SET this card's description to the given description
        this.description = description;
    }

    /**
     * Returns the type of the instantiated action card.
     *
     * @return type of the action card.
     */
    public ActionCardType getType()
    {
        //RETURN the ActionCardType of this action card
        return type;
    }

    /**
     * Returns the description of the action card.
     *
     * @return description list stored
     */
    public List<String> getDescription()
    {
        //RETURN the description list for this action card.
        return description;
    }
}
