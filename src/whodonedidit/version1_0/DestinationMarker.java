package whodonedidit.version1_0;

import java.io.Serializable;

/**
 * DestinationMarker is used to represent one of the destination markers being
 * used in the game.
 *
 * @author Hayden - skeleton, javadocs, pseudocode
 * @version 0.0
 * @since 25-Oct-2015
 */
public class DestinationMarker implements Serializable
{
    /**String to store the name of the destination the marker will represent*/
    private String destination;

    /**
     * Creates a DestinationMarker object with the passed destination.
     *
     * @param destination the name of the destination marker being created
     */
    public DestinationMarker(String destination)
    {
        //SET this destination marker's destination string to given parameter
        this.destination = destination;
    }

    /**
     * @return the name of the destination marker
     */
    public String getDestination()
    {
        //RETURN this destination marker's destination
        return destination;
    }
}
