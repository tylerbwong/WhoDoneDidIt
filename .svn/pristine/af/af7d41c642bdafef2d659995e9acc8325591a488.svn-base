package whodonedidit.version1_0;

import whodonedidit.gui.MainFrame;

/**
 * GUIApp contains the runnable main to initialize the GUI client application.
 * 
 * @author Brittany Berlanga
 * @version 1.0
 * @since 17-Nov-2015
 */
public class GUIApp
{
    /**
     * Initializes the GUI client application.
     * This main method is called on to start the GUI client application. It 
     * creates the JFrame used for the application and the ViewController that 
     * controls and manipulates the components within the JFrame.
     * 
     * @param args main does not require any command line arguments
     */
    public static void main(String args[]) 
    {
        //INIT MainFrame
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : 
                javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(
                java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(
                java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(
                java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(
                java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the frame */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                MainFrame newFrame = new MainFrame();
            }
        });
    }
}
