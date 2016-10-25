package is.ru.TicTacToe;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class TicTacToeTest {
    GameBoard  board =  new GameBoard();
    PlayGame game = new PlayGame();

    @Test 
    public void testBoard(){

        char[] row = new char[3];

        for(int i = 0; i < 3; i++)
        {
            row[i] = '-';
        } 

        char[] table0 = new char[3];
        char[] table1 = new char[3];
        char[] table2 = new char[3];

        for(int i = 0; i < 3; i++)
        {
            table0[i] = board.board[0][i];
        } 

        for(int i = 0; i < 3; i++)
        {
            table1[i] = board.board[1][i];
        } 

        for(int i = 0; i < 3; i++)
        {
            table2[i] = board.board[2][i];
        } 


        Arrays.equals(row, table0);
        Arrays.equals(row, table1);
        Arrays.equals(row, table2);
    }

    @Test
	public void testValidNumber() {
		assertEquals(false, game.isValidNumber(10));
	}

	@Test
	public void testSlotFree() {
        board.board[0][1] = 'X';
		assertEquals(false, game.isSlotFree(0,1));
	}

	@Test
	public void testCheckWinner() {
        board.board[0][0] = 'X';
        board.board[0][1] = 'X';
        board.board[0][2] = 'X';
		assertEquals(true, game.checkWinner());
	}
    
}