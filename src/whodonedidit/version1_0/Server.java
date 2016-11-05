package whodonedidit.version1_0;

import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;

/**
 * Extension of AbstractServer to communicate with all clients joining
 * the game. Server will use the Message Listener to handle any
 * messages delivered from the client.
 *
 * The Message Listener will change when the server moves from the
 * game lobby to the game table.
 *
 * @author austinrobarts - skeleton, javadocs
 * @author Hayden - pseudocode
 */
public class Server extends AbstractServer
{
    /** Default port for communication with the Server (one of our assigned ports)**/
    public static final int kDefaultPort = 50650;

    /**
     * The listener is where the received messages from the client
     * will be sent.
     */
    private MessageListener listener;

    /**
     * Constructs a server with a specified port for the game to be hosted on
     *
     * @param port     port number
     */
    public Server(int port)
    {
        //CALL the constructor of AbstractServer to construct a server with the port
        super(port);
        //SET listener to null, this will be set by a setListener call
        listener = null;
    }

    /**
     * Sets the listener that will be dealing with messages from the
     * clients
     *
     * @param listener an object that has implemented the
     *                 MessageListener interface
     */
    public void setListener(MessageListener listener)
    {
        //SET listener to the given MessageListener
        this.listener = listener;
    }

    /**
     * Any messages received from clients will then be sent to the
     * message listener
     *
     * @param msg        the message object delivered from the client
     * @param connection the connection between the client and server
     */
    @Override
    protected void handleMessageFromClient(Object msg, ConnectionToClient connection)
    {
        System.out.println("Message received from client");
        //CALL the current MessageListener's receiveMessage method passing it msg
        listener.receiveMessage(msg);
    }

    /**
     * Notifies the server application that a client has connected
     *
     * @param client client that has connected
     */
    @Override
    protected void clientConnected(ConnectionToClient client)
    {
        //CALL the listener's receiveMessage method passing it client
        listener.receiveMessage(client);
    }

    /**
     * Notifies the server application that a client has disconnected
     *
     * @param client client that has disconnected
     */
    @Override
    protected synchronized void clientDisconnected(ConnectionToClient client)
    {
        //CALL the listener's receiveMessage method passing it client
        listener.receiveMessage(client);
    }


}
