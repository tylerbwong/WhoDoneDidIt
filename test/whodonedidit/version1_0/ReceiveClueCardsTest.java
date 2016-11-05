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
 * @author brittanyberlanga
 * @since 11-20-15
 * @version 1.0
 */
public class ReceiveClueCardsTest
{

    public ReceiveClueCardsTest()
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
     * Test of doInstruction method, of class ReceiveClueCards.
     */
    @Test
    public void testDoInstruction()
    {
        System.out.println("doReceiveClueCards");
        Player player = new Player(0, "player");
        List<ClueCard> clueCards = new ArrayList<>();
        List<String> description = new ArrayList<>();
        description.add("female");
        clueCards.add(new ClueCard("miss scarlet", description));
        ReceiveClueCards instruction = new ReceiveClueCards(player.getState().type, 0, clueCards);
        instruction.doInstruction(player);
        PlayerState state = player.getState();
        assertEquals(state == PlayerState.ReceivingClueCards, true);
        assertEquals(state.getCardsToReveal().get(0).getName().equals("miss scarlet"), true);
    }
}