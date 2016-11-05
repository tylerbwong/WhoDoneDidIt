
package whodonedidit.version1_0;

import java.io.Serializable;

/**
 * The solution class represents a solution of 3 clue cards picked
 * during a game of Who Done Did it? There is 1 person card, 1 vehicle
 * card and 1 destination card in a solution. Players try to guess the
 * solution.
 *
 * @author austinrobarts
 * @since 11-16-15
 */
public class Solution implements Serializable
{
    /**
     * The person in the solution
     */
    public final ClueCard person;
    /**
     * The vehicle in the solution
     */
    public final ClueCard vehicle;
    /**
     * The destination in the solution
     */
    public final ClueCard destination;

    /**
     * Constructs a Solution given 3 clue cards
     * @param person The ClueCard that is the person
     * @param vehicle The ClueCard that is the vehicle
     * @param destination The ClueCard that is the destination
     */
    public Solution(ClueCard person, ClueCard vehicle, ClueCard destination)
    {
        this.person = person;
        this.vehicle = vehicle;
        this.destination = destination;
    }

    /**
     * Checks if a given solution matches this solution.
     *
     * @param personGuess the person in the guess
     * @param vehicleGuess the vehicle in the guess
     * @param destinationGuess the destination in the guess
     * @return returns true if the solutions match and false if any
     *         clue card does not match the solution
     */
    public boolean checkSolution(String personGuess, String vehicleGuess, String destinationGuess)
    {
        //SET match to true
        boolean match = true;
        //IF person's name is not equal to guess person's name
        if (!person.getName().equals(personGuess))
        {
            //SET match to false
            match = false;
        }
        //ELSEIF vehicle's name is not equal to guess vehicle's name
        else if (!vehicle.getName().equals(vehicleGuess))
        {
            //SET match to false
            match = false;
        }
        //ELSEIF destination's name is not equal to guess destination's name
        else if (!destination.getName().equals(destinationGuess))
        {
            //SET match to false
            match = false;
        }

        return match;
    }
}
