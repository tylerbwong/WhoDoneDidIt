/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package whodonedidit.version1_0;

import java.lang.reflect.Field;
import whodonedidit.version1_0.PlayerState;
import whodonedidit.version1_0.PlayerStateMachine;
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
public class PlayerStateMachineTest
{
    public PlayerStateMachineTest()
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
     * Test of getCurrentState method, of class PlayerStateMachine.
     */
    @Test
    public void testGetCurrentState()
    {
        System.out.println("getCurrentState");
        PlayerStateMachine instance = new PlayerStateMachine();
        PlayerState expResult = PlayerState.Idle;

        try
        {
            Field currentStateField = PlayerStateMachine.class.getDeclaredField(
                    "currentState");
            currentStateField.setAccessible(true);
            currentStateField.set(instance, expResult);
        }
        catch (Exception exc)
        {
            fail("Exception thrown during test of getCurrentState");
        }

        PlayerState result = instance.getCurrentState();
        assertEquals(expResult, result);
    }

    /**
     * Test of setState method, of class PlayerStateMachine.
     */
    @Test
    public void testSetState()
    {
        System.out.println("setState");
        PlayerState firstState = PlayerState.Idle;
        PlayerState secondState = PlayerState.DoingTurn;
        PlayerStateMachine instance = new PlayerStateMachine();
        instance.setState(firstState);
        instance.setState(secondState);

        try
        {
            Field currentStateField = PlayerStateMachine.class.getDeclaredField(
                    "currentState");
            currentStateField.setAccessible(true);
            assertEquals(secondState, currentStateField.get(instance));

            Field previousStateField = PlayerStateMachine.class.getDeclaredField(
                    "previousState");
            previousStateField.setAccessible(true);
            assertEquals(firstState, previousStateField.get(instance));
        }
        catch (Exception exc)
        {
            fail("Exception thrown during test of getCurrentState");
        }

    }

    /**
     * Test of revertToPreviousState method, of class PlayerStateMachine.
     */
    @Test
    public void testRevertToPreviousState()
    {
        System.out.println("revertToPreviousState");
        PlayerState firstState = PlayerState.Idle;
        PlayerState secondState = PlayerState.DoingTurn;
        PlayerStateMachine instance = new PlayerStateMachine();

        try
        {
            Field currentStateField = PlayerStateMachine.class.getDeclaredField(
                    "currentState");
            currentStateField.setAccessible(true);
            currentStateField.set(instance, firstState);

            Field previousStateField = PlayerStateMachine.class.getDeclaredField(
                    "previousState");
            previousStateField.setAccessible(true);
            previousStateField.set(instance, secondState);

            instance.revertToPreviousState();
            assertEquals(secondState, currentStateField.get(instance));
            assertEquals(firstState, previousStateField.get(instance));
        }
        catch (Exception exc)
        {
            fail("Exception thrown during test of getCurrentState");
        }
    }
}