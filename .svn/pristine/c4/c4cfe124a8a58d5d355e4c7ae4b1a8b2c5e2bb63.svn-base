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
public class EndTurnTest
{

    public EndTurnTest()
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
     * Test of doAction method, of class EndTurn.
     */
    @Test
    public void testDoAction()
    {
        List<Player> players = new ArrayList<>();
        players.add(new TestPlayer(0, "a"));
        players.add(new TestPlayer(1, "b"));
        players.add(new TestPlayer(2, "c"));

        System.out.println("doAction");
        TestManager manager = new TestManager(new TestTable(players), 0);
        EndTurn instance = new EndTurn();
        instance.doAction(manager);
        assertTrue(manager.instructedNextPlayerCalled);
        assertTrue(manager.sentUpdateTableInstruction);
    }

    private class TestManager extends GameManager
    {
        private Table table;
        private int timer;
        public boolean instructedNextPlayerCalled = false;
        public boolean sentUpdateTableInstruction = false;

        public TestManager(Table table, int timerLimit)
        {
            super(table, timerLimit);
            this.table = table;

        }

        @Override
        public void instructNextPlayerToDoTurn()
        {
            instructedNextPlayerCalled = true;
        }


        @Override
        public int getCurActingPlayerID()
        {
            return 1;
        }

        @Override
        public void sendInstructionToAllPlayers(Instruction instruction)
        {
            if (instruction instanceof UpdateTable)
            {
                sentUpdateTableInstruction = true;
            }
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

        @Override
        public List<DestinationMarker> getDestinationMarkers()
        {
            return markers;
        }

        @Override
        public Solution getSolution()
        {
            return super.getSolution(); //To change body of generated methods, choose Tools | Templates.
        }


    }

    private class TestPlayer extends Player
    {
        String name;
        Hand hand;

        @Override
        public void setState(PlayerState state)
        {
            assert(state == PlayerState.Idle);
        }

        public TestPlayer(int playerID, String username)
        {
            super(playerID, username);
        }



        @Override
        public Hand getHand()
        {
            return new Hand();
        }

        @Override
        public String getUsername()
        {
            return super.getUsername(); //To change body of generated methods, choose Tools | Templates.
        }

    }

}