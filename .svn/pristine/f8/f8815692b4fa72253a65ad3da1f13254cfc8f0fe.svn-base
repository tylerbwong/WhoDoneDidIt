package whodonedidit.version1_0;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Table serves to store the list of players in the game, destination
 * markers that are not currently held by a player, the set of cards making up
 * the solution, discard pile, and the deck being used.
 *
 * @author Hayden - skeleton, javadocs, psuedocode.
 * @version 0.0
 * @since 25-Oct-2015
 */
public class Table implements Serializable
{

    /**
     * List of Player objects participating in the game.
     */
    private List<Player> players;
    /**
     * List of destination markers that are not occupied by any of the
     * players.
     */
    private List<DestinationMarker> markers;
   /**
    * Set of three clue cards making up the solution.
    */
    private Solution solution;
   /**
    * Deck of action cards and clue cards in the game.
    */
    private Deck deck;
   /**
    * DiscardPile object to store all action cards played.
    */
    private DiscardPile discardPile;
   /**
    * String storing the notification for the most recent action made.
    */
    private String lastNotification;

   /**
    * Creates a Table with the given players and then initializes a deck,
    * discard pile, list of destination markers, and forms the solution.
    *
    * @param players list of players in the current game
    */
    public Table(List<Player> players)
    {
        ClueCard tempPerson, tempVehicle, tempDestination;
        ArrayList<String> tempDescription = new ArrayList<String>();
        ArrayList<String> cardNames;
        //SET players list equal to the passed list of players
        this.players = players;
        //INIT discardPile by calling its constructor
        discardPile = new DiscardPile();
        //INIT deck by calling its constructor
        deck = new Deck();      
        //CALL deck's populateDeck method.
        deck.populateDeck();
        //INIT markers list
        markers = new ArrayList<DestinationMarker>();
        //SET cardNames to the clue card names returned from deck.getCardNames
        cardNames = deck.getCardNames();
        //FOR each name in cardNames
        for (String name : cardNames)
        {
            //ADD a new destination marker with the current name to markers
            markers.add(new DestinationMarker(name));
        }
        //ENDFOR
        //CALL collection's shuffle marker on the list of destination markers
        Collections.shuffle(markers);
        //CALL the deck's shuffle method
        deck.shuffle();
        //ADD the first tempDescription for the card to be "Suspect"
        tempDescription.add(0, "Suspect");
        //CALL the deck's findClueCard method with the person tempDescription,
        //      store the returned card in tempPerson
        tempPerson = deck.findClueCard(tempDescription);
        //SET the tempDescription for the card to be "Vehicle"
        tempDescription.set(0, "Vehicle");
        //CALL the deck's findClueCard method with the tempDescription,
        //      store the returned card in tempVehicle
        tempVehicle = deck.findClueCard(tempDescription);
        //SET the tempDescription for the card to be "Destination"
        tempDescription.set(0, "Destination");
        //CALL the deck's findClueCard method with the tempDescription,
        //      store the returned card in tempDestination
        tempDestination = deck.findClueCard(tempDescription);
        //INIT solution passing it the temp clue cards.
        solution = new Solution(tempPerson, tempVehicle, tempDestination);

    }
    /**
     * Creates a new table object using a passed table to copy all of the
     * data from to make a copy of the other table.
     * 
     * @param other table to have data copied from
     */
    public Table(Table other)
    {
        //COPY the other table's list of players
        this.players = new ArrayList<Player>(other.getPlayers());
        //COPY the other table's destination markers list
        this.markers = new ArrayList<DestinationMarker>(other.getDestinationMarkers());
        //SET this table's solution to the other table's solution
        this.solution = other.getSolution();
        //SET this table's deck to the other table's deck
        this.deck = other.getDeck();
        //SET this table's discard pile to the other table's discard pile
        this.discardPile = other.getDiscardPile();
        //SET this table's last notification to the other table's last notification
        this.lastNotification = other.getLastNotification();
    }

    /**
     * Returns the list of all the players in the game.
     *
     * @return the players list currently stored
     */
    public List<Player> getPlayers()
    {
        //RETURN players List this object stores.
        return players;
    } 

    /**
     * Returns the list of destination markers still on the table.
     *
     * @return list of remaining destination markers.
     */
    public List<DestinationMarker> getDestinationMarkers()
    {
        //RETURN the list of destination markers
        return markers;
    }

    /**
     * Returns the generated solution for the current game.
     *
     * @return the current solution object held
     */
    public Solution getSolution()
    {
        //RETURN solution held by this table
        return solution;
    }

    /**
     * Returns the deck being used in the current game.
     *
     * @return the current deck being used.
     */
    public Deck getDeck()
    {
        //RETURN the deck held by this table
        return deck;
    }

    /**
     * Returns the discard pile being used in the game.
     *
     * @return the current discard pile
     */
    public DiscardPile getDiscardPile()
    {
        //RETURN the discard pile
        return discardPile;
    }

    /**
     * Sets the notification for the most recent action made.
     *
     * @param notification the last notification to be displayed on the table
     */
    public void setLastNotification(String notification)
    {
        //SET lastNotification to the passed notification
        lastNotification = notification;
    } 

    /**
     * Returns the last notification given to the table
     *
     * @return the last notification currently stored
     */
    public String getLastNotification()
    {
        //RETURN lastNotification
        return lastNotification;
    } 

    /*
     * LOC before implementation: 24
     * LOC so far: 38
     */
}
