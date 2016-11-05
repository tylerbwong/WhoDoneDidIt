/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package whodonedidit.version1_0;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
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
public class AIControllerTest
{
    public AIControllerTest()
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

    private Action playerAction = null;

    private class TestPlayer extends Player
    {
        public TestPlayer(int playerID, String username)
        {
            super(playerID, username);
        }

        @Override
        public void sendActionToGameManager(Action action)
        {
            playerAction = action;
        }
    }

    /**
     * Test of update method, of class AIController.
     */
    @Test
    public void testUpdate()
    {
        System.out.println("update");

        /************** Set up Player ********************/
        AIController controller = new AIController();

        Player player = new Player(0, "test_player")
        {
            @Override
            public void notifyObservers()
            {

            }

            @Override
            public void sendActionToGameManager(Action action)
            {
                playerAction = action;
            }
        };

        player.addObserver(controller);

        /********** Test response to PrivateTipOne ************/
        System.out.println("Testing response to PrivateTipOne");
        PlayerState state = PlayerState.RespondingToPrivateTipOne;
        ClueCard clueCard = new ClueCard("test_Card", new ArrayList<String>());
        state.getCardsToReveal().add(clueCard);


        try
        {
            // Set the player state
            Field playerStateMachineField = Player.class.getDeclaredField("stateMachine");
            playerStateMachineField.setAccessible(true);
            Field playerStateField = PlayerStateMachine.class.getDeclaredField("currentState");
            playerStateField.setAccessible(true);
            playerStateField.set(playerStateMachineField.get(player), state);

            controller.update(player, null);
            assertEquals(SendClueCards.class, playerAction.getClass());

            Field sentClueCardsField = SendClueCards.class.getDeclaredField("cards");
            sentClueCardsField.setAccessible(true);
            List<ClueCard> sentClueCards = (List<ClueCard>)sentClueCardsField.
                    get(playerAction);

            assertNotNull(sentClueCards);
            assertEquals(1, sentClueCards.size());
            assertTrue(sentClueCards.contains(clueCard));
        }
        catch (Exception exc)
        {
            fail("Threw exception during chooseCardToReveal test:\n" + exc);
        }

        /********** Test response to DoTurn ************/
        System.out.println("Testing response to DoTurn");
        state = PlayerState.DoingTurn;
        ClueCard personCard = new ClueCard("person", Arrays.asList("person"));
        ClueCard vehicleCard = new ClueCard("vehicle", Arrays.asList("vehicle"));
        ClueCard destinationCard = new ClueCard("destination", Arrays.
                asList("destination"));

        ArrayList<ClueCard> cardsInGame = new ArrayList<ClueCard>();
        cardsInGame.add(personCard);
        cardsInGame.add(vehicleCard);
        cardsInGame.add(destinationCard);
        AIResources resources = AIResources.instance();
        AIResources.instance().setClueCardsInGame(cardsInGame);


        try
        {
            // Set the player state
            Field playerStateMachineField = Player.class.getDeclaredField("stateMachine");
            playerStateMachineField.setAccessible(true);
            Field playerStateField = PlayerStateMachine.class.getDeclaredField("currentState");
            playerStateField.setAccessible(true);
            playerStateField.set(playerStateMachineField.get(player), state);

            controller.update(player, null);
            assertEquals(MakeAccusation.class, playerAction.getClass());

            Field personField = MakeAccusation.class.getDeclaredField("person");
            personField.setAccessible(true);
            String accusedPersonCard = (String)(personField.get(playerAction));
            Field vehicleField = MakeAccusation.class.getDeclaredField("vehicle");
            vehicleField.setAccessible(true);
            String accusedVehicleCard = (String)vehicleField.get(playerAction);
            Field destinationField = MakeAccusation.class.
                    getDeclaredField("destination");
            destinationField.setAccessible(true);
            String accusedDestinationCard = (String)destinationField.
                    get(playerAction);

            assertNotNull(accusedPersonCard);
            assertEquals(personCard.getName(), accusedPersonCard);
            assertNotNull(accusedVehicleCard);
            assertEquals(vehicleCard.getName(), accusedVehicleCard);
            assertNotNull(accusedDestinationCard);
            assertEquals(destinationCard.getName(), accusedDestinationCard);
        }
        catch (Exception exc)
        {
            fail("Threw exception during DoTurn test:\n" + exc);
        }
    }

}