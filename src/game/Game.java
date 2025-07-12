package game;

import javax.swing.JButton;

import game.GUI.Board;
import game.GUI.Frame;

public class Game {
    private Board board;
    private Computer computer;
    // private char currentPlayer;
    // private JButton[][] buttons;
    private Frame frame;
    private final int SIZE;
    private String difficulty;

    public Game(Board board) {
        this.board = board;
        this.SIZE = board.SIZE;
        // this.buttons = board.getButtons();
        this.frame = board.frame;
        computer = new Computer(board);
    }

    public void handlePlayerMove(int row, int col, JButton[][] buttons) {
        if (!board.isMoveValid(row, col)) return;

        board.updateBoard(row, col, 'X');
        buttons[row][col].setEnabled(false);

        if(board.checkWin('X')){
            frame.playerScore++;
            frame.updateScore();
            frame.showEndMessage("Kamu menang!");
            return;
        } else if (board.isDraw()){
            frame.showEndMessage("Permainan seri!");
            return;
        }

        this.difficulty = board.getDifficulty();
        computer.makeComputerMove('O', this.difficulty, buttons);

        if (board.checkWin('O')) {
            frame.computerScore++;
            frame.updateScore();
            frame.showEndMessage("Komputer menang!");
            return;
        } else if (board.isDraw()) {
            frame.showEndMessage("Permainan seri!");
            return;
        }
    }
}