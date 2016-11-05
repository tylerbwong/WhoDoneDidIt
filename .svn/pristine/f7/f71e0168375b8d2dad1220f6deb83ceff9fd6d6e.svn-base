package whodonedidit.version1_0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Instruction to tell a player to respond to a specific description
 * with any cards that fits the description.
 *
 * @since 10-Nov-2015
 * @version 1.0
 * @author austinrobarts
 * @author Brittany Berlanga
 */
public class RespondWithClueCards implements Instruction
{

    /**
     * Strings that describe the clue cards they must respond with
     *
     * Example: description: {"Vehicle", "Ground"}
     */
    private List<String> description;
    /**
     * True if they need to send all cards that match the description
     * and false if they only need to send one card of that
     * description.
     */
    private boolean sendAll;

    /**
     * The card type the player will be responding to
     */
    private ActionCardType cardType;
    /**
     * The player to respond to
     */
    private int toPlayerID;

    private static final Map<ActionCardType, PlayerState> actionCardPlayerStateMap;
    static {
        actionCardPlayerStateMap = new HashMap<>();
        actionCardPlayerStateMap.put(ActionCardType.AllSnoopLeft, PlayerState.BeingSnoopedUpon);
        actionCardPlayerStateMap.put(ActionCardType.AllSnoopRight, PlayerState.BeingSnoopedUpon);
        actionCardPlayerStateMap.put(ActionCardType.Snoop, PlayerState.BeingSnoopedUpon);
        actionCardPlayerStateMap.put(ActionCardType.PrivateTipAll, PlayerState.RespondingToPrivateTipAll);
        actionCardPlayerStateMap.put(ActionCardType.PrivateTipOne, PlayerState.RespondingToPrivateTipOne);
        actionCardPlayerStateMap.put(ActionCardType.SuperSleuth, PlayerState.RespondingToSuperSleuth);
    }
    /**
     * Constructs an instruction that requests cards from the player
     * that fit a certain description.
     *
     * @param toPlayerID  the player to respond to
     * @param description descriptions of the cards that they must
     *                    respond with
     * @param sendAll     true if the player should send all of cards
     *                    that description and false if only one card
     *                    should be sent back
     * @param cardType    the card type the player will be responding to
     */
    public RespondWithClueCards(int toPlayerID, ActionCardType cardType,
        List<String> description, boolean sendAll)
    {
        //SET instance toPlayerId to toPlayerId
        this.toPlayerID = toPlayerID;
        //SET instance cardType to cardType
        this.cardType = cardType;
        //SET instance description to description
        this.description = description;
        //SET instance sendAll to sendAll
        this.sendAll = sendAll;
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
        //CALL doRespondWithClueCards with the current RespondWithClueCards
        //object and player
        doRespondWithClueCards(this, player);
    }

    /**
     * The player executes the instruction and checks to see if any
     * of their cards match the specified description.
     *
     * @param myself a reference to self to access private information
     * @param player a reference to the player doing the instruction
     */
    private static void doRespondWithClueCards(RespondWithClueCards myself,
        Player player)
    {
        //CALL getHand on player RETURNING the player's Hand
        Hand playerHand = player.getHand();
        //GET the PlayerState associated with the ActionCardType
        PlayerState state = actionCardPlayerStateMap.get(myself.cardType);
        // SET state's targetPlayerID to this RespondWithClueCard's toPlayerID
        state.targetPlayerID = myself.toPlayerID;
        //GET the list of cards to reveal and clear the list
        List<ClueCard> matchingCards = state.getCardsToReveal();
        matchingCards.clear();
        //IF description is empty, force send snoop clue card
        if (myself.description.isEmpty())
        {
            //ADD a random ClueCard from the player's hand to the list of cards
            //to reveal
            matchingCards.add(playerHand.getRandomClueCard());
            //CALL setState on the player with PlayerState
            player.setState(state);
            //INIT SendClueCards with the ClueCard and the instance
                    //toPlayerId
            //CALL sendActionToGameManager on instance player with
                    //SendClueCards
            player.sendActionToGameManager(new SendClueCards(myself.cardType,
                    new ArrayList<>(matchingCards), myself.toPlayerID, player.getPlayerID()));
        }
        //ELSE show possible cards to choose from
        else
        {
            //ADD ClueCards from the player's hand that match the description to
            // the list of cards to reveal
            matchingCards.addAll(playerHand.findClueCard(myself.description));
            //CALL setState on the player with PlayerState
            player.setState(state);
            //IF sendAll is true, force send private tip all cards
            if (myself.sendAll)
            {
                //CALL sendActionToGameManager on instance player with
                    //SendClueCards
                player.sendActionToGameManager(new SendClueCards(myself.cardType,
                        new ArrayList<>(matchingCards), myself.toPlayerID, player.getPlayerID()));
            }
        }
    }
}
