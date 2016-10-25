package is.ru.TicTacToe;

public class PlayGame {
    private GameBoard board = new GameBoard();

    protected boolean isValidNumber(int num){
        if(num <= 0 || num > 9 )
        {
            return false;
        }
        return true;
    }
    protected boolean isSlotFree(int col, int row){
        if (board.board[col][row] != '-') {
            return false;
        }
        return true;

    }
}