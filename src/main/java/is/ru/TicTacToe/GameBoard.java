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
        System.out.println("Player " + player + " move: ");
    }

    public void printWinner(String win){
        System.out.println(win);
    }

}