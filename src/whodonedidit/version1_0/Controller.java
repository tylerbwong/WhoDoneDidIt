package whodonedidit.version1_0;

import java.util.List;
import whodonedidit.gui.MainFrame;

/**
 * The Controller connects the GUI to the backend model.
 *
 * Controller updates the game Table according to user input in the GUI
 *
 * @author Brittany Berlanga
 * @author Tyler Wong
 * @version 1.0
 * @since 07-Nov-2015
 */
public class Controller
{
    /**
     * The Player changed by the Controller
     */
    private Player player;

    /**
     * The main frame
     */
    private MainFrame frame;

    /**
     * Constructs a Controller for the given MainFrame
     *
     * @param mainFrame the MainFrame the Controller connects to the model
     */
    public Controller(MainFrame mainFrame, Player player)
    {
        //SET instance player to player
        this.player = player;
        this.frame = mainFrame;
    }

    /**
     * Creates an EndTurn Action and sends it to the Player to be send to the
     * Game Manager.
     */
    public void sendEndTurn()
    {
        //INIT EndTurn
        EndTurn endTurn = new EndTurn();

        //CALL sendActionToGameManager on instance player with EndTurn
        this.player.sendActionToGameManager(endTurn);
    }

    /**
     * Creates a Snoop Action and sends it to the Player to be send to the Game
     * Manager
     *
     * @param targetPlayerId the integer id of the player to be snooped on
     */
    public void sendSnoopAction(int targetPlayerId)
    {
        //INIT Snoop with the targetPlayerId
        Snoop snoop = new Snoop(targetPlayerId);

        //REVERT player state
        this.player.revertState();

        //CALL sendActionToGameManager on instance player with Snoop
        this.player.sendActionToGameManager(snoop);
    }

    /**
     * Creates an AllSnoop Action and sends it to the Player to be send to the
     * Game Manager
     *
     * @param isRight boolean to tell if it is an allSnoop right or left. Right
     * if true, left if false
     */
    public void sendAllSnoopAction(ActionCardType allSnoopType)
    {
        //INIT AllSnoop with isRight
        AllSnoop allSnoop = new AllSnoop(allSnoopType);

        //REVERT player state
        this.player.revertState();

        //CALL sendActionToGameManager on instance player with AllSnoop
        this.player.sendActionToGameManager(allSnoop);
    }

    /**
     * Creates a SuperSleuth Action and sends it to the Player to be send to
     * the Game Manager
     *
     * @param description a list of strings to describe the description of the
     * card they are looking for
     */
    public void sendSuperSleuthAction(List<String> description)
    {
        //INIT SuperSleuth with description
        SuperSleuth superSleuth = new SuperSleuth(description);

        //REVERT player state
        this.player.revertState();

        //CALL sendActionToGameManager on instance player with SuperSleuth
        this.player.sendActionToGameManager(superSleuth);
    }

    /**
     * Creates a MakeAccusation Action and sends it to the Player to be send to
     * the Game Manager
     *
     * @param person the person the player chose
     * @param vehicle the vehicle the player chose
     * @param destination the destination the player chose
     */
    public void sendMakeAccusationAction(String person, String vehicle, String
                    destination)
    {
        //INIT MakeAccusation with person, vehicle, and destination
        MakeAccusation makeAccusation = new MakeAccusation(person, vehicle, destination);

        //REVERT player state
        this.player.revertState();

        //CALL sendActionToGameManager on instance player with MakeAccusation
        this.player.sendActionToGameManager(makeAccusation);
    }

    /**
     * Creates a MakeSuggestion Action and sends it to the Player to be send to
     * the Game Manager
     *
     * @param person the person the player chose
     * @param vehicle the vehicle the player chose
     * @param destination the destination the player chose
     */
    public void sendMakeSuggestionAction(ActionCardType suggestionType, String person, String vehicle, String
                    destination)
    {
        //INIT MakeSuggestion with person, vehicle, and destination
        MakeSuggestion makeSuggestion = new MakeSuggestion(suggestionType, person, vehicle, destination);

        //REVERT player state
        this.player.revertState();

        if (suggestionType == ActionCardType.SuggestFromAny)
        {
            SwapDestinationMarkers swap = new SwapDestinationMarkers(destination,
                    suggestionType);
            this.player.sendActionToGameManager(swap);
        }
        
        //CALL sendActionToGameManager on instance player with MakeSuggestion
        this.player.sendActionToGameManager(makeSuggestion);
    }

    /**
     * Creates a PrivateTip Action and sends it to the Player to be send to
     * the Game Manager
     *
     * @param privateTipType an ActionCardType that describes the kind of private tip
     * @param targetPlayerId the id of the player to get a tip from
     * @param description a list of strings that describe the private tip
     */
    public void sendPrivateTipAction(ActionCardType privateTipType, int targetPlayerId, List<String>
                    description)
    {
        //INIT PrivateTip with targetPlayerId, description, and showAll
        PrivateTip privateTip = new PrivateTip(privateTipType, targetPlayerId, description);

        //REVERT player state
        this.player.revertState();

        //CALL sendActionToGameManager on instance player with PrivateTip
        this.player.sendActionToGameManager(privateTip);
    }

    /**
     * Creates a SendClueCard Action and sends it to the Player to be send to
     * the Game Manager
     *
     * @param cards the cards to be sent to the game manager
     * @param targetPlayerId the integer id of the player who will receive the
     * cards
     */
    public void sendSendClueCardsAction(List<ClueCard> cards, int targetPlayer)
    {
        //INIT SendClueCards with cards and targetPlayerId
        SendClueCards sendCards = new SendClueCards(player.getState().type, cards, targetPlayer, player.getPlayerID());

        //CALL sendActionToGameManager on instance player with SendClueCards
        this.player.sendActionToGameManager(sendCards);
    }

    /**
     * Creates a SwapDestinationMarkers Action and sends it to the Player to be
     * send to the Game Manager
     *
     * @param destination the destination to be switched to
     */
    public void sendSwapDestinationMarkersAction(String destination) {
        //INIT SwapDestinationMarkers
        SwapDestinationMarkers swapDestinations = new SwapDestinationMarkers(
                destination, ActionCardType.SuggestFromCurrent);

        //REVERT player state
        this.player.revertState();

        //CALL sendActionToGameManager on instance player with
            //SwapDestinationMarkers
        this.player.sendActionToGameManager(swapDestinations);
    }

}
