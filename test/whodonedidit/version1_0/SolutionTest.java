/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package whodonedidit.version1_0;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 *
 * @author austinrobarts
 */
public class SolutionTest
{

    public SolutionTest()
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
     * Test of checkSolution method, of class Solution.
     */
    @Test
    public void testCheckSolution()
    {
        System.out.println("checkSolution");
        Solution solution = new Solution(new ClueCard("person", null),
                                         new ClueCard("vehicle", null),
                                         new ClueCard("dest", null));
        boolean result = solution.checkSolution("person", "vehicle", "dest");
        assertEquals(true, result);
        result = solution.checkSolution("notperson", "vehicle", "dest");
        assertEquals(false, result);
        result = solution.checkSolution("person", "notvehicle", "dest");
        assertEquals(false, result);
        result = solution.checkSolution("person", "vehicle", "notdest");
        assertEquals(false, result);
        result = solution.checkSolution("dest", "vehicle", "person");
        assertEquals(false, result);

    }
}