package whodonedidit.version1_0;

import java.util.List;

/**
 * Represents the action taken when a player plays a Private Tip
 *
 * A private tip asks one player to:
 * "Show me all your Suspect Cards."(1)
 * "Show me all your Vehicle Cards." (1)
 * "Show me all your Destination Cards." (1)
 * "Show me one female Suspect Card." (1)
 * "Show me one red Vehicle Card." (1)
 * "Show me one northern Destination Card." (1)
 *
 * SRS Functional Requirement: 2.4, Extension G
 *
 * @author austinrobarts
 * @since 11-17-15
 */
public class PrivateTip implements Action
{

    /**
     * the target player of the Private Tip
     */
    private int target_player_id;
    /**
     * A list of strings to describe the desired card
     * Example: 1) {"Vehicle", "Red"} 2) {"Destination", "North"}
     */
    private List<String> description;
    /**
     * The type of private tip it is, either a PrivateTipAll or a PrivateTipOne
     */
    private ActionCardType privateTipType;

    /**
     * Constructs the PrivateTip action so it can be executed by the
     * game manager once it is received.
     *
     * @param target_player_id the id of the player to get a tip from
     * @param description      a list of strings that describe the
     *                         private tip
     * @param privateTipType   card type identifier to check how many cards
     *                         to get
     */
    public PrivateTip(ActionCardType privateTipType, int target_player_id, List<String> description)
    {
        //SET the target player id
        this.target_player_id = target_player_id;
        //SET the description
        this.description = description;
        //SET the show all
        this.privateTipType = privateTipType;
    }

    /**
     * Executes the action to be played out on the table
     *
     * @param manager a reference to the game manager
     */
    @Override
    public void doAction(GameManager manager)
    {
        //CALL the doPrivateTip method
        doPrivateTip(this, manager);
    }

    /**
     * Tells the game manager to request the specified cards from the
     * player that was targeted by the private tip.
     *
     * @param myself  a reference to PrivateTip to access private data
     * @param manager a reference to the game manager
     */
    private static void doPrivateTip(PrivateTip myself, GameManager manager)
    {
        Player currentPlayer = manager.getTable().getPlayers().get(manager.getCurActingPlayerID());
        int currentPlayerID = currentPlayer.getPlayerID();
        //CREATE new GetNotified instruction with private tip string
        GetNotified notification = new GetNotified(currentPlayer.getUsername() +
                " has played a private tip");
        //SEND instruction to all players
        manager.sendInstructionToAllPlayers(notification);

        RespondWithClueCards respondToPrivateTip;

        //IF player must show all cards matching description
        if (myself.privateTipType == ActionCardType.PrivateTipAll)
        {
            //CREATE new RespondWithClueCards instruction with description
            respondToPrivateTip = new RespondWithClueCards(currentPlayerID,
                    ActionCardType.PrivateTipAll, myself.description,
                    true);
        }
        else //player needs to show only one card
        {
            respondToPrivateTip = new RespondWithClueCards(currentPlayerID,
                    ActionCardType.PrivateTipOne, myself.description,
                    false);
        }

        //CALL the game manager's sendInstructionToPlayer method with
        //the target player id and the new instruction
        manager.sendInstructionToPlayerExpectingResponse(respondToPrivateTip, myself.target_player_id);
        manager.getTable().getDiscardPile().discard(currentPlayer.getHand().removeActionCard(myself.privateTipType, myself.description));
    }
}
