package is.ru.TicTacToe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

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
        //BufferedReader readInput = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);
        int slot = 0;      
        
        slot = in.nextInt();
        in.close();

        if(!isValidNumber(slot)) {
            System.out.println("Not a valid slot!");
        }
        else {
            makeMark(slot);
            changePlayer();
        }
        board.promptUser(currentPlayerMark);
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
           board.printWinner("Winner is " + currentPlayerMark);
    }

}