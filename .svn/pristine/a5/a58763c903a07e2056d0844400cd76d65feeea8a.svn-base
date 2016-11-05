/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author cathibod
 */
public class GameMessengerTest {
    
    public GameMessengerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    public class TestGameMessenger extends GameMessenger
    {
        public GameManager manager;
        public List<PlayerMessenger> playerMessengers;
    }
    /**
     * Test of sendMessage method, of class GameMessenger.
     */
    @Test
    public void testSendMessage() {
        System.out.println("sendMessage");
        Instruction instruction = null;
        int player_id = 0;
        GameMessenger instance = new GameMessenger();
        instance.sendMessage(instruction, player_id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of receiveMessage method, of class GameMessenger.
     */
    @Test
    public void testReceiveMessage() {
        System.out.println("receiveMessage");
        Object msg = null;
        GameMessenger instance = new GameMessenger();
        instance.receiveMessage(msg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of connectPlayerMessenger method, of class GameMessenger.
     */
    @Test
    public void testConnectPlayerMessenger() {
        System.out.println("connectPlayerMessenger");
        PlayerMessenger messenger = new PlayerMessenger();
        TestGameMessenger instance = new TestGameMessenger();
        
        
        assertTrue(instance.playerMessengers.isEmpty());
        instance.connectPlayerMessenger(messenger);
        assertFalse(instance.playerMessengers.isEmpty());
    }

    /**
     * Test of setManager method, of class GameMessenger.
     */
    @Test
    public void testSetManager() {
        System.out.println("setManager");
        GameManager manager = 
                new GameManager(new Table(new ArrayList<Player>()), 30);
        TestGameMessenger instance = new TestGameMessenger();
        
        
        assertNull(instance.manager);
        instance.setManager(manager);
        assertNotNull(instance.manager);
    }
}