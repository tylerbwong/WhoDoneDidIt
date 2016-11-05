package whodonedidit.version1_0;

/**
 *The endTurn action gives the game manager information needed to end
 * the turn of the current player and then tells the next player to
 * take their turn.
 *
 * @author austinrobarts
 * @since 11-17-15
 */
public class EndTurn implements Action
{

    /**
     * Constructs an end turn to send to the game manager to
     * execute
     */
    public EndTurn()
    {
    }

    /**
     * Method to execute the action
     *
     * @param manager a reference to the game manager
     */
    @Override
    public void doAction(GameManager manager)
    {
        //CALL endTurn to execute an endTurn
        endTurn(this, manager);
    }

    /**
     * Ends the turn of the current player and tells the next player
     * that it is their turn.
     *
     * @param myself  a self reference to access AllSnoop variables
     * @param manager a reference to manager
     */
    private static void endTurn(EndTurn myself, GameManager manager)
    {
        Table table = manager.getTable();
        int playerID = manager.getCurActingPlayerID();
        //CREATE updateTable instruction
        Hand playerHand = table.getPlayers().get(playerID).getHand();
        Hand newHand = new Hand(playerHand.getClueCards(), playerHand.getActionCards(), playerHand.getDestinationMarker());
        table.getPlayers().get(playerID).setHand(newHand);
        table.getPlayers().set(playerID, new Player(table.getPlayers().get(playerID)));

        manager.sendInstructionToAllPlayers(new UpdateTable(new Table(table)));

        //CALL game manager's instructNextPlayerToDoTurn method
        manager.instructNextPlayerToDoTurn();
    }
}
