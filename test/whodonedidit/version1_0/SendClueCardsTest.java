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
public class SendClueCardsTest
{

    public SendClueCardsTest()
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
     * Test of doAction method, of class SendClueCards.
     */
    @Test
    public void testDoAction()
    {
        List<Player> players = new ArrayList<>();
        players.add(new TestPlayer(0, "a"));
        players.add(new TestPlayer(1, "b"));
        players.add(new TestPlayer(2, "c"));

        System.out.println("SendClueCards");
        TestManager manager = new TestManager(new TestTable(players), 0);
        SendClueCards instance = new SendClueCards(players.get(0).getState().type, null, 2, 1);
        instance.doAction(manager);
        assertTrue(manager.sentCorrectPlayerID);
        assertTrue(manager.sentDisproveSuggestion);

    }

    private class TestManager extends GameManager
    {
        public boolean sentCorrectPlayerID = false;
        public boolean sentDisproveSuggestion = false;
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
        public void sendInstructionToPlayer(Instruction instruction, int targetPlayerID)
        {
            if(instruction instanceof ReceiveClueCards)
                sentDisproveSuggestion = true;
            if(targetPlayerID == 2)
                sentCorrectPlayerID = true;
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