package whodonedidit.version1_0;

import java.io.IOException;

/**
 * PlayerMessenger is used to facilitate communication between the
 * player and the game manager.
 *
 * If the the player messenger is online the messages will be sent
 * through the server to the game messenger. If the player messenger
 * is offline the messages will be delivered directly to the game
 * messenger.
 *
 * @author austinrobarts
 */
public class PlayerMessenger implements MessageListener
{
    /**
     * Client that is connected to the game server. This will be null
     * if the game is offline.
     */
    private Client client;
    /**
     * The player that the player messenger is representing
     */
    private Player player;
    /**
     * A reference to the game messenger to communicate with
     */
    private GameMessenger gameMessenger;

    /**
     * Constructs an offline messenger
     */
    public PlayerMessenger()
    {
        //SET client null
        client = null;
        gameMessenger = null;
    }

    /**
     * Constructs an online messenger with an associated client
     *
     * @param client the player's client to send messages over
     */
    public PlayerMessenger(Client client)
    {
        //SET client
        this.client = client;
        gameMessenger = null;
        player = null;
    }

    /**
     * Sends an action to be executed by the the Game Manager
     *
     * @param action action that the player wants to be completed
     */
    public void sendMessage(Action action)
    {
        //IF isOnline() THEN
            //CALL client.sendToServer with action
        //ELSE
            //CALL gameMessenger.receiveMessage with action
        //ENDIF
        if(client == null)
        {
            gameMessenger.receiveMessage(action);
        }
        else
        {
            try
            {
                client.sendToServer(action);
            }
            catch(IOException err)
            {
                System.err.println("Caught IOException: " + err.getMessage());
            }
        }
    }

    /**
     * Called when a player has received an instruction from the game
     * manager.
     *
     * @param instruction the instruction to be followed by the player
     */
    @Override
    public void receiveMessage(Object instruction)
    {
        //CALL player.executeInstruction with instruction
        player.executeInstruction((Instruction)instruction);
    }

    /**
     * sets the game messenger so the player messenger can communicate
     * with it
     *
     * @param messenger The game manager's messenger
     */
    public void connectGameMessenger(GameMessenger messenger)
    {
        //SET game messenger
        this.gameMessenger = messenger;
    }

    /**
     * Takes in a player to be assigned to the messenger.
     *
     * @param player A Player to be assigned to the messenger
     */
    public void setPlayer(Player player)
    {
        //SET player
        this.player = player;
    }
}
