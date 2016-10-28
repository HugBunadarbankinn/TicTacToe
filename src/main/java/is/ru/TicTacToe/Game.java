/**
 * ## Game.java
 * ### Class that runs the game
 * @author: HugBúnaðarbankinn
 *
 * The Game.java class only holds the main function that calls
 * to the 'playSingleGame' function from PlayGame.java.
 */
package is.ru.TicTacToe;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
    	 String answer = "";
    	 Scanner user_input = new Scanner( System.in );

    	do {
    		PlayGame game = new PlayGame();
        	game.playSingleGame();
        	System.out.println("Do you want to play another game? (y/n)");
        	answer = user_input.next();
        } while(answer.equals("y"));
    }
}
