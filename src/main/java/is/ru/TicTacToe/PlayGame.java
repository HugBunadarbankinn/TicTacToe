 /**
 * ## PlayGame.java
 * ### Buissness class that handles all logic
 * @author: HugBúnaðarbankinn
 *  
 * ###The constructor:
 * - initializes the board
 * - sets Player 1(X)
 * - prints the board and prompts user
 *
 * ###List Of Functions:
 * 
 *   -   **makeMove:**
 * > Reads input from the user and checks if it's valid. 
 * Calls the 'makeMark' function and the 'changePlayer' function.
 * 
 *  -   **makeMark(int slot):**
 * > Adds the current player's mark on a given location on the board. The state of the board is updated.
 *  @param slot range 1-9
 * 
 *  -  **isValidNumber(int num):**
 *  @param num input from user
 *  
 *  @return 'true' if num is in range 1-9 and the slot is free, else 'false'
 *  
 *  -  **isSlotFree(int row, int col):**
 *  @param row&col
 *  
 *  @return 'true' if free, else 'false'
 * 
 *  >Checks if the given index has the mark ('-')
 * 
 *  -  **checkWinner:**
 *  > Calls the 'checkLine' function for all rows including the angled ones
 * to check if there is a 3 in a row pattern.
 * Returns true if 'checkLine' turns true for any of it's checks.
 *
 *  -  **isFull:**
 *  > Returns 'false' if any slot contains the mark ('-'), else return 'true'.
 * 
 *  -  **checkLine:**
 *  > Returns true if checked indexes have the same mark.
 *  
 *  -  **changePlayer:**
 *  > Called after each turn, changes current player mark between X's and O's.
 *
 *  -  **gameOver:**
 *  > Returns true if either 'isFull' or 'checkWinner' turns true.
 * Used in the 'playSingleGame' function.
 * 
 *  -  **playSingleGame:**
 *  > While the game is not over this function prints out the board, switches between
 * players letting them make their mark. After each mark the board is printed out.
 *
 *  -  **getWinner:**
 *  > Decides what string to send into the printWinner function in the interface class
 *  depending on if the board is full or if there's a winner.
 * 
 */
package is.ru.TicTacToe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlayGame {
    protected GameBoard board = new GameBoard();
    private final int [][] MARK = {{1,2,3}, {4,5,6}, {7,8,9}};
    protected char currentPlayerMark;

    public PlayGame() {
        currentPlayerMark = 'X';
        board.initializeBoard();
        board.printBoard();
        board.promptUser(currentPlayerMark);
    }


    public void makeMove() {
        BufferedReader readInput = new BufferedReader(new InputStreamReader(System.in));
        int slot = 0;
        try {
            String s = readInput.readLine();
            slot = Integer.parseInt(s);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(!isValidNumber(slot)) {
            System.out.println("Not a valid slot!");
        }
        else {
            makeMark(slot);
            changePlayer();
        }
        
        board.printBoard();
    }
    
    protected void makeMark(int slot){
        for (int col = 0; col < 3; col++){
            for (int row = 0; row < 3; row++){
                if(slot == MARK[col][row]){
                    if(isSlotFree(col,row)){
                        board.board[col][row] = currentPlayerMark;
                    }
                    else {
                        System.out.println("Slot is not free");
                    }
                }
            }
        }
    }
    
    protected boolean isValidNumber(int num){
        if(num <= 0 || num > 9 ){
            return false;
        }
        return true;
    }
    protected boolean isSlotFree(int col, int row){
        if(board.board[col][row] == 'X' || board.board[col][row] == 'O') {
            return false;
        }
        return true;
    }

    protected boolean checkWinner()
    {
        for(int i = 0; i < 3; i++)
        {
            if(checkLine(board.board[i][0], board.board[i][1], board.board[i][2]) == true)
            {
                return true;
            }
            else if(checkLine(board.board[0][i], board.board[1][i], board.board[2][i]) == true)
            {
                return true;
            }
            else if((checkLine(board.board[0][0], board.board[1][1], board.board[2][2]) == true) ||
                    (checkLine(board.board[0][2], board.board[1][1], board.board[2][0]) == true))
            {
                return true;
            }
        }
        return false;
    }

    protected boolean isFull()
    {
        if((board.board[0][0] == '-') || (board.board[0][1] == '-') || (board.board[0][2] == '-') ||
           (board.board[1][0] == '-') || (board.board[1][1] == '-') || (board.board[1][2] == '-') ||
           (board.board[2][0] == '-') || (board.board[2][1] == '-') || (board.board[2][2] == '-')){
            return false;
        }

        return true;
    }


    protected boolean checkLine(char a, char b, char c)
    {
        if ((a == '-') || (b == '-') || (c == '-'))
            return false;
        else if((a == b) && (b == c))
            return true;


        return false;
    }

    void changePlayer()
    {
        currentPlayerMark = (currentPlayerMark == 'X' ? 'O' : 'X');
    }

    public boolean gameOver() {
        return (checkWinner() || isFull());
    }

    public final void playSingleGame()
    {
        while (!gameOver())
        {
            board.promptNextTurn(currentPlayerMark);
            makeMove();
        }

        getWinner();
    }


    public void getWinner() {
        changePlayer();
        if(isFull())
        {
            board.printWinner("Draw!");
        }
        else
           board.printWinner("Winner is " + currentPlayerMark + "!");
    }

}
