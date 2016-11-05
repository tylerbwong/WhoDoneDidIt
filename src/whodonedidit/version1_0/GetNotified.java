package whodonedidit.version1_0;

/**
 * Instruction for notifying player of other players' actions
 * 
 * @author Brittany Berlanga
 * @version 1.0
 * @since 10-Nov-2015
 */
public class GetNotified implements Instruction
{
    /**
     * The String containing information about the last action made
     */
    private String historyLogEntry;
    
    /**
     * Constructs a GetNotified instruction that notifies the player of other 
     * players' actions
     * 
     * @param historyLogEntry the player id of the winner of the game
     */
    public GetNotified(String historyLogEntry) 
    {
        //SET instance historyLogEntry to historyLogEntry
        this.historyLogEntry = historyLogEntry;
    }
    
    /**
     * Follow the instruction given by the game manager
     *
     * @param player a reference to the player to follow the instruction
     */
    @Override
    public void doInstruction(Player player)
    {
        //CALL doGetNotified with the GetNotified instruction and player
        doGetNotified(this, player);
    }
    
    /**
     * Notifies the player of other players' actions
     * 
     * @param myself a self reference to access information
     * @param player a reference to the player doing the instruction
     */
    private static void doGetNotified(GetNotified myself, Player player) 
    {
        //CALL getTable on player RETURNING the player's Table
        Table playerTable = player.getTable();
        //CALL setLastNotification on the player's Table
        playerTable.setLastNotification(myself.historyLogEntry);
        player.setState(player.getState());
    }
}
