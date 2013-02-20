/**
 * 
 */
package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import rps.GameManager;
import rps.Player;

/**
 * 
 * Testcase for the {@link GameManager}. All public methods shall be tested.
 * 
 * @author Felix Ortmann
 */
public class GameManagerTest
{
    Player _player1;
    Player _player2;

    GameManager _underTest;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception
    {
        _player1 = new Player("Player A");
        _player2 = new Player("Player B");

        _underTest = new GameManager();
    }

    /**
     * Test method for {@link rps.GameManager#playGame(rps.Player, rps.Player)}.
     */
    @Test
    public void testPlayGame()
    {
        Player winPlayer = _underTest.playGame(_player1, _player2);

        if (winPlayer != null) // it was no tie
        {
            assertEquals(1, winPlayer.getNumberOfWins());
            // use knowledge about Player to verify behaviour.
        }
    }

    /**
     * Test method for
     * {@link rps.GameManager#playMultipleGames(rps.Player, rps.Player, int)}.
     */
    @Test
    public void testPlayMultipleGames()
    {
        // play 100 games and test that the returnal is correct
        ArrayList<Player> winPlayerList = _underTest.playMultipleGames(
                _player1, _player2, 100);

        // Remember the win count to test for.
        int winPlayer1 = 0;
        int winPlayer2 = 0;

        for (Player player : winPlayerList)
        {
            if (player != null) // it was no tie
            {
                if (player.equals(_player1))
                {
                    // it was player 1, count his wins
                    ++winPlayer1;
                }
                else
                {
                    // else it has to be player 2, count his wins.
                    ++winPlayer2;
                }
            }
        }

        assertEquals(winPlayer1, _player1.getNumberOfWins());
        assertEquals(winPlayer2, _player2.getNumberOfWins());
    }
}
