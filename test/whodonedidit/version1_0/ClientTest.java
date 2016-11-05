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
 * @author Markus
 */
public class ClientTest
{
    public ClientTest()
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

    public Object messageReceived;

    /**
     * Test of handleMessageFromServer method, of class Client.
     */
    @Test
    public void testHandleMessageFromServer()
    {
        System.out.println("handleMessageFromServer");

        messageReceived = null;
        MessageListener listener = new MessageListener() 
        {
            @Override
            public void receiveMessage(Object msg)
            {
                messageReceived = msg; 
            }
        };

        String message = new String("Hello");
        Client instance = new Client("localhost", 12345);
        instance.setListener(listener);
        instance.handleMessageFromServer(message);
        assertEquals(message, messageReceived);
    }
}