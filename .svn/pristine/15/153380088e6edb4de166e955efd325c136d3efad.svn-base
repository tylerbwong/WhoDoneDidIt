/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package whodonedidit.version1_0;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Markus
 */
public class GameManagerTest
{
    Instruction sentInstruction;
    int sentToPlayer;

    public GameManagerTest()
    {
        sentInstruction = null;
        sentToPlayer = -1;
    }

    @BeforeClass
    public static void setUpClass()
    {
    }

    @AfterClass
    public static void tearDownClass()
    {
    }

    @Before
    public void setUp()
    {
    }

    @After
    public void tearDown()
    {
    }

    /**
     * Test of getCurActingPlayerID method, of class GameManager.
     */
    @Test
    public void testGetCurActingPlayerID()
    {
        System.out.println("getCurActingPlayerID");
        GameManager instance = new GameManager(null, 30);
        int expResult = 2;

        try
        {
            Field curActingPlayerField = GameManager.class.getDeclaredField(
                    "curActingPlayerID");
            curActingPlayerField.setAccessible(true);
            curActingPlayerField.set(instance, expResult);
        }
        catch (Exception exc)
        {
            fail("Threw exception during getCurActingPlayerID test:\n" + exc);
        }

        int result = instance.getCurActingPlayerID();
        assertEquals(expResult, result);
    }

    private boolean sentUpdateTable;

    /**
     * Test of instructNextPlayerToDoTurn method, of class GameManager.
     */
    @Test
    public void testInstructNextPlayerToDoTurn()
    {
        System.out.println("instructNextPlayerToDoTurn");
        List<Player> players = new ArrayList<Player>();
        players.add(new Player(0, "player_00"));
        players.add(new Player(1, "player_01"));
        players.add(new Player(2, "player_02"));
        Table table = new Table(players);

        // Clear the deck's action cards
        while (!table.getDeck().actionIsEmpty())
        {
            table.getDeck().drawActionCard();
        }

        ActionCard actionCard = new ActionCard(ActionCardType.Snoop,
                Arrays.asList("description"));
        table.getDeck().addActionCard(actionCard);

        GameManager instance = new GameManager(table, 30)
        {
            @Override
            public void sendInstructionToPlayerExpectingResponse(
                    Instruction instruction, int targetPlayerID)
            {
                sentInstruction = instruction;
                sentToPlayer = targetPlayerID;
            }

            @Override
            public void sendInstructionToAllPlayers(Instruction instr)
            {
                if (instr.getClass() == UpdateTable.class)
                {
                    sentUpdateTable = true;
                }
            }
        };

        sentUpdateTable = false;
        instance.instructNextPlayerToDoTurn();

        // Make sure player got it's action card
        Hand playerHand = players.get(1).getHand();
        List<ActionCard> actionCards = playerHand.getActionCards();
        assertEquals(actionCard.getType(), actionCards.get(0).getType());
        assertEquals(1, actionCards.get(0).getDescription().size());
        assertEquals("description", actionCards.get(0).getDescription().get(0));

        assertEquals(DoTurn.class, sentInstruction.getClass());
        assertEquals(1, sentToPlayer);

        instance.instructNextPlayerToDoTurn();
        assertEquals(2, sentToPlayer);

        instance.instructNextPlayerToDoTurn();
        assertEquals(0, sentToPlayer);
        
        instance.instructNextPlayerToDoTurn();
        assertEquals(1, sentToPlayer);
    }

    private boolean didAction;
    private GameManager gameManager;

    /**
     * Test of executePlayerAction method, of class GameManager.
     */
    @Test
    public void testExecutePlayerAction()
    {
        System.out.println("executePlayerAction");
        Action action = new Action() {

            @Override
            public void doAction(GameManager manager)
            {
                didAction = true;
                gameManager = manager;
            }
        };

        didAction = false;
        gameManager = null;
        GameManager instance = new GameManager(null, 30);
        instance.executePlayerAction(action);

        assertTrue(didAction);
        assertEquals(instance, gameManager);
    }

    /**
     * Test of sendInstructionToPlayer method, of class GameManager.
     */
    @Test
    public void testSendInstructionToPlayer()
    {
        System.out.println("sendInstructionToPlayer");

        Instruction instruction = new DoTurn();
        int targetPlayerID = 2;
        GameManager instance = new GameManager(null, 30);

        GameMessenger messenger = new GameMessenger()
        {
            @Override
            public void sendMessage(Instruction instruction, int player_id)
            {
                sentInstruction = instruction;
                sentToPlayer = player_id;
            }
        };
        messenger.setManager(instance);
        instance.setGameMessenger(messenger);

        sentInstruction = null;
        sentToPlayer = -1;
        instance.sendInstructionToPlayer(instruction, targetPlayerID);

        assertEquals(instruction, sentInstruction);
        assertEquals(targetPlayerID, sentToPlayer);
    }

    /**
     * Test of replacePlayerWithAI method, of class GameManager.
     */
    @Test
    public void testReplacePlayerWithAI()
    {
        /* All I really do here is check the player has an observer and has
         * an offline messenger afterwards. I'm not sure how to get any more
         * verification than that. At least we'll know if it throws any exceptions.
         */ 

        System.out.println("replacePlayerWithAI");

        int playerID = 0;

        // Set up the player list
        Player player = new Player(0, "firstPlayer");

        ArrayList<Player> playerList = new ArrayList<Player>();
        playerList.add(player);

        // Set up the table
        Table table = new Table(playerList);

        GameManager manager = new GameManager(table, 30);
        GameMessenger gameMessenger = new GameMessenger();
        manager.setGameMessenger(gameMessenger);

        PlayerMessenger messenger = null;
        try
        {
            Method replaceMethod = GameManager.class.getDeclaredMethod(
                    "replacePlayerWithAI", int.class);
            replaceMethod.setAccessible(true);
            replaceMethod.invoke(manager, 0);

            Field playerMessengerField = Player.class.getDeclaredField("messenger");
            playerMessengerField.setAccessible(true);
            messenger = (PlayerMessenger)playerMessengerField.get(player);

            assertNotNull(messenger);

            Field messengerGameMessengerField = PlayerMessenger.class.getDeclaredField("gameMessenger");
            messengerGameMessengerField.setAccessible(true);
            assertEquals(gameMessenger, (GameMessenger)messengerGameMessengerField.
                    get(messenger));

            Field messengerClientField = PlayerMessenger.class.getDeclaredField("client");
            messengerClientField.setAccessible(true);
            assertNull(messengerClientField.get(messenger));
        }
        catch (Exception exc)
        {
            fail("Threw exception during replacePlayerWithAI test.");
        }

        assertEquals(1, player.countObservers());
    }

    /**
     * Test of dealInitialCards
     */
    @Test
    public void testDealInitialCards()
    {
        System.out.println("dealInitialcards");

        // Set up the game cards
        ClueCard firstClue = new ClueCard("First", null);
        ClueCard secondClue = new ClueCard("Second", null);
        ClueCard thirdClue = new ClueCard("Third", null);
        ClueCard fourthClue = new ClueCard("Fourth", null);

        ActionCard firstAction = new ActionCard(ActionCardType.Snoop, null);
        ActionCard secondAction = new ActionCard(ActionCardType.AllSnoopRight, null);
        ActionCard thirdAction = new ActionCard(ActionCardType.SuggestFromAny, null);

        // Set up the player list
        Player firstPlayer = new Player(0, "firstPlayer");
        Player secondPlayer = new Player(1, "secondPlayer");
        Player thirdPlayer = new Player(2, "thirdPlayer");

        ArrayList<Player> playerList = new ArrayList<Player>();
        playerList.add(firstPlayer);
        playerList.add(secondPlayer);
        playerList.add(thirdPlayer);

        // Set up the table
        Table table = new Table(playerList);
        Deck deck = table.getDeck();

        // Clear the deck
        while (!deck.clueIsEmpty())
        {
            deck.drawClueCard();
        }

        while (!deck.actionIsEmpty())
        {
            deck.drawActionCard();
        }

        deck.addClueCard(firstClue);
        deck.addClueCard(secondClue);
        deck.addClueCard(thirdClue);
        deck.addClueCard(fourthClue);
        deck.addActionCard(firstAction);
        deck.addActionCard(secondAction);
        deck.addActionCard(thirdAction);

        GameManager manager = new GameManager(table, 30)
        {
            @Override
            public void sendInstructionToAllPlayers(Instruction instr)
            {
                sentInstruction = instr;
            }
        };

        try
        {
            Method dealInitialCardsMethod = GameManager.class.
                    getDeclaredMethod("dealInitialCards");
            dealInitialCardsMethod.setAccessible(true);
            dealInitialCardsMethod.invoke(manager);
        }
        catch (Exception exc)
        {
            fail("dealInitialCards test threw an exception\n" + exc);
        }

        assertTrue(firstPlayer.getHand().getClueCards().contains(firstClue));
        assertTrue(firstPlayer.getHand().getClueCards().contains(fourthClue));
        assertEquals(2, firstPlayer.getHand().getClueCards().size());
        assertTrue(secondPlayer.getHand().getClueCards().contains(secondClue));
        assertEquals(1, secondPlayer.getHand().getClueCards().size());
        assertTrue(thirdPlayer.getHand().getClueCards().contains(thirdClue));
        assertEquals(1, thirdPlayer.getHand().getClueCards().size());

        assertTrue(firstPlayer.getHand().getActionCards().contains(firstAction));
        assertEquals(1, firstPlayer.getHand().getActionCards().size());
        assertTrue(secondPlayer.getHand().getActionCards().contains(secondAction));
        assertEquals(1, secondPlayer.getHand().getActionCards().size());
        assertTrue(thirdPlayer.getHand().getActionCards().contains(thirdAction));
        assertEquals(1, thirdPlayer.getHand().getActionCards().size());

        try
        {
            Field tableField = UpdateTable.class.getDeclaredField("table");
            tableField.setAccessible(true);
            assertEquals(table, tableField.get(sentInstruction));
        }
        catch (Exception exc)
        {
            fail("dealInitialCards test threw an exception\n" + exc);
        }

        // TODO: Test for destination markers once that's set up
    }

    /**
     * Tests the timer
     */
    @Test
    public void testTimer() throws InterruptedException
    {
        Player firstPlayer = new Player(0, "player_00");
        Player secondPlayer = new Player(1, "player_01");
        List<Player> players = new ArrayList<Player>();
        players.add(firstPlayer);
        players.add(secondPlayer);
        Table table = new Table(players);

        GameManager manager = new GameManager(table, 1);

        GameMessenger messenger = new GameMessenger()
        {
            @Override
            public void sendMessage(Instruction instruction, int player_id)
            {
                sentInstruction = instruction;
                sentToPlayer = player_id;
            }
        };

        // Be sure neither player is an AI
        assertEquals(0, firstPlayer.countObservers());
        assertEquals(0, secondPlayer.countObservers());

        // Set the GameManager's messenger to my test messenger to intercept instructions 
        manager.setGameMessenger(messenger);
        messenger.setManager(manager);

        // Instruct second player to do its turn and wait for half the time limit
        manager.instructNextPlayerToDoTurn();
        Thread.sleep(500);

        // Send a response to the game manager so it doesn't time out
        Action receivedAction = new Action() 
        {
            @Override
            public void doAction(GameManager manager)
            {
            }
        };
        messenger.receiveMessage(receivedAction);

        // Wait until after it would have timed out and check to make sure it didn't
        Thread.sleep(800);
        assertEquals(0, firstPlayer.countObservers());
        assertEquals(0, secondPlayer.countObservers());

        // Tell first player to do its turn
        manager.instructNextPlayerToDoTurn();

        // Wait for half the time limit and make sure it didn't time out so we can
        // be sure the timer was reset
        Thread.sleep(500);
        assertEquals(0, firstPlayer.countObservers());
        assertEquals(0, secondPlayer.countObservers());

        // Wait until after it would have timed out and make sure the first player timed out
        Thread.sleep(800);
        assertEquals(1, firstPlayer.countObservers());
        assertEquals(0, secondPlayer.countObservers());
    }
}