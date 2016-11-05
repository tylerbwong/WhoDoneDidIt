/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package whodonedidit.version1_0;

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
public class PlayerMessengerTest {
    
    public PlayerMessengerTest() {
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

    public class TestPlayerMessenger extends PlayerMessenger
    {
        public GameMessenger gameMessenger;
        public Player player;
    }
    
    /**
     * Test of sendMessage method, of class PlayerMessenger.
     */
    @Test
    public void testSendMessage() {
        System.out.println("sendMessage");
        Action action = null;
        PlayerMessenger instance = new PlayerMessenger();
        instance.sendMessage(action);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of receiveMessage method, of class PlayerMessenger.
     */
    @Test
    public void testReceiveMessage() {
        System.out.println("receiveMessage");
        Object instruction = null;
        PlayerMessenger instance = new PlayerMessenger();
        instance.receiveMessage(instruction);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of connectGameMessenger method, of class PlayerMessenger.
     */
    @Test
    public void testConnectGameMessenger() {
        System.out.println("connectGameMessenger");
        GameMessenger messenger = null;
        TestPlayerMessenger instance = new TestPlayerMessenger();
        
        assertNull(instance.gameMessenger);
        instance.connectGameMessenger(messenger);
        assertNotNull(instance.gameMessenger);
    }

    /**
     * Test of setPlayer method, of class PlayerMessenger.
     */
    @Test
    public void testSetPlayer() {
        System.out.println("setPlayer");
        Player player = new Player(0, "username");
        TestPlayerMessenger instance = new TestPlayerMessenger();
        
        assertNull(instance.player);
        instance.setPlayer(player);
        assertNotNull(instance.player);
    }
}