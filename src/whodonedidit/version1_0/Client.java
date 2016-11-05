package whodonedidit.version1_0;

import ocsf.client.AbstractClient;

/**
 * The client class represents a client that will be connected to the
 * game server.
 * The main responsibility of client is to send over messages from the
 * server to a specified message listener that will figure out what to
 * do with it.
 * Operations:
 * A Client can set its listener.
 * A Client can handle a message from the server its connected to.
 * A Client can handle its connection being closed.
 * A Client can handle an exception caused by its connection to the server.
 *
 * @author austinrobarts
 * @author Markus
 */
public class Client extends AbstractClient
{
    /** Listener to receive any messages sent from the server */
    private MessageListener listener;

    /**
     * Constructs a Client that will be connected to the Server
     * on the argued host through the argued port.
     *
     * @param listener Deals with messages received from server
     * @param host     The host to connect to
     * @param port     The port to connect through 
     */
    public Client(String host, int port)
    {
        super(host, port);
        

        // SET this Client's "listener" to argued "listener"
    }

    /**
     * Sets the listener to a new MessageListener that will handle
     * messages from server.
     * 
     * @param listener listener that is notified when any message is
     *                 received from the server
     */
    public void setListener(MessageListener listener)
    {
        // SET this Client's "listener" to the argued "listener"
        this.listener = listener;
    }

    /**
     * Takes message received from server and passes it along to
     * listener to be acted upon.
     *
     * @param msg the message sent from the server
     */
    @Override
    protected void handleMessageFromServer(Object msg)
    {
        // IF "listener" is not null
        if (listener != null)
        {
            // CALL listener's receiveMessage method using "msg"
            listener.receiveMessage(msg);
        }
        // END IF
    }

    /**
     * Notify the client that it has been disconnected from the
     * server.
     */
    @Override
    protected void connectionClosed()
    {
        super.connectionClosed();
    }

    /**
     * Notify the client that the server has thrown an exception.
     *
     * @param exception exception thrown by Server
     */
    @Override
    protected void connectionException(Exception exception)
    {
        super.connectionException(exception);
    }
}
