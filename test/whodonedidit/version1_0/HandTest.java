/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package whodonedidit.version1_0;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hayden
 */
public class HandTest {
    
    public HandTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test of addClueCard method, of class Hand.
     */
    @Test
    public void testAddClueCard() 
    {
        System.out.println("addClueCard");
        ClueCard card = new ClueCard("Bob", null);
        Hand instance = new Hand();
        
        assertTrue(instance.getClueCards().isEmpty());
        instance.addClueCard(card);
        assertFalse(instance.getClueCards().isEmpty());
    }

    /**
     * Test of addActionCard method, of class Hand.
     */
    @Test
    public void testAddActionCard()
    {
        System.out.println("addActionCard");
        ActionCard card = new ActionCard(ActionCardType.Snoop, null);
        Hand instance = new Hand();
        
        assertTrue(instance.getActionCards().isEmpty());
        instance.addActionCard(card);
        assertFalse(instance.getActionCards().isEmpty());
    }
    
    /**
     * Test of containsClueCard method, of class Hand.
     */
    @Test
    public void testContainsClueCard() 
    {
        System.out.println("containsClueCard");
        String cardName = "Bill";
        ClueCard card = new ClueCard(cardName, null);
        Hand instance = new Hand();
        
        assertFalse(instance.containsClueCard(cardName));
        instance.addClueCard(card);
        assertTrue(instance.containsClueCard(cardName));
    }

    /**
     * Test of findClueCard method, of class Hand.
     */
    @Test
    public void testFindClueCard() 
    {
        System.out.println("findClueCard");
        ArrayList<String> cardDescription = new ArrayList<>();
        cardDescription.add("Destination");
        cardDescription.add("North");
        cardDescription.add("West");
        ClueCard card = new ClueCard("Rushmore", cardDescription);
        
        ArrayList<String> targetDescription = new ArrayList<>();
        targetDescription.add("Destination");
        targetDescription.add("West");
        
        Hand instance = new Hand();
        assertTrue(instance.findClueCard(targetDescription).isEmpty());
        instance.addClueCard(card);
        assertFalse(instance.findClueCard(targetDescription).isEmpty());
        assertEquals(card, instance.findClueCard(targetDescription).get(0));
    }


    /**
     * Test of removeClueCard method, of class Hand.
     */
    @Test
    public void testRemoveClueCard() 
    {
        System.out.println("removeClueCard");
        String name = "John";
        ClueCard expResult = new ClueCard(name, null);
        Hand instance = new Hand();
       
        
        ClueCard result = instance.removeClueCard(name);
        assertNull(result);
        instance.addClueCard(expResult);
        result = instance.removeClueCard(name);
        assertEquals(expResult, result);
    }


    /**
     * Test of removeActionCard method, of class Hand.
     */
    @Test
    public void testRemoveActionCard() 
    {
        System.out.println("removeActionCard");
        ActionCardType type = ActionCardType.PrivateTipAll;
        ArrayList<String> description = new ArrayList<>();
        description.add("Vehicle");
        ActionCard expResult = new ActionCard(type, description);
        Hand instance = new Hand();
        
        instance.addActionCard(new ActionCard(ActionCardType.Snoop, null));
        ActionCard result = instance.removeActionCard(type, description);
        assertNull(result);
        instance.addActionCard(expResult);
        result = instance.removeActionCard(type, description);
        assertEquals(expResult, result);
    }

    /**
     * Test of swapDestinationMarker method, of class Hand.
     */
    @Test
    public void testSwapDestinationMarker() 
    {
        System.out.println("swapDestinationMarker");
        DestinationMarker oldMarker = new DestinationMarker("School");
        DestinationMarker newMarker = new DestinationMarker("Hawaii");
        Hand instance = new Hand();
        
        DestinationMarker result = instance.swapDestinationMarker(oldMarker);
        assertNull(result);
        
        result = instance.swapDestinationMarker(newMarker);
        assertEquals(oldMarker, result);
        assertEquals(newMarker, instance.getDestinationMarker());
    }
    

}