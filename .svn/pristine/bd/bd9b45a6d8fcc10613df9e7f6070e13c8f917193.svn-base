
package whodonedidit.version1_0;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * The ServerLobby class represents a messenger between clients and
 * the server before the game starts. This helps keep track of what
 * clients have connected and when the game will start.
 *
 * @author austinrobarts
 * @since 11/15/15
 */
public class ServerLobby implements MessageListener
{

    /**The server that clients will connect to for the game */
    private Server server;
    /** List of players that are waiting in the lobby */
    private List<LobbyPlayer> lobbyPlayers;

    private int numHumanPlayers;

    /** the defaultTimer for the game in seconds */
    private static final int kDefaultTimer = 600;

    /**
     * Constructs a ServerLobby to communicate with clients before
     * the game starts
     *
     * @param server the server where clients will send messages
     */
    public ServerLobby(Server server)
    {
        //INIT lobbyPlayers to empty linked list
        lobbyPlayers = new LinkedList<>();
        //SET server
        this.server = server;
        //SET numHumanPlayers to 0
        numHumanPlayers = 0;
    }

    /**
     * Starts listening for clients to connect
     */
    public void startUpLobby()
    {
        try
        {
            //CALL server's listen method
            server.listen();
            System.out.println("Server is waiting for clients...");
        }
        catch (IOException exception)
        {
            System.err.println("IOException because of : " + exception.getMessage());
        }
    }

    /**
     * This method is called when a new message is received from a
     * client. This can tell the server that a client connected,
     * disconnected, or is ready to start the game.
     *
     * @param msg received by server from client, the msg will be
     * a list of players or a newly created table
     */
    @Override
    public void receiveMessage(Object msg)
    {
        System.out.println("Message received: " + msg.getClass());
        //IF msg is a lobbyPlayer
        if (msg instanceof LobbyPlayer)
        {
            System.out.println("Player " + ((LobbyPlayer)msg).getUserName() + " has connected.");
            //CALL updateLobbyPlayers
            updateLobbyPlayers((LobbyPlayer)msg);
            System.out.println("Lobby players connected:");
            for (int i = 0; i < lobbyPlayers.size(); i++)
                System.out.println(lobbyPlayers.get(i).userName);
            //CALL server's sendToAllClients method with the list of lobby players
            server.sendToAllClients(new LinkedList<>(lobbyPlayers));
        }
        //IF msg equals "start"
        else if(msg instanceof String && msg.equals("start"))
        {
            //CALL server's stop listening method
            server.stopListening();
            //SEND message to all clients game started
            server.sendToAllClients(msg);
            //CALL createGame method
            createGame();
        }
        //ELSE IF msg equals "client disconnected"
        else if (msg instanceof Integer)
        {
            //remove the integer player from lobbyPlayers
            lobbyPlayers.remove(((Integer)msg).intValue());
            //DECREMENT numHumanPlayers by 1
            numHumanPlayers--;
            //Call server's sendToAllClients method with the list of lobby players
            server.sendToAllClients(lobbyPlayers);
        }
    }

    /**
     * This update method takes a player and either adds it to the list
     * if the name is not already contained or removes it from the list
     * if it already exists. The username is used to check if the
     * players match
     *
     * @param player the player given from a client to use to update the
     * list of players
     */
    private void updateLobbyPlayers(LobbyPlayer player)
    {
        if (getIndexFromUsername(player.userName) > -1)
        {
            removeLobbyPlayer(player);
        }
        else
        {
            addLobbyPlayer(player);
        }
    }

    /**
     * AddLobbyPlayer takes lobbyPlayers that are sent by clients and
     * add them to the list of lobbyPlayers to be in the next game.
     * Human players take precedence over computer players and are added
     * to the front of the list
     *
     * @param newPlayer the player that has joined the lobby
     */
    private void addLobbyPlayer(LobbyPlayer newPlayer)
    {
        //IF lobby player is human
        if (newPlayer.descriptor == LobbyPlayer.Descriptor.Human)
        {
            //INSERT in first spot that is not a human player
            lobbyPlayers.add(numHumanPlayers, newPlayer);
            //INCREMENT numHumanPlayers by 1
            numHumanPlayers++;
        }
        //ELSE its a computer
        else
        {
            //ADD player to end of player list
            lobbyPlayers.add(newPlayer);
        }
    }

    /**
     * Remove the lobby player from the list of lobbyPlayers
     *
     * @param player the player to remove from the list
     */
    private void removeLobbyPlayer(LobbyPlayer player)
    {
       //get the index of the player given
        //remove the player from the list
        lobbyPlayers.remove(getIndexFromUsername(player.userName));
        if (player.descriptor == LobbyPlayer.Descriptor.Human)
        {
            numHumanPlayers--;
        }
    }

    /**
     * Returns the index of the player that has the same username
     *
     * @param username the username to find in the list
     * @return the index of the player that matches the same name as the
     *         given username. If no match was found, it returns -1.
     */
    private int getIndexFromUsername(String username)
    {
        int foundIndex = -1;
        int currentIndex = 0;

        //WHILE no index was found and still players in list
        while (foundIndex < 0 && currentIndex < lobbyPlayers.size())
        {
            //if the current username matches the given username
            if (lobbyPlayers.get(currentIndex).userName.equals(username))
            {
                //SET found index to current index
                foundIndex = currentIndex;
            }
            //INCREMENT current index
            currentIndex++;
        }
        return foundIndex;
    }

    /**
     * Called once the host of the game lobby sends a start game message.
     * It creates the list of players and creates the table, game manager
     * and game messenger. Then it calls game managers run game
     */
    private void createGame()
    {
        //CONSTRUCT GameMessenger with Server
        GameMessenger messenger = new GameMessenger(server);

        //CREATE empty list of players
        List<Player> players = new ArrayList<>();

        //FOR EACH lobbyPlayer in lobbyPlayers
        for (int index = 0; index < lobbyPlayers.size();index++)
        {
            //Get lobbyPlayer at index
            LobbyPlayer lobbyPlayer = lobbyPlayers.get(index);
            //CONSTRUCT player with id and userName of lobbyPlayer
            Player gamePlayer = new Player(index, lobbyPlayer.userName);

            //IF lobbyPlayer is human
            if (lobbyPlayer.descriptor == LobbyPlayer.Descriptor.Human)
            {
                //SET playermessenger to null
                gamePlayer.setPlayerMessenger(null);
                //CONNECT messengers together
                messenger.connectPlayerMessenger(null);
            }
            //ELSE its a computer player
            else
            {
                gamePlayer.addObserver(new AIController());
                //CONSTRUCT offline player messenger
                PlayerMessenger playerMessenger = new PlayerMessenger();

                //SET playermessenger for player
                gamePlayer.setPlayerMessenger(playerMessenger);
                playerMessenger.setPlayer(gamePlayer);
                playerMessenger.connectGameMessenger(messenger);
                messenger.connectPlayerMessenger(playerMessenger);
            }
            //ADD player to list
            players.add(gamePlayer);

        }

        //CONSTRUCT Table with list of players
        Table table = new Table(players);
        //CONSTRUCT GameManager with table and default timer
        GameManager manager = new GameManager(table, kDefaultTimer);
        //SET GameManager's GameMessenger
        manager.setGameMessenger(messenger);
        //SET server's listener to game messenger
        server.setListener(messenger);
        //SET messenger's game manager
        messenger.setManager(manager);
        //CALL GameManager's runGame method
        manager.runGame();
    }

}
