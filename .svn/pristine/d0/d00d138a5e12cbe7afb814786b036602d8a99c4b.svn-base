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
 * @author brittanyberlanga
 * @since 11-20-15
 * @version 1.0
 */

public class RespondWithClueCardsTest
{
    public class MockPlayer extends Player
    {
        private Action action;
        
        public MockPlayer(int id, String name)
        {
            super(id, name);
            
        }
        
        @Override
        public Hand getHand()
        {
            return new MockHand();
        }
        
        @Override
        public void sendActionToGameManager(Action action)
        {
            this.action = action;
        }
        
        public Action getAction()
        {
            return this.action;
        }
    }
    public class MockHand extends Hand
    {
        public MockHand()
        {
            super();          
        }
        @Override
        public List<ClueCard> findClueCard(List<String> description)
        {
            List<ClueCard> clueCards = new ArrayList();
            clueCards.add(new ClueCard("miss scarlet", description));
            clueCards.add(new ClueCard("air baloon", description));
            clueCards.add(new ClueCard("paradise falls", description));
            return clueCards;
        }
        @Override
        public ClueCard getRandomClueCard()
        {
            List<String> description = new ArrayList<>();
            description.add("place");
            return new ClueCard("paradise falls", description);
        }
    }
    
    public RespondWithClueCardsTest()
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
     * Test of doInstruction method, of class RespondWithClueCards.
     */
    
    @Test
    public void testAllSnoopLeft()
    {
        System.out.println("doRespondWithClueCards for AllSnoopLeft");
        MockPlayer player = new MockPlayer(0, "player");
        List<String> description = new ArrayList<>();
        RespondWithClueCards instance = new RespondWithClueCards(1, ActionCardType.AllSnoopLeft, description, false);
        instance.doInstruction(player);
        PlayerState state = player.getState();
        assertEquals(state == PlayerState.BeingSnoopedUpon, true);
        assertEquals (state.getCardsToReveal().get(0).getName().equals("paradise falls"), true);
        assertEquals(player.getAction() instanceof SendClueCards, true);
    }
    
    @Test
    public void testAllSnoopRight()
    {
        System.out.println("doRespondWithClueCards for AllSnoopRight");
        MockPlayer player = new MockPlayer(0, "player");
        List<String> description = new ArrayList<>();
        RespondWithClueCards instance = new RespondWithClueCards(1, ActionCardType.AllSnoopRight, description, false);
        instance.doInstruction(player);
        PlayerState state = player.getState();
        assertEquals(state == PlayerState.BeingSnoopedUpon, true);
        assertEquals (state.getCardsToReveal().get(0).getName().equals("paradise falls"), true);
        assertEquals(player.getAction() instanceof SendClueCards, true);
    }
    
    @Test
    public void testSnoop()
    {
        System.out.println("doRespondWithClueCards for Snoop");
        MockPlayer player = new MockPlayer(0, "player");
        List<String> description = new ArrayList<>();
        RespondWithClueCards instance = new RespondWithClueCards(1, ActionCardType.Snoop, description, false);
        instance.doInstruction(player);
        PlayerState state = player.getState();
        assertEquals(state == PlayerState.BeingSnoopedUpon, true);
        assertEquals (state.getCardsToReveal().get(0).getName().equals("paradise falls"), true);
        assertEquals(player.getAction() instanceof SendClueCards, true);
    }
    
    @Test
    public void testPrivateTipAll()
    {
        System.out.println("doRespondWithClueCards for PrivateTipAll");
        MockPlayer player = new MockPlayer(0, "player");
        List<String> description = new ArrayList<>();
        description.add("female");
        RespondWithClueCards instance = new RespondWithClueCards(1, ActionCardType.PrivateTipAll, description, true);
        instance.doInstruction(player);
        PlayerState state = player.getState();
        assertEquals(state == PlayerState.RespondingToPrivateTipAll, true);
        List<ClueCard> cardsToReveal = state.getCardsToReveal();
        List<String> cardNames = new ArrayList();
        for (int i = 0; i < cardsToReveal.size(); i++) 
        {
            cardNames.add(cardsToReveal.get(i).getName());
        }
        assertEquals(cardNames.contains("miss scarlet"), true);
        assertEquals(cardNames.contains("air baloon"), true);
        assertEquals(cardNames.contains("paradise falls"), true);
    }
    
    @Test
    public void testPrivateTipOne()
    {
        System.out.println("doRespondWithClueCards for PrivateTipOne");
        System.out.println("doRespondWithClueCards for PrivateTipAll");
        MockPlayer player = new MockPlayer(0, "player");
        List<String> description = new ArrayList<>();
        description.add("female");
        RespondWithClueCards instance = new RespondWithClueCards(1, ActionCardType.PrivateTipOne, description, false);
        instance.doInstruction(player);
        PlayerState state = player.getState();
        assertEquals(state == PlayerState.RespondingToPrivateTipOne, true);
        List<ClueCard> cardsToReveal = state.getCardsToReveal();
        List<String> cardNames = new ArrayList();
        for (int i = 0; i < cardsToReveal.size(); i++) 
        {
            cardNames.add(cardsToReveal.get(i).getName());
        }
        assertEquals(cardNames.contains("miss scarlet"), true);
        assertEquals(cardNames.contains("air baloon"), true);
        assertEquals(cardNames.contains("paradise falls"), true);
    }
}