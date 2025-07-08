package game;

import java.util.Scanner;

public class Game {
    private Board board;
    private Score score;
    private Computer computer;
    private char currentPlayer;

    public Game() {
        board = new Board();
        score = new Score();
        computer = new Computer(board);
        currentPlayer = 'X';
    }

    public void start() {
        Scanner input = new Scanner(System.in);
        boolean playAgain;
        int[] scores = score.loadScore();
        int playerScore = scores[0];
        int computerScore = scores[1];
        
        do {
            board.initializeBoard();
            System.out.print("Pilih tingkat kesulitan (easy/medium/hard): ");
            String difficulty = input.nextLine();

            while (true) {
                board.printBoard();
                System.out.println("Skor: Pemain X = " + playerScore + " | Komputer O = "+ computerScore);

                if(currentPlayer == 'X'){
                    System.out.println("Pemain X, Masukkan baris dan kolom [0-2]: ");
                    int row, col;
                    while (true) {
                        System.out.print("Baris: ");
                        row = Integer.parseInt(input.nextLine());
                        System.out.print("Kolom: ");
                        col = Integer.parseInt(input.nextLine());

                        if(board.isMoveValid(row, col)){
                            board.updateBoard(row, col, 'X');
                            break;
                        } else {
                            System.out.println("Kotak tidak valid, pilih yang lain!");
                        }
                    }
                } else {
                    computer.makeComputerMove(difficulty);
                }

                if(board.checkWin(currentPlayer)){
                    board.printBoard();
                    if (currentPlayer == 'X') {
                        System.out.println("Pemain X menang!");
                        playerScore++;
                    } else {
                        System.out.println("Komputer menang!");
                        computerScore++;
                    }
                    break;
                } else if (board.isDraw()){
                    board.printBoard();
                    System.out.println("Permainan seri!");
                    break;
                }
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
            System.out.println("===== Skor saat ini ======");
            System.out.println("Pemain X: " + playerScore);
            System.out.println("Komputer O: " + computerScore);
            score.saveScore(playerScore, computerScore);
            System.out.print(" Restart Game? [y/n]: ");
            String again = input.nextLine();
            playAgain = again.equalsIgnoreCase("y");
        } while (playAgain);
        System.out.println("Terimakasih sudah bermain!");
        input.close();
    }
}