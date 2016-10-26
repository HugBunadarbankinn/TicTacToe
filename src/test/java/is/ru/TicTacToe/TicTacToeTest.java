package is.ru.TicTacToe;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class TicTacToeTest {
   //GameBoard  board =  new GameBoard();
    PlayGame game = new PlayGame();


    @Test 
    public void testBoard(){

        char[] row = new char[3];

        for(int i = 0; i < 3; i++){
            row[i] = '-';
        } 

        char[] table0 = new char[3];
        char[] table1 = new char[3];
        char[] table2 = new char[3];

        for(int i = 0; i < 3; i++){
            table0[i] = game.board.board[0][i];
        } 

        for(int i = 0; i < 3; i++){
            table1[i] = game.board.board[1][i];
        } 

        for(int i = 0; i < 3; i++){
            table2[i] = game.board.board[2][i];
        }
        for(int i = 0; i < 3; i++)
        {
            table0[i] = game.board.board[0][i];
        } 

        for(int i = 0; i < 3; i++)
        {
            table1[i] = game.board.board[1][i];
        } 

        for(int i = 0; i < 3; i++)
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
	public void testSlotFree1() {
        game.board.board[0][1] = 'X';
		assertEquals(false, game.isSlotFree(0,1));
	}

    @Test
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
    public void testSlotFree() {
        game.board.board[0][1] = '-';
        assertEquals(true, game.isSlotFree(1,1));
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
    
}
