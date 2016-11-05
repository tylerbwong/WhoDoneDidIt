package whodonedidit.version1_0;

/**
 * Instruction for notifying the player that notifies the player that his/her
 * accusation was incorrect
 * 
 * @author Brittany Berlanga
 * @version 1.0
 * @since 17-Nov-2015
 */
public class YouLose implements Instruction
{
    /**
     * Constructs a YouLose instruction that notifies the player that his/her
     * accusation was incorrect
     */
    public YouLose() 
    {
    }
    
    /**
     * Follow the instruction given by the game manager
     *
     * @param player a reference to the player to follow the instruction
     */
    @Override
    public void doInstruction(Player player)
    {
        //CALL doYouLose with the YouLose instruction and player
        doYouLose(this, player);
    }
    
    /**
     * Notifies the player that his/her accusation was incorrect
     * 
     * @param myself a self reference to access information
     * @param player a reference to the player doing the instruction
     */
    private static void doYouLose(YouLose myself, Player player) 
    {
        player.setState(PlayerState.Defeat);
        //CALL setCurrentState on player with a Defeat PlayerState
        player.setState(PlayerState.YouLose);
    }
}
