package game.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class Frame extends JFrame {
    private Board board;
    private final int SIZE;

    public int playerScore = 0;
    public int computerScore = 0;
    private JLabel scoreLabel;

    public Frame() {
        this.board = new Board(this);
        this.SIZE = board.SIZE;
        setContentPane(new Board(this));
        initFrame();    
    }

    private void initFrame() {
        setTitle("Tic Tac Toe");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(240, 240, 240));
        setLayout(new BorderLayout());

        scoreLabel = new JLabel("Pemain: 0  |  Komputer: 0", SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        scoreLabel.setForeground(new Color(30, 30, 30));
        scoreLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(scoreLabel, BorderLayout.NORTH);

        add(board, BorderLayout.CENTER);
        board.resetBoard();

        JLabel statusLabel = new JLabel("Your turn", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        statusLabel.setForeground(new Color(80, 80, 80));
        statusLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(statusLabel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);

        showDifficultyDialog();
    }

    public void showEndMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
        int option = JOptionPane.showConfirmDialog(this, "Main lagi?", "Restart",
                JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            board.resetBoard();
            showDifficultyDialog();
        } else {
            System.exit(0);
        }
    }

    public void updateScore() {
        scoreLabel.setText("Pemain: " + playerScore + "     |   Komputer: " + computerScore);
    }

    private void showDifficultyDialog() {
        String[] options = {"Easy", "Normal", "Hard"};
        String choice = null;

        while (choice == null) {
            choice = (String) JOptionPane.showInputDialog(
                this,
                "Pilih tingkat kesulitan:",
                "Kesulitan",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
            );

            if (choice == null) {
                System.exit(0);
            }
        }

        board.setDifficulty(choice.toUpperCase());
    }

    // public static void main(String[] args) {
    //     SwingUtilities.invokeLater(Frame::new);
    // }
}
