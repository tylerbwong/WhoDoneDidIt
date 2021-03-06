package whodonedidit.version1_0;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * Hand serves to represent the player's collection of ClueCards, ActionMarkers,
 * and a DestinationMarker.
 *
 * @author Hayden - skeleton, javadocs, pseudocode
 * @version 0.0
 * @since 25-Oct-2015
 */
public class Hand implements Serializable
{
    /**List of ClueCard objects that make up the player's hand.*/
    private List<ClueCard> clueCards;
    /**List of ActionCard objects that make up the player's hand.*/
    private List<ActionCard> actionCards;
    /**Player's current DestinationMarker*/
    private DestinationMarker marker;

    /**
     * Creates an empty hand for cards to be dealt to at the start of the game.
     */
    public Hand()
    {
        //INIT an empty array list for clue cards
        clueCards = new ArrayList<>();
        //INIT an empty array list for action cards
        actionCards = new ArrayList<>();
        //INIT the destination marker to null, it will be set during start game
        marker = null;
    }

    /**
     * Creates a hand consisting of the player's clue cards, action cards, and
     * a destination marker.
     *
     * @param clueCards List of 3 to 6 ClueCards dealt to the player's hand
     * @param actionCards List holding one ActionCard initially dealt
     * @param marker DestinationMarker the player starts out with
     */
    public Hand(List<ClueCard> clueCards, List<ActionCard> actionCards,
            DestinationMarker marker)
    {
        this.actionCards = null;
        //COPY the passed ClueCard list to this hand's clueCards
        //Collections.copy(this.clueCards, clueCards);
        this.clueCards = new ArrayList<>(clueCards);
        //COPY the passed ActionCard list to this hand's actionCards
        //Collections.copy(this.actionCards, actionCards);
        this.actionCards = new ArrayList<>(actionCards);
        //SET this hand's destination marker to the given destination marker.
        //this.marker = marker;
        this.marker = new DestinationMarker(marker.getDestination());
    }

    /**
     * This method searches for a specific card name in the player's
     * hand and returns a boolean representing if it is contained in
     * the hand or not.
     *
     * @param cardName the string name of the clue card to find
     * @return true if the card is contained within the hand and false
     * if the hand does have the requested card
     */
    public boolean containsClueCard(String cardName)
    {
        //SET found to false
        boolean found = false;
        int index = 0;

        //WHILE the card has not been found and there are still cards in hand
        while (!found && index < clueCards.size())
        {
            //if the name of the current clue card matches the given card name
            if (clueCards.get(index).getName().equals(cardName))
            {
                //SET found to true
                found = true;
            }
            //INCREMENT index
            index++;
        //ENDWHILE
        }
        //RETURN found
        return found;
    }

    /**
     * This method finds the clue card with a certain card name in the
     * hand.
     *
     * @param cardName the string name of the clue card to find
     * @return a list of clue cards found, either one will be contained
     * or it will be empty
     */
    public List<ClueCard> findClueCard(String cardName)
    {
        //SET found to false
        boolean found = false;
        int index = 0;
        List<ClueCard> cards = new ArrayList<>();

        //WHILE the card has not been found and there are still cards in hand
        while (!found && index < clueCards.size())
        {
            //if the name of the current clue card matches the given card name
            if (clueCards.get(index).getName().equals(cardName))
            {
                //SET found to true
                found = true;
                //ADD Clue card to list
                cards.add(clueCards.get(index));
            }
            //INCREMENT index
            index++;
        //ENDWHILE
        }
        //RETURN found
        return cards;
    }

    /**
     * Looks through the clueCards list to find any cards with all of the
     * attributes given in the description parameter.
     *
     * @param description  List of strings describing a type of clue card to find
     * @return List of any of the clue cards found matching the passed description
     */
    public List<ClueCard> findClueCard(List<String> description)
    {
        boolean match;
        ClueCard tempCard;
        //INIT temp list to contain clue cards held that match the description
        ArrayList<ClueCard> tempList = new ArrayList<>();
        //FOR all ClueCard objects in clueCards
        for (int count = 0; count < clueCards.size(); count++)
        {
            //SET boolean "match" to true to represent if the current card
            //    matches the description so far
            match = true;
            //INITIALIZE tempCard to the current card being checked
            tempCard = clueCards.get(count);
            //FOR every string in the clue card's description
            for (int index = 0; index < description.size(); index++)
            {
                //IF the card being checked doesn't contain the description
                if (!tempCard.getDescription().contains(description.get(index)))
                {
                    //SET match to false, the card being checked was not a match
                    match = false;
                    //BREAK the loop through the description
                    break;
                //ENDIF
                }
            //ENDFOR
            }
            //IF match is still true
            if (match)
            {
                //CALL tempList's add method passing it the current card being checked
                tempList.add(tempCard);
            //ENDIF
            }
        //ENDFOR
        }
        //RETURN tempList
        return tempList;
    }

    /**
     * Adds the passed clue card to this hand's list of clue cards.
     *
     * @param card being added into this hand
     */
    public void addClueCard(ClueCard card)
    {
       //CALL clueCard's add method to add the given clue card
        clueCards.add(card);
    }

    /**
     * Removes the clue card with the requested name from this hand
     *
     * @param name of the clue card to find
     * @return the clue card being removed from this hand
     */
    public ClueCard removeClueCard(String name)
    {
        //FOR all clueCards
        for (int count = 0; count < clueCards.size(); count++)
        {
            //IF the clue card has the same name as the passed name
            if (clueCards.get(count).getName().equals(name))
            {
                //RETURN this clue card by removing it from its list
                return clueCards.remove(count);
            //ENDIF
            }
        //ENDFOR
        }
        //RETURN null in case it wasn't found
        return null;
    }

    /**
     * Adds the passed action card to this hand's list of action cards.
     *
     * @param card being added into this hand
     */
    public void addActionCard(ActionCard card)
    {
        // ADDS action cards to player's hand
        actionCards.add(card);
    }

    /**
     * Removes the first action card with a matching type from this hand.
     *
     * @param type of action card to find and remove
     * @return an action card with a matching type or null
     */
    public ActionCard removeActionCard(ActionCardType type, List<String> description)
    {
        //IF the first action card in actionCards isnt null and is the same type
        if (actionCards.get(0) != null && actionCards.get(0).getType() == type)
        {
            //IF the description being looked for is null or the action card at
            //   index 0 contains all of the passed descriptions
            if (description == null || actionCards.get(0).getDescription().containsAll(description))
            {
                //RETURN the action card by removing it from this hand
                return actionCards.remove(0);
            //ENDIF
            }
        //ENDIF
        }
        //IF the second action card is not null and is the same type
        if ((actionCards.size() > 1 && actionCards.get(1) != null)
                && actionCards.get(1).getType() == type)
        {
            //IF the description being looked for is null or the action card at
            //   index 0 contains all of the passed descriptions
            if (description == null || actionCards.get(1).getDescription().containsAll(description))
            {
                //RETURN the action card by removing it from this hand
                return actionCards.remove(1);
            //ENDIF
            }
        //ENDIF
        }
        //RETURN null if there is no action card of the requested type
        return null;
    }

    /**
     * Sets this hands destination marker to the marker passed as a parameter.
     *
     * @param marker the new marker being assigned to this hand
     */
    public void setDestinationMarker(DestinationMarker marker)
    {
        //SET this hand's destination marker to the given marker
        this.marker = marker;
    }

    /**
     * Gets this hand's destination marker.
     *
     * @return this hand's destination marker
     */
    public DestinationMarker getDestinationMarker()
    {
        //RETURN the destination marker for this hand
        return marker;
    }

    /**
     * Returns a random clue card from this hand. This method will mostly
     * be used as a response to being snooped on.
     *
     * @return one of the clue cards held in this hand
     */
    public ClueCard getRandomClueCard()
    {
        Random rand = new Random();
        int index = Math.abs(rand.nextInt()) % clueCards.size();
        //RETURN a clue card at a random index of the clueCards list
        //return clueCards.get((int)(Math.random() * clueCards.size()));
        return clueCards.get(index);
    }

    /**
     * Replaces this hand's destination marker with a given marker and returns
     * the destination marker it was previously holding.
     *
     * @param newMarker
     * @return the old destination marker held by this hand
     */
    public DestinationMarker swapDestinationMarker(DestinationMarker newMarker)
    {
        //INIT a temp DestinationMarker to hold on to this hand's current marker
        DestinationMarker oldMarker = this.marker;
        //SET this hand's destination marker to newMarker
        this.marker = newMarker;
        //RETURN the old destination marker being held by the temp variable
        return oldMarker;
    }

    /**
     * Returns the list of clue cards held by this hand
     *
     * @return clueCards list
     */
    public List<ClueCard> getClueCards()
    {
        //RETURN clueCards;
        return clueCards;
    }

    /**
     * Returns the list of action cards held by this hand
     *
     * @return actionCards list
     */
    public List<ActionCard> getActionCards()
    {
        //RETURN actionCards
        return actionCards;
    }


    /*11/8: Markus needs to revise the UML to have removeActionCard accept
    *  ActionCardType and needs to make removeClueCard and removeActionCard
    *  return the card instead of void.
    * Also needs to add getRandomClueCard and swapDestinationMarker to UML.
    */
    /*
     * LOC before implementation: 26
     * LOC so far: 58
     */
}
