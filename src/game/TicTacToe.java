public class TicTacToe {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public TicTacToe() {
        board = new Board();
        player1 = new Player("Player 1", 'X');
        player2 = new Player("Player 2", 'O');
        currentPlayer = player1;
    }

    public void startGame() {
        board.initializeBoard();
        boolean gameWon = false;

        while (!gameWon && !board.isFull()) {
            board.printBoard();
            int move = InputHandler.getUserInput(currentPlayer.getName() + ", enter your move (1-9): ");
            if (board.isMoveValid(move)) {
                board.updateBoard(move, currentPlayer.getSymbol());
                gameWon = checkWin();
                switchPlayer();
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        board.printBoard();
        if (gameWon) {
            System.out.println("Congratulations " + currentPlayer.getName() + ", you win!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    private boolean checkWin() {
        char symbol = currentPlayer.getSymbol();
        return (board.checkRows(symbol) || board.checkColumns(symbol) || board.checkDiagonals(symbol));
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
}