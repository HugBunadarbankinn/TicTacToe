package is.ru.TicTacToe;

public class PlayGame {
    protected GameBoard board = new GameBoard();
    protected char currentPlayerMark;

    public PlayGame() {
        board.initializeBoard();
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

}