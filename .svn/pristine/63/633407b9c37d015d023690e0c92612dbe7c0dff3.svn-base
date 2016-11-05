package whodonedidit.version1_0;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import ocsf.server.ConnectionToClient;

/**
 * The GameMessenger class is an adapter to the server class that
 * allows a message to be sent over the server or locally in an
 * offline mode. This messenger will be used by the Game Manager to
 * send and receive messages between players.
 *
 * In an online game, game messenger will send an instruction through
 * the server to the client. The client will then send it to the
 * player messenger. When a player sends an action, it will be
 * received through the Server and then delivered here.
 *
 * In an offline game, game messenger will send an instruction
 * directly to the player messenger. Game messenger will receive
 * actions directly from the player messenger.
 *
 * @author austinrobarts
 */
public class GameMessenger implements MessageListener
{
    /**
     * The server to use if the game is online, if the game is offline
     * the server will be null
     */
    private Server server;
    /**
     * A list of the player messengers to communicate with
     */
    private List<PlayerMessenger> playerMessengers;
    /**
     * The GameManager the game messenger sends messages for
     */
    private GameManager manager;

    /**
     * Constructs an offline GameMessenger
     */
    public GameMessenger()
    {
        //SET server null
	//INIT playerMessengers
        server = null;
        manager = null;
        playerMessengers = new ArrayList<PlayerMessenger>();
    }

    /**
     * Constructs an online GameMessenger for the Game Manager to use
     *
     * @param server The server to communicate through
     */
    public GameMessenger(Server server)
    {
	//SET server
        //INIT playerMessengers
        this.server = server;
        manager = null;
        playerMessengers = new ArrayList<PlayerMessenger>();
    }

    /**
     * Send an instruction message to a player messenger directly or
     * through the server depending if its online or offline.
     *
     * @param instruction instruction for a player to do
     * @param player_id   player to do instruction
     */
    public void sendMessage(Instruction instruction, int player_id)
    {
        // IF playerMessengers[player_id] does not exist
            // CALL getClientConnections()[player_id]'s sendToClient
            //      method using instruction
        // ELSE
            // CALL playerMessengers[player_id]'s receiveMessage method using
            //      instruction
        // END IF
        //TODO: EDIT AND VERIFY PSUEDOCODE
        if (playerMessengers.get(player_id) != null)
        {
            playerMessengers.get(player_id).receiveMessage(instruction);
        }
        else 
        {
            try
            {
                ((ConnectionToClient)server.getClientConnections()[player_id]).sendToClient(instruction);
            }
            catch(Exception err)
            {
                System.err.println("Message failed to send to player " + player_id);
                System.err.println("Caught IOException: " + err.getMessage());
            }
        }
    }

    /**
     * Receive an action message from the server or directly from the
     * player messenger depending on if its online or offline.
     *
     * @param msg The action message for the game manager to execute
     * @pre the Object must be of type Action
     */
    @Override
    public void receiveMessage(Object msg)
    {
        //CALL (Action)msg.doAction
        manager.executePlayerAction((Action)msg);
    }

    /**
     * Adds a player messenger to the list of player messengers so
     * they can communicate during a game.
     *
     * @param messenger the player messenger to be added
     */
    public void connectPlayerMessenger(PlayerMessenger messenger)
    {
        //CALL playerMessengers.add with messenger
        playerMessengers.add(messenger);
    }

    /**
     * Set the game manager so the messenger can give the game manager
     * messages.
     *
     * @param manager a reference to the game manager
     */
    public void setManager(GameManager manager)
    {
        //SET game manager
        this.manager = manager;
    }
}
