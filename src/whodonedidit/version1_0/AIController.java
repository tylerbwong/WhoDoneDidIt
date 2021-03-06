package whodonedidit.version1_0;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import static whodonedidit.version1_0.PlayerState.Defeat;

/**
 * AIController
 * This class represents the intelligence between a computer player that
 * decides its actions and responses. It observes its Player using the
 * Observer interface and reacts to when the Player changes in state,
 * meaning that the Player must respond to something in the game.
 * Operations:
 * An AIController can be updated when its Player changes.
 * @author Markus
 * @version 0.0
 * @since 08-Nov-2015
 */
public class AIController implements Observer
{
    /**
     * {@inheritDoc}
     */
    @Override
    public void update(Observable obsPlayer, Object argument)
    {
        Player player = (Player)obsPlayer;

        // CASE player's PlayerState OF
        switch (((Player)player).getState())
        {
            // Idle : do nothing
            case ReceivingClueCards :
                player.revertState();
                break;
            case ReceivingInitialCards :
                player.revertState();
                break;
            case BeingSnoopedUpon :
                player.revertState();
                break;
            case RespondingToPrivateTipOne :
                chooseCardToReveal((Player)player);
                break;
            // RespondingToPrivateTipAll : do nothing
            // RespondingToSuperSleuth : CALL chooseCardToReveal
            case RespondingToSuperSleuth :
                chooseCardToReveal((Player)player);
                break;
            case DisprovingSuggestion :
                chooseCardToReveal((Player)player);
                break;
            case DoingTurn :
                player.revertState();
                doTurn((Player)player);
                break;
            // Victory : do nothing
            case Defeat :
                break;
            case YouLose :
                ((Player)player).revertState();
                //endTurn((Player)player);
                break;
            // Default : do nothing
            default :
                break;
        }
        // END CASE
    }

    /**
     * Sends an EndTurn action to the GameManager through the argued player.
     * @param player player that's ending its turn
     */
    private void endTurn(Player player)
    {
        // Pause for a second to feel a little more human
        /*
        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex)
        {
        }
        */

        // Construct an EndTurn
        Action action = new EndTurn();
        // Send the EndTurn through player's sendActionToGameManager
        player.sendActionToGameManager(action);

    }

    /**
     * Chooses a card to reveal to another player in response to
     * an action card or accusation, then sends that card in a
     * SendClueCard action to the GameManager.
     * @param player the player controlled by this AIController
     * @pre player's playerState's cardsToReveal list contains
     *      the cards that are a valid response to the current
     *      action card being played against this player
     */
    private void chooseCardToReveal(Player player)
    {
        // CONSTRUCT list of ClueCard "cards"
        List<ClueCard> cards = new ArrayList<ClueCard>();

        // IF player's playerState's cardsToReveal list isn't empty
        if (!player.getState().getCardsToReveal().isEmpty())
        {
            // ADD first clue card from the player's playerState's
            //     cardsToReveal list
            cards.add(player.getState().getCardsToReveal().get(0));
        }
        // END IF

        int targetPlayerID = player.getState().targetPlayerID;

        // Revert player state
        player.revertState();

        // TODO: Figure out how to know what player to send this to
        // CONSTRUCT a SendClueCards action using cards, the targetPlayerID
        // held in player's state, and the ID of player
        SendClueCards action = new SendClueCards(player.getState().type,
                cards, targetPlayerID, player.getPlayerID());
        // CALL player's sendActionToGameManager method using instruction
        player.sendActionToGameManager(action);
    }

    /**
     * Chooses an action to preform in response to an instruction
     * to do a turn, then sends that action in a DoTurn Action.
     * @param player the player controlled by this AIController
     */
    private void doTurn(Player player)
    {
        // TODO: Comment this method
        ActionCard suggestionCard = null;

        for (ActionCard card : player.getHand().getActionCards())
        {
            if (card.getType().equals(ActionCardType.SuggestFromAny) ||
                card.getType().equals(ActionCardType.SuggestFromCurrent))
            {
                suggestionCard = card;
            }
        }

        if (suggestionCard == null)
        {
            makeAccusation(player);
        }
        else
        {
            makeSuggestion(player, suggestionCard.getType());
        }
    }

    private void makeSuggestion(Player player, ActionCardType suggType)
    {
        // Set a boolean fromAny to true if suggType is SuggestFromAny
//        boolean fromAny = (suggType == ActionCardType.SuggestFromAny);
//
//        // SET ClueCard person to null
//        ClueCard person = null;
//        // SET ClueCard person to null
//        ClueCard vehicle = null;
//        // SET ClueCard "destination" to null
//        ClueCard destination = null;
//
//        // Get all clue cards in the game from Deck in player's Table
//        List<ClueCard> clueCardsInGame = player.getTable().getDeck().
//                getPrototypeClueCards();
//
//        // For each clue card in the clue cards in the game
//        for (ClueCard card : clueCardsInGame)
//        {
//            // If card is a person, set person to card
//            if (card.getDescription().contains("person"))
//            {
//                person = card;
//            }
//            // If card is a vehicle, set vehicle to card
//            else if (card.getDescription().contains("vehicle"))
//            {
//                vehicle = card;
//            }
//            // If card is a destination, set destination to card
//            else if (card.getDescription().contains("destination"))
//            {
//                destination = card;
//            }
//        }
//
//        // Set a string personName to the person card's name
//        String personName = person.getName();
//        // Set a string vehicleName to the vehicle card's name
//        String vehicleName = vehicle.getName();
//        // Set a string destinationName to the person card's name
//        String destinationName = destination.getName();
//
//        // If fromAny is false (i.e. it's a SuggestFromCurrent)
//        if (!fromAny)
//        {
//            // Set destinationName to the player's current destination
//            destinationName = player.getHand().getDestinationMarker().
//                    getDestination();
//        }

        // Construct a new MakeSuggestion using suggType, personName,
        //           vehicleName, and destinationName
        //MakeSuggestion suggestion = new MakeSuggestion(suggType, personName,
                //vehicleName, destinationName);
        MakeSuggestion suggestion = new MakeSuggestion(suggType, "Hera", "Apollo's Chariot", "Poseidon Ocean");
        // Call player's sendActionToGameManager using suggestion
        player.sendActionToGameManager(suggestion);
        endTurn((Player)player);
    }

    private void makeAccusation(Player player)
    {
        // SET ClueCard "person" to null
        ClueCard person = null;
        // SET ClueCard "vehicle" to null
        ClueCard vehicle = null;
        // SET ClueCard "destination" to null
        ClueCard destination = null;

        // Get all clue cards in the game from Deck in player's Table
        List<ClueCard> clueCardsInGame = player.getTable().getDeck().
                getPrototypeClueCards();

        // FOR each ClueCard in clueCardsInGame while person is null
        for (int index = 0; index < clueCardsInGame.size() && person == null;
                index++)
        {
            // IF current ClueCard's description contains person
            if (clueCardsInGame.get(index).getDescription().contains("person"))
            {
                // SET person to the current ClueCard
                person = clueCardsInGame.get(index);
            }
        }
        // END FOR

        // FOR each ClueCard in clueCardsInGame while vehicle is null
        for (int index = 0; index < clueCardsInGame.size() && vehicle == null;
                index++)
        {
            // IF current ClueCard's description contains vehicle
            if (clueCardsInGame.get(index).getDescription().contains("vehicle"))
            {
                // SET vehicle to the current ClueCard
                vehicle = clueCardsInGame.get(index);
            }
        }
        // END FOR

        // FOR each ClueCard in clueCardsInGame while destination is null
        for (int index = 0; index < clueCardsInGame.size() && destination == null;
                index++)
        {
            // IF current ClueCard's description contains destination
            if (clueCardsInGame.get(index).getDescription().contains("destination"))
            {
                // SET destination to the current ClueCard
                destination = clueCardsInGame.get(index);
            }
        }
        // END FOR

        // TODO: Change this instantiation to use the Solution class once
        //       MakeAccusation's constructor is fixed.
        // CONSTRUCT a MakeAccusation action using person,
        //           vehicle and destination
        //MakeAccusation action = new MakeAccusation(
                //person.getName(), vehicle.getName(), destination.getName());
        MakeAccusation action = new MakeAccusation(
                "Hera", "Apollo's Chariot", "Poseidon Ocean");
        // CALL player's sendActionToGameManager using action
        player.sendActionToGameManager(action);
        endTurn(player);
    }
}
