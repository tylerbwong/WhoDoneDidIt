/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package whodonedidit.version1_0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 *
 * @author austinrobarts
 */
public class PrivateTipTest
{

    public PrivateTipTest()
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

    /**
     * Test of doAction method, of class AllSnoop.
     */
    @Test
    public void testDoAction()
    {
        List<Player> players = new ArrayList<>();
        players.add(new TestPlayer(0, "a"));
        players.add(new TestPlayer(1, "b"));
        players.add(new TestPlayer(2, "c"));

        System.out.println("PrivateTip");
        TestManager manager = new TestManager(new TestTable(players), 0);
        PrivateTip instance = new PrivateTip(ActionCardType.PrivateTipAll, 2, Arrays.asList("vehicle", "blue", "ground"));
        players.get(1).getHand().addActionCard(new ActionCard(ActionCardType.PrivateTipAll, Arrays.asList("vehicle", "blue", "ground")));
        instance.doAction(manager);
        assertTrue(manager.sentGetNotified);
        assertTrue(manager.sentCorrectPlayerID);
        assertTrue(manager.sentCorrectInstruction);
        assertEquals(0, players.get(1).getHand().getActionCards().size());

        manager = new TestManager(new TestTable(players), 0);
        instance = new PrivateTip(ActionCardType.PrivateTipOne, 2, Arrays.asList("vehicle", "blue", "ground"));
        players.get(1).getHand().addActionCard(new ActionCard(ActionCardType.PrivateTipOne, Arrays.asList("vehicle", "blue", "ground")));
        instance.doAction(manager);
        assertTrue(manager.sentGetNotified);
        assertTrue(manager.sentCorrectPlayerID);
        assertTrue(manager.sentCorrectInstruction);
        assertEquals(0, players.get(1).getHand().getActionCards().size());

    }

    private class TestManager extends GameManager
    {
        public boolean sentCorrectPlayerID;
        public boolean sentCorrectInstruction;
        public boolean sentGetNotified;
        private Table table;
        private int timer;

        public TestManager(Table table, int timerLimit)
        {
            super(table, timerLimit);
            this.table = table;
            sentCorrectPlayerID = false;
            sentCorrectInstruction = false;
            sentGetNotified = false;
        }

        @Override
        public int getCurActingPlayerID()
        {
            return 1;
        }

        @Override
        public void sendInstructionToPlayerExpectingResponse(Instruction instruction, int targetPlayerID)
        {
            if(instruction instanceof RespondWithClueCards)
                sentCorrectInstruction = true;
            if(targetPlayerID == 2)
                sentCorrectPlayerID = true;
        }

        @Override
        public void sendInstructionToAllPlayers(Instruction instruction)
        {
            if (instruction instanceof GetNotified)
                sentGetNotified = true;
        }

        @Override
        public Table getTable()
        {
            return table;
        }

    }

    private class TestTable extends Table
    {
        List<Player> players;
        List<DestinationMarker> markers;
        Solution solution;

        public TestTable(List<Player> players)
        {
            super(players);
            this.players = players;
        }

        @Override
        public List<Player> getPlayers()
        {
            return players;
        }
    }

    private class TestPlayer extends Player
    {
        String name;
        Hand hand;

        public TestPlayer(int playerID, String username)
        {
            super(playerID, username);
        }

        @Override
        public String getUsername()
        {
            return super.getUsername(); //To change body of generated methods, choose Tools | Templates.
        }

    }

    private class TestHand extends Hand
    {

        @Override
        public List<ClueCard> findClueCard(List<String> description)
        {
            return super.findClueCard(description); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public DestinationMarker getDestinationMarker()
        {
            return super.getDestinationMarker(); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public ClueCard getRandomClueCard()
        {
            return super.getRandomClueCard(); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public DestinationMarker swapDestinationMarker(DestinationMarker newMarker)
        {
            return super.swapDestinationMarker(newMarker); //To change body of generated methods, choose Tools | Templates.
        }

    }
}