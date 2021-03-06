package whodonedidit.version1_0;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author brittanyberlanga
 * @since 11-20-15
 * @version 1.0
 */
public class DisproveSuggestionTest
{
    private MockPlayer player;

    public class MockPlayer extends Player
    {
        public MockPlayer(int id, String name)
        {
            super(id, name);
        }

        @Override
        public Hand getHand()
        {
            return new MockHand();
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
    }

    public class MockDisproveSuggestion extends DisproveSuggestion
    {
        public MockDisproveSuggestion(String person, String vehicle, String destination)
        {
            super(null, 0, person, vehicle, destination);
        }

    }

    public DisproveSuggestionTest()
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
     * Test of doInstruction method, of class DisproveSuggestion.
     */
    @Test
    public void testDoInstruction()
    {
        System.out.println("doDisproveSuggestion");
        String person = "miss scarlet";
        String vehicle = "air baloon";
        String destination = "paradise falls";
        player = new MockPlayer(0, "player"); //set hand for actual tests
        DisproveSuggestion instruction = new DisproveSuggestion(null, 0, person, vehicle, destination);
        instruction.doInstruction(player);
        PlayerState state = player.getState();
        assertEquals(state == PlayerState.DisprovingSuggestion, true);
        List<ClueCard> cardsToReveal = state.getCardsToReveal();
        List<String> cardNames = new ArrayList();
        for (int i = 0; i < cardsToReveal.size(); i++)
        {
            cardNames.add(cardsToReveal.get(i).getName());
        }
        assertEquals(cardNames.contains(person), true);
        assertEquals(cardNames.contains(vehicle), true);
        assertEquals(cardNames.contains(destination), true);
    }
}