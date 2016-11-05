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
 * @since 11-22-15
 * @version 1.0
 */
public class YouLoseTest
{
    
    public YouLoseTest()
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
     * Test of doInstruction method, of class YouLose.
     */
    @Test
    public void testDoInstruction()
    {
        System.out.println("doYouLose");
        Player player = new Player(0, "player");
        YouLose instruction = new YouLose();
        instruction.doInstruction(player);
        assertEquals(player.getState() == PlayerState.YouLose, true);
    }
}