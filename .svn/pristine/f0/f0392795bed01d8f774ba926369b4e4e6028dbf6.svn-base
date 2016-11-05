package whodonedidit.version1_0;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Deck is used to create all of clue cards and action cards being used by the
 * game. After the clue cards have been dealt out, the deck serves to hold all
 * of the remaining action cards that haven't been drawn yet.
 *
 * @author Hayden - skeleton, javadocs, pseudocode
 * @version 0.0
 * @since 25-Oct-2015
 */
public class Deck implements Serializable
{
    /**List of ClueCard objects being held by the deck*/
    private List<ClueCard> clueCards;
    /**List of ActionCards being held by the deck*/
    private List<ActionCard> actionCards;
    /**List of the names of the clue cards generated*/
    private ArrayList<String> destinationNames;
    /**Permanent list storing the references to all clue cards that were made*/
    private ArrayList<ClueCard> prototypeClueCards;
    /**Permanent list storing the references to all action cards that were made*/
    private ArrayList<ActionCard> prototypeActionCards;
    

    /**
     * Creates the deck of 21 ClueCards and 39 ActionCards.
     */
    public Deck()
    {
        //INIT clueCards list as a list to hold 21 ClueCards
        clueCards = new ArrayList<>();
        //INIT actionCards list as a list to hold 39 ActionCards
        actionCards = new ArrayList<>();
        //INIT clueCardNames to an array list
        destinationNames = new ArrayList<>();
    }

    /**
     * Returns the stored list of all clue card references.
     * 
     * @return list of all clue cards initially in this Deck
     */
    public List<ClueCard> getPrototypeClueCards()
    {
        return new ArrayList<ClueCard>(prototypeClueCards);
    }

    /**
     * Shuffles the cards being held in the clueCards and actionCards lists.
     */
    public void shuffle()
    {
        //CALL Collections.shuffle() on the clueCards list
        Collections.shuffle(clueCards);
        //CALL Collections.shuffle() on the actionCards list
        Collections.shuffle(actionCards);

    }

    /**
     * Finds the first clue card is this deck that matches the given description.
     * This is mostly used for finding the person, vehicle, and destination to form
     * the solution to the game.
     *
     * @param description of the card requested
     * @return the first ClueCard with a matching description
     */
    public ClueCard findClueCard(List<String> description)
    {
        //INIT a clue card object to null
        ClueCard result = null; 
        
        //FOR each index of clueCards list while result is still null
        for (int index = 0; index < clueCards.size() && result == null; index++)
        {
            //IF the clue card at the current index has all of the descriptions
            if (clueCards.get(index).getDescription().containsAll(description))
            {
                //STORE the clue card at the index, removing it from the list
                result = clueCards.remove(index);
            //ENDIF    
            }
        //ENDFOR    
        }
        //RETURN result
        return result;
    }

    /**
     * Draws an action card from the front of the actionCards list.
     *
     * @return the ActionCard object being held in the actionCards list
     */
    public ActionCard drawActionCard()
    {
        //IF actionCards list is not empty
        if (!actionCards.isEmpty())
        {
            //RETURN action card at index of actionCards size - 1 by removing it
            //       from the list
            return actionCards.remove(actionCards.size() - 1);
        //ENDIF
        }
        //RETURN null if the list is empty
        return null;
    }

    /**
     * Draws a clue card from the front of this deck's clueCards list.
     *
     * @return the ClueCard object being held in the clueCards list
     */
    public ClueCard drawClueCard()
    {
        //IF clueCards list is not empty
        if (!clueCards.isEmpty())
        {
            //RETURN clue card at clueCard size - 1 by removing it from the list
            return clueCards.remove(clueCards.size() - 1);
        //ENDIF
        }
        //RETURN null if the list is empty.
        return null;
    }


    /**
     * Adds the passed action card back into the deck's actionCards list.
     *
     * @param card the ActionCard being returned to the deck
     */
    public void addActionCard(ActionCard card)
    {
        //INSERT the action card to the front of the list
        actionCards.add(0, card);
    }

    /**
     * Adds the clue card back into this deck's clueCards list.
     *
     * @param card the ClueCard object being returned to the deck
     */
    public void addClueCard(ClueCard card)
    {
        //INSERT the clue card to the front of the list which is the bottom of the
        //       stack
        clueCards.add(0, card);
    }

    /**
     * Generates and stores all of the initial clue cards and action cards for
     * this deck.
     */
    public void populateDeck()
    {
    	ArrayList<String> description;
    	String name;
        
        name = "Ares";
        description = new ArrayList<>();
        description.add("Suspect");
        description.add("Male");
        clueCards.add(new ClueCard(name, description));
        
        name = "Dionysus";
        description = new ArrayList<>();
        description.add("Suspect");
        description.add("Male");
        clueCards.add(new ClueCard(name, description));
        
        name = "Hermes";
        description = new ArrayList<>();
        description.add("Suspect");
        description.add("Male");
        clueCards.add(new ClueCard(name, description));
        
        name = "Aphrodite";
        description = new ArrayList<>();
        description.add("Suspect");
        description.add("Female");
        clueCards.add(new ClueCard(name, description));
        
        name = "Artemis";
        description = new ArrayList<>();
        description.add("Suspect");
        description.add("Female");
        clueCards.add(new ClueCard(name, description));
        
        name = "Hera";
        description = new ArrayList<>();
        description.add("Suspect");
        description.add("Female");
        clueCards.add(new ClueCard(name, description));
        
        name = "Apollo's Chariot";
        description = new ArrayList<>();
        description.add("Vehicle");
        description.add("Flying");
        description.add("Blue");
        clueCards.add(new ClueCard(name, description));
        
        name = "Athena's Horse";
        description = new ArrayList<>();
        description.add("Vehicle");
        description.add("Ground");
        description.add("Blue");
        clueCards.add(new ClueCard(name, description));
        
        name = "Eros' Wings";
        description = new ArrayList<>();
        description.add("Vehicle");
        description.add("Flying");
        description.add("Blue");
        clueCards.add(new ClueCard(name, description));
        
        name = "Hades' Dogs";
        description = new ArrayList<>();
        description.add("Vehicle");
        description.add("Ground");
        description.add("Red");
        clueCards.add(new ClueCard(name, description));
        
        name = "Hermes Sandals";
        description = new ArrayList<>();
        description.add("Vehicle");
        description.add("Flying");
        description.add("Red");
        clueCards.add(new ClueCard(name, description));
        
        name = "Poseidon's Ship";
        description = new ArrayList<>();
        description.add("Vehicle");
        description.add("Ground");
        description.add("Red");
        clueCards.add(new ClueCard(name, description));
        
        name = "Athena's Forest";
        description = new ArrayList<>();
        description.add("Destination");
        description.add("North");
        description.add("East");
        clueCards.add(new ClueCard(name, description));
        destinationNames.add(name);
        
        name = "Athens";
        description = new ArrayList<>();
        description.add("Destination");
        description.add("North");
        description.add("East");
        clueCards.add(new ClueCard(name, description));
        destinationNames.add(name);
        
        name = "Atlas' Sky";
        description = new ArrayList<>();
        description.add("Destination");
        description.add("North");
        description.add("West");
        clueCards.add(new ClueCard(name, description));
        destinationNames.add(name);
        
        name = "Dionysus Vineyard";
        description = new ArrayList<>();
        description.add("Destination");
        description.add("North");
        description.add("West");
        clueCards.add(new ClueCard(name, description));
        destinationNames.add(name);
        
        name = "Hades Underworld";
        description = new ArrayList<>();
        description.add("Destination");
        description.add("South");
        description.add("West");
        clueCards.add(new ClueCard(name, description));
        destinationNames.add(name);
        
        name = "Hephaestus Volcano";
        description = new ArrayList<>();
        description.add("Destination");
        description.add("South");
        description.add("West");
        clueCards.add(new ClueCard(name, description));
        destinationNames.add(name);
        
        name = "Mount Olympus";
        description = new ArrayList<>();
        description.add("Destination");
        description.add("South");
        description.add("West");
        clueCards.add(new ClueCard(name, description));
        destinationNames.add(name);
        
        name = "Phoebe's Moon";
        description = new ArrayList<>();
        description.add("Destination");
        description.add("South");
        description.add("East");
        clueCards.add(new ClueCard(name, description));
        destinationNames.add(name);
        
        name = "Poseidon Ocean";
        description = new ArrayList<>();
        description.add("Destination");
        description.add("South");
        description.add("East");
        clueCards.add(new ClueCard(name, description));
        destinationNames.add(name);        
        //INIT description to a new array list
    	description = new ArrayList<>();
        //ADD the description of Destination to the list for the suggestion
        //    action card descriptions
	description.add("Destination");

        //FOR the first ten action cards
    	while (actionCards.size() < 10)
    	{
            //ADD a new SuggestFromAny action card with the current description
            //    to the actionCards list
    	    actionCards.add(new ActionCard(ActionCardType.SuggestFromAny, description));
    	}

        //FOR the next 9 action cards
    	while (actionCards.size() < 19)
    	{
            //ADD a new SuggestFromCurrent action card with the description
    	    actionCards.add(new ActionCard(ActionCardType.SuggestFromCurrent, description));
    	}

        //FOR the next 6 action cards
    	while (actionCards.size() < 23)
    	{
            //ADD new new Snoop card with a null description
    	    actionCards.add(new ActionCard(ActionCardType.Snoop, null));
    	}

        //FOR the next 2 action cards
    	while (actionCards.size() < 25)
    	{
            //ADD a new AllSnoopLeft action card with a null description
    	    actionCards.add(new ActionCard(ActionCardType.AllSnoopLeft, null));
    	}

        //FOR the next 2 action cards
    	while (actionCards.size() < 27)
    	{
            //ADD a new AllSnoopRight action card with a null description
    	    actionCards.add(new ActionCard(ActionCardType.AllSnoopRight, null));
    	}

        /*
    	description = new ArrayList<String>();
    	description.add("Suspect");
    	description.add("Female");
    	actionCards.add(new ActionCard(ActionCardType.SuperSleuth, description));

    	description = new ArrayList<String>();
    	description.add("Suspect");
    	description.add("Male");
    	actionCards.add(new ActionCard(ActionCardType.SuperSleuth, description));

    	description = new ArrayList<String>();
    	description.add("Vehicle");
    	description.add("Flying");
    	actionCards.add(new ActionCard(ActionCardType.SuperSleuth, description));

    	description = new ArrayList<String>();
    	description.add("Vehicle");
    	description.add("Blue");
    	actionCards.add(new ActionCard(ActionCardType.SuperSleuth, description));

    	description = new ArrayList<String>();
    	description.add("Destination");
    	description.add("South");
    	actionCards.add(new ActionCard(ActionCardType.SuperSleuth, description));

    	description = new ArrayList<String>();
    	description.add("Destination");
    	description.add("West");
    	actionCards.add(new ActionCard(ActionCardType.SuperSleuth, description));
        */

        //INIT description to a new array list of strings
    	description = new ArrayList<>();
        //ADD "Suspect" to be the description of the first PrivateTipAll card
    	description.add("Suspect");
        //ADD a new PrivateTipAll card to actionCards with the description
    	actionCards.add(new ActionCard(ActionCardType.PrivateTipAll, description));

        //INIT description to a new array list
    	description = new ArrayList<>();
        //ADD "Vehicle" to be the description of the next PrivateTipAll card
    	description.add("Vehicle");
        //ADD a new PrivateTipAll card to actionCards with the description
    	actionCards.add(new ActionCard(ActionCardType.PrivateTipAll, description));

        //INIT description to a new array list
    	description = new ArrayList<>();
        //ADD "Destination" to be the description of the last PrivateTipAll card
    	description.add("Destination");
        //ADD the last PrivateTipAll card to actionCards with the description
    	actionCards.add(new ActionCard(ActionCardType.PrivateTipAll, description));

        //INIT description to a new array list
    	description = new ArrayList<>();
        //ADD "Suspect" to be the first description of a PrivateTipOne card
    	description.add("Suspect");
        //ADD "Female" to be the second description of the card
    	description.add("Female");
        //ADD a new PrivateTipOne card to actionCards with the description
    	actionCards.add(new ActionCard(ActionCardType.PrivateTipOne, description));

        //INIT description to a new array list
    	description = new ArrayList<>();
        //ADD "Vehicle" to be the first description of the next PrivateTipOne
        //     card
    	description.add("Vehicle");
        //ADD "Red" to be the second description of the card
    	description.add("Red");
        //ADD a new PrivateTipOne card to actionCards with the description
    	actionCards.add(new ActionCard(ActionCardType.PrivateTipOne, description));

        //INIT description to a new array list
    	description = new ArrayList<>();
        //ADD "Destination" to be the first description of the last
        //     PrivateTipOne card
    	description.add("Destination");
        //ADD "North" to be the second description of the card
    	description.add("North");
        //ADD the last PrivateTipOne card to actionCards with the description
    	actionCards.add(new ActionCard(ActionCardType.PrivateTipOne, description));

        //INIT prototypeClueCards to an array list
        prototypeClueCards = new ArrayList<>();
        //ADD all clue cards from clueCards into the prototype list
        prototypeClueCards.addAll(clueCards);
        //INIT prototypeActionCards to an array list
        prototypeActionCards = new ArrayList<>();
        //ADD all action cards from actionCards into the prototype list
        prototypeActionCards.addAll(actionCards);    
    }

    /**
     * Checks to see whether this deck is out of clue cards.
     *
     * @return true if the clueCards list is empty
     */
    public boolean clueIsEmpty()
    {
        //RETURN the result of calling the clueCards isEmpty method
        return clueCards.isEmpty();
    }

    /**
     * Checks to see whether this deck is out of action cards.
     *
     * @return true if the actionCards list is empty
     */
    public boolean actionIsEmpty()
    {
        //RETURN the result of calling the actionCards isEmpty method
        return actionCards.isEmpty();
    }
    
    /**
     * Returns the list of clue card names for the table to build the 
     * destination markers with.
     * 
     * @return list of clue card names
     */
    public ArrayList<String> getCardNames()
    {
        return destinationNames;
    }
    
    private void print()
    {
        for (ClueCard card : clueCards)
        {
            System.out.println(card.getName());
        }
    }

    /*

     * LOC count before implementation: 22
     * LOC count so far: 49
     */
}
