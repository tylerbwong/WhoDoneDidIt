package whodonedidit.version1_0;

/**
 * The makeAccusation class will construct an action that is capable
 * of conducting all the logic needed to make an accusation during the
 * game. The player is telling the game manager that they believe a
 * certain player, vehicle, and destination is the solution.
 *
 * SRS Functional Requirement: 2.4, extension E
 *
 * @author austinrobarts
 * @since 11-16-15
 */
public class MakeAccusation implements Action
{

    /**
     * The person to accuse
     */
    private String person;
    /**
     * The vehicle the person was in
     */
    private String vehicle;
    /**
     * The destination to find the accused person
     */
    private String destination;

    /**
     * Constructs an Action with the needed information to do an
     * accusation
     *
     * @param person      the person the player chose
     * @param vehicle     the vehicle the player chose
     * @param destination the destination the player chose
     */
    public MakeAccusation(String person, String vehicle, String destination)
    {
        //SET the person
        this.person = person;
        //SET the vehicle
        this.vehicle = vehicle;
        //SET the destination
        this.destination = destination;
    }

    /**
     * Method to execute the action
     *
     * @param manager a reference to the game manager
     */
    @Override
    public void doAction(GameManager manager)
    {
        //CALL the doMakeAccusation method
        doMakeAccusation(this, manager);
    }

    /**
     * This will check the solution with the player's accusation and
     * tell everyone if the player was correct or not. It will also
     * mark the player as the winner or a loser.
     *
     * @param myself  the reference to its own object so it can access
     *                private information
     * @param manager a reference to the game manager
     */
    private static void doMakeAccusation(MakeAccusation myself, GameManager manager)
    {
        //GET the solution from Game Manager
        Solution solution = manager.getTable().getSolution();
        String playerName = manager.getTable().getPlayers().get(manager.getCurActingPlayerID()).getUsername();
        GetNotified notification;

        //CALL solutions check solution method
        //SET match to return value
        boolean match = solution.checkSolution(myself.person, myself.vehicle, myself.destination);

        //IF match is false
        if (!match)
        {
            PlayerState state = PlayerState.Defeat;
            manager.getTable().getPlayers().get(manager.getCurActingPlayerID()).setState(state);
            //CREATE GetNotified instruction with player lost
            notification = new GetNotified(playerName + " has made an incorrect Accusation");
            //SEND GetNotified to all players
            manager.sendInstructionToAllPlayers(notification);
            //CREATE YouLose instruction
            YouLose youLostInstruction = new YouLose();
            //SEND YouLose instruction to player
            manager.sendInstructionToPlayer(youLostInstruction, manager.getCurActingPlayerID());
        }
        //ELSE
        else
        {
            //CREATE GetNotified instruction with player won
            notification = new GetNotified(playerName + " has made a correct Accusation");
            //SEND GetNotified to all players
            manager.sendInstructionToAllPlayers(notification);
            //CREATE EndGame instruction
            EndGame playerWon = new EndGame(manager.getCurActingPlayerID());
            //SEND EndGame instruction to all player's
            manager.sendInstructionToAllPlayers(playerWon);
        }



    }
}
