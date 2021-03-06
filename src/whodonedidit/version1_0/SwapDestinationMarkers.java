package whodonedidit.version1_0;

import java.util.List;

/**
 * The action to switch a destination marker from a player to another
 * one on the table. The other destination marker will be on the
 * table or with another player.
 *
 * SRS Functional Requirement: 2.4 Extension B
 *
 * @author austinrobarts
 * @since 11-17-15
 */
public class SwapDestinationMarkers implements Action
{

    /**
     * A string representation of the destination to be switched to
     */
    private String destination;

    /**
     * Type of suggestion that caused this Instruction (SuggestFromAny or
     * SuggestFromCurrent)
     */
    private ActionCardType suggestionType;

    /**
     * Constructs an Action with the specific destination the player
     * would like to switch to.
     *
     * @param destination the destination to be switched to
     */
    public SwapDestinationMarkers(String destination, ActionCardType suggestionType)
    {
        //set destination
        this.destination = destination;
        // Set this action's suggestionType to the argued suggestionType
        this.suggestionType = suggestionType;
    }

    /**
     * Method to execute the action
     *
     * @param manager a reference to the game manager
     */
    @Override
    public void doAction(GameManager manager)
    {
        //call doSwapDestination method
        doSwapDestinationMarkers(this, manager);
    }

    /**
     * This method will tell the game manager to switch out the
     * destination markers. The destination marker to switch could be
     * in the table's list of destination markers or a player could
     * have it
     *
     * @param myself  reference to self
     * @param manager reference to the game manager
     */
    private static void doSwapDestinationMarkers(SwapDestinationMarkers myself, GameManager manager)
    {
        //SET FoundIndex to -1
        int foundIndex = -1;
        //SET found to false
        boolean found = false;
        Table table = manager.getTable();
        Player currentPlayer = table.getPlayers().get(manager.getCurActingPlayerID());
        //Set tempMarker to current player's destination marker
        DestinationMarker tempMarker = new DestinationMarker(currentPlayer.getHand().getDestinationMarker().getDestination());
        //Create GetNotified instruction with players and destination
        GetNotified notification = new GetNotified(currentPlayer.getUsername() +
                " has switched destinations for " + myself.destination);
        //Send GetNotified to all players
        manager.sendInstructionToAllPlayers(notification);

        //Call table's get list of destination markers
        List<DestinationMarker> list = table.getDestinationMarkers();
        //FOR each destination marker in the list
        for (int index = 0; index < list.size(); index++)
        {
            //IF destination marker equals the description
            if (myself.destination.equals(list.get(index).getDestination()))
            {
                //SET FoundIndex to current destination index
                foundIndex = index;
            }
        }

        //IF FoundIndex is greater than -1
        if (foundIndex > -1)
        {
            //call Remove on destination marker list with FoundIndex
            //set current turn's player to that destination marker
            currentPlayer.getHand().setDestinationMarker(list.remove(foundIndex));
            //add tempMarker to table's destination marker list
            list.add(tempMarker);
        }
        else //a player has the destination marker
        {
            //FOR each player who isn't on turn
            for(Player targetPlayer : table.getPlayers())
            {
                //Get player's destination marker
                DestinationMarker targetMarker = new DestinationMarker(targetPlayer.getHand().getDestinationMarker().getDestination());
                //IF player destination marker equals the description
                if (!targetPlayer.getUsername().equals(currentPlayer.getUsername()) &&
                        myself.destination.equals(targetMarker.getDestination()))
                {
                    //SET turn player's destination marker to current looped player's
                    currentPlayer.getHand().setDestinationMarker(targetMarker);
                    //SET current looped players to tempMarker
                    targetPlayer.getHand().setDestinationMarker(tempMarker);
                }
            }
        }

        // If a SuggestsFromCurrent, remove a SuggestFromCurrent action card
        if (myself.suggestionType == ActionCardType.SuggestFromCurrent)
        {
            manager.getTable().getDiscardPile().discard(currentPlayer.getHand().removeActionCard(ActionCardType.SuggestFromCurrent, null));
        }

        manager.sendInstructionToAllPlayers(new UpdateTable(new Table(manager.getTable())));
    }
}
