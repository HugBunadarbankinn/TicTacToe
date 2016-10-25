package is.ru.TicTacToe;

public class PlayGame {
    protected GameBoard board = new GameBoard();

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
}