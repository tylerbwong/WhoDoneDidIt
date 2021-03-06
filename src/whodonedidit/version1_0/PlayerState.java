package whodonedidit.version1_0;

import java.util.ArrayList;
import java.util.List;

/**
 * PlayerState
 * This enum represents the current state of operations of a player. The
 * player's state will affect its behaviour, and will be utilised by the
 * user interface to request input or display information.
 * @author Markus
 * @version 0.0
 * @since 28-Oct-2015
 */
public enum PlayerState
{
    Idle(),
    ReceivingClueCards(),
    ReceivingInitialCards(),
    BeingSnoopedUpon(),
    RespondingToPrivateTipOne(),
    RespondingToPrivateTipAll(),
    RespondingToSuperSleuth(),
    DisprovingSuggestion(),
    DoingTurn(),
    Victory(),
    Defeat(),
    YouLose();

    /**
     * A list of cards being revealed to another player in response
     * to an action card or accusation.
     */
    private List<ClueCard> cardsToReveal;
    /**
     * The ID of the player who sent the card
     */
    public int sentFromPlayerID;

    /**
     * ID of target player of current instruction.
     */
    public int targetPlayerID;

    /**
     *
     */
    public ActionCardType type;

    /**
     * Default constructor for PlayerState
     */
    PlayerState()
    {
        // SET cardsToReveal to a new ArrayList
        cardsToReveal = new ArrayList<ClueCard>();
    }

    /**
     * Accessor for the list of cards to be revealed to another
     * player in response to an action card.
     * @return
     */
    public List<ClueCard> getCardsToReveal()
    {
        // RETURN cardsToReveal
        return cardsToReveal;
    }
}
