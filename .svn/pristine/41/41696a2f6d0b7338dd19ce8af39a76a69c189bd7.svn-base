package whodonedidit.version1_0;

/**
 * Sent from the game manager to the player so that they
 * can begin their turn. 
 *
 * @since 10-Nov-2015
 * @version 1.0
 * @author austinrobarts
 * @author Brittany Berlanga
 */
public class DoTurn implements Instruction
{
    /**
     * Constructs a new instruction that will tell the player to start
     * their turn 
     *
     */
    public DoTurn()
    {
    }

    /**
     * Allows the player to follow the instruction given by the game
     * manager
     *
     * @param player a reference to the player to follow the
     *               instruction
     */
    @Override
    public void doInstruction(Player player)
    {
        //CALL doDoTurn with the current DoTurn object and player
        doDoTurn(this, player);
    }

    /**
     * The player takes the action card and then waits for user input
     * for to what to do during their turn
     *
     * @param myself a reference to DoTurn object to access private
     *               fields
     * @param player a reference to the player doing the instruction
     */
    private static void doDoTurn(DoTurn myself, Player player)
    {
        //IF getState on player is YouLose, send an EndTurn Action
        if (player.getState() == PlayerState.Defeat)
        {
            player.sendActionToGameManager(new EndTurn());
        }
        //ELSE CALL setState on player with a DoingTurn PlayerState
        else 
        {
            player.setState(PlayerState.DoingTurn);
        }
    }
}
