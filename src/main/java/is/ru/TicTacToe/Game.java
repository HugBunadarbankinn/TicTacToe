/**
 * ## Game.java
 * ### Class that runs the game
 * @author: HugBúnaðarbankinn
 *
 * The Game.java class only holds the main function that calls
 * to the 'playSingleGame' function from PlayGame.java.
 */
package is.ru.TicTacToe;

public class Game {
    public static void main(String[] args) {
    	PlayGame game = new PlayGame();
        game.playSingleGame();
    }
}