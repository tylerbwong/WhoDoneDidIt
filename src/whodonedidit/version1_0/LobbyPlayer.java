package whodonedidit.version1_0;

import java.io.Serializable;

/**
 * LobbyPlayer
 * This will hold a user name and specific descriptor
 * for a player that has joined a lobby, and will be
 * used by LobbyController.
 *
 * @author Tyler Wong
 * @author Brittany Berlanga
 * @version 1.0
 * @since 07-Nov-2015
 */
public class LobbyPlayer implements Serializable
{
    /**
     * A string containing a player's user name
     */
    public final String userName;
    /**
     * An enumerator describing the type of player
     */
    public final Descriptor descriptor;

    /**
     * The enumerator describes the type of player in the lobby.
     */
    public enum Descriptor
    {
        Human,
        ComputerBeginner,
        ComputerIntermediate,
        ComputerAdvanced;
    }

    public String getUserName()
    {
        return this.userName;
    }

    public Descriptor getDescriptor()
    {
        return this.descriptor;
    }

    /**
     * Constructs a LobbyPlayer containing the user name
     * of a player and the type of player.
     *
     * @param userName the player's name
     * @param descriptor the kind of player
     */
    public LobbyPlayer(String userName, Descriptor descriptor)
    {
        // INIT player's user name
        this.userName = userName;

        // INIT player's descriptor
        this.descriptor = descriptor;
    }
}
