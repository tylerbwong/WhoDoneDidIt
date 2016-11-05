package whodonedidit.version1_0;

import java.util.List;

/**
 * NOT IMPLEMENTED, WILL BE IMPLEMENTED IN VERSION 2 
 *
 *
 * Represents the action that will take place when a player plays a
 * Super Sleuth card.
 *
 * A super sleuth card asks all players for:
 * "Show me one female Suspect Card." (1)
 * "Show me one male Suspect Card." (1)
 * "Show me one flying Vehicle Card." (1)
 * "Show me one blue Vehicle Card." (1)
 * "Show me one southern Destination Card." (1)
 * "Show me one western Destination Card." (1)
 *
 * @author austinrobarts
 */
public class SuperSleuth implements Action
{

    /**
     * A list of descriptions that need to be matched to cards
     * Example: 1) {"Vehicle", "Blue"}, 2) {"Person", "Male"}
     */
    private List<String> description;

    /**
     * Constructs a SuperSleuth action to be sent to the game manager
     *
     * @param description a list of strings to describe the
     *                    description
     *                    of the card they are looking for
     */
    public SuperSleuth(List<String> description)
    {
        //SET the description
    }

    /**
     * Method to execute the action
     *
     * @param manager a reference to the game manager
     */
    public void doAction(GameManager manager)
    {
        //Call the doSuperSleuth method
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Game Manager requests the card description from each player
     * around the table.
     *
     * @param myself  a reference to access the description
     * @param manager a reference to the game manager
     */
    private static void doSuperSleuth(SuperSleuth myself, GameManager manager)
    {
        //Create GetNotified instruction with description
        //Send GetNotified to all players
        //Create RespondWithClueCards instruction with description and
            //supersleuth enum
        //FOR each player that isn't on turn
            //Send RespondWithClueCards to that player
        //ENDFOR
    }
}
