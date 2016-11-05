/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package whodonedidit.version1_0;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cathibod
 */
public class PlayerTest 
{
    
    public PlayerTest() 
    {
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

    private boolean executedInstruction;

    /**
     * Test of executeInstruction method, of class Player.
     */
    @Test
    public void testExecuteInstruction() 
    {
        System.out.println("executeInstruction");
        Instruction instruction = new Instruction() {

            @Override
            public void doInstruction(Player player)
            {
                executedInstruction = true;
            }
        };
        Player instance = new Player(0, "player");
        executedInstruction = false;
        instance.executeInstruction(instruction);
        assertTrue(executedInstruction);
    }

    private boolean sentActionToMessenger;

    /**
     * Test of sendActionToGameManager method, of class Player.
     */
    @Test
    public void testSendActionToGameManager() 
    {
        System.out.println("sendActionToGameManager");
        Action action = new Action()
        {
            @Override
            public void doAction(GameManager manager)
            {
            }
        };

        PlayerMessenger messenger = new PlayerMessenger()
        {
            @Override
            public void sendMessage(Action action)
            {
                sentActionToMessenger = true;
            }
        };

        Player instance = new Player(0, "player");
        instance.setPlayerMessenger(messenger);
        sentActionToMessenger = false;
        instance.sendActionToGameManager(action);
        assertTrue(sentActionToMessenger);
    }

    /**
     * Test of setHand method, of class Player.
     */
    @Test
    public void testSetHand() 
    {
        System.out.println("setHand");

        ActionCard firstAction = new ActionCard(ActionCardType.Snoop, null);
        ActionCard secondAction = new ActionCard(ActionCardType.SuggestFromAny, null);

        ClueCard firstClue = new ClueCard("firstClue", new ArrayList<String>());
        ClueCard secondClue = new ClueCard("secondClue", new ArrayList<String>());

        Hand hand = new Hand();
        hand.addActionCard(firstAction);
        hand.addActionCard(secondAction);
        hand.addClueCard(firstClue);
        hand.addClueCard(secondClue);
        Player player = new Player(0, "player");
        player.setHand(hand);
        assertEquals(hand, player.getHand());
    }

    /**
     * Test of setTable method, of class Player.
     */
    @Test
    public void testSetTable() 
    {
        System.out.println("setTable");

        ArrayList<Player> playerList = new ArrayList<Player>();
        Player serverPlayer = new Player(0, "player");
        playerList.add(serverPlayer);
        Table table = new Table(playerList);
        Hand hand = new Hand();
        hand.addClueCard(new ClueCard("clue", null));
        serverPlayer.setHand(hand);

        Player clientPlayer = new Player(0, "player");

        // Make sure the client player's hand is empty before the first table update
        assertEquals(0, clientPlayer.getHand().getClueCards().size());

        // Update the table with a table in which the player does have cards in its hand,
        // and make sure the hand was set.
        clientPlayer.setTable(table);
        assertEquals(hand, clientPlayer.getHand());
        assertEquals(table, clientPlayer.getTable());

        // Make sure the player in the client table is still the same client player
        assertEquals(clientPlayer, clientPlayer.getTable().getPlayers().get(0));

        // Reset all the server side stuff and set table again with a different hand
        Hand newHand = new Hand();
        newHand.addActionCard(new ActionCard(ActionCardType.Snoop, null));
        serverPlayer = new Player(0, "player");
        serverPlayer.setHand(newHand);
        playerList = new ArrayList<Player>();
        playerList.add(serverPlayer);
        table = new Table(playerList);
        clientPlayer.setTable(table);

        // Make sure the hand was set to the new hand
        assertEquals(newHand, clientPlayer.getHand());
        assertEquals(table, clientPlayer.getTable());

        // Make sure the client player on the table is still the same client player
        assertEquals(clientPlayer, clientPlayer.getTable().getPlayers().get(0));
    }
}