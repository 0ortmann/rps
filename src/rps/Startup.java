package rps;

/**
 * Start Up the Rock-Paper-Scissors Application with pre-set {@link Player}s.
 * The first player will always draw paper, the other is random.
 * 
 * @author Felix Ortmann
 * 
 */

public class Startup
{

    /**
     * Start the applications, args not needed here.
     * @param args
     */
    public static void main(String[] args)
    {
        // Set up Player A, always draw Paper
        Player player1 = new Player("Player A");
        player1.setDrawOutput(Output.Paper);

        // Set up Player B
        Player player2 = new Player("Player B");

        // Start the manager
        GameManager manager = new GameManager();

        // play 100 games
        manager.playMultipleGames(player1, player2, 100);

    }
}
