package whodonedidit.version1_0;

/**
 * PlayerStateMachine
 * This class acts as a state machine that contains the PlayerState of a player.
 * It stores a current and previous state.
 * Operations:
 * A PlayerStateMachine can be assigned a new state.
 * A PlayerStateMachine can be reverted to its previous state.
 * A PlayerStateMachine can report its currents tate.
 * @author Markus
 * @version 0.0
 * @since 28-Oct-2015
 */
public class PlayerStateMachine 
{
    /** The current state of the state machine **/
    private PlayerState currentState;

    /** The previous state of the state machine **/
    private PlayerState previousState;

    /**
     * Default constructor that sets current and previous states to Idle.
     */
    public PlayerStateMachine()
    {
        currentState = PlayerState.Idle;
        previousState = PlayerState.Idle;
    }

    /**
     * getCurrentState
     * Reports the current state held by the state machine.
     * @return PlayerState - the current state held by the state machine
     */
    public PlayerState getCurrentState()
    {
        // RETURN "currentState"
        return currentState;
    }
    
    /**
     * getPreviousState
     * Reports the previous state held by the state machine.
     * @return PlayerState - the previous state held by the state machine
     */
    public PlayerState getPreviousState()
    {
        // RETURN "previousState"
        return previousState;
    }

    /**
     * setState
     * Sets the current state of the state machine.
     * @param state PlayerState - the new state to be held by the 
     *              state machine.
     */
    public void setState(PlayerState state)
    {
        // SET "previousState" to "currentState"
        previousState = currentState;
        // SET "currentState" to argued "state"
        currentState = state;
    }

    /**
     * revertToPreviousState
     * Reverts the state machine to its previous state. The previous state
     * becomes the current state and the current state becomes the previous
     * state.
     */
    public void revertToPreviousState()
    {
        // SET a variable PlayerState "temp" to "currentState"
        PlayerState temp = currentState;
        // SET "currentState" to "previousState"
        currentState = previousState;
        // SET "previousState" to "temp"
        previousState = temp;
    }
}
