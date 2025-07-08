package game;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private char[][] board;
    protected final int SIZE = 3;

    public Board() {
        board = new char[SIZE][SIZE];
        initializeBoard();
    }

    protected char[][] initializeBoard(){
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                board[i][j] = ' ';
            }
        }
        return board;
    }

    protected void printBoard()
    {
        System.out.println("---------------");
        for(int i = 0; i < SIZE; i++){
            System.out.print("| ");
            for(int j = 0; j < SIZE; j++){
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("---------------");
        }
    }

    protected boolean isMoveValid(int row, int col)
    {
        if(row >= 0 && row < SIZE && col >= 0 && col < SIZE){
            if(board[row][col] == ' '){
                return true;
            } 
        }
        return false;
    }

    protected void updateBoard(int row, int col, char symbol) {
        board[row][col] = symbol;
    }
    
    protected boolean checkWin(char symbol) {
        // Cek baris dan kolom
        for (int i = 0; i < SIZE; i++) {
            if ((board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) ||
                (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)) {
                return true;
            }
        }
        // Cek diagonal
        if ((board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
            (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)) {
            return true;
        }
        return false;
    }

    protected boolean isDraw() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    protected List<int[]> getAvailableMoves()
    {
        List<int[]> moves = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == ' ') {
                    moves.add(new int[] {i, j});
                }
            }
        }
        return moves;
    }
}