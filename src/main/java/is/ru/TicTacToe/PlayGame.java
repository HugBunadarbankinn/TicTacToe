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
    protected boolean isFull()
    {
        if((board.board[0][0] == 'f') && (board.board[0][1] == 'f') && (board.board[0][2] == 'f') &&
           (board.board[1][0] == 'f') && (board.board[1][1] == 'f') && (board.board[1][2] == 'f') &&
           (board.board[2][0] == 'f') && (board.board[2][1] == 'f') && (board.board[2][2] == 'f')){
            return false;
        }

        return true;
    }
}