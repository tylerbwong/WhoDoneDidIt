
package whodonedidit.version1_0;

import java.util.List;

/**
 * Interface ClientLobby represents the lobby before a game has started
 * It contains a list of lobby players, can be human or computer players.
 * The lobby has the role of starting the game when the first player
 * decides to start the game.
 *
 * @author austinrobarts
 * @since 11-19-15
 */
public interface ClientLobby
{

    /**
     * This is called when the player is ready to start the game. The
     * implementation of the method will depend on whether the client
     * is offline or online.
     */
    public void startGame();
    /**
     * Add the player to the list of lobby players
     * @param playerType the descriptor that represents the player
     */
    public void addPlayer(LobbyPlayer.Descriptor playerType);
    /**
     * Add a computer player to the list of lobby players
     * @param difficulty the difficulty descriptor of the computer
     * @param name the screen name to represent the computer
     */
    public void addComputerPlayer(LobbyPlayer.Descriptor difficulty, String name);
    /**
     * Remove the player at the corresponding index from the list of
     * lobby players
     *
     * @param index the index into the list of lobby players of the
     * player that should be removed
     */
    public void removePlayer(int index);
    /**
     * Remove the player with the corresponding name from the list of
     * lobby players
     *
     * @param name the name of the player to be removed from the list
     */
    public void removePlayer(String name);
    /**
     * Accessor method to see the list of lobby players
     *
     * @return returns a reference to the list of lobby players so the
     * user can see who is in the lobby
     */
    public List<LobbyPlayer> getLobbyPlayers();
}
