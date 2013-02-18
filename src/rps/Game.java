package rps;

import java.util.HashMap;

/**
 * A Rock-Paper-Scissor game. There are two {@link Player}s participating in a
 * {@link Game}. The goal is to win.
 * 
 * @author Felix Ortmann
 * 
 */
public class Game
{
    /**
     * the triumpher map contains the correlation of triumphing elements in the
     * given {@link Game}. The key adresses the loosing {@link Output} and the
     * value return its triumpher, meaning the Output whitch is beating "key".
     */
    private HashMap<Output, Output> _triumpher;

    // references to the two game participants.
    private Player _player1;
    private Player _player2;

    /**
     * Create a new {@link Game}. A {@link Game} by default operates based on
     * the win conditions pre-given by Justsoftware.
     * 
     * @param player1
     *            the first participant in this {@link Game}
     * @param player2
     *            the secong paticipant in this {@link Game}
     */
    public Game(Player player1, Player player2)
    {
        _player1 = player1;
        _player2 = player2;
        adjustJustsoftwareConfigurations();
    }

    /**
     * Load the given win conditions wanted from JustsoftwareAG into the game's
     * triumpher correlations.
     */
    private void adjustJustsoftwareConfigurations()
    {
        // fixed number due to win definitions by Justsoftware
        _triumpher = new HashMap<>(3);

        // fill in the triumphers according to Justsoftware's preferred order:

        // scissors beat paper
        _triumpher.put(Output.Paper, Output.Scissors);

        // paper beats rock
        _triumpher.put(Output.Rock, Output.Paper);

        // rock beats scissors
        _triumpher.put(Output.Scissors, Output.Rock);

    }

    /**
     * Let the {@link Game} begin! Both {@link Player}s in this {@link Game}
     * will now compete against each other. The winning {@link Player} will be
     * returned or null if no {@link Player} has won.
     * 
     * @return the winning {@link Player} or null if no one wins
     */
    public Player play()
    {
        Output out1 = _player1.draw();
        Output out2 = _player2.draw();

        int outcome = determineWin(out1, out2);

        return outcome == 0 ? null : outcome == 1 ? _player1 : _player2;

    }

    /**
     * Based on the triumpher correlation, the superior {@link Output} of the
     * given two will be determined.
     * 
     * @param drawOfFirstPlayer
     *            Output of first {@link Player}'s draw.
     * @param drawOfSecondPlayer
     *            Output of second {@link Player}'s draw.
     * @return 0 if it is a tie, the index of the triumphing {@link Output} else
     * 
     */
    private int determineWin(Output drawOfFirstPlayer, Output drawOfSecondPlayer)
    {
        // first player triumphs over second?
        if (drawOfFirstPlayer == _triumpher.get(drawOfSecondPlayer))
        {
            return 1;
        }

        // second player triumphs over first?
        if (drawOfSecondPlayer == _triumpher.get(drawOfFirstPlayer))
        {
            return 2;
        }

        // else it has to be a tie...
        return 0;

    }

}
