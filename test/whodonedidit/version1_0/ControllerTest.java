package whodonedidit.version1_0;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import whodonedidit.gui.MainFrame;

/**
 *
 * @author Tyler Wong
 */
public class ControllerTest
{
    MainFrame frame = new MainFrame();
    MockPlayer player = new MockPlayer(0, "Tyler");

    public class MockPlayer extends Player
    {
        private Action action;

        public MockPlayer(int id, String name)
        {
            super(id, name);
        }

        @Override
        public void sendActionToGameManager(Action action)
        {
            this.action = action;
        }
        public Action getAction()
        {
            return this.action;
        }
    }

    public ControllerTest()
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
     * Test of sendEndTurn method, of class Controller.
     */
    @Test
    public void testSendEndTurn()
    {
        System.out.println("sendEndTurn");
        Controller instance = new Controller(this.frame, this.player);
        instance.sendEndTurn();
        assertEquals(this.player.getAction() instanceof EndTurn, true);
    }

    /**
     * Test of sendSnoopAction method, of class Controller.
     */
    @Test
    public void testSendSnoopAction()
    {
        System.out.println("sendSnoopAction");
        int targetPlayerId = 0;
        Controller instance = new Controller(this.frame, this.player);
        instance.sendSnoopAction(targetPlayerId);
        assertEquals(this.player.getAction() instanceof Snoop, true);
    }

    /**
     * Test of sendAllSnoopAction method, of class Controller.
     */
    @Test
    public void testSendAllSnoopAction()
    {
        System.out.println("sendAllSnoopAction");
        Controller instance = new Controller(this.frame, this.player);
        instance.sendAllSnoopAction(ActionCardType.AllSnoopLeft);
        assertEquals(this.player.getAction() instanceof AllSnoop, true);
    }

    /**
     * Test of sendSuperSleuthAction method, of class Controller.
     */
    @Test
    public void testSendSuperSleuthAction()
    {
        System.out.println("sendSuperSleuthAction");
        List<String> description = null;
        Controller instance = new Controller(this.frame, this.player);
        instance.sendSuperSleuthAction(description);
        assertEquals(this.player.getAction() instanceof SuperSleuth, true);
    }

    /**
     * Test of sendMakeAccusationAction method, of class Controller.
     */
    @Test
    public void testSendMakeAccusationAction()
    {
        System.out.println("sendMakeAccusationAction");
        String person = "";
        String vehicle = "";
        String destination = "";
        Controller instance = new Controller(this.frame, this.player);
        instance.sendMakeAccusationAction(person, vehicle, destination);
        assertEquals(this.player.getAction() instanceof MakeAccusation, true);
    }

    /**
     * Test of sendMakeSuggestionAction method, of class Controller.
     */
    @Test
    public void testSendMakeSuggestionAction()
    {
        System.out.println("sendMakeSuggestionAction");
        String person = "";
        String vehicle = "";
        String destination = "";
        Controller instance = new Controller(this.frame, this.player);
        instance.sendMakeSuggestionAction(ActionCardType.SuggestFromAny, person, vehicle, destination);
        assertEquals(this.player.getAction() instanceof MakeSuggestion, true);
    }

    /**
     * Test of sendPrivateTipAction method, of class Controller.
     */
    @Test
    public void testSendPrivateTipAction()
    {
        System.out.println("sendPrivateTipAction");
        int targetPlayerId = 0;
        List<String> description = null;
        boolean showAll = false;
        Controller instance = new Controller(this.frame, this.player);
        instance.sendPrivateTipAction(ActionCardType.PrivateTipOne, targetPlayerId, description);
        assertEquals(this.player.getAction() instanceof PrivateTip, true);
    }

    /**
     * Test of sendSendClueCardsAction method, of class Controller.
     */
    @Test
    public void testSendSendClueCardsAction()
    {
        System.out.println("sendSendClueCardsAction");
        List<ClueCard> cards = null;
        int targetPlayerId = 0;
        Controller instance = new Controller(this.frame, this.player);
        instance.sendSendClueCardsAction(cards, 0);
        assertEquals(this.player.getAction() instanceof SendClueCards, true);
    }

    /**
     * Test of sendSwapDestinationMarkersAction method, of class Controller.
     */
    @Test
    public void testSendSwapDestinationMarkersAction()
    {
        System.out.println("sendSwapDestinationMarkersAction");
        String destination = "";
        Controller instance = new Controller(this.frame, this.player);
        instance.sendSwapDestinationMarkersAction(destination);
        assertEquals(this.player.getAction() instanceof
                SwapDestinationMarkers, true);
    }
}