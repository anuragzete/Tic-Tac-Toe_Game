# DuoPlay — Tic-Tac-Toe Game

Welcome to DuoPlay, a Tic-Tac-Toe game featuring both Classic and Ultimate modes, with bot player support powered by the Minimax algorithm.

---

## Features

### Game Modes

* **Classic Mode:**

  * Traditional 3x3 grid Tic-Tac-Toe.
  * Supports 2 players or 1 player vs Bot.

* **Ultimate Mode:**

  * A 3x3 grid of mini Tic-Tac-Toe boards (total of 9 boards).
  * Each mini board behaves like a regular Tic-Tac-Toe board.
  * The winner of a mini board claims the corresponding cell in the larger board.
  * The first player to form a line (horizontal, vertical, or diagonal) on the larger board wins.

### Bot Player with Minimax Algorithm

* AI opponent using the Minimax algorithm.
* Plays optimal moves for competitive gameplay.

### Current Status

* UI implemented using Java Swing.
* Multiplayer server (Spring Boot + WebSockets) is under development.
* Currently supports only local gameplay.

### Future Enhancements

* Real-time multiplayer using WebSockets
* Undo/Redo moves
* Leaderboard and statistics tracking

---

## Tech Stack

* Java for core logic
* Java Swing for UI
* Minimax algorithm for AI
* Spring Boot (planned) for backend server
* WebSockets (planned) for real-time communication

---

## How to Run Locally

1. Clone the repository:

```bash
git clone https://github.com/anuragzete/Tic-Tac-Toe_Game.git
```

2. Compile the Java files:

```bash
javac -d out src/main/java/com/project/game/*.java
javac -d out src/main/java/com/project/game/ticTacToe/*.java
```

3. Run the game:

```bash
java -cp out com.project.game.Main
```

---

## Game Rules

### Classic Mode

* Two players take turns marking cells on a 3x3 grid.
* The first player to form a line (horizontal, vertical, or diagonal) wins.

### Ultimate Mode

* The board consists of 9 mini Tic-Tac-Toe boards arranged in a 3x3 grid.
* Players play on mini boards.
* The winner of a mini board claims the larger cell.
* The first player to form a line on the larger board wins.

---

## Folder Structure

```plaintext
/tic-tac-toe
 ├── src
 │     ├── com/project/game  
 │     │     ├── Main.java
 │     │     ├── ticTacToe
 │     └── resources
 ├── README.md
 ├── LICENSE
 └── docs
```

---

## GitHub Release

Download the JAR from GitHub Releases:
https://github.com/anuragzete/Tic-Tac-Toe_Game/releases/tag/v1.0.1

---

## License

This project is licensed under the MIT License.

---

## Contributing

Feel free to raise issues, suggest improvements, and submit pull requests.
