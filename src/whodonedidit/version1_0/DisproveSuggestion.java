package whodonedidit.version1_0;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to instruct the Player to search through their
 * hand and try to disprove the suggestion that was given. They can
 * disprove it by matching the person, vehicle, or destination.
 *
 * @author austinrobarts
 */
public class DisproveSuggestion implements Instruction
{

    /**
     * The suggested person
     */
    private String person;
    /**
     * The suggested vehicle
     */
    private String vehicle;
    /**
     * The suggested destination
     */
    private String destination;
    /**
     * the player to disprove
     */
    private int toPlayerID;
    /**
     * The type of suggestion made
     */
    private ActionCardType type;

    /**
     * Constructs an instruction that will be given to a player with
     *
     * @param toPlayerID  the player you are disproving
     * @param person      the person needed to be disproved
     * @param vehicle     the vehicle needed to be disproved
     * @param destination the destination needed to be disproved
     */
    public DisproveSuggestion(ActionCardType type, int toPlayerID, String person, String vehicle, String destination)
    {
        //SET action card type
        this.type = type;
        //SET playerID to target
        this.toPlayerID = toPlayerID;
        //SET instance person to person
        this.person = person;
        //SET instance vehicle to vehicle
        this.vehicle = vehicle;
        //SET instance destination to destination
        this.destination = destination;
    }

    /**
     * Follow the instruction given by the game manager
     *
     * @param player a reference to the player to follow the
     *               instruction
     */
    @Override
    public void doInstruction(Player player)
    {
        //CALL doDisproveSuggestion with current DisproveSuggestion object and
        //player
        doDisproveSuggestion(this, player);
    }

    /**
     * Search through the player's hand and try to find a card that
     * matches the description of the suggestion card.
     *
     * @param myself reference to the instruction to access
     *               information
     * @param player a reference to the player to carry out the
     *               instruction
     */
    private static void doDisproveSuggestion(DisproveSuggestion myself, Player player)
    {

        //Search hand for each clue card and store them in list
        List<ClueCard> matchingCards = new ArrayList<>();
        matchingCards.addAll(player.getHand().findClueCard(myself.person));
        matchingCards.addAll(player.getHand().findClueCard(myself.destination));
        matchingCards.addAll(player.getHand().findClueCard(myself.vehicle));

        //INIT DisprovingSuggestion PlayerState
        PlayerState disprovingSuggestion = PlayerState.DisprovingSuggestion;
        disprovingSuggestion.targetPlayerID = myself.toPlayerID;
        //CALL setDisplayCards on DisprovingSuggestion PlayerState with
            //matchingCards
        List<ClueCard> currentCards = disprovingSuggestion.getCardsToReveal();
        currentCards.clear();
        currentCards.addAll(matchingCards);
        //CALL setCurrentState on the PlayerStateMachine with the
            //DisprovingSuggestion PlayerState
        player.getState().type = myself.type;
        player.setState(disprovingSuggestion);


    }
}
