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
public class DoTurnTest
{
    
    public DoTurnTest()
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
     * Test of doInstruction method, of class DoTurn.
     */
    @Test
    public void testDoInstruction()
    {
        System.out.println("doDoTurn");
        Player player = new Player(0, "player");
        DoTurn instruction = new DoTurn();
        instruction.doInstruction(player);
        PlayerState state = player.getState();
        assertEquals(state == PlayerState.DoingTurn, true);
    }
}