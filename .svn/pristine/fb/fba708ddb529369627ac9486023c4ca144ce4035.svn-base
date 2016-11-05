package whodonedidit.version1_0;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * TimerRunnable
 * This class represents a timer that can run on a separate thread and informs
 * a listener when a specified time is reached. The timer only has a resolution
 * of 100ms, so don't expect to use it for any precise timing.
 * Operations:
 * A TimerRunnable can have its time limit set.
 * A TimerRunnable can be reset.
 * A TimerRunnable can be started.
 * A TimerRunnable can be stopped.
 * @author Markus
 * @version 0.0
 * @since 28-Oct-2015
 */
public class TimerRunnable implements Runnable
{
    /** Time in ms between checks to see if the timeLimit has been reached */
    private static final int kTimerResolution = 100;

    /** The time in milliseconds since the timer began counting **/
    private double time;

    /** 
     *  The time in milliseconds at which the listener will be notified of a 
     *  timeout 
     */
    private double timeLimit;

    /** The listener to notify when the time limit is reached **/
    private TimeoutListener listener;

    /**
     * True if the timer is paused.
     * False if the timer is currently running.
     */
    private boolean paused;

    /**
     * TimerRunnable
     * @param listener the listener to be notified when the time limit is
     *                 reached
     * @param timerLimit the time in seconds at which the listener will be
     *                   notified of a timeout
     */
    public TimerRunnable(TimeoutListener listener, int timerLimit)
    {
        // SET this TimerRunnable's "listener" to the argued "listener"
        this.listener = listener;
        // SET this TimerRunnable's "timeLimit" to the argued "timerLimit" times 
        //     1000 to convert to milliseconds
        this.timeLimit = timerLimit * 1000;
        // SET "time" to 0
        this.time = 0;
        // SET "paused" to true
        this.paused = true;
    }

    /**
     * run
     * Runs the timer. This method should not be called by the architecture,
     * but will be called during the creation of its own thread.
     */
    @Override
    public void run()
    {
        boolean running = true; // True until thread is interrupted

        // WHILE thread hasn't been interrupted
        while(running)
        {
            try
            {
                // Wait for "kTimerResolution" milliseconds
                Thread.sleep(kTimerResolution);

                // IF not paused
                if (!paused)
                {
                    // ADD "kTimerResolution" to "time"
                    time += kTimerResolution;
                }
                // END IF

                // IF "time" is greater than or equal to "timeLimit"
                if (time >= timeLimit)
                {
                    // CALL this timer's reset method
                    reset();
                    // CALL listener's respondToTimeout method
                    listener.respondToTimeout();
                }
                // END IF
            }
            catch (InterruptedException exc)
            {
                running = false;
            }
        }
        // END WHILE
    }

    /**
     * reset
     * Resets the timer, setting its time back to zero.
     */
    public void reset()
    {
        // SET "paused" to true 
        paused = true;
        // SET "time" to 0
        time = 0;
    }

    /**
     * start
     * Starts the timer.
     */
    public void start()
    {
        // SET "paused" to false 
        paused = false;
    }

    /**
     * stop
     * Pauses the timer.
     */
    public void stop()
    {
        // SET "paused" to true
        paused = true;
    }
}
