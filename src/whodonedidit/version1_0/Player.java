package whodonedidit.version1_0;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;

/**
 * Player An abstract class representing a Player in a "Who Done Did
 * It?" game
 *
 * @author Tyler
 * @version 0.0
 * @since 25-Oct-2015
 */
public class Player extends Observable implements Serializable
{
    /**
     * The id of the player
     */
    private int playerID;
    /**
     * The username of the player
     */
    private String username;
    /**
     * The action cards and clue cards in the player's hand
     */
    private Hand hand;
    /**
     * The messenger the player uses to communicate with the game
     * manager
     */
    private transient PlayerMessenger messenger;
	/**
	 * The state machine the player uses to track state changes.
	 * The GUI responds to various Player States
	 */
    private transient PlayerStateMachine stateMachine;
	/**
     * The table is held by each player to be modified by setTable method.
	 *
     */
    private Table table;

    /**
     * Constructor for Player
     *
     * @param playerID identifies each player on the server
     */
    public Player(int playerID, String username)
    {
        //SET playerID
        //SET username
        //INIT stateMachine
        //SET messenger null
        //SET hand null
        //SET table null
        this.playerID = playerID;
        this.username = username;//TODO
        stateMachine = new PlayerStateMachine();
        messenger = null;
        hand = new Hand();
        table = null;
    }

    public Player(Player other)
    {
        this.playerID = other.playerID;
        this.username = other.getUsername();
        PlayerStateMachine neoStateMachine = new PlayerStateMachine();
        neoStateMachine.setState(other.stateMachine.getPreviousState());
        neoStateMachine.setState(other.stateMachine.getCurrentState());
        stateMachine = neoStateMachine;
        messenger = null;
        hand = other.getHand();
        table = null;
    }

    /**
     * Takes in an instruction from the game manager and
     * executes the instruction.
     *
     * @param instruction an instruction to be executed by the player
     *                    from the server
     */
    public void executeInstruction(Instruction instruction)
    {
        //CALL instruction.doInstruction with instruction
        instruction.doInstruction(this);
    }

    /**
     * Sends an action to the game manager.
     *
     * @param action an action to be sent to the game manager
     */
    public void sendActionToGameManager(Action action)
    {
        //CALL messenger.sendMessage with action
        messenger.sendMessage(action);
    }

    /**
     * Accessor for this Player's ID.
     *
     * @return this player's unique identification number as an int
     */
    public int getPlayerID()
    {
        //RETURN playerID
        return playerID;
    }

    /**
     * Takes in a PlayerMessenger to be assigned to the
     * player.
     *
     * @param messenger A PlayerMessenger to be assigned to the player
     */
    public void setPlayerMessenger(PlayerMessenger messenger)
    {
        //SET messenger
        this.messenger = messenger;
    }

    /**
     * Gets a Hand from a Player.
     *
     * @return a Hand from a Player
     */
    public Hand getHand()
    {
        //RETURN hand
        return hand;
    }

    /**
     * Takes in a Hand to be assigned to the player.
     *
     * @param hand A Hand to be assigned to the player
     */
    public void setHand(Hand hand)
    {
        //SET hand
        this.hand = new Hand(hand.getClueCards(), new ArrayList<>(hand.getActionCards()), new DestinationMarker(hand.getDestinationMarker().getDestination()));
    }

    /**
     * Takes in a Table to be assigned to the player.
     *
     * @param table A Table to be assigned to the player
     */
    public void setTable(Table table)
    {
        // Set this Player's table to the argued table
        this.table = table;
        // Set this Player's hand to the hand of the Player
        // in the argued table that has the same ID as this player
        setHand(table.getPlayers().get(playerID).getHand());
        // Replace the player in table that has the same ID as this player
        // with this player
        table.getPlayers().set(playerID, this);

        // notify observers
        setChanged();
        notifyObservers();
    }

    /**
     * Gets a Table from a Player.
     *
     * @return a Table from a Player
     */
    public Table getTable()
    {
        //RETURN table
        return table;
    }

    /**
     * Accessor for this Player's current PlayerState, which represents its
     * current state of operations and influences its behaviour.
     * @return the current PlayerState of this Player
     */
    public PlayerState getState()
    {
        // RETURN state returned by playerStateMachine's getState method
        return stateMachine.getCurrentState();
    }

    /**
     * Accessor for this Player's previous PlayerState, which represents its
     * previous state of operations and influences its behaviour.
     * @return the previous PlayerState of this Player
     */
    public PlayerState getPreviousState()
    {
        // RETURN previous state returned by playerStateMachine's getState method
        return stateMachine.getPreviousState();
    }

    /**
     * Assigns this Player a new PlayerState given by the state parameter.
     * @param state the PlayerState this Player will be assigned
     * @post observers of this Player are notified of a change
     */
    public void setState(PlayerState state)
    {
        // CALL playerStateMachine's setState method using argued state
        stateMachine.setState(state);
        // CALL setChanged
        setChanged();
        // CALL notifyObservers
        notifyObservers();
    }

    /**
     * Reverts this Player's PlayerState to the previously held PlayerState.
     * @post observers of this Player are notified of a change
     */
    public void revertState()
    {
        // CALL playerStateMachine's revertState method
        stateMachine.revertToPreviousState();
        // CALL setChanged
        setChanged();
        // CALL notifyObservers
        notifyObservers();
    }

    /**
     * Gets the username from a Player.
     *
     * @return a String representing a username from a Player
     */
    public String getUsername()
    {
        //RETURN username
        return username;
    }
}