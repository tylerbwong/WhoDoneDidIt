package whodonedidit.version1_0;

/**
 * Instruction for notifying player that the game has ended and a player has won 
 * 
 * @author Brittany Berlanga
 * @version 1.0
 * @since 17-Nov-2015
 */
public class EndGame implements Instruction 
{
    /**
     * The player id of the winner of the game
     */
    private int winnerId;
    
    /**
     * Constructs an EndGame instruction that notifies the player the game has 
     * ended and which player won the game
     * 
     * @param winnerId the player id of the winner of the game
     */
    public EndGame(int winnerId) 
    {
        //SET instance winnerId to winnerId
        this.winnerId = winnerId;
    }
    
    /**
     * Follow the instruction given by the game manager
     *
     * @param player a reference to the player to follow the instruction
     */
    @Override
    public void doInstruction(Player player)
    {
        //CALL doEndGame with the EndGame instruction and player
        doEndGame(this, player);
    }
    
    /**
     * Notifies the player that the game is over and who has won
     * 
     * @param myself a self reference to access information
     * @param player a reference to the player doing the instruction
     */
    private static void doEndGame(EndGame myself, Player player) 
    {
        //IF instance winnerId is equal to the player id of player
        if (myself.winnerId == player.getPlayerID())
        {
            //CALL setState on the player with a Victory PlayerState
            PlayerState state = PlayerState.Victory;
            state.targetPlayerID = myself.winnerId;
            player.setState(state);
        }
        //ELSE
        else
        {
            //CALL setState on the player with a Victory PlayerState 
            PlayerState state = PlayerState.Victory;
            state.targetPlayerID = myself.winnerId;
            player.setState(state);
        }
    }
}
