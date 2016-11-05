/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package whodonedidit.version1_0;

import java.util.List;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hayden
 */
public class DeckTest {
    
    public DeckTest() {
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
     * Test of findClueCard method, of class Deck.
     */
    @Test
    public void testFindClueCard() 
    {
        System.out.println("findClueCard");
        Deck instance = new Deck();
        ArrayList<String> cardDescription = new ArrayList<>();
        cardDescription.add("Suspect");
        cardDescription.add("Female");
        ClueCard expSuspect = new ClueCard("Peacock", cardDescription);
        instance.addClueCard(expSuspect);
      
        ArrayList<String> targetDescription = new ArrayList<>();
        targetDescription.add("Suspect");
        ClueCard result = instance.findClueCard(targetDescription);
        assertEquals(expSuspect, result);
        assertTrue(instance.clueIsEmpty());
        
        cardDescription = new ArrayList<>();
        cardDescription.add("Destination");
        cardDescription.add("South");
        cardDescription.add("East");
        ClueCard expDestination = new ClueCard("Miami", cardDescription);
        instance.addClueCard(expDestination);
        instance.addClueCard(expSuspect);
        
        result = instance.findClueCard(targetDescription);
        assertEquals(expSuspect, result);
        targetDescription.set(0, "Destination");
        result = instance.findClueCard(targetDescription);
        assertEquals(expDestination, result);
    }

    /**
     * Test of drawActionCard method, of class Deck.
     */
    @Test
    public void testDrawActionCard() 
    {
        System.out.println("drawClueCard");
        Deck instance = new Deck();
        ArrayList<String> description = new ArrayList<>();
        description.add("Destination");
        description.add("North");
        ActionCard expResult = new ActionCard(ActionCardType.PrivateTipOne, description);
        
        instance.addActionCard(expResult);
        ActionCard result = instance.drawActionCard();
        assertEquals(expResult, result);
        
        result = instance.drawActionCard();
        assertTrue(instance.actionIsEmpty());
        assertNull(result);
        
        instance.addActionCard(expResult);
        instance.addActionCard(new ActionCard(ActionCardType.Snoop, null));
        result = instance.drawActionCard();
        assertEquals(expResult, result);
        result = instance.drawActionCard();
        assertNotSame(expResult, result);
        assertTrue(instance.actionIsEmpty());
    }

    /**
     * Test of drawClueCard method, of class Deck.
     */
    @Test
    public void testDrawClueCard()
    {
        System.out.println("drawClueCard");
        Deck instance = new Deck();
        ArrayList<String> description = new ArrayList<>();
        description.add("Suspect");
        description.add("Female");
        ClueCard expResult = new ClueCard("White", description);
        
        instance.addClueCard(expResult);
        ClueCard result = instance.drawClueCard();
        assertEquals(expResult, result);
        
        result = instance.drawClueCard();
        assertTrue(instance.clueIsEmpty());
        assertNull(result);
        
        instance.addClueCard(expResult);
        instance.addClueCard(new ClueCard("Scarlet", null));
        result = instance.drawClueCard();
        assertEquals(expResult, result);
        result = instance.drawClueCard();
        assertNotSame(expResult, result);
        assertTrue(instance.clueIsEmpty());
    }

    /**
     * Test of addActionCard method, of class Deck.
     */
    @Test
    public void testAddActionCard() 
    {
        System.out.println("addActionCard");
        ActionCard card = new ActionCard(ActionCardType.Snoop, null);
        Deck instance = new Deck();
        
        assertTrue(instance.actionIsEmpty());
        instance.addActionCard(card);
        assertFalse(instance.actionIsEmpty());
    }

    /**
     * Test of addClueCard method, of class Deck.
     */
    @Test
    public void testAddClueCard() 
    {
        System.out.println("addClueCard");
        ClueCard card = new ClueCard("Scarlet", null);
        Deck instance = new Deck();
        
        assertTrue(instance.clueIsEmpty());
        instance.addClueCard(card);
        assertFalse(instance.clueIsEmpty());
    }

    /**
     * Test of populateDeck method, of class Deck by checking that deck built
     * 6 Suspects, 6 Vehicles, and 9 Destinations
     */
    @Test
    public void testPopulateDeck() throws Exception 
    {
        System.out.println("populateDeck");
        Deck instance = new Deck();
        instance.populateDeck();
        ArrayList<String> targetDescription = new ArrayList<>();
        ClueCard card;
        ActionCard actCard;
        
        targetDescription.add("Suspect");
        
        for (int count = 0; count < 6; count++)
        {
            card = instance.findClueCard(targetDescription);
            assertNotNull(card);
        }
        
        card = instance.findClueCard(targetDescription);
        assertNull(card);
        targetDescription.set(0, "Vehicle");
        
        for (int count = 0; count < 6; count++)
        {
            card = instance.findClueCard(targetDescription);
            assertNotNull(card);
        }
        
        card = instance.findClueCard(targetDescription);
        assertNull(card);
        targetDescription.set(0, "Destination");
        
        for (int count = 0; count < 9; count++)
        {
            card = instance.findClueCard(targetDescription);
            assertNotNull(card);
        }
        
        card = instance.findClueCard(targetDescription);
        assertNull(card);
        assertTrue(instance.clueIsEmpty());
        
        for (int count = 0; count < 33; count++)
        {
            actCard = instance.drawActionCard();
            assertNotNull(actCard);
        }
        actCard = instance.drawActionCard();
        assertNull(actCard);
        assertTrue(instance.actionIsEmpty());
    }

    /**
     * Test of clueIsEmpty method, of class Deck.
     */
    @Test
    public void testClueIsEmpty()
    {
        System.out.println("clueIsEmpty");
        Deck instance = new Deck();
        boolean result = instance.clueIsEmpty();
        assertTrue(result);
    }

    /**
     * Test of actionIsEmpty method, of class Deck.
     */
    @Test
    public void testActionIsEmpty() 
    {
        System.out.println("actionIsEmpty");
        Deck instance = new Deck();        
        boolean result = instance.actionIsEmpty();
        assertTrue(result);
    }
    
    /**
     * Test of shuffle method checking if it works on an empty deck.
     */
    @Test
    public void testShuffle()
    {
        System.out.println("shuffle");
        Deck instance = new Deck();
        
        try
        {
            instance.shuffle();
            //If an exception was not thrown, the test passed.
            assertTrue(true);
        }
        catch (Exception e)
        {
            //If an exception was thrown by shuffle, the test failed. 
            assertTrue(false);
        }
    }
    
}