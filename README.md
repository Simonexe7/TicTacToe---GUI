# Tic Tac Toe Game

## Overview
This is a simple implementation of the classic Tic Tac Toe game in Java. The game allows two players to take turns marking their symbols (X or O) on a 3x3 grid. The first player to align three of their symbols horizontally, vertically, or diagonally wins the game.

## Project Structure
```
tic-tac-toe-java
├── src
│   ├── Main.java
│   ├── game
│   │   ├── Board.java
│   │   ├── Player.java
│   │   └── TicTacToe.java
│   └── utils
│       └── InputHandler.java
├── .gitignore
└── README.md
```

## Files Description
- **src/Main.java**: Entry point of the application. Initializes the game and starts the Tic Tac Toe logic.
- **src/game/Board.java**: Manages the game board with methods to initialize, print, validate moves, and update the board.
- **src/game/Player.java**: Represents a player with properties for name and symbol, along with methods to retrieve this information.
- **src/game/TicTacToe.java**: Contains the main game logic, including methods to start the game, check for a win, and switch players.
- **src/utils/InputHandler.java**: Manages user input, providing methods to read and validate input from the console.

## How to Run the Game
1. Ensure you have Java Development Kit (JDK) installed on your machine.
2. Clone the repository or download the project files.
3. Navigate to the project directory in your terminal.
4. Compile the Java files using the command:
   ```
   javac src/Main.java src/game/*.java src/utils/*.java
   ```
5. Run the game with the command:
   ```
   java src/Main
   ```

Enjoy playing Tic Tac Toe!