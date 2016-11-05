
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
public class AllSnoopTest
{

    public AllSnoopTest()
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

        players.get(1).getHand().addActionCard(new ActionCard(ActionCardType.AllSnoopRight, null));

        System.out.println("AllSnoop");
        GameManager manager = new TestManager(new TestTable(players), 0);
        AllSnoop instance = new AllSnoop(ActionCardType.AllSnoopRight);
        instance.doAction(manager);

        assertEquals(0, players.get(1).getHand().getActionCards().size());

    }

    private class TestManager extends GameManager
    {
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
        public void sendInstructionToPlayerExpectingResponse(Instruction instruction, int targetPlayerID)
        {
            assert(instruction instanceof RespondWithClueCards);
            assert(targetPlayerID > -1 && targetPlayerID < 3);
        }

        @Override
        public void sendInstructionToAllPlayers(Instruction instruction)
        {
            assert(instruction instanceof GetNotified);
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
}