package whodonedidit.version1_0;

import java.io.Serializable;

/**
 * Interface Action will be implemented by subclasses to represent all
 * possible Actions a player can take during a game of Who Done Did It
 *
 * All Actions will be constructed by players and then sent to the
 * Game Manager to be executed. Some example actions are playing a
 * suggestion card or switching a destination marker.
 *
 * @author austinrobarts
 * @since 11-08-15
 */
public interface Action extends Serializable
{

    /**
     * This method will be implemented by all Action subclasses to
     * conduct a certain action. The doAction method will be called by
     * the game manager's executePlayerAction method
     *
     * @param manager A reference to the game manager
     */
    public void doAction(GameManager manager);
}
