package whodonedidit.version1_0;

import java.util.ArrayList;
import java.util.List;

/**
 * AIResources
 * This singleton contains resources to be used by AIControllers
 * in the game. It contains a list of what clue cards exist in this
 * instance of the game. This class can not be modified after it's
 * initialized.
 * 
 * Operations:
 * AIResources can provide a static instance of itself.
 * AIResources can provide a list of ClueCards that exist in this game. 
 * AIResources can be initialized, but only once.
 * @author Markus Gemperle
 * @version 29-Nov-2015
 * @deprecated
 */
public class AIResources 
{
    /** Instance of AIResources singleton **/
    private static AIResources instance = new AIResources();

    /** List of clue cards that exist in this instance of the game **/
    private List<ClueCard> clueCardsInGame;

    /** True if this class has been initialized, false otherwise.
     * This class should only allow being modified if uninitialized.
     */
    private boolean isInitialized;

    /**
     * Default instructor that should not be called outside of this class.
     */
    private AIResources()
    {
        // SET clueCardsInGame to new ArrayList
        clueCardsInGame = new ArrayList<>();
        // SET isInitialized to false
        isInitialized = false;
    }

    /**
     * Stores the argued clue cards as the clue cards that exist in the game 
     * and locks this class from being modified in the future.
     * This method will do nothing if this class has already been initialized.
     * @param clueCardsInGame the clue cards that exist in this instance of
     *                        the game
     */
    public void setClueCardsInGame(List<ClueCard> clueCardsInGame)
    {
        // IF isInitialized is false
        if (!isInitialized)
        {
            // SET AIResources' clueCardsInGame to a copy of argued "clueCardsInGame"
            this.clueCardsInGame = new ArrayList<ClueCard>(clueCardsInGame);
            // SET "isInitialized" to true
            isInitialized = true;
        }
        // END IF
    }

    public static AIResources instance()
    {
        // RETURN instance 
        return instance;
    }

    /**
     * Provides the list of clue cards that exist in this instance of the game.
     * @return a copy of the list of clue cards that exist in the game
     */
    public List<ClueCard> getClueCardsInGame()
    {
        // RETURN a copy of clueCardsInGame
        return new ArrayList<ClueCard>(clueCardsInGame);
    }
}
