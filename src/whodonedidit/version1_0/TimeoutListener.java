package whodonedidit.version1_0;

/**
 * TimeoutListener
 * This interface represents something that can respond to something it relies
 * on timing out.
 * @author Markus
 * @version 0.0
 * @since 28-Oct-2015
 */
public interface TimeoutListener 
{
    /**
     * respondToTimeout
     * Responds to something this class depends on timing out.
     */
    public abstract void respondToTimeout(); 
}
