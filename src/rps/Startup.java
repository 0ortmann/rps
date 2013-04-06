package rps;

/**
 * Start Up the Rock-Paper-Scissors Application with pre-set {@link Player}s
 * according to the Justsoftware definitions.
 * 
 * @author Felix Ortmann
 * 
 */

//Random Comment 
public class Startup
{

    public static void main(String[] args)
    {
        // Set up Player A, always draw Paper
        Player player1 = new Player("Player A");
        player1.setDrawOutput(Output.Paper);

        // Set up Player B
        Player player2 = new Player("Player B");

        // Start the manager
        GameManager manager = new GameManager();

        // play 100 games like wanted by Justsoftware
        manager.playMultipleGames(player1, player2, 100);

    }
}
