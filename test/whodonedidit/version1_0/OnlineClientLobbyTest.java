/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package whodonedidit.version1_0;

import java.io.IOException;
import java.util.LinkedList;
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
public class OnlineClientLobbyTest
{

    public OnlineClientLobbyTest()
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
     * Test of receiveMessage method, of class OnlineClientLobby.
     */
    @Test
    public void testReceiveMessage()
    {
        System.out.println("receiveMessage");
        List<LobbyPlayer> players = new LinkedList<>();
        players.add(new LobbyPlayer("bob", LobbyPlayer.Descriptor.Human));
        TestClient testClient = new TestClient("blah", 12345);
        OnlineClientLobby instance = new OnlineClientLobby("Bobby", testClient);
        instance.receiveMessage(players);

        assertEquals(1, instance.getLobbyPlayers().size());
    }

    /**
     * Test of getLobbyPlayers method, of class OnlineClientLobby.
     */
    @Test
    public void testGetLobbyPlayers()
    {
        System.out.println("getLobbyPlayers");
        TestClient testClient = new TestClient("blah", 12345);
        OnlineClientLobby instance = new OnlineClientLobby("Bobby", testClient);

        List<LobbyPlayer> players = new LinkedList<>();
        players.add(new LobbyPlayer("bob", LobbyPlayer.Descriptor.Human));

        instance.receiveMessage(players);
        instance.getLobbyPlayers();
        assertEquals(1, instance.getLobbyPlayers().size());
        players.add(new LobbyPlayer("job", LobbyPlayer.Descriptor.ComputerBeginner));
        instance.receiveMessage(players);
        assertEquals(2, instance.getLobbyPlayers().size());
    }

    /**
     * Test of startGame method, of class OnlineClientLobby.
     */
    @Test
    public void testStartGame()
    {
        System.out.println("startGame");
        TestClient testClient = new TestClient("blah", 12345);
        OnlineClientLobby instance = new OnlineClientLobby("Bobby", testClient);
        instance.startGame();

        assertTrue(testClient.sentStartToServer);
    }

    /**
     * Test of addPlayer method, of class OnlineClientLobby.
     */
    @Test
    public void testAddPlayer()
    {
        System.out.println("addPlayer");
        LobbyPlayer.Descriptor playerType = LobbyPlayer.Descriptor.Human;
        TestClient testClient = new TestClient("blah", 12345);
        OnlineClientLobby instance = new OnlineClientLobby("Bobby", testClient);
        instance.addPlayer(playerType);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(testClient.sentHumanPlayerToServer);
        assertEquals(((LobbyPlayer)testClient.sentItem).userName, "Bobby");
    }

    /**
     * Test of addComputerPlayer method, of class OnlineClientLobby.
     */
    @Test
    public void testAddComputerPlayer()
    {
        System.out.println("addComputerPlayer");
        LobbyPlayer.Descriptor difficulty = LobbyPlayer.Descriptor.ComputerBeginner;
        String name = "comp1";
        TestClient testClient = new TestClient("blah", 12345);
        OnlineClientLobby instance = new OnlineClientLobby("Bobby", testClient);
        instance.addComputerPlayer(difficulty, name);

        assertTrue(testClient.sentComputerPlayerToServer);
        assertEquals(((LobbyPlayer)testClient.sentItem).userName, "comp1");
        assertEquals(((LobbyPlayer)testClient.sentItem).descriptor, LobbyPlayer.Descriptor.ComputerBeginner);
    }

    /**
     * Test of removePlayer method, of class OnlineClientLobby.
     */
    @Test
    public void testRemovePlayer_int()
    {
        System.out.println("removePlayer");

        TestClient testClient = new TestClient("blah", 12345);
        OnlineClientLobby instance = new OnlineClientLobby("Bobby", testClient);
        instance.addPlayer(LobbyPlayer.Descriptor.Human);
        instance.getLobbyPlayers().add(new LobbyPlayer("Bobby", LobbyPlayer.Descriptor.Human));
        instance.removePlayer(0);

        assertTrue(testClient.sentHumanPlayerToServer);
        assertEquals(((LobbyPlayer)testClient.sentItem).userName, "Bobby");
        assertEquals(((LobbyPlayer)testClient.sentItem).descriptor, LobbyPlayer.Descriptor.Human);
    }

    /**
     * Test of removePlayer method, of class OnlineClientLobby.
     */
    @Test
    public void testRemovePlayer_String()
    {
        System.out.println("removePlayer");
        TestClient testClient = new TestClient("blah", 12345);
        OnlineClientLobby instance = new OnlineClientLobby("Bobby", testClient);
        instance.addPlayer(LobbyPlayer.Descriptor.Human);
        instance.getLobbyPlayers().add(new LobbyPlayer("Bobby", LobbyPlayer.Descriptor.Human));
        instance.removePlayer("Bobby");

        assertTrue(testClient.sentHumanPlayerToServer);
        assertEquals(((LobbyPlayer)testClient.sentItem).userName, "Bobby");
        assertEquals(((LobbyPlayer)testClient.sentItem).descriptor, LobbyPlayer.Descriptor.Human);
    }

    /**
     * Test of quit method, of class OnlineClientLobby.
     */
    @Test
    public void testQuit()
    {
        System.out.println("quit");
        TestClient testClient = new TestClient("blah", 12345);
        OnlineClientLobby instance = new OnlineClientLobby("Bobby", testClient);
        instance.addPlayer(LobbyPlayer.Descriptor.Human);
        instance.getLobbyPlayers().add(new LobbyPlayer("Bobby", LobbyPlayer.Descriptor.Human));
        instance.quit();

        assertTrue(testClient.sentHumanPlayerToServer);
        assertEquals(((LobbyPlayer)testClient.sentItem).userName, "Bobby");
        assertEquals(((LobbyPlayer)testClient.sentItem).descriptor, LobbyPlayer.Descriptor.Human);

    }

    private class TestClient extends Client
    {
        public boolean setListenerToClientLobby = false;
        public boolean sentStartToServer = false;
        public boolean sentComputerPlayerToServer = false;
        public boolean sentHumanPlayerToServer = false;
        public Object sentItem;

        public TestClient(String host, int port)
        {
            super(host, port);
        }

        @Override
        public void setListener(MessageListener listener)
        {
            if (listener instanceof OnlineClientLobby)
                setListenerToClientLobby = true;
        }

        @Override
        public void sendToServer(Object msg) throws IOException
        {
            sentItem = msg;

            if (msg instanceof String && "start".equals(msg))
                sentStartToServer = true;
            if (msg instanceof LobbyPlayer && ((LobbyPlayer)msg).descriptor == LobbyPlayer.Descriptor.Human)
                sentHumanPlayerToServer = true;
            if (msg instanceof LobbyPlayer && ((LobbyPlayer)msg).descriptor == LobbyPlayer.Descriptor.ComputerBeginner)
                sentComputerPlayerToServer = true;
        }


    }

}