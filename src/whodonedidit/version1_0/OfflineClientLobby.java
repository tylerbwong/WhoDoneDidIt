
package whodonedidit.version1_0;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

/**
 * The offline client lobby contains the information needed before a
 * game starts. It holds the list of lobby lobbyPlayers and has the logic to
 * start the game.
 *
 * @author austinrobarts
 * @since 11-19-15
 */
public class OfflineClientLobby extends Observable implements ClientLobby
{
    /** the defaultTimer for the game in seconds */
    private static final int kDefaultTimer = 30;
    /**
     * The username of the client in the offline lobby
     */
    private String username;

    /**
     * List of lobbyPlayers set up in the game lobby before the game starts
     */
    List<LobbyPlayer> lobbyPlayers;

    public OfflineClientLobby(String username)
    {
        this.username = username;
        lobbyPlayers = new LinkedList<>();
    }

    /**
     * Accessor method to get a reference to the list of lobby lobbyPlayers
     * to display to the client.
     *
     * @return a reference to the list of lobby lobbyPlayers
     */
    @Override
    public List<LobbyPlayer> getLobbyPlayers()
    {
        return lobbyPlayers;
    }

    /**
     *
     */
    @Override
    public void startGame()
    {
        createGame();
    }

    /**
     *
     * @param playerType
     */
    @Override
    public void addPlayer(LobbyPlayer.Descriptor playerType)
    {
        //CREATE a new player based on player
        LobbyPlayer newPlayer = new LobbyPlayer(username, playerType);
        //ADD the player to the list of lobbyPlayers
        lobbyPlayers.add(newPlayer);
        setChanged();
        notifyObservers(lobbyPlayers);
    }

    /**
     * Add a computer player to the list of lobby lobbyPlayers
     * This notifies the observers of a change to the list of lobbyPlayers.
     *
     * @param difficulty difficulty descriptor for computer
     * @param name the screen name of the computer
     */
    @Override
    public void addComputerPlayer(LobbyPlayer.Descriptor difficulty, String name)
    {
        //CREATE a new player based on difficulty and name
        LobbyPlayer newComputerPlayer = new LobbyPlayer(name, difficulty);
        //ADD the player to the list of lobbyPlayers
        lobbyPlayers.add(newComputerPlayer);
        setChanged();
        notifyObservers(lobbyPlayers);
    }

    /**
     * Remove the player from the list of lobby lobbyPlayers based on the index
     * given. This notifies the observers of a change to the list of lobbyPlayers
     * @param index
     */
    @Override
    public void removePlayer(int index)
    {
        lobbyPlayers.remove(index);
        setChanged();
        notifyObservers(lobbyPlayers);
    }

    @Override
    public void removePlayer(String name)
    {
        removePlayer(getIndexFromUsername(name));
    }



    /**
     * Called once the host of the game starts the game
     * It creates the list of lobbyPlayers and creates the table, game manager
     * and game messenger. Then it calls game manager's run game
     */
    private void createGame()
    {
        //CONSTRUCT GameMessenger with Server
        GameMessenger messenger = new GameMessenger();

        //CREATE empty list of lobbyPlayers
        List<Player> gamePlayers = new ArrayList<>();

        //FOR EACH lobbyPlayer in lobbyPlayers
        for (int index = 0; index < lobbyPlayers.size();index++)
        {
            //Get lobbyPlayer at index
            LobbyPlayer lobbyPlayer = lobbyPlayers.get(index);
            //CONSTRUCT player with id and userName of lobbyPlayer
            Player gamePlayer = new Player(index, lobbyPlayer.userName);
            if (lobbyPlayer.descriptor != LobbyPlayer.Descriptor.Human)
            {
                gamePlayer.addObserver(new AIController());
            }

            //CONSTRUCT offline player messenger
            PlayerMessenger playerMessenger = new PlayerMessenger();
            //SET playermessenger for player
            gamePlayer.setPlayerMessenger(playerMessenger);
            //connect game messenger to player messenger
            playerMessenger.connectGameMessenger(messenger);
            //connect player messenger to game messenger
            messenger.connectPlayerMessenger(playerMessenger);
            //set the player
            playerMessenger.setPlayer(gamePlayer);
            //ADD player to list
            gamePlayers.add(gamePlayer);
        }
        //CONSTRUCT Table with list of players
        Table table = new Table(gamePlayers);
        //CONSTRUCT GameManager with table and default timer
        GameManager manager = new GameManager(table, 0);
        //SET GameManager's GameMessenger
        manager.setGameMessenger(messenger);
        //SET messenger's game manager
        messenger.setManager(manager);

        setChanged();
        notifyObservers(gamePlayers.get(0));

        //CALL GameManager's runGame method
        manager.runGame();
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
}
