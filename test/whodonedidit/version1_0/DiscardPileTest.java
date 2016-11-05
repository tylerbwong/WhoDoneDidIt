/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package whodonedidit.version1_0;

import junit.framework.Assert;
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
public class DiscardPileTest {
    
    public DiscardPileTest() {
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
     * Test of getTopCard method, of class DiscardPile.
     */
    @Test
    public void testGetTopCard() 
    {
        System.out.println("discard");
	DiscardPile pile = new DiscardPile();
	assertNull(pile.getTopCard());
		
	ActionCard tempSnoop = new ActionCard(ActionCardType.Snoop, null);
	pile.discard(tempSnoop);
	assertEquals(pile.getTopCard(), tempSnoop);
    }
    
    /**
     * Test of discard method, of class DiscardPile. Decided against testing 
     * this because all the method does is call the ArrayList's add method. 
     * The functionality of this method is being checked by the second half of 
     * testGetTopCard.
     *
    @Test
    public void testDiscard() {
        
    }
    */

    /**
     * Test of reshuffleIntoDeck method, of class DiscardPile.
     */
    @Test
    public void testReshuffleIntoDeck() 
    {
        System.out.println("reshuffleIntoDeck");
        Deck deck = new Deck();
        DiscardPile pile = new DiscardPile();
        //Checking the case of reshuffling an empty discard pile into the deck
        assertNull(pile.getTopCard());
        pile.reshuffleIntoDeck(deck);
        assertNull(pile.getTopCard());
        //Checking the case of reshuffling a discard pile with only 1 card
        pile.discard(new ActionCard(ActionCardType.Snoop, null));
        assertNotNull(pile.getTopCard());
        pile.reshuffleIntoDeck(deck);
        assertNull(pile.getTopCard());
        //Checking the case of reshuffling a discard pile with more than 1 card
        pile.discard(new ActionCard(ActionCardType.Snoop, null));
        pile.discard(new ActionCard(ActionCardType.PrivateTipOne, null));
        assertNotNull(pile.getTopCard());
        pile.reshuffleIntoDeck(deck);
        assertNull(pile.getTopCard());
    }

    public class FakeDeck extends Deck
    {
	public FakeDeck()
	{
			
	}
		
	@Override
	public void addActionCard(ActionCard card)
	{
	    //DO nothing
	}
    }
	
}