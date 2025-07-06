package game;

import java.util.Scanner;
import game.Board;

public class Game {
    private Board board;
    private char currentPlayer;

    public Game() {
        board = new Board();
        currentPlayer = 'X';
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            board.printBoard();
            System.out.println("Giliran pemain " + currentPlayer);
            System.out.print("Masukkan baris (0-2): ");
            int row = scanner.nextInt();
            System.out.print("Masukkan kolom (0-2): ");
            int col = scanner.nextInt();

            if (!board.isMoveValid(row, col)) {
                System.out.println("Langkah tidak valid, coba lagi.");
                continue;
            }

            board.updateBoard(row, col, currentPlayer);

            if (board.checkWin(currentPlayer)) {
                board.printBoard();
                System.out.println("Pemain " + currentPlayer + " menang!");
                break;
            }

            if (board.isFull()) {
                board.printBoard();
                System.out.println("Permainan seri!");
                break;
            }

            // Ganti pemain
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
        scanner.close();
    }
}