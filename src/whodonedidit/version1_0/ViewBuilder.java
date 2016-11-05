package whodonedidit.version1_0;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import whodonedidit.gui.*;

/**
 * The ViewBuilder connects the backend model to the GUI.
 *
 * ViewBuilder observes the game Table and a Player for state changes and
 * updates the GUI accordingly
 *
 * @author Brittany Berlanga
 * @author Tyler Wong
 * @version 1.0
 * @since 25-Oct-2015
 */
public class ViewBuilder implements Observer
{

    /**
     * The MainFrame ViewBuilder manipulates as it observers changes from the
     * game Table and the Player
     */
    private MainFrame mainFrame;
    /**
     * The Player observed by the ViewBuilder
     */
    private Player player;
    /**
     * The Table observed by the ViewBuilder
     */
    private Table table;
    
    /**
     * The last notification sent
     */
    private String lastNotification;

    /**
     * Constructor for ViewBuilder
     *
     * @param mainFrame the GUI frame used to display the Who Done Did It? game
     */
    public ViewBuilder(MainFrame mainFrame)
    {
        //SET instance mainFrame to mainFrame
        this.mainFrame = mainFrame;

        //CALL setViewBuiler on mainFrame with the current ViewBuilder
        this.mainFrame.setViewBuilder(this);
        this.lastNotification = "";
    }

    /**
     * Adds a SnoopPanel to the GUI. A SnoopPanel contains list of players
     *
     * @param otherPlayers players to chose from
     */
    public void showSnoopDialog(List<Player> otherPlayers)
    {
        // CONSTRUCT a SnoopPanel with the list of players
        SnoopPanel snoopPanel =
                this.mainFrame.createSnoopPanel(otherPlayers);

        // CALL addDialogPanel on instance mainFrame with the SnoopPanel
        this.mainFrame.showDialog(snoopPanel);
    }
    
    /**
     * Adds a SuggestionPanel to the GUI.
     *
     * @param actionCardType suggestion action card type
     * @param currentDestination string that is the current destination
     */
    public void showSuggestionDialog(ActionCardType actionCardType, 
            String currentDestination)
    {
        // CONSTRUCT a SuggestionPanel
        SuggestionPanel suggestionPanel =
                this.mainFrame.createSuggestionPanel(actionCardType, currentDestination);

        // CALL addDialogPanel on instance mainFrame with the SuggestionPanel
        this.mainFrame.showDialog(suggestionPanel);
    }
    
    /**
     * Adds a PrivateTipPanel to the GUI. A PrivateTipPanel contains list of players
     *
     * @param otherPlayers players to chose from
     */
    public void showPrivateTipDialog(List<Player> otherPlayers, List<String> description, ActionCardType actionCardType)
    {
        // CONSTRUCT a PrivateTipPanel with the list of players
        PrivateTipPanel privateTipPanel =
                this.mainFrame.createPrivateTipPanel(otherPlayers, description, actionCardType);

        // CALL addDialogPanel on instance mainFrame with the PrivateTipPanel
        this.mainFrame.showDialog(privateTipPanel);
    }
    
    /**
     * Adds a SnoopedOnPanel to the GUI. A SnoopedOnPanel contains a card and a
     * username.
     *
     * @param cardName the card the user of Snoop saw
     * @param userPlayerUsername the username of the user of Snoop
     */
    private void showSnoopedOnDialog(String cardName, String userPlayerUsername)
    {
        // CONSTRUCT a SnoopedOnPanel with the cardName and the 
        //userPlayerUsername
        SnoopedOnPanel snoopedOnPanel =
                this.mainFrame.createSnoopedOnPanel(cardName,
                userPlayerUsername);

        // CALL addDialogPanel on instance mainFrame with the SnoopedOnPanel
        this.mainFrame.showDialog(snoopedOnPanel);
    }

    /**
     * Adds a PrivateTipResponsePanel to the GUI. A PrivateTipResponsePanel
     * contains a list of cards and a username
     *
     * @param cardNames the cards the player can choose to respond with
     * @param userPlayerUsername the username of the user of Private Tip
     * @param playerId id of the current player
     */
    private void showPrivateTipResponseDialog(String[] cardNames,
            String userPlayerUsername, int playerId)
    {
        // CONSTRUCT a PrivateTipResponsePanel with the cardNames and the 
        //userPlayerUsername
        PrivateTipResponsePanel responsePanel =
                this.mainFrame.createPrivateTipResponsePanel(cardNames,
                userPlayerUsername, playerId);

        // CALL addDialogPanel on instance mainFrame with the 
        //PrivateTipResponsePanel
        this.mainFrame.showDialog(responsePanel);
    }
    
    /**
     * Adds a PrivateTipResponsePanel to the GUI. A PrivateTipResponsePanel
     * contains a list of cards and a username
     *
     * @param cardNames the cards the player can choose to respond with
     * @param userPlayerUsername the username of the user of Private Tip
     * @param playerId id of the current player
     */
    private void showPrivateTipAllResultDialog(String[] cardNames,
            String userPlayerUsername)
    {
        // CONSTRUCT a PrivateTipResponsePanel with the cardNames and the 
        //userPlayerUsername
        PrivateTipAllResultPanel resultPanel =
                this.mainFrame.createPrivateTipAllResultPanel(cardNames,
                userPlayerUsername);

        // CALL addDialogPanel on instance mainFrame with the 
        //PrivateTipResponsePanel
        this.mainFrame.showDialog(resultPanel);
    }

    /**
     * Adds a SuperSleuthResponsePanel to the GUI. A SuperSleuthResponsePanel
     * contains a list of cards and a username
     *
     * @param cardNames the cards the player can choose to respond with
     * @param userPlayerUsername the username of the user of Super Sleuth
     */
    private void showSuperSleuthResponseDialog(String[] cardNames,
            String userPlayerUsername)
    {
        // CONSTRUCT a SuperSleuthResponsePanel with the cardNames and the 
        //userPlayerUsername

        SuperSleuthResponsePanel responsePanel =
                this.mainFrame.createSuperSleuthResponsePanel(cardNames,
                userPlayerUsername);

        // CALL addDialogPanel on instance mainFrame with the 
        //SuperSleuthResponsePanel
        this.mainFrame.showDialog(responsePanel);
    }

    /**
     * Adds an AllSnoopedOnPanel to the GUI. An AllSnoopedOnPanel contains a
     * list of cards and two usernames
     *
     * @param isRight defines the direction of the All Snoop
     * @param cardName the card seen
     * @param userPlayerUsername the username of the user of All Snoop
     * @param receivingPlayerUsername the username of the receiving player
     */
    private void showAllSnoopedOnDialog(boolean isRight, String cardName,
            String userPlayerUsername, String receivingPlayerUsername)
    {
        // CONSTRUCT an AllSnoopedOnPanel with isRight, cardNames, and 
        //userPlayerUsername
        SnoopedOnPanel snoopedOnPanel =
                this.mainFrame.createAllSnoopedOnPanel(isRight, cardName,
                userPlayerUsername, receivingPlayerUsername);

        // CALL addDialogPanel on instance mainFrame with the 
        //AllSnoopedOnPanel
        this.mainFrame.showDialog(snoopedOnPanel);
    }

    /**
     * Adds a DisproveSuggestionPanel to the GUI. A DisproveSuggestionPanel
     * contains a list of cards and a username
     *
     * @param cardNames the cards the player can choose to respond with
     * @param userPlayerUsername the username of the user of Suggestion
     */
    private void showDisproveSuggestionDialog(String[] cardNames,
            String userPlayerUsername, int targetId)
    {
        // CONSTRUCT a DisproveSuggestionPanel with the cardNames and the
        //userPlayerUsername
        DisproveSuggestionPanel sugPanel =
                this.mainFrame.createDisproveSuggestionPanel(cardNames,
                userPlayerUsername, targetId);

        // CALL addDialogPanel on instance mainFrame with the 
        //DisproveSuggestionPanel
        this.mainFrame.showDialog(sugPanel);
    }

    /**
     * Adds a ReceivedCardsPanel to the GUI. A ReceivedCardsPanel contains a
     * list of cards and a username
     *
     * @param cardNames the cards shown to the player
     * @param senderPlayerUsername the username of the player that sent the
     * cards
     * @param type the current ActionCardType
     */
    private void showReceivedCardsDialog(String[] cardNames,
            String senderPlayerUsername, ActionCardType type)
    {
        // CONSTRUCT a ReceivedCardsPanel with the cardNames and the
        //senderPlayerUsername
        ReceivedCardsPanel receivedPanel =
                this.mainFrame.createReceivedCardsPanel(cardNames,
                senderPlayerUsername, type);
        // CALL addDialogPanel on instance mainFrame with the ReceivedCardsPanel
        this.mainFrame.showDialog(receivedPanel);
    }

    /**
     * Adds an EndGamePanel to the GUI. An EndGamePanel contains the a username
     *
     * @param winner a boolean indicating if the player is the winner
     * @param winnerScreenName the screen name of the player who won the game
     * @param person the right suspect
     * @param vehicle the right vehicle
     * @param destination the right place
     */
    private void showEndGameDialog(boolean winner, String winnerScreenName, 
            String person, String vehicle, String destination)
    {
        // CONSTRUCT an EndGamePanel with the winnerScreenName
        EndGamePanel endPanel = this.mainFrame.createEndGamePanel(winner,
                winnerScreenName, person, vehicle, destination);

        // CALL addDialogPanel on instance mainFrame with the EndGamePanel
        this.mainFrame.showDialog(endPanel);
    }
    
    /**
     * Adds an IncorrectAccusationPanel to the GUI.
     *
     * @param person the right suspect
     * @param vehicle the right vehicle
     * @param destination the right place
     */
    private void showIncorrectAccusationDialog(String person, String vehicle, String destination)
    {
        // CONSTRUCT an EndGamePanel with the winnerScreenName
        IncorrectAccusationPanel incorrectPanel = 
                this.mainFrame.createIncorrectAccusationPanel(person, vehicle, destination);

        // CALL addDialogPanel on instance mainFrame with the EndGamePanel
        this.mainFrame.showDialog(incorrectPanel);
    }

    /**
     * Updates the GUI TablePanel. Updates the TablePanel with the given
     * destination markers, discard pile, and hand cards
     *
     * @param usernames the usernames of the players in the game
     * @param destinations the names of the destination markers
     * @param discardPileCardType the name of the last card played
     * @param handClueCardNames the names of the clue cards in the player's hand
     * @param handActionCardTypes the ActionCardTypes in the player's hand
     * @param currentPlayer the current player taking turn
     * @param numCards the number of cards in each players' hand
     */
    private void updateTable(String userName, String[] userNames, String[] destinations,
            ActionCardType discardPileCardType, String[] handClueCardNames,
            ActionCard[] handActionCard, String notification, String currentPlayer,
            ArrayList<Integer> numCards)
    {
        // CALL updateTable on mainFrame with usernames, destinations,
        // discardPileCardType, handClueCardNames, handActionCardtypes
        this.mainFrame.updateTable(userName, userNames, destinations, discardPileCardType,
                handClueCardNames, handActionCard, notification, this.table, this.player, 
                currentPlayer, numCards);
    }

    @Override
    /**
     * Updates the GUI if the Player's state changes. Updating the GUI can
     * involve updating the GUI Lobby, adding cards to the player's hand, or
     * adding action dialogs depending on the state of the //player
     *
     * @param o the Player the ViewController is observing
     * @param arg extra information needed for dialogs, such as the player
     * //screen name of the winner
     */
    public void update(Observable o, Object arg)
    {
        //CAST o to a Player RETURNING the Player the ViewBuilder is 
        //observing
        this.player = (Player) o;
        this.mainFrame.setController(this.player);

        //CALL getTable on player and set equal to table
        this.table = this.player.getTable();
        String notification = this.table.getLastNotification();
        if (notification == null || this.lastNotification.equals(notification))
        {
            notification = "";
        }
        else
        {
            this.lastNotification = notification;
        }

        //CALL getUsername on instance player RETURNING the player's 
        //String username, username
        String userName = this.player.getUsername();

        //CALL getHand on instance player RETURNING the player's Hand
        Hand hand = this.player.getHand();

        //CALL getClueCards on the player's Hand RETURNING a List of 
        //ClueCards
        List<ClueCard> clueCards = hand.getClueCards();

        //INIT a String array of the size of the List of ClueCards, 
        //clueCardNames
        String[] clueCardNames = new String[clueCards.size()];
        
        //FOR the size of the List of ClueCards
        for (int i = 0; i < clueCards.size(); i++)
        {
            //CALL getName on each ClueCard RETURNING the String
            //equivalent of the card
            //ADD the String to the clueCardNames array
            clueCardNames[i] = clueCards.get(i).getName();
            //ENDFOR
        }
        //CALL getActionCards on the player's Hand RETURNING a List of 
        //ActionCard
        List<ActionCard> actionCardList = hand.getActionCards();
        
        ActionCard[] actionCards = new ActionCard[actionCardList.size()];
        
        for (int i = 0; i < actionCardList.size(); i++)
        {
            actionCards[i] = actionCardList.get(i);
        }

        //CALL getPlayers on the Table RETURNING a List of the 
        //Players
        List<Player> players = this.table.getPlayers();

        //INIT an array of Strings the size of the List of the Players, 
        //userNames
        String[] userNames = new String[players.size()];

        //INIT an array of Strings the size of the List of the Players, 
        //destinations
        String[] destinations = new String[players.size()];
        String currentPlayer = "";
        int currentPlayerId = -1;
        ArrayList<Integer> numCards = new ArrayList<Integer>();
        //CALL getState on the Player RETURNING the Player's PlayerState
        PlayerState state = this.player.getState();
        String sentFromPlayerName;
        String targetPlayerName;
        
        if (state.targetPlayerID == -1)
        {
            sentFromPlayerName = "";
            targetPlayerName = "";
        }
        else
        {
            sentFromPlayerName = players.get(state.sentFromPlayerID).getUsername();
            targetPlayerName = players.get(state.targetPlayerID).getUsername();
        }
        //FOR the size of the List of the Players
        for (int i = 0; i < players.size(); i++)
        {
            //CALL getUsername on each Player RETURNING a String 
            //userName
            //ADD the userName to the userNames array
            userNames[i] = players.get(i).getUsername();

            //CALL getHand on each Player RETURNING the Player's Hand
            Hand newHand = players.get(i).getHand();
            
            if (newHand.getActionCards().size() > 1)
            {
                currentPlayer = players.get(i).getUsername();
                currentPlayerId = players.get(i).getPlayerID();
            }
            
            numCards.add(newHand.getClueCards().size());

            //CALL getDestinationMarker on the player's RETURNING Hand's
            //DestinationMarker
            //CALL getDestination on the Hand's DestinationMarker 
            //RETURNING the String equivalent of the destination 
            //marker
            //ADD the String of the destintaion marker to the 
            //destinations array
            destinations[i] = newHand.getDestinationMarker().getDestination();
            
            //ENDFOR
        }
        //CALL getDiscardPile on the Table RETURNING the Table's 
        //DiscardPile
        DiscardPile discardPile = this.table.getDiscardPile();
        
        //CALL getTopCard on the DiscardPile RETURNING the last 
        //ActionCard played
        ActionCard topCard = discardPile.getTopCard();
        
        //CALL getType on the last ActionCard played RETURNING the 
        //card's ActionCardType, discardPileCardType
        ActionCardType discardPileCardType = null;
        if (topCard != null)
        {
            discardPileCardType = topCard.getType();
        }
        
        //CALL updateTable with userName, userNames, destinations, 
        //discardPileCardType, clueCardNames, and actionCardTypes
        updateTable(userName, userNames, destinations, discardPileCardType, 
                clueCardNames, actionCards, notification, currentPlayer, numCards);

        
        ArrayList<ClueCard> cards =
                (ArrayList<ClueCard>) state.getCardsToReveal();
        String[] cardNames = new String[cards.size()];

        for (int i = 0; i < cards.size(); i++)
        {
            cardNames[i] = cards.get(i).getName();
        }

        Solution sol;
        
        //CASE PlayerState OF
        switch (state)
        {
            //ReceivingClueCards:
            case ReceivingClueCards:
                //CALL showReceivedCardsDialog with 
                //ReceivingClueCards's displayCards
                showReceivedCardsDialog(cardNames, sentFromPlayerName, state.type);
                this.player.revertState();
                break;
            //BeingSnoopedUpon:
            case BeingSnoopedUpon:
                //CALL showSnoopedOnDialog with BeingSnoopedUpon's 
                //displayCards
                showSnoopedOnDialog(cardNames[0], targetPlayerName);
                this.player.revertState();
                break;
            //RespondingToPrivateTipOne:
            case RespondingToPrivateTipOne:
                //CALL showPrivateTipResponseDialog with 
                //RespondingToPrivateTipOne's displayCards
                showPrivateTipResponseDialog(cardNames, targetPlayerName, state.targetPlayerID);
                this.player.revertState();
                break;
            //RespondingToPrivateTipAll:
            case RespondingToPrivateTipAll:
                //CALL showPrivateTipResponseDialog with 
                //RespondingToPrivateTipAll's displayCards
                showPrivateTipAllResultDialog(cardNames, targetPlayerName);
                this.player.revertState();
                break;
            //RespondingToSuperSleuth:
            case RespondingToSuperSleuth:
                //CALL showSuperSleuthResponseDialog with 
                //RespondingToSuperSleuth's displayCards
                showSuperSleuthResponseDialog(cardNames, targetPlayerName);
                this.player.revertState();
                break;
            //DisprovingSuggestion:
            case DisprovingSuggestion:
                //CALL showDisproveSuggestionDialog with 
                //DisprovingSuggestion's displayCards
                showDisproveSuggestionDialog(cardNames, targetPlayerName, state.targetPlayerID);
                this.player.revertState();
                break;
            //DoingTurn:
            case DoingTurn:
                //CALL enableActionCards on instance mainFrame
                this.mainFrame.enableActionCards();
                this.mainFrame.enableArrestButton();
                break;
            //Victory:
            case Victory:
                //CALL showEndGameDialog with winner as true
                sol = this.table.getSolution();
                showEndGameDialog(true, targetPlayerName, sol.person.getName(), 
                        sol.vehicle.getName(), sol.destination.getName());
                this.mainFrame.disableActionCards();
                this.mainFrame.disableArrestButton();
                this.mainFrame.disableEndTurnButton();
                break;
            //Defeat:
            case Defeat:
                //IDLE until victory
                this.mainFrame.disableActionCards();
                this.mainFrame.disableArrestButton();
                this.mainFrame.disableEndTurnButton();
                break;
            //Lose:
            case YouLose:
                //CALL IncorrectAccusationDialog
                sol = this.table.getSolution();
                showIncorrectAccusationDialog(sol.person.getName(), 
                        sol.vehicle.getName(), sol.destination.getName());
                this.player.revertState();
            //Idle:
            default:
                this.mainFrame.disableActionCards();
                this.mainFrame.disableArrestButton();
                break;
            //ENDCASE
            }
    }
}
