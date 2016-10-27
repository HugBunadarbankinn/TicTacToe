package is.ru.TicTacToe;


public class GameBoard {
    protected final int boardSize = 3;
    protected char[][] board = new char[boardSize][boardSize];

    public void initializeBoard() {
        for(int i = 0; i < boardSize; i++) {
            for(int j = 0; j < boardSize; j++)
            {
                board[i][j] = '-';
            }
        }
    }

    public void printBoard() {
        System.out.println("-------------");
        for(int i = 0; i < boardSize; i++) {
            System.out.print("| ");
            for(int j = 0; j < boardSize; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public void promptUser() {
        System.out.println("To play, enter the number");
        System.out.println("123\n456\n789\non the board.");
    }

    public void promptNextTurn(char player) {
        System.out.println("Player " + player + " move: ");
    }

    public void printWinner(String win) {
        System.out.println(win);
    }

}