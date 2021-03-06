package whodonedidit.version1_0;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

/**
 * The lobby controller is responsible for updating the Lobby interface based on
 * responses from the server and informing the server when game settings have
 * been changed. This is only on the Client side of the application.
 *
 * @author austinrobarts
 * @since 11/15/15
 */
public class OnlineClientLobby extends Observable implements MessageListener, ClientLobby
{

    /**
     * Connection to server for the player
     */
    private Client client;
    /**
     * List of players currently in the lobby Can be computer players and human
     * players
     */
    private List<LobbyPlayer> players;
    /**
     * Current player this controller belongs to
     */
    private LobbyPlayer currentPlayer;
    /**
     * Current player username;
     */
    private String username;

    /**
     * Constructs the OnlineClientLobby to update the GUI and send information
     * to the server
     *
     * @param mainFrame a reference to the GUI display
     * @param client the client the player will be using
     */
    public OnlineClientLobby(String username)
    {
        //Set username
        this.username = username;
        //Create client
        this.client = new Client("localhost", Server.kDefaultPort);
        try
        {
            client.openConnection();
        }
        catch (IOException exception)
        {
            System.out.println("Server connection failed");
        }
        //Set the listener of client to OnlineClientLobby
        client.setListener(this);
    }

    /**
     * Constructor used mainly for testing with a predefined client
     *
     * @param username the username of client player
     * @param client the Client to use for communication
     */
    public OnlineClientLobby(String username, Client client)
    {
        players = new LinkedList<>();
        //Set username
        this.username = username;
        //Create client
        this.client = client;
        client.setListener(this);
    }

    /**
     * Receive messages from the server that either tell the client that the
     * list of lobby players has been updated or the game has started
     *
     * @param msg sent from server lobby with an updated list of players
     */
    @Override
    public void receiveMessage(Object msg)
    {
        //IF msg is a list of lobbyPlayers
        if (msg instanceof List)
        {
            //SET players to newly received list of players
            players = (List<LobbyPlayer>) msg;
            System.out.println(players.size() + " lobby players connected:");
            for (int i = 0; i < players.size(); i++)
            {
                System.out.println(players.get(i).userName);
            }
            //tell the GUI to update
            setChanged();
            notifyObservers(players);
        }
        //ELSEIF msg is "start"
        else if (msg instanceof String && msg.equals("start"))
        {
            //Call initilizeGame
            initializeGame();
        }
    }

    /**
     * Used to get the list of lobby players in the lobby
     *
     * @return a list of lobby players currently in the lobby
     */
    @Override
    public List<LobbyPlayer> getLobbyPlayers()
    {
        return players;
    }

    /**
     * Tells the server the player is ready to start the game
     */
    @Override
    public void startGame()
    {
        try
        {
            //send start game to server
            client.sendToServer("start");
        }
        catch (IOException exception)
        {
            System.out.println("Failed to start game");
        }
    }

    /**
     * Add a Human player to the lobby. This will only be called when a user
     * joins the game lobby to add themselves, otherwise a player can only add
     * computers players, if they are the host of the game
     *
     * @param playerType the Description of the player to add
     */
    @Override
    public void addPlayer(LobbyPlayer.Descriptor playerType)
    {
        try
        {
            //create the player
            LobbyPlayer addedPlayer = new LobbyPlayer(username, playerType);
            //send the new player to the server
            client.sendToServer(addedPlayer);
        }
        catch (IOException exception)
        {
        }
    }

    /**
     * Add a computer player to the lobby player list and inform the server of
     * the added player
     *
     * @param difficulty the difficulty of the computer player
     * @param name the username for the computer player
     */
    @Override
    public void addComputerPlayer(LobbyPlayer.Descriptor difficulty, String name)
    {
        try
        {
            //create the player based on difficulty and name
            LobbyPlayer addedPlayer = new LobbyPlayer(name, difficulty);
            //send the new player to the server
            client.sendToServer(addedPlayer);
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
    }

    /**
     *
     * @param index the index into the list to remove a player
     */
    @Override
    public void removePlayer(int index)
    {
        try
        {
            client.sendToServer(players.get(index));
        }
        catch (IOException exception)
        {
            System.out.println("Failed to remove player from lobby");
        }
    }

    @Override
    public void removePlayer(String name)
    {
        removePlayer(getIndexFromUsername(name));
    }

    /**
     * Method to close the client connection if the player quits the lobby
     */
    public void quit()
    {
        try
        {
            removePlayer(getIndexFromUsername(username));
            client.closeConnection();
        }
        catch (IOException exception)
        {
        }
    }

    /**
     * Returns the index of the player that has the same username
     *
     * @param username the string username to represent the player
     * @return the index of the player that matches the same name as the given
     * username. If no match was found, it returns -1.
     */
    private int getIndexFromUsername(String username)
    {
        int foundIndex = -1;
        int currentIndex = 0;

        while (foundIndex < 0 && currentIndex < players.size())
        {
            if (players.get(currentIndex).userName.equals(username))
            {
                foundIndex = currentIndex;
            }
            currentIndex++;
        }
        return foundIndex;
    }

    private void initializeGame()
    {
        //Construct a Player with lobbyPlayer id and username
        Player player = new Player(getIndexFromUsername(username), username);
        //Construct a Player messenger with client
        PlayerMessenger messenger = new PlayerMessenger(client);
        //CALL playerMessenger.setPlayer with player
        messenger.setPlayer(player);
        //set the player's player messenger
        player.setPlayerMessenger(messenger);
        //set client listener to player messenger
        client.setListener(messenger);
        //CALL mainframes initializeGame with player
        setChanged();
        notifyObservers(player);
    }
}
