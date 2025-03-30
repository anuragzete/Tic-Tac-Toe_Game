# 🎯 Tic-Tac-Toe Game

Welcome to the **Tic-Tac-Toe Game**, featuring both **Classic** and **Ultimate** modes, with **bot player support** powered by the **Minimax algorithm**. 🤖✨

---

## 🚀 Features

### 🎲 **Game Modes**
- **Classic Mode:**
    - Traditional **3x3 grid** Tic-Tac-Toe.
    - Supports **2 players** or **1 player vs Bot**.
- **Ultimate Mode:**
    - A **3x3 grid of mini Tic-Tac-Toe boards** (totaling **9 mini boards**).
    - Each mini board behaves like a regular Tic-Tac-Toe board.
    - The winner of a mini board claims the corresponding cell in the larger board.
    - The first player to form a line (horizontally, vertically, or diagonally) on the larger board wins.

### 🤖 **Bot Player with Minimax Algorithm**
- **Smart AI** opponent using the **Minimax algorithm**.
- Challenges players with optimal moves.
- Ensures **unpredictable gameplay** and a competitive challenge.

### 🔥 **Future Enhancements**
- **Real-time Multiplayer**:
    - Play with friends over the internet using **WebSockets**.
- **Undo/Redo Moves**:
    - Enhance the user experience with the ability to revert or redo moves.
- **Leaderboard and Statistics**:
    - Track win/loss records and player stats.

---

## 🛠️ Tech Stack

- **Java** for core logic and game management.
- **JavaFX** or **Swing** for the graphical user interface.
- **Minimax algorithm** for bot decision-making.
- Future multiplayer mode: **WebSockets** for real-time communication.

---

## 💻 How to Run Locally

1. Clone the repository:
```bash
$ git clone https://github.com/anuragzete/Tic-Tac-Toe_Game.git
```
2. Compile the Java files:
```bash
$ javac -d out src/main/java/com/project/game/*.java
```
```bash
$ javac -d out src/main/java/com/project/game/ticTacToe/*.java
```
3. Run the game:
```bash
$ java -cp out com.project.game.Main
```

---

## 🎯 Game Rules

### ✅ **Classic Mode**
- Two players take turns marking cells on the **3x3 grid**.
- The first player to form a line (horizontally, vertically, or diagonally) wins.

### 🔥 **Ultimate Mode**
- The game board consists of **9 mini Tic-Tac-Toe boards** arranged in a **3x3 grid**.
- Players make moves on the mini boards.
- The winner of a mini board claims the larger cell.
- The first player to form a line on the larger board wins.

---

## 📚 Folder Structure

```plaintext
/tic-tac-toe
 ├── src
 │     ├── com/project/game  
 │     │     ├── Main.java        # Main entry point
 │     │     ├── ticTacToe        # Game logic and UI components
 │     └── resources              # Assets and game resources
 ├── README.md
 ├── LICENSE
 └── docs                         # Javadoc documentation
```

---

## 🔥 GitHub Release

You can download the **Tic-Tac-Toe Game JAR file** from the **GitHub Releases** section:
[Download Latest Release](https://github.com/anuragzete/Tic-Tac-Toe_Game/releases/tag/v1.0.1)

---

## ⚖️ License

This project is licensed under the **MIT License**. Feel free to use, modify, and distribute it.

---

## 🔥 Contributing

Feel free to raise issues, suggest improvements, and submit pull requests.

---

## 📧 Contact

- **Email:** anuragzete27@outlook.com
- **Portfolio:** [Anurag Zete](https://portfolio-anuragzete.web.app)

---

🚀 **Enjoy the game!** 🎉

