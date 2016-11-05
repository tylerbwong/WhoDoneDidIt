/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package whodonedidit.version1_0;

import whodonedidit.version1_0.PlayerState;
import whodonedidit.version1_0.ClueCard;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Markus
 */
public class PlayerStateTest
{
    public PlayerStateTest()
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
     * Test of getCardsToReveal method, of class PlayerState.
     */
    @Test
    public void testGetCardsToReveal()
    {
        System.out.println("getCardsToReveal");
        PlayerState first = PlayerState.Idle;
        PlayerState second = PlayerState.Idle;

        // Neither list should be null after construction
        assertNotNull(first.getCardsToReveal());
        assertNotNull(second.getCardsToReveal());

        List<String> cardDesc = new ArrayList<String>();
        cardDesc.add("aCard");
        ClueCard testCard = new ClueCard("card", cardDesc);

        // Make sure states of the same type are considered equal
        assertEquals(first, second);

        // Make sure states are still seen as equal even if they have
        // different cards to reveal.
        first.getCardsToReveal().add(testCard);
        assertEquals(first, second);

        // Make sure the card added to the cards to reveal list was
        // actually added to the list, and not a copy of it.
        assertEquals(testCard, first.getCardsToReveal().get(0));

        // TODO: PlayerState types are singletons. This probably won't cause
        //       issues now, but should be fixed in the future.
        // Make sure states don't share their cards to reveal lists
        // just because their types are the same. That would be a problem.
        //assertNotSame(first.getCardsToReveal().size(), 
        //        second.getCardsToReveal().size());
    }
}