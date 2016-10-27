/**
 * ## GameBoard.java
 * ### Interface Class that handles prompts and printouts
 * @author: HugBúnaðarbankinn
 *
 * List Of Functions:
 *
 *  - ### initializeBoard:
 *  The board should be of desired size, usually 3*3 grid.
 *  All indexes are empty, represented with a symbol ('-').
 *  - ### printBoard
 *  - ### promptUser(char player)
 *  - ### promptNextTurn(char player)
 *  - ### printWinner(String win)
 *  - third item
 *
 * This is a text that contains an [external link][link].
 *
 * [link]: http://external-link.com/
 *
 * @param id the user id
 * @return the user object with the passed `id` or `null` if no user with this `id` is found
 */
package is.ru.TicTacToe;


public class GameBoard {
    protected char[][] board = new char[3][3];

    public void initializeBoard() {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                board[i][j] = '-';
            }
        }
    }

    public void printBoard()
    {
        System.out.println("-------------");
        for(int i = 0; i < 3; i++)
        {
            System.out.print("| ");
            for(int j = 0; j < 3; j++)
            {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public void promptUser(char player){
        System.out.println("To play, enter the number");
        System.out.println("123\n456\n789\non the board.");
    }

    public void promptNextTurn(char player) {
        System.out.println("Player " + player + " move: ");
    }

    public void printWinner(String win){
        System.out.println(win);
    }

}