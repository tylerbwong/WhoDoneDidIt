package whodonedidit.version1_0;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author brittanyberlanga
 * @since 11-20-15
 * @version 1.0
 */
public class EndGameTest
{
    
    public EndGameTest()
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
     * Test of doInstruction method, of class EndGame.
     */
    @Test
    public void testDoInstruction()
    {
        System.out.println("doEndGame");
        Player player1 = new Player(1, "player1");
        Player player2 = new Player(2, "player2");
        Player player3 = new Player(3, "player3");
        EndGame instruction = new EndGame(3);
        instruction.doInstruction(player1);
        instruction.doInstruction(player2);
        instruction.doInstruction(player3);
        PlayerState state = player1.getState();
        assertEquals(state == PlayerState.Defeat, true);
        state = player2.getState();
        assertEquals(state == PlayerState.Defeat, true);
        state = player3.getState();
        assertEquals(state == PlayerState.Victory, true);     
    }
}