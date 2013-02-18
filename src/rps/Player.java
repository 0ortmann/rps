package rps;

import java.util.Random;

/**
 * A Player who can draw an {@link Output} in order to prticipate in a
 * Rock-Paper-Scissors game.
 * 
 * @author Felix Ortmann
 * 
 */
public class Player
{
    // name of this Player
    private String _name;

    // total amount of wins during the lifetime of this player.
    private int _wins;

    private Output _drawOutput;

    /**
     * Create a new {@link Player}. A Player has a name and is able to
     * participate in Rock-Paper-Scissor games. By default, the {@link Player}
     * will draw random output for such a game, but the draw-outcome can also be
     * fixed to one value.
     * 
     * @param name
     *            The name of this {@link Player}
     */
    public Player(String name)
    {
        _name = name;
        _wins = 0;
        _drawOutput = null;
    }

    /**
     * The player draws a possible {@link Output} of a Rock-Paper-Scissor game
     * 
     * @return an {@link Output} of a Rock-Paper-Scissor game
     */
    public Output draw()
    {
        if (_drawOutput != null)
        {
            return _drawOutput;
        }
        return drawRandom();

    }

    /**
     * Returns a randomly drawn Output of a possible Rock-Paper-Scissor game.
     * 
     * @return a randomly generated {@link Output} of a Rock-Paper-Scissor game.
     */
    private Output drawRandom()
    {
        Output[] possibilities = Output.values();
        Random randomGenerator = new Random();

        // draw a random int between 0 and the number of possible outputs
        int random = randomGenerator.nextInt(possibilities.length - 1);

        return possibilities[random];
    }

    /**
     * Returns the name of this {@link Player}.
     * 
     * @return the name of this {@link Player}.
     */
    public String getName()
    {
        return _name;
    }

    /**
     * Raises the number of wins of this {@link Player} by 1.
     */
    public void incrementWins()
    {
        _wins += 1;
    }

    /**
     * Returns the number of wins this {@link Player} has totally had.
     * 
     * @return the number of total wins.
     */
    public int getNumberOfWins()
    {
        return _wins;
    }

    /**
     * set the the outcome of this {@link Player#draw()} to a fixed result.
     * 
     * @param output
     *            the fixed output to set
     */
    public void setDrawOutput(Output output)
    {
        _drawOutput = output;
    }

    /**
     * Resets the outcome of the {@link Player#draw()} method to random output
     * again.
     */
    public void resetDrawOutput()
    {
        _drawOutput = null;
    }

}
