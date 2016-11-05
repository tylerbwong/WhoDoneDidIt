/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package whodonedidit.version1_0;

import whodonedidit.version1_0.TimerRunnable;
import whodonedidit.version1_0.TimeoutListener;
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
public class TimerRunnableTest
{
    /** Used for testing purposes to check if a timeout was detected **/
    public boolean timeoutDetected;

    public TimerRunnableTest()
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
     * Test of run method, of class TimerRunnable.
     */
    @Test
    public void testRun() throws InterruptedException
    {
        System.out.println("run");

        timeoutDetected = false;

        // Construct anonymous class to detect timeout
        TimeoutListener listener = new TimeoutListener() 
        {

            @Override
            public void respondToTimeout()
            {
                timeoutDetected = true;
            }
        };

        int timeLimitSeconds = 1;
        int timeLimitMS = timeLimitSeconds * 1000;
        TimerRunnable timer = new TimerRunnable(listener, timeLimitSeconds);
        Thread timerThread = new Thread(timer);
        timerThread.start();

        // Start the timer and make sure it doesn't immediately report
        // a timeout (since timeout should occue until 1 second).
        timer.start();
        assertEquals(false, timeoutDetected);

        // Wait until just after a timeout should be reported, and make
        // sure it was reported.
        Thread.sleep(timeLimitMS + 150);
        assertEquals(true, timeoutDetected);
    }

    /**
     * Test of reset method, of class TimerRunnable.
     */
    @Test
    public void testReset() throws InterruptedException
    {
        System.out.println("reset");
        timeoutDetected = false;

        // Construct anonymous class to detect timeout
        TimeoutListener listener = new TimeoutListener() 
        {

            @Override
            public void respondToTimeout()
            {
                timeoutDetected = true;
            }
        };

        int timeLimitSeconds = 1;
        int timeLimitMS = timeLimitSeconds * 1000;
        TimerRunnable timer = new TimerRunnable(listener, timeLimitSeconds);
        Thread timerThread = new Thread(timer);
        timerThread.start();

        // Since the timer just started and timeout is at 1 second,
        // it shouldn't have timed out yet.
        assertEquals(false, timeoutDetected);

        // If we wait until just before the time limit, reset, then
        // wait until after time limit would have been passed, there
        // should be no timeout detection due to the reset.
        Thread.sleep(timeLimitMS - 150);
        timer.reset();
        Thread.sleep(300);
        assertEquals(false, timeoutDetected);

        // Since the timer was reset, it should be set at 0 and paused,
        // so if we wait the length required for a timeout, there should
        // be no timeout (due to the pausing).
        Thread.sleep(timeLimitMS + 150);
        assertEquals(false, timeoutDetected);

        // Make sure that timeout is detected when it should be after
        // we resume the timer.
        timer.start();
        Thread.sleep(timeLimitMS + 150);
        assertEquals(true, timeoutDetected);
    }

    /**
     * Test of stop method, of class TimerRunnable.
     */
    @Test
    public void testStop() throws InterruptedException
    {
        System.out.println("stop");
        timeoutDetected = false;

        // Construct anonymous class to detect timeout
        TimeoutListener listener = new TimeoutListener() 
        {
            @Override
            public void respondToTimeout()
            {
                timeoutDetected = true;
            }
        };

        int timeLimitSeconds = 1;
        int timeLimitMS = timeLimitSeconds * 1000;
        TimerRunnable timer = new TimerRunnable(listener, timeLimitSeconds);
        Thread timerThread = new Thread(timer);
        timerThread.start();

        System.out.println("stop_01");
        // Make sure that if we stop the timer after it's started,
        // it doesn't continue to report a timeout when it would have.
        timer.start();
        timer.stop();
        Thread.sleep(timeLimitMS + 150);
        assertEquals(false, timeoutDetected);

        System.out.println("stop_02");
        // Make sure the timer not only didn't set the timeout, but
        // actually paused itself as well by starting it and waiting 
        // until right before it would time out and make sure it didn't yet.
        timer.start();
        Thread.sleep(timeLimitMS - 300);
        assertEquals(false, timeoutDetected);

        System.out.println("stop_03");
        // Make sure the timer did actually start up again though by checking
        // if it reports timeout after going over the time limit.
        Thread.sleep(300);
        assertEquals(true, timeoutDetected);
    }
}