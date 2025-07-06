public class Board {
    private char[][] board;
    private final int SIZE = 3;

    public Board() {
        board = new char[SIZE][SIZE];
        initializeBoard();
    }

    public void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isMoveValid(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == '-';
    }

    public void updateBoard(int row, int col, char symbol) {
        if (isMoveValid(row, col)) {
            board[row][col] = symbol;
        }
    }
}