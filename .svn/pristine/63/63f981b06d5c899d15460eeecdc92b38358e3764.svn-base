package whodonedidit.version1_0;

/**
 * Instruction for updating the clients' Tables with the server's Table
 * 
 * @author Brittany Berlanga
 * @version 1.0
 * @since 10-Nov-2015
 */
public class UpdateTable implements Instruction
{
    /**
     * The server's Table
     */
    private Table table;
    
    /**
     * Constructs an UpdateTable for updating the clients' Tables with the 
     * server's Table
     * 
     * @param table the server's Table
     */
    public UpdateTable(Table table) 
    {
        //SET instance table to table
        this.table = table;
    }
    
    /**
     * Follow the instruction given by the game manager
     *
     * @param player a reference to the player to follow the instruction
     */
    @Override
    public void doInstruction(Player player)
    {
        //CALL doUpdateTable with the UpdateTable instruction and player
        doUpdateTable(this, player);
    }
    
    /**
     * Updates the clients' Tables with the server's Table
     * 
     * @param myself a self reference to access information
     * @param player a reference to the player doing the instruction
     */
    private static void doUpdateTable(UpdateTable myself, Player player) 
    {
        //CALL setTable on player with the instance table
        player.setTable(myself.table);
    }
}
