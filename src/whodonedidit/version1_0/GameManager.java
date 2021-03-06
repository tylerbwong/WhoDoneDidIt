package whodonedidit.version1_0;

/**
 * GameManager
 * This class represents a referee or manager for the game, acting out player's
 * turns, requesting input or action from players, and informing players of
 * events happening during the game. It has a messenger to communicate with
 * players, the game table, and a timer for timing players' turns.
 * Operations:
 * The GameManager can start running the game.
 * The GameManager can deal an action card to a player.
 * The GameManager can execute a player's action for his/her turn.
 * The GameManager can send instructions to players.
 * The GameManager can disconnect a player if he/she is not responding within a
 * pre-determined amount of time.
 * The GameManager can choose the game's solution.
 * The GameManager can deal out the players' initial cards.
 * @author Markus
 * @version 0.0
 * @since 25-Oct-2015
 */
public class GameManager implements TimeoutListener
{
    /**
     * The messenger used to communicate with players
     */
    private GameMessenger messenger;

    /**
     * The instruction last sent by the GameManager
     */
    private Instruction lastInstruction;

    /**
     *  ID of the player and instruction was last sent to.
     */
    private int playerSentLastInstruction;

    /**
     * The player whose response the GameManager is waiting for
     */
    private int curActingPlayerID;

    /**
     * The player whose turn is being executed by the GameManager
     */
    private int curRespondingPlayerID;

    /**
     * The table representing the state of the current game
     */
    private Table table;

    /**
     * The timer for detecting when players time out
     */
    private TimerRunnable timer;

    /**
     * True if players can time out (only for online games)
     */
    private boolean timeoutEnabled;

    /**
     * GameManager
     * Creates a game manager to manage the game on the argued table.
     *
     * @param table the table representing the state of the game
     * @param timerLimit the threshold in seconds at which the timer determines
     *                   a player timed out
     */
    public GameManager(Table table, int timerLimit)
    {
        // SET GameManager's table to argued table
        this.table = table;
        // SET currentAction to null
        lastInstruction= null;
        // SET curActingPlayerID to 0
        curActingPlayerID = 0;
        // SET curRespondingPlayerID to 0
        curRespondingPlayerID = 0;
        // SET messenger to null
        messenger = null;

        // SET timer to a new TimerRunnable using "timerLimit"
        timer = new TimerRunnable(this, timerLimit);
        // CONSTRUCT a new Thread using timer and CALL its start method
        Thread timerThread = new Thread(timer);
        // CALL timer's reset method
        timer.reset();
        // Set timeoutEnabled to true if timerLimit is greater than 0
        timeoutEnabled = (timerLimit > 0);
        // CALL the timer thread's start method
        timerThread.start();
    }

    /**
     * Accessor for the ID of the Player currently doing its turn.
     * @return ID of the player currently doing its turn
     */
    public int getCurActingPlayerID()
    {
        return curActingPlayerID;
    }

    /**
     * runGame
     * Distributes initial hands to Players and instructs the first player to
     * perform its turn.
     * @pre messengers have been initialized
     */
    public void runGame()
    {
        // CALL dealInitialCards
        dealInitialCards();
        // CALL instructPlayerToDoTurn
        instructPlayerToDoTurn(0);
    }

    /**
     * Instructs the next player to do its turn by sending it a
     * DoTurn instruction with a drawn ActionCard.
     * This method should only be called by an EndTurn action, or
     * when the game is started.
     */
    public void instructNextPlayerToDoTurn()
    {
        // Set an integer numIterations to 0
        int numIterations = 0; 

        // WHILE Table's players[curActingPlayerID] has a
        //       PlayerState equal to Defeat (do it at least once though)
        do
        {
            // Advance to next player
            curActingPlayerID = (curActingPlayerID + 1) %
                    table.getPlayers().size();
            // Increment the number of times this loop has run
            numIterations++;

        }
        while (table.getPlayers().get(curActingPlayerID)
                .getState() == PlayerState.Defeat &&
                numIterations < table.getPlayers().size());
        // END WHILE

        // If all players are defeated (numIterations greater than or equal 
        // to number of players)
        if (numIterations >= table.getPlayers().size())
        {
            // Notify players that the game is over
            sendInstructionToAllPlayers(new GetNotified(
                    "Game Over: All players accused incorrectly"));

            sendInstructionToAllPlayers(new EndGame(-1));
        }
        // Otherwise, instruct the next player to do its turn
        else
        {
            // CALL instructPlayerToDoTurn using the new
            //      curActingPlayer
            int playerID = curActingPlayerID;
            instructPlayerToDoTurn(playerID);
        }
    }

    /**
     * Instructs argued Player to do its turn by giving it a new ActionCard,
     * then sending it a DoTurn Instruction.
     * @param playerID id of the player being instructed to do its turn
     */
    private void instructPlayerToDoTurn(int playerID)
    {
        curActingPlayerID = playerID;
        // CALL deck's drawActionCard method saving the ActionCard "drawnCard"
        ActionCard drawnCard = table.getDeck().drawActionCard();
        // ADD "drawnCard" to the Hand of the current player
        Hand playerHand = table.getPlayers().get(
                playerID).getHand();
        playerHand.addActionCard(drawnCard);
        //IF the deck is out of action cards
        if (table.getDeck().actionIsEmpty())
        {
            //CALL the table's discard pile's reshuffleIntoDeck method
            table.getDiscardPile().reshuffleIntoDeck(table.getDeck());
            //CALL deck's shuffle method
            table.getDeck().shuffle();
        }

        Hand newHand = new Hand(playerHand.getClueCards(), playerHand.getActionCards(), playerHand.getDestinationMarker());
        table.getPlayers().get(playerID).setHand(newHand);
        table.getPlayers().set(playerID, new Player(table.getPlayers().get(playerID)));

        //SEND notifitcation of who has the new turn
        sendInstructionToAllPlayers(new GetNotified(getTable().getPlayers().get(playerID).getUsername() +
                "'s Turn"));

        sendInstructionToAllPlayers(new UpdateTable(new Table(table)));
        // CONSTRUCT a DoTurn "instruction"
        DoTurn instruction = new DoTurn();
        // CALL sendInstructionToPlayerExpectingResponse using "instruction" and
        //           "curRespondingPlayerID"
        sendInstructionToPlayerExpectingResponse(instruction, playerID);
    }

    /**
     * executePlayerAction
     * Executes the action received from a player.
     *
     * @param action action sent by a player
     */
    public void executePlayerAction(Action action)
    {
        // CALL receivedResponseFromPlayer
        receivedResponseFromPlayer();
        // CALL doAction in argued "action" using "this" instance of GameManager
        action.doAction(this);
    }

    /**
     * sendInstructionToPlayer
     * Send an instruction to the single argued player.
     *
     * @param instruction Instruction to be sent to the argued player.
     * @param targetPlayerID ID of the player to which the instruction will be
     *                       sent
     */
    public void sendInstructionToPlayer(Instruction instruction,
           int targetPlayerID)
    {
        // Save instruction as lastInstruction
        this.lastInstruction = instruction;
        // Save ID of player who was sent the instruction in
        // playerSentLastInstruction
        this.playerSentLastInstruction = targetPlayerID;

        // CALL messenger's sendMessage using "instruction" and "targetPlayerID"
        messenger.sendMessage(instruction, targetPlayerID);
    }

    /**
     * sendInstructionToPlayerExpectingResponse
     * Send an instruction to the single argued player and start the timer
     * to see if the player receiving the instruction responds to it in a
     * reasonable amount of time. If the player doesn't respond in time,
     * disconnect it
     * @param instruction Instruction to be sent to the argued player
     * @param targetPlayerID ID of the player to which the instruction will
     *                       be sent
     */
    public void sendInstructionToPlayerExpectingResponse(
            Instruction instruction, int targetPlayerID)
    {
        // CALL requestingResponseFromPlayer method
        requestingResponseFromPlayer();
        // SET curRespondingPlayerID to targetPlayerID
        curRespondingPlayerID = targetPlayerID;
        // CALL sendInstructionToPlayer using "instruction" and "targetPlayerID"
        sendInstructionToPlayer(instruction, targetPlayerID);
    }

    /**
     * sendInstructionToAllPlayers
     * Send the argued instruction to every player.
     *
     * @param instruction instruction to be sent to all players
     */
    public void sendInstructionToAllPlayers(Instruction instruction)
    {
        // FOR each "player" in the game
        for (Player player : table.getPlayers())
        {
            // CALL sendInstructionToPlayer using argued "instruction" and
            //      "player"
            sendInstructionToPlayer(instruction, player.getPlayerID());
        }
        // END FOR
    }

    /**
     * requestingResponseFromPlayer
     * Notifies GameManager's timer that it is now waiting for a response
     * from a player. This should be called every time an instruction is
     * sent to a player that expects a response.
     * @pre curRespondingPlayerID is set to the ID of the player
     *      whose response is being requested
     */
    private void requestingResponseFromPlayer()
    {
        // CALL timer's start method
        timer.start();
    }

    /**
     * receivedResponseFromPlayer
     * Notifies GameManager's timer that a response from the player it was
     * waiting for has been received. This should be invoked every time after
     * requestingResponseFromPlayer once the player's response is received by
     * GameManager.
     */
    private void receivedResponseFromPlayer()
    {
        // CALL "timer's" reset method
        timer.reset();
    }

    /**
     * replacePlayerWithAI
     * Replaces the player with the argued ID with a ComputerPlayer. Allowing
     * a game to continue if a HumanPlayer disconnects.
     *
     * @param playerID the ID of the player to be replaced by computer player
     */
    private void replacePlayerWithAI(int playerID)
    {
        // TODO: Be sure to copy player state

        /* Since Player already exists, I don't need to replace it, I just
         * Need to replace its messenger and connect it to an AIController.
        // SET Table's players[playerID] to a new Player
        Player newAI = new Player(playerID, "Smith");
        newAI.setHand(table.getPlayers().get(playerID).getHand());
        table.getPlayers().set(playerID, newAI);
        */
        // CONSTRUCT a new PlayerMessenger "playerMessenger" using default
        //           constructor
        PlayerMessenger playerMessenger = new PlayerMessenger();
        // CONSTUCT a new AIController
        AIController controller = new AIController();
        // ADD AIController to players[playerID]'s observers
        table.getPlayers().get(playerID).addObserver(controller);
        // CALL setMessenger method of players[playerID] using "playerMessenger"
        table.getPlayers().get(playerID).setPlayerMessenger(playerMessenger);
        // CALL messenger's connectPlayerMessenger using "playerMessenger"
        messenger.connectPlayerMessenger(playerMessenger);
        // CALL playerMessenger's connectGameMessenger using "messenger"
        playerMessenger.connectGameMessenger(messenger);
        // Send last instruction to the new computer player
        sendInstructionToPlayerExpectingResponse(lastInstruction, playerID);

        // TODO: We may also want to inform other players of the change somehow
    }

    /**
     * getTable
     * @return the table representing the state of the game
     */
    public Table getTable()
    {
        // RETURN "table"
        return table;
    }

    /**
     * setGameMessenger
     * Sets the game messenger to facilitate communication between
     * the GameManager and the Players.
     *
     * @param messenger the messenger to be used by GameManager to communicate
     *                  with the Players
     */
    public void setGameMessenger(GameMessenger messenger)
    {
        // SET "this" GameManager's "messenger" to the argued "messenger"
        this.messenger = messenger;
    }

    /**
     * respondToTimeout
     * Handler for when a human player's connection times out.
     * Replaces the player with a new computer player.
     */
    @Override
    public void respondToTimeout()
    {
        // CALL timer's reset method
        timer.reset();

        // If timeout is enabled for players
        if (timeoutEnabled)
        {
            // CALL replacePlayerWithAI using curActingPlayerID
            replacePlayerWithAI(curActingPlayerID);
        }
    }

    /**
     * dealInitialCards
     * Sets up the game board by dealing out clue cards, action cards, and
     * destination markers to players.
     */
    private void dealInitialCards()
    {
        // WHILE there are still clue cards in the deck
        while (!table.getDeck().clueIsEmpty())
        {
            // FOR each "player" while there are still clue cards in the deck
            for (int index = 0; (index < table.getPlayers().size()) &&
                    !table.getDeck().clueIsEmpty(); index++)
            {
                // CALL deck's drawClueCard and add it to player's Hand
                Hand hand = table.getPlayers().get(index).getHand();
                hand.addClueCard(table.getDeck().drawClueCard());
            }
            // END FOR
        }
        // END WHILE

        for (Player player : table.getPlayers())
        {
            // CALL deck's drawActionCard and add it to player's Hand
            player.getHand().addActionCard(table.getDeck().drawActionCard());
            // TODO: Need to assign destination marker to players
            player.getHand().setDestinationMarker(table.getDestinationMarkers().
                    remove(0));
        }

        // CONSTRUCT UpdateTable instruction with hands dealt and send it
        //           to all players
        UpdateTable instruction = new UpdateTable(table);
        sendInstructionToAllPlayers(instruction);
    }
}