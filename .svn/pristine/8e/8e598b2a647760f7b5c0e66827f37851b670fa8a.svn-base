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
public class MakeAccusationTest
{

    public MakeAccusationTest()
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
     * Test of doAction method, of class MakeAccusation.
     */
    @Test
    public void testDoAction()
    {
        List<Player> players = new ArrayList<>();
        players.add(new TestPlayer(0, "a"));
        players.add(new TestPlayer(1, "b"));
        players.add(new TestPlayer(2, "c"));

        System.out.println("MakeAccusation");
        TestManager manager = new TestManager(new TestTable(players), 0);
        MakeAccusation instance = new MakeAccusation("person", "vehicle", "destination");
        instance.doAction(manager);
        assertTrue(manager.sentEndGame);
        assertTrue(manager.sentGetNotified);

    }

    private class TestSolution extends Solution
    {

        public TestSolution(ClueCard person, ClueCard vehicle, ClueCard destination)
        {
            super(person, vehicle, destination);
        }

        @Override
        public boolean checkSolution(String personGuess, String vehicleGuess, String destinationGuess)
        {
            assertEquals(personGuess, "person");
            assertEquals(vehicleGuess, "vehicle");
            assertEquals(destinationGuess, "destination");
            return true;
        }

    }

    public class TestManager extends GameManager
    {
        public boolean sentEndGame = false;
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
        public void sendInstructionToPlayerExpectingResponse(Instruction instruction, int targetPlayerID)
        {
            assert(instruction instanceof RespondWithClueCards);
            assert(targetPlayerID > -1 && targetPlayerID < 3);
        }

        @Override
        public void sendInstructionToAllPlayers(Instruction instruction)
        {
            if (instruction instanceof EndGame)
            {
                sentEndGame = true;
            }
            if (instruction instanceof GetNotified)
            {
                sentGetNotified = true;
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
        public Solution getSolution()
        {
            return new TestSolution(null, null, null);
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