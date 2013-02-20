package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import rps.Game;
import rps.Output;
import rps.Player;

/**
 * Testcase for the {@link Game}. All public methods as well as the constructor
 * shall be tested.
 * 
 * Therefore knowledge from the Game implementation is used:
 * Knowledge used: Rock triumphs over Scissor, Scissor over Paper and Paper over
 * Rock.
 * 
 * @author Felix Ortmann
 * 
 */
public class GameTest
{
    Player _paperPlayer; // prepared to always draw paper
    Player _rockPlayer; // prepared to always draw rock
    Player _scissorPlayer; // prepared to always draw scissors

    Game _underTest;

    @Before
    public void setUp() throws Exception
    {
        // set up the Players with predefined behaviour.
        _paperPlayer = new Player("Paperman");
        _paperPlayer.setDrawOutput(Output.Paper);

        _rockPlayer = new Player("Rocker");
        _rockPlayer.setDrawOutput(Output.Rock);

        _scissorPlayer = new Player("Cutter");
        _scissorPlayer.setDrawOutput(Output.Scissors);

    }

    /**
     * Testmethod for {@link Game#Game(rps.Player, rps.Player)}
     */
    @Test
    public void testGame()
    {
        // barely anything to test here..

        _underTest = new Game(_paperPlayer, _rockPlayer);
        assertNotNull(_underTest);

    }

    /**
     * Testmethod for {@link Game#play()}.
     */
    @Test
    public void testPlay()
    {
        // use implementation knowledge, to verifiy Game's behaviour.

        // Knowledge: Paper > Rock
        _underTest = new Game(_paperPlayer, _rockPlayer);
        assertEquals(_paperPlayer, _underTest.play());

        // vice versa:
        _underTest = new Game(_rockPlayer, _paperPlayer);
        assertEquals(_paperPlayer, _underTest.play());

        // knowledge: Rock > Scissors
        _underTest = new Game(_rockPlayer, _scissorPlayer);
        assertEquals(_rockPlayer, _underTest.play());

        // vice versa:
        _underTest = new Game(_scissorPlayer, _rockPlayer);
        assertEquals(_rockPlayer, _underTest.play());

        // knowledge: Scissor > Paper
        _underTest = new Game(_paperPlayer, _scissorPlayer);
        assertEquals(_scissorPlayer, _underTest.play());

        // vice versa:
        _underTest = new Game(_scissorPlayer, _paperPlayer);
        assertEquals(_scissorPlayer, _underTest.play());

        // Tie-possibilities:
        _underTest = new Game(_paperPlayer, _paperPlayer);
        assertNull(_underTest.play());
        // Tie-possibilities:
        _underTest = new Game(_rockPlayer, _rockPlayer);
        assertNull(_underTest.play());
        // Tie-possibilities:
        _underTest = new Game(_scissorPlayer, _scissorPlayer);
        assertNull(_underTest.play());
    }

}
