package whodonedidit.version1_0;

/**
 *
 * @author Tyler Wong
 */

public class WhoDoneDidIt
{
    public static void main(String[] args)
    {
        if (args.length != 0 && args[0].toLowerCase().equals("-server"))
        {
            ServerApp.main(args);
        }
        else
        {
            GUIApp.main(args);
        }
    }
}
