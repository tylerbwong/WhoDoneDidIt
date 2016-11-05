/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package whodonedidit.version1_0;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;


/**
 *
 * @author austinrobarts
 */
public class MakeSuggestionTest
{

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
        players.get(2).getHand().addClueCard(new ClueCard("person", null));
        players.get(1).getHand().addActionCard(new ActionCard(ActionCardType.SuggestFromCurrent, null));

        System.out.println("MakeSuggestion");
        TestManager manager = new TestManager(new TestTable(players), 0);
        MakeSuggestion instance = new MakeSuggestion(ActionCardType.SuggestFromCurrent, "person", "vehicle", "destination");
        instance.doAction(manager);
        assertTrue(manager.sentGetNotified);
        assertTrue(manager.sentCorrectPlayerID);
        assertTrue(manager.sentDisproveSuggestion);
        assertEquals(0, players.get(1).getHand().getActionCards().size());

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
        public void sendInstructionToPlayerExpectingResponse(Instruction instruction, int targetPlayerID)
        {
            if(instruction instanceof DisproveSuggestion)
                sentDisproveSuggestion = true;
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