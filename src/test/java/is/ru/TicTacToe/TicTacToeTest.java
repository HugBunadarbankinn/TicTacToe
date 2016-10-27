/**
 * ## TicTacToeTest.java
 * ### Unit Tests
 * @author: HugBúnaðarbankinn
 *
 * ###List Of Tests:
 *
 *  - test for initializeBoard
 *  - tests for isValidNumber: must be in range 1-9
 *  - tests for isFull: all indexes have other marks than ('-')
 *  - tests for isSlotFree: index has mark ('-')
 *  - tests for checkWinner
 *  - tests for makeMark: has the mark changed from ('-') to ('X' or 'O')
 *  - test for changePlayer
 */
package is.ru.TicTacToe;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class TicTacToeTest {
    PlayGame game = new PlayGame();
    GameBoard testBoard = new GameBoard();

    @Test 
    public void testBoard() {

        char[] row = new char[testBoard.boardSize];

        for(int i = 0; i < testBoard.boardSize; i++) {
            row[i] = '-';
        } 

        char[] table0 = new char[testBoard.boardSize];
        char[] table1 = new char[testBoard.boardSize];
        char[] table2 = new char[testBoard.boardSize];

        for(int i = 0; i < testBoard.boardSize; i++) {
            table0[i] = game.board.board[0][i];
        } 

        for(int i = 0; i < testBoard.boardSize; i++) {
            table1[i] = game.board.board[1][i];
        } 

        for(int i = 0; i < testBoard.boardSize; i++) {
            table2[i] = game.board.board[2][i];
        }
        for(int i = 0; i < testBoard.boardSize; i++)
        {
            table0[i] = game.board.board[0][i];
        } 

        for(int i = 0; i < testBoard.boardSize; i++)
        {
            table1[i] = game.board.board[1][i];
        } 

        for(int i = 0; i < testBoard.boardSize; i++)
        {
            table2[i] = game.board.board[2][i];
        } 

        Arrays.equals(row, table0);
        Arrays.equals(row, table1);
        Arrays.equals(row, table2);
    }

    @Test
    public void testTooHighNumber() {
        assertEquals(false, game.isValidNumber(10));
    }

    @Test
    public void testTooLowNumber() {
        assertEquals(false, game.isValidNumber(-1));
    }

    @Test
    public void testValidNumber() {
        assertEquals(true, game.isValidNumber(5));
    }

    @Test

    public void testIsFull() {
        for (int i = 0; i < testBoard.boardSize; i++) {
            for(int j = 0; j < testBoard.boardSize; j++) {
                game.board.board[i][j] = 'X';
            }
        }
        assertEquals(true, game.isFull());
    }

    @Test
    public void testIsNotFull() {
        for (int i = 0; i < testBoard.boardSize; i++) {
            for(int j = 0; j < testBoard.boardSize; j++) {
                game.board.board[i][j] = '-';
            }
        }
        game.board.board[0][1] = '-';

        assertEquals(false, game.isFull());
    }

    @Test
    public void testSlotFree() {
        game.board.board[0][1] = '-';
        assertEquals(true, game.isSlotFree(1,1));
    } 

    @Test
    public void testSlotFree1() {
        game.board.board[0][1] = 'X';
        assertEquals(false, game.isSlotFree(0,1));
    } 

    public void testSlotFree2() {
        game.board.board[0][1] = '-';
        assertEquals(true, game.isSlotFree(0,1));
    }

    @Test
    public void testCheckWinnerA() {
        game.board.board[0][0] = 'X';
        game.board.board[0][1] = 'O';
        game.board.board[0][2] = 'O';
        assertEquals(false, game.checkWinner());
    }

    @Test
    public void testCheckWinnerB() {
        game.board.board[0][0] = 'O';
        game.board.board[0][1] = 'O';
        game.board.board[0][2] = 'O';
        assertEquals(true, game.checkWinner());
    }

    @Test
    public void testCheckWinnerC() {
        game.board.board[0][0] = 'X';
        game.board.board[1][1] = 'X';
        game.board.board[2][2] = 'X';
        assertEquals(true, game.checkWinner());
    }

    @Test
    public void testMakeMark() {
        char mark = game.currentPlayerMark;
        game.makeMark(3);

        assertEquals(mark, game.board.board[0][2]);
    }

    @Test
    public void testMakeMark2() {
        game.changePlayer();
        char mark = game.currentPlayerMark;
        game.makeMark(6);

        assertEquals(mark, game.board.board[1][2]);
    }
    
    public void testChangePlayer() {
        game.currentPlayerMark = 'X';
        game.changePlayer();
        assertEquals('O', game.currentPlayerMark);
    } 

}
