package whodonedidit.version1_0;

import java.util.ArrayList;

/**
 * Represents the action that takes place after a player plays a Snoop
 * card. You choose one random card from a certain player's hand
 *
 * SRS Functional Requirements: 2.4 Extension D
 *
 * @author austinrobarts
 * @since 11-17-15
 */
public class Snoop implements Action
{

    /**
     * the target player that will be snooped on
     */
    private int targetPlayer;

    /**
     * Constructs an action that can be used by the game manager to do
     * a Snoop on a target player.
     *
     * @param target_player the player to be snooped on
     */
    public Snoop(int targetPlayer)
    {
        //SET target player
        this.targetPlayer = targetPlayer;
    }

    /**
     * Method to execute the action
     *
     * @param manager a reference to the game manager
     */
    @Override
    public void doAction(GameManager manager)
    {
        //CALL the doSnoop method
        doSnoop(this, manager);
    }

    /**
     * The game manager takes one card from the target player's hand
     * and sends it to the player who played the snoop card.
     *
     * @param myself  a reference to itself to access information
     * @param manager a reference to the game manager
     */
    private static void doSnoop(Snoop myself, GameManager manager)
    {
        Player targetPlayer = manager.getTable().getPlayers().get(myself.targetPlayer);
        Player currentPlayer = manager.getTable().getPlayers().get(manager.getCurActingPlayerID());

        //CREATE RespondWithClueCards instruction with snoop enum
        RespondWithClueCards tellRespond = new RespondWithClueCards(
                manager.getCurActingPlayerID(), ActionCardType.Snoop,
                new ArrayList<String>(), false);
        //CREATE GetNotified instruction with string
        GetNotified notification = new GetNotified(currentPlayer.getUsername() +
                " has Snooped on " + targetPlayer.getUsername());
        //SEND GetNotified instruction to all players
        manager.sendInstructionToAllPlayers(notification);
        //SEND RespondWithClueCards instruction to the target player
        manager.sendInstructionToPlayerExpectingResponse(tellRespond, targetPlayer.getPlayerID());
        manager.getTable().getDiscardPile().discard(currentPlayer.getHand().removeActionCard(ActionCardType.Snoop, null));
    }
}
