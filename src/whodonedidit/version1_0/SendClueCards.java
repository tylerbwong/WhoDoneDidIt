package whodonedidit.version1_0;

import java.util.List;

/**
 * An action sent from the player to notify the game manager that they
 * have sent clue cards. These cards will then be sent to the target
 * player set in the constructor
 *
 * @author austinrobarts
 * @since 11-17-15
 */
public class SendClueCards implements Action
{

    /**
     * List of cards that the player wants to show the current turn
     * player. If the list is empty than the player had no cards that
     * matched the requested cards.
     */
    private List<ClueCard> cards;

    /**
     * The target player to receive the cards
     */
    private int target_player;
    /**
     * the player who is sending the clue cards
     */
    private int fromPlayerID;
    /**
     * The card type you are sending for
     */
    private ActionCardType type;


    /**
     * Constructs the action to send the specified clue cards
     *
     * @param cards the cards to be sent to the game manager
     * @param target_player  the player to receive clue cards
     */
    public SendClueCards(ActionCardType type, List<ClueCard> cards, int target_player, int fromPlayerID)
    {
        //SET the action card type
        this.type = type;
        //SET the list of cards
        this.cards = cards;
        //SET the target_player
        this.target_player = target_player;
        //SET the fromPlayerID
        this.fromPlayerID = fromPlayerID;
    }

    /**
     * Method to execute the action
     *
     * @param manager a reference to the game manager
     */
    @Override
    public void doAction(GameManager manager)
    {
        //CALL the doSendCards method
        doSendCards(this, manager);
    }

    /**
     * The game manager takes the cards that have been sent and sends
     * them to the target player
     *
     * @param myself  a reference to the action to receive private
     *                info
     * @param manager a reference to the game manager
     */
    private static void doSendCards(SendClueCards myself, GameManager manager)
    {
        //CREATE new ReceiveClueCards instruction with the list of clue cards
        ReceiveClueCards receiveCards = new ReceiveClueCards(myself.type, myself.fromPlayerID, myself.cards);
        //SEND receiveClueCards instruction to target player
        manager.sendInstructionToPlayer(receiveCards, myself.target_player);
    }
}
