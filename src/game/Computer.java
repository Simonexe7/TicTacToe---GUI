package game;

import java.util.List;
import java.util.Random;

import javax.swing.JButton;

import game.GUI.Board;

public class Computer {
    private Board board;
    private final int SIZE;
    // JButton[][] buttons;

    public Computer(Board board) {
        this.board = board;
        this.SIZE = board.SIZE;
        // this.buttons = board.getButtons();
    }

    protected void makeComputerMove(char symbol, String difficulty, JButton[][] buttons)
    {
        switch (difficulty) {
            case "EASY":
                makeRandomMove(symbol, buttons);   
                break;
            
            case "NORMAL":
                if (!tryWinOrBlock(symbol, buttons)) {
                    makeRandomMove(symbol, buttons);
                }
                break;
            
            case "HARD":
                makeBestMoveWithMinimax(symbol, buttons);
                break;

            default:
                makeRandomMove(symbol, buttons);
                break;
        }
    }

    // private void handlePlayerMove(int row, int col){
    //     if(!isMoveValid(row, col)) return;

    //     updateBoard(row, col, PLAYER);

    //     if (checkWin(PLAYER)) {
    //         frame.playerScore++;
    //         frame.updateScore();
    //         frame.showEndMessage("Kamu menang!");
    //         return;
    //     } else if (isDraw()){
    //         frame.showEndMessage("Seri!");
    //         return;
    //     }

    //     handleComputerMove();
    // }

    // private void handleComputerMove() {
    //     List<int[]> moves = getAvailableMoves();
    //     if(moves.isEmpty()) return;

    //     int[] move = moves.get(new Random().nextInt(moves.size()));
    //     int row = move[0], col = move[1];
    //     updateBoard(row, col, COMPUTER);

    //     if (checkWin(COMPUTER)) {
    //         frame.computerScore++;
    //         frame.updateScore();
    //         frame.showEndMessage("Komputer Menang!");
    //     } else if (isDraw()) {
    //         frame.showEndMessage("Seri!");
    //     }
    // }

    private void makeRandomMove(char symbol, JButton[][] buttons){
        List<int[]> moves = board.getAvailableMoves();
        int[] move = moves.get(new Random().nextInt(moves.size()));
        board.updateBoard(move[0], move[1], symbol);
        buttons[move[0]][move[1]].setEnabled(false);

    }

    private boolean tryWinOrBlock(char symbol, JButton[][] buttons) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board.isMoveValid(i, j)) {
                    board.updateBoard(i, j, symbol);
                    if (board.checkWin(symbol)) {
                        buttons[i][j].setEnabled(false);
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
                        buttons[i][j].setEnabled(false);
                        return true;
                    }
                    board.updateBoard(i, j, ' ');
                }
            }
        }
        return false;
    }

    private void makeBestMoveWithMinimax(char symbol, JButton[][] buttons) {
        int bestScore = Integer.MIN_VALUE;
        int[] move = {-1, -1};

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board.isMoveValid(i, j)) {
                    board.updateBoard(i, j, symbol);
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
        board.updateBoard(move[0], move[1], symbol);
        buttons[move[0]][move[1]].setEnabled(false);
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
