package whodonedidit.version1_0;

import java.util.ArrayList;

/**
 * The All Snoop class represents a player playing an All Snoop card
 * on the table. Every player gets to look at one random card from the
 * player to the left or right of them.
 *
 * "All Snoop on player's hand to LEFT" (2 Cards)
 * "All Snoop on player's hand to RIGHT" (2 Cards)
 *
 * SRS Functional Requirement: 2.4, Extension E
 *
 * @author austinrobarts
 * @since 11-17-15
 */
public class AllSnoop implements Action
{
    /**
     * The AllSnoopType, either AllSnoopLeft or AllSnoopRight
     */
    private ActionCardType allSnoopType;

    /**
     * Constructs an all snoop action to send to the game manager to
     * execute
     *
     * @param allSnoopType card type identifier
     */
    public AllSnoop(ActionCardType allSnoopType)
    {
        //SET allSnoopType to allSnoopType
        this.allSnoopType = allSnoopType;
    }

    /**
     * Method to execute the action
     *
     * @param manager a reference to the game manager
     */
    @Override
    public void doAction(GameManager manager)
    {
        //CALL doAllSnoop to execute AllSnoop
        doAllSnoop(this, manager);
    }

    /**
     * Specialized method to conduct any logic needed to do an
     * AllSnoop. Gets all players to see a card from the player's hand
     * to the left or to the right based on the all snoop card
     *
     * @param myself  a self reference to access AllSnoop variables
     * @param manager a reference to manager
     */
    private static void doAllSnoop(AllSnoop myself, GameManager manager)
    {
        int increment;
        int numPlayers = manager.getTable().getPlayers().size();
        Player currentTurnPlayer = manager.getTable().getPlayers().get(manager.getCurActingPlayerID());

        //CREATE GetNotified instruction
        GetNotified notification = new GetNotified(currentTurnPlayer.getUsername() + " played an AllSnoop");
        //SEND instruction to all players
        manager.sendInstructionToAllPlayers(notification);

        //IF you need to all snoop on the right player's hand
        if (myself.allSnoopType == ActionCardType.AllSnoopRight)
        {
            //SET increment to right
            increment = -1;
        }
        else //All snoop on players hand to left
        {
            //SET increment to left
            increment = 1;
        }

        //FOR EACH player at the table
        for (int index = 0; index < numPlayers; index++)
        {
            //CREATE a RespondWithClueCards instruction
            RespondWithClueCards respondInstruction =
                    new RespondWithClueCards(index, myself.allSnoopType, new ArrayList<String>(), false);
            //SEND the instruction to the player based on the increment
            manager.sendInstructionToPlayerExpectingResponse(respondInstruction,
                    (numPlayers + index + increment) % numPlayers);
        }

        manager.getTable().getDiscardPile().discard(currentTurnPlayer.getHand().removeActionCard(myself.allSnoopType, null));
    }
}
