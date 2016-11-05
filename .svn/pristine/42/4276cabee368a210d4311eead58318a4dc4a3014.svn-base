package whodonedidit.version1_0;

import java.io.Serializable;

/**
 * Interface Instruction facilitates communication from the Game
 * Manager to the Player. The Game Manager sends instructions to a
 * Player for them to carry out. Each subclass must create a
 * Constructor that will have the needed information to do the
 * instruction like Cards or description of what to do.
 *
 * @author austinrobarts
 */
public interface Instruction extends Serializable
{

    /**
     * Method enforced in all subclasses so any Instruction can be
     * executed out by the Player
     *
     * @param player the player that will be doing the instruction
     */
    public void doInstruction(Player player);
}
