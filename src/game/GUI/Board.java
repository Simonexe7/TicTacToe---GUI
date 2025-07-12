package game.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import game.Game;

public class Board extends JPanel {
    private JButton[][] buttons;
    private char[][] board;
    private Game game;
    public Frame frame;
    public final int SIZE = 3;
    public String difficulty = "NORMAL";
    // private final char PLAYER = 'X';
    // private final char COMPUTER = 'O';

    // private int playerScore;
    // private int computerScore;

    public Board(Frame frame) {
        this.frame = frame;
        this.game = new Game(this);
        this.buttons = new JButton[SIZE][SIZE];
        this.board = new char[SIZE][SIZE];
        // this.playerScore = frame.playerScore;
        // this.computerScore = frame.computerScore;
        setLayout(new BorderLayout());
        initBoard();
    }

    private void initBoard(){
        JPanel boardPanel = new JPanel(new GridLayout(3, 3, 5, 5));
        boardPanel.setBackground(new Color(60, 63, 65));
        boardPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        Font font = new Font("Arial", Font.BOLD, 48);

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                JButton btn = new JButton("");
                btn.setFont(font);
                btn.setBackground(new Color(255, 255, 255));
                btn.setFocusPainted(false);
                btn.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 2));
                final int row = i, col = j;
                btn.addActionListener(e -> game.handlePlayerMove(row, col, buttons));
                buttons[i][j] = btn;
                boardPanel.add(btn);
            }
        }
        add(boardPanel, BorderLayout.CENTER);
    }



    public JButton[][] getButtons() {
        return this.buttons;
    }

    protected void resetBoard(){
        for (int i = 0; i < SIZE; i++) {
            Arrays.fill(board[i], ' ');
            for (int j = 0; j < SIZE; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
            }
        }
    }

    public List<int[]> getAvailableMoves() {
        List<int[]> moves = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == ' ') {
                    moves.add(new int[]{i, j});
                }
            }
        }
        return moves;
    }

    public boolean checkWin(char player) {
        for (int i = 0; i < SIZE; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true;
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true;
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;
        return false;
    }

    public boolean isDraw() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isMoveValid(int row, int col)
    {
        if(row >= 0 && row < SIZE && col >= 0 && col < SIZE){
            if(board[row][col] == ' '){
                return true;
            } 
        }
        return false;
    }

    public void updateBoard(int row, int col, char symbol) {
        board[row][col] = symbol;
        buttons[row][col].setText(String.valueOf(symbol));
    }

    public void getSymbol(int row, int col) {
        System.out.println(board[row][col]);
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getDifficulty(){
        return difficulty;
    }
}