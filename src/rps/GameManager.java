package rps;

import java.util.ArrayList;

/**
 * Manages {@link Player}s who praticipate in {@link Game}s. Is able to start
 * {@link Game}s with given {@link Player}s. A {@link GameManager} can print the
 * resutlts of one or many {@link Game}s and the participants to the console.
 * 
 * @author Felix Ortmann
 * 
 */
public class GameManager
{

    /**
     * Play a Rock-Paper-Scissor {@link Game}. The two given {@link Player}
     * compete in the game and the winner is returned. If there is no winner (a
     * tie) null will be returned.
     * 
     * @param player1
     *            Participant 1
     * @param player2
     *            Participant 2
     * @return the winning player or null if a tie
     */
    public Player playGame(Player player1, Player player2)
    {
        Game game = new Game(player1, player2);
        Player winner = game.play();
        score(winner);
        return winner;
    }

    /**
     * Play @param count Rock-Paper-Scissor {@link Game}s. The two given
     * {@link Player} compete in each game and a list of the results is
     * returned. The result list has @param count enties and containes the
     * winning Player or null if there is no winner.
     * 
     * @param player1
     *            Participant 1
     * @param player2
     *            Participant 2
     * @param count
     *            the count of times to play a game
     * @return A list of winning {@link Player}s, entries may null if a tie
     *         happened.
     */
    public ArrayList<Player> playMultipleGames(Player player1, Player player2,
            int count)
    {
        ArrayList<Player> returnList = new ArrayList<>();

        for (int i = 0; i < count; ++i)
        {
            returnList.add(i, playGame(player1, player2));
        }
        printResults(player1, player2, count);
        return returnList;
    }

    /**
     * Score a new win to the given {@link Player}.
     * 
     * @param player
     *            the {@link Player} to increment his wins.
     */
    private void score(Player player)
    {
        if (player != null)
            player.incrementWins();
    }

    /**
     * Print the name and score of the given {@link Player} to the console, also
     * print the count of total games played.
     * 
     * @param player
     *            the player to print the scores from
     * 
     * @param count
     *            count of total games played by this player
     */
    private void printTotalScores(Player player, int count)
    {
        System.out.println(player.getName() + " wins "
                + player.getNumberOfWins() + " of " + count + " games.");
    }

    /**
     * Prints the number of wins and ties from the given two {@link Player}s,
     * assuming that they played @param count games.
     * 
     * @param player1
     * @param player2
     * @param count
     */
    private void printResults(Player player1, Player player2, int count)
    {
        printTotalScores(player1, count);
        printTotalScores(player2, count);
        int ties = count - player1.getNumberOfWins()
                - player2.getNumberOfWins();
        System.out.println("Tie: " + ties + " of " + count + " games.");
    }

}
