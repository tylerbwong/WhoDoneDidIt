package whodonedidit.version1_0;

import java.util.List;

/**
 * Instruction to tell players that they have received Clue
 * Cards that they want to see.
 *
 * @since 17-Nov-2015
 * @version 1.0
 * @author austinrobarts
 * @author Brittany Berlanga
 */
public class ReceiveClueCards implements Instruction
{

    /**
     * The list of cards to show the player
     */
    private List<ClueCard> cards;
    /**
     * The player they are getting cards from
     */
    private int fromPlayerID;
    /**
     * The action type of the card you are receiving for
     */
    private ActionCardType type;

    /**
     * Constructs an instruction to deliver cards to a certain player.
     * Once the player follows the instruction they will get to see
     * the
     * cards
     *
     * @param fromPlayerID player who sent the cards to reveal
     * @param sentFromPlayerId the integer player id of the player who sent the
     * cards
     * @param cards list of cards the player should see
     */
    public ReceiveClueCards(ActionCardType type, int fromPlayerID, List<ClueCard> cards)
    {
        //SET action card type
        this.type = type;
        //SET instance cards to cards
        this.cards = cards;
        //SET fromPlayerID
        this.fromPlayerID = fromPlayerID;
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
        //CALL doReceiveClueCards with the current ReceiveClueCards object and
        //player
        doReceiveClueCards(this, player);
    }

    /**
     * Tells the player to look at clue cards
     *
     * @param myself a reference to itself to access information
     * @param player a reference to the player to do that instruction
     */
    private static void doReceiveClueCards(ReceiveClueCards myself, Player player)
    {
        //INIT a ReceivingClueCards PlayerState
        PlayerState state = PlayerState.ReceivingClueCards;
        state.type = myself.type;
        //CALL setCardsToReveal on ReceivingClueCards PlayerState with
            //instance cards
        List<ClueCard> cardsToReveal = state.getCardsToReveal();
        cardsToReveal.clear();
        cardsToReveal.addAll(myself.cards);
        state.sentFromPlayerID = myself.fromPlayerID;
        //CALL setState on player with RecievingClueCards PlayerState
        player.setState(state);
    }
}
