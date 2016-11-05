package whodonedidit.version1_0;

/**
 * ServerApp class is used to start the server application. It creates
 * the server and starts waiting for clients
 *
 * @author Markus
 * @author austinrobarts
 * @version 0.0
 * @since 25-Oct-2015
 */
public class ServerApp
{
    /**
     * Entry point into application to begin the server application
     *
     * @param args command line arguments
     */
    public static void main(String[] args)
    {
        //Create server based on default port
        Server gameServer = new Server(Server.kDefaultPort);
        //CREATE ServerLobby with server
        ServerLobby lobby = new ServerLobby(gameServer);
        //set server's listener to lobbymessenger
        gameServer.setListener(lobby);
        //call lobby's startUpLobby method
        lobby.startUpLobby();
    }
}
