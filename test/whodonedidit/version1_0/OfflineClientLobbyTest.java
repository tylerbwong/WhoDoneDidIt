/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package whodonedidit.version1_0;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author austinrobarts
 */
public class OfflineClientLobbyTest
{

    public OfflineClientLobbyTest()
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
     * Test of getLobbyPlayers method, of class OfflineClientLobby.
     */
    @Test
    public void testGetLobbyPlayers()
    {
        System.out.println("getLobbyPlayers");
        OfflineClientLobby instance = new OfflineClientLobby("bob");
        List expResult = null;
        List<LobbyPlayer> result = instance.getLobbyPlayers();
        assertEquals(0, result.size());
        instance.addPlayer(LobbyPlayer.Descriptor.Human);
        result = instance.getLobbyPlayers();
        assertEquals(1, result.size());
        assertEquals("bob", result.get(0).userName);

    }

    /**
     * Test of addPlayer method, of class OfflineClientLobby.
     */
    @Test
    public void testAddPlayer()
    {
        System.out.println("addPlayer");
        OfflineClientLobby instance = new OfflineClientLobby("bob");
        List expResult = null;
        List<LobbyPlayer> result = instance.getLobbyPlayers();
        assertEquals(0, result.size());
        instance.addPlayer(LobbyPlayer.Descriptor.Human);
        result = instance.getLobbyPlayers();
        assertEquals(1, result.size());
        assertEquals("bob", result.get(0).userName);
        assertEquals(LobbyPlayer.Descriptor.Human, result.get(0).descriptor);
    }

    /**
     * Test of addComputerPlayer method, of class OfflineClientLobby.
     */
    @Test
    public void testAddComputerPlayer()
    {
        System.out.println("addComputerPlayer");
        OfflineClientLobby instance = new OfflineClientLobby("Joe");
        instance.addComputerPlayer(LobbyPlayer.Descriptor.ComputerBeginner, "c1");
        assertEquals(1, instance.getLobbyPlayers().size());
        assertEquals("c1", instance.getLobbyPlayers().get(0).userName);
        assertEquals(LobbyPlayer.Descriptor.ComputerBeginner, instance.getLobbyPlayers().get(0).descriptor);
        instance.addComputerPlayer(LobbyPlayer.Descriptor.ComputerAdvanced, "c2");
        assertEquals(2, instance.getLobbyPlayers().size());
        assertEquals("c2", instance.getLobbyPlayers().get(1).userName);
        assertEquals(LobbyPlayer.Descriptor.ComputerAdvanced, instance.getLobbyPlayers().get(1).descriptor);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of removePlayer method, of class OfflineClientLobby.
     */
    @Test
    public void testRemovePlayer_int()
    {
        System.out.println("removePlayer");
        OfflineClientLobby instance = new OfflineClientLobby("austin");
        instance.addPlayer(LobbyPlayer.Descriptor.Human);
        instance.addComputerPlayer(LobbyPlayer.Descriptor.ComputerAdvanced, "c1");
        instance.addComputerPlayer(LobbyPlayer.Descriptor.ComputerAdvanced, "c2");
        instance.addComputerPlayer(LobbyPlayer.Descriptor.ComputerAdvanced, "c3");
        instance.removePlayer(2);
        assertEquals("c3", instance.getLobbyPlayers().get(2).userName);
        assertEquals(3, instance.getLobbyPlayers().size());
        instance.removePlayer(0);
        assertEquals(2, instance.getLobbyPlayers().size());
        assertEquals("c1", instance.getLobbyPlayers().get(0).userName);
        assertEquals("c3", instance.getLobbyPlayers().get(1).userName);
    }

    /**
     * Test of removePlayer method, of class OfflineClientLobby.
     */
    @Test
    public void testRemovePlayer_String()
    {
        System.out.println("removePlayer");
        OfflineClientLobby instance = new OfflineClientLobby("austin");
        instance.addPlayer(LobbyPlayer.Descriptor.Human);
        instance.addComputerPlayer(LobbyPlayer.Descriptor.ComputerAdvanced, "c1");
        instance.addComputerPlayer(LobbyPlayer.Descriptor.ComputerAdvanced, "c2");
        instance.addComputerPlayer(LobbyPlayer.Descriptor.ComputerAdvanced, "c3");
        instance.removePlayer("c2");
        assertEquals("c3", instance.getLobbyPlayers().get(2).userName);
        assertEquals(3, instance.getLobbyPlayers().size());
        instance.removePlayer("austin");
        assertEquals(2, instance.getLobbyPlayers().size());
        assertEquals("c1", instance.getLobbyPlayers().get(0).userName);
        assertEquals("c3", instance.getLobbyPlayers().get(1).userName);
    }
}