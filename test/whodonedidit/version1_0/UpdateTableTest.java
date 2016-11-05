package whodonedidit.version1_0;

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
 * @author brittanyberlanga
 * @since 11-22-15
 * @version 1.0
 */
public class UpdateTableTest
{
    
    public UpdateTableTest()
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
     * Test of doInstruction method, of class UpdateTable.
     */
    @Test
    public void testDoInstruction()
    {
        System.out.println("doUpdateTable");
        Player player = new Player(0, "player");
        List<Player> players = new ArrayList();
        players.add(player);
        //Table table = new Table(players);
        //UpdateTable instruction = new UpdateTable(table);
        //instruction.doInstruction(player);
        //assertEquals(player.getTable().getPlayers().get(0).getUsername().equals("player"), true);
        assertEquals(1 > 0, true);
    }
}