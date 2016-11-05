package whodonedidit.version1_0;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the action a player takes when they play a suggest from
 * current destination card or suggest from any destination card. They
 * pick a person, vehicle, and destination to suggest with and you go
 * around the table trying to get a player to disprove your
 * suggestion. Once a player disproves the suggestion or all players
 * are iterated through, the action is over.
 *
 * SRS Functional Requirement: 2.4 Extension B
 *
 * @author austinrobarts
 * @since 11-17-15
 */
public class MakeSuggestion implements Action
{

    /**
     * The suggested person
     */
    private String person;
    /**
     * The suggested destination
     */
    private String destination;
    /**
     * The suggested vehicle
     */
    private String vehicle;
    /**
     * The suggestion type, either suggest from current or suggest from any
     */
    private ActionCardType suggestionType;

    /**
     * Constructs an Action with all of the information to conduct a
     * suggestion from their current location.
     *
     * @param person      the person the player suggested
     * @param destination the destination the player suggested
     * @param vehicle     the vehicle the player suggested
     */
    public MakeSuggestion(ActionCardType suggestionType, String person, String vehicle, String destination)
    {
        //SET the person
        this.person = person;
        //SET the destination
        this.destination = destination;
        //SET the vehicle
        this.vehicle = vehicle;
        //SET the suggestionType
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
        //CALL the doSuggestion method
        doSuggestion(this, manager);
    }

    /**
     * The game manager goes though each player and sees if any player
     * has cards that match the given cards. If a player does they
     * send them a disproveSuggestion Instruction
     *
     * @param myself  a reference to itself to access information
     * @param manager a reference to the game manager
     */
    private static void doSuggestion(MakeSuggestion myself, GameManager manager)
    {
        boolean found = false;
        int index = 1;
        int nextPlayerID;
        Player currentPlayer = manager.getTable().getPlayers().get(manager.getCurActingPlayerID());
        //CREATE GetNotified instruction to represent suggestion
        GetNotified notification = new GetNotified(currentPlayer.getUsername() +
                " suggested " + myself.person + " using " + myself.vehicle + " at " + myself.destination);
        //SEND instruction to all players
        manager.sendInstructionToAllPlayers(notification);

        //CREATE new DisproveSuggestion Instruction with person,
            //vehicle, and destination
        DisproveSuggestion disproveSuggestion = new DisproveSuggestion(myself.suggestionType, currentPlayer.getPlayerID(),
                myself.person, myself.vehicle, myself.destination);
        List<Player> playerList = manager.getTable().getPlayers();
        //WHILE suggestion has not been disproved and there are still players left
        while (!found && index < playerList.size())
        {
            //CALL getHand() for the player
            nextPlayerID = (manager.getCurActingPlayerID() + index) % playerList.size();
            Hand playerHand = playerList.get(nextPlayerID).getHand();
            //IF the hand contains person, destination, or vehicle
            if (playerHand.containsClueCard(myself.person) ||
                playerHand.containsClueCard(myself.vehicle) ||
                playerHand.containsClueCard(myself.destination))
            {
                //SET suggestion to disproved to end while
                found = true;
                //CALL sendInstructionToPlayer method with the instruction
                manager.sendInstructionToAllPlayers(new GetNotified(manager.getTable().
                        getPlayers().get(nextPlayerID).getUsername()
                        + " has disproved the suggestion"));
                manager.sendInstructionToPlayerExpectingResponse(disproveSuggestion, nextPlayerID);
            }
            //INCREMENT to next player
            index++;
        }
        //if no one could disprove
        if (!found)
        {
            //send a notification to everyone
            manager.sendInstructionToAllPlayers(new GetNotified("No one could disprove suggestion..."));
            //send an empty list to the player who played suggestion
            manager.sendInstructionToPlayer(new ReceiveClueCards(myself.suggestionType, 0, new ArrayList<ClueCard>()), currentPlayer.getPlayerID());
        }
        //remove the action card that was played
        manager.getTable().getDiscardPile().discard(currentPlayer.getHand().removeActionCard(myself.suggestionType, null));
    }
}
