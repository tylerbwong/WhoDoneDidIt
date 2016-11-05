package whodonedidit.version1_0;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * DiscardPile serves as an object to temporarily store the played action cards
 * until the deck needs to be reset.
 *
 * @author Hayden - skeleton, javadocs, pseudocode
 * @version 0.0
 * @since 25-Oct-2015
 */
public class DiscardPile implements Serializable
{
    /**List of the discarded ActionCard objects in the game*/
    private List<ActionCard> pile;

    /**
     * Creates a discard pile object by initializing an array list to hold
     * discarded action cards.
     */
    public DiscardPile()
    {
        //INIT pile to an array list
        pile = new ArrayList<>();
    }

    /**
     * Adds the action card to the discard pile.
     *
     * @param card the ActionCard object being discarded
     */
    public void discard(ActionCard card)
    {
        //CALL pile's add method passing it card
        pile.add(card);

    }

    /**
     * Returns the action cards from the pile back into the deck passed to it.
     *
     * @param deck the deck to return the ActionCard objects to.
     */
    public void reshuffleIntoDeck(Deck deck)
    {
        //WHILE the discard pile still has cards
        while (!pile.isEmpty())
        {
            //CALL deck's addActionCard method passing it the card
            deck.addActionCard(pile.remove(pile.size() - 1));
        //ENDWHILE
        }
        //deck.shuffle(); Could call the deck's shuffle here
    }

    /**
     * Returns the last card added to this discard pile
     *
     * @return the action card at the end of the discard pile or null if the
     * pile is empty
     */
    public ActionCard getTopCard()
    {
        //IF the discard pile is not empty
        if (pile.size() > 0)
        {
            //RETURN the action card at the last index of the discard pile
            return pile.get(pile.size() - 1);
        }
        //RETURN null if the discard pile was empty
        return null;
    }

    /*
     * LOC before implementation: 7
     * LOC so far: 12
     */

}
