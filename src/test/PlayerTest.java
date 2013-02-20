/**
 * 
 */
package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import rps.Output;
import rps.Player;

/**
 * 
 * Testcase for the {@link Player}. All public methods as well as the
 * constructor
 * shall be tested.
 * 
 * @author Felix Ortmann
 * 
 */
public class PlayerTest
{

    Player _underTest;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception
    {
        _underTest = new Player("Tester");
    }

    /**
     * Test method for {@link rps.Player#Player(java.lang.String)}.
     */
    @Test
    public void testPlayer()
    {
        // use knowledge given in constructer-comment in Player.

        // win-count is 0 at the start:
        assertEquals(0, _underTest.getNumberOfWins());

        // name is "tester" as defined in the setUp():
        assertEquals("Tester", _underTest.getName());
    }

    /**
     * Test method for {@link rps.Player#draw()}.
     */
    @Test
    public void testDraw()
    {
        // first its assumed to be default:
        assertNotNull(_underTest.draw());

        // set the draw-output, test changed draw-functionality:
        _underTest.setDrawOutput(Output.Paper);
        assertEquals(Output.Paper, _underTest.draw());

        _underTest.setDrawOutput(Output.Rock);
        assertEquals(Output.Rock, _underTest.draw());

        _underTest.setDrawOutput(Output.Scissors);
        assertEquals(Output.Scissors, _underTest.draw());

    }

    /**
     * Test method for {@link rps.Player#getName()}.
     */
    @Test
    public void testGetName()
    {
        assertNotNull(_underTest);
        assertEquals("Tester", _underTest.getName());
    }

    /**
     * Test method for {@link rps.Player#incrementWins()}.
     */
    @Test
    public void testIncrementWins()
    {
        assertNotNull(_underTest);
        int x = _underTest.getNumberOfWins(); // current count of wins, expected
                                              // to be 0
        _underTest.incrementWins();
        assertEquals(x + 1, _underTest.getNumberOfWins());

    }

    /**
     * Test method for {@link rps.Player#getNumberOfWins()}.
     */
    @Test
    public void testGetNumberOfWins()
    {
        assertNotNull(_underTest);
        // during setUp() the Player was newly instanciated - thus the number of
        // wins is 0
        assertEquals(0, _underTest.getNumberOfWins());

        _underTest.incrementWins();
        _underTest.incrementWins();
        assertEquals(2, _underTest.getNumberOfWins());
    }

    /**
     * Test method for {@link rps.Player#setDrawOutput(rps.Output)}.
     */
    @Test
    public void testSetDrawOutput()
    {
        assertNotNull(_underTest);
        _underTest.setDrawOutput(Output.Paper);
        assertEquals(Output.Paper, _underTest.draw());

        _underTest.setDrawOutput(Output.Rock);
        assertEquals(Output.Rock, _underTest.draw());

        _underTest.setDrawOutput(Output.Scissors);
        assertEquals(Output.Scissors, _underTest.draw());
    }

    /**
     * Test method for {@link rps.Player#resetDrawOutput()}.
     */
    @Test
    public void testResetDrawOutput()
    {
        // as defined in method-comment in Player, by default a random Output is
        // returned.
        assertNotNull(_underTest);

        // set up reference list with valid outputs:
        ArrayList<Output> possibilities = new ArrayList<>();
        for (Output o : Output.values())
            possibilities.add(o);

        assertTrue(possibilities.contains(_underTest.draw()));

        _underTest.setDrawOutput(Output.Paper); // always draw paper

        assertEquals(Output.Paper, _underTest.draw()); // verifiy draw results
                                                       // in paper

        _underTest.resetDrawOutput(); // reset

        // verify it is still a valid output
        assertTrue(possibilities.contains(_underTest.draw()));

        // verify that draw can result in different Outputs:

        boolean switched = false; // marker for differing draws
        Output out = _underTest.draw(); // randomly chosen output as reference
        int breaker = 0;

        // this while loop will result in a not ending process, if the
        // implementation is wrong.
        // optional one can uncomment the break condition, to work based on
        // success possibilities and to avoid endless loops.

        while (!switched && breaker < 100000)
        {
            if (!out.equals(_underTest.draw())) // not equal, different draw
                switched = true;
            // ++breaker;
        }

        assertTrue(switched);

    }
}
