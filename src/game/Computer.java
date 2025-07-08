package game;

import java.util.List;
import java.util.Random;

public class Computer {
    private Board board;
    private final int SIZE;

    public Computer(Board board) {
        this.board = board;
        this.SIZE = board.SIZE;
    }

    protected void makeComputerMove(String difficulty)
    {
        if (difficulty.equalsIgnoreCase("easy")) {
            makeRandomMove();
        } else if (difficulty.equalsIgnoreCase("medium")) {
            if (!tryWinOrBlock('O')) {
                makeRandomMove();
            }
        } else if (difficulty.equalsIgnoreCase("hard")) {
            makeBestMoveWithMinimax();
        }
    }

    private void makeRandomMove(){
        List<int[]> moves = board.getAvailableMoves();
        int[] move = moves.get(new Random().nextInt(moves.size()));
        board.updateBoard(move[0], move[1], 'O');
    }

    private boolean tryWinOrBlock(char symbol) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board.isMoveValid(i, j)) {
                    board.updateBoard(i, j, symbol);
                    if (board.checkWin(symbol)) {
                        return true; // bisa menang
                    }
                    board.updateBoard(i, j, ' ');
                }
            }
        }

        // kalau tidak bisa menang, coba blokir lawan
        char opponent = (symbol == 'O') ? 'X' : 'O';
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board.isMoveValid(i, j)) {
                    board.updateBoard(i, j, opponent);
                    if (board.checkWin(opponent)) {
                        board.updateBoard(i, j, ' ');
                        board.updateBoard(i, j, symbol);
                        return true;
                    }
                    board.updateBoard(i, j, ' ');
                }
            }
        }
        return false;
    }

    private void makeBestMoveWithMinimax() {
        int bestScore = Integer.MIN_VALUE;
        int[] move = {-1, -1};

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board.isMoveValid(i, j)) {
                    board.updateBoard(i, j, 'O');
                    int score = minimax(0, false, Integer.MIN_VALUE, Integer.MAX_VALUE);
                    board.updateBoard(i, j, ' ');
                    if (score > bestScore) {
                        bestScore = score;
                        move[0] = i;
                        move[1] = j;
                    }
                }
            }
        }
        board.updateBoard(move[0], move[1], 'O');
    }

    private int minimax(int depth, boolean isMaximizing, int alpha, int beta) {
        if (board.checkWin('O')) return 10 - depth;
        if (board.checkWin('X')) return depth - 10;
        if(board.isDraw()) return 0;

        if (isMaximizing) {
            int maxEval = Integer.MIN_VALUE;
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (board.isMoveValid(i, j)){
                        board.updateBoard(i, j, 'O');;
                        int eval = minimax(depth + 1, false, alpha, beta);
                        board.updateBoard(i, j, ' ');;
                        maxEval = Math.max(maxEval, eval);
                        alpha = Math.max(alpha, eval);

                        if (beta <= alpha) {
                            break;
                        }
                    }
                }
            }
            return maxEval;
        } else {
            int minEval = Integer.MAX_VALUE;
            for (int i = 0; i < SIZE; i++){
                for (int j = 0; j < SIZE; j++){
                    if (board.isMoveValid(i, j)) {
                        board.updateBoard(i, j, 'X');;
                        int eval = minimax(depth + 1, true, alpha, beta);
                        board.updateBoard(i, j, ' ');;
                        minEval = Math.min(minEval, eval);
                        beta = Math.min(beta, eval);

                        if (beta <= alpha) {
                            break;
                        }
                    }
                }
            }
            return minEval;
        }
    }
}
