/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package whodonedidit.version1_0;

import java.util.ArrayList;
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
public class SwapDestinationMarkersTest
{

    public SwapDestinationMarkersTest()
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
     * Test of doAction method, of class SwapDestinationMarkers.
     */
    @Test
    public void testSwapWithPlayer()
    {
        System.out.println("SwapPlayerDestinationMarker");
        List<Player> players = new ArrayList<>();
        players.add(new TestPlayer(0, "a"));
        players.add(new TestPlayer(1, "b"));
        players.add(new TestPlayer(2, "c"));
        TestTable table = new TestTable(players, new ArrayList<DestinationMarker>());
        TestManager manager = new TestManager(table, 0);

        players.get(0).getHand().setDestinationMarker(new DestinationMarker("destination1"));
        players.get(1).getHand().setDestinationMarker(new DestinationMarker("destination2"));
        players.get(2).getHand().setDestinationMarker(new DestinationMarker("destination3"));
        SwapDestinationMarkers instance = new SwapDestinationMarkers("destination1", null);
        players.get(1).getHand().addActionCard(new ActionCard(ActionCardType.SuggestFromAny, null));
        instance.doAction(manager);

        assertTrue(manager.sentGetNotified);
        assertEquals("destination2",players.get(0).getHand().getDestinationMarker().getDestination());
        assertEquals("destination1",players.get(1).getHand().getDestinationMarker().getDestination());
    }

    /**
     * Test of doAction method, of class SwapDestinationMarkers.
     */
    @Test
    public void testSwapInTable()
    {
        System.out.println("SwapTableDestinationMarker");

        List<Player> players = new ArrayList<>();
        players.add(new TestPlayer(0, "a"));
        players.add(new TestPlayer(1, "b"));
        players.add(new TestPlayer(2, "c"));

        List<DestinationMarker> markers = new ArrayList<>();
        markers.add(new DestinationMarker("destination4"));
        markers.add(new DestinationMarker("destination5"));
        markers.add(new DestinationMarker("destination6"));

        TestTable table = new TestTable(players, markers);
        TestManager manager = new TestManager(table, 0);
        players.get(0).getHand().setDestinationMarker(new DestinationMarker("destination1"));
        players.get(1).getHand().setDestinationMarker(new DestinationMarker("destination2"));
        players.get(2).getHand().setDestinationMarker(new DestinationMarker("destination3"));
        SwapDestinationMarkers instance = new SwapDestinationMarkers("destination6", null);
        players.get(1).getHand().addActionCard(new ActionCard(ActionCardType.SuggestFromAny, null));
        instance.doAction(manager);

        assertTrue(manager.sentGetNotified);
        assertEquals("destination2",markers.get(markers.size() - 1).getDestination());
        assertEquals("destination6",players.get(1).getHand().getDestinationMarker().getDestination());
    }

    private class TestManager extends GameManager
    {
        public boolean sentGetNotified = false;
        private Table table;
        private int timer;

        public TestManager(Table table, int timerLimit)
        {
            super(table, timerLimit);
            this.table = table;
        }

        @Override
        public int getCurActingPlayerID()
        {
            return 1;
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

        public TestTable(List<Player> players, List<DestinationMarker> markers)
        {
            super(players);
            this.players = players;
            this.markers = markers;
        }

        @Override
        public List<DestinationMarker> getDestinationMarkers()
        {
            return markers;
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
            hand = new TestHand();
        }

        @Override
        public String getUsername()
        {
            return super.getUsername(); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Hand getHand()
        {
            return hand;
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