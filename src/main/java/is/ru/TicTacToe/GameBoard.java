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
 *  - ### printBoard:
 *  Prints out the board in it's current state, in the beginning
 *  and after each turn.
 *  - ### promptUser:
 *  In the beginning og each game, prints out instructions on what to input.
 *  - ### promptNextTurn(char player):
 *  @param player , either X or O
 *  @return Player X move: / Player O move:
 *  Called on by the 'playSingleGame' function in PlayGame.java
 *  - ### printWinner(String win):
 *  @param win Draw! / "Winner is " + currentPlayerMark + "!"
 *  Called on by the 'getWinner' function in PlayGame.java.
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