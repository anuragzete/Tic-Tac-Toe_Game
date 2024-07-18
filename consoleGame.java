package tic_tac_toe;

import java.util.*;

public class consoleGame {
    static boolean gameOver = false;
    final static int maxDepth = 5;
    static boolean isEasy;
    static int turns = 0;
    static char playerX = 'X';
    static char playerO = 'O';
    static char currentPlayer;
    static char player;
    static char computer;
    static int userInput;
    char[][] board;

    consoleGame() {
        board = new char[3][3];
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                board[r][c] = ' ';
            }
        }
        System.out.println("Tic Tac Toe");
        System.out.println("============");
        startGame();
    }

    public void initializeBoard() {
        int idx = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + idx + " ");
                idx++;
                if (j < 2) {
                    System.out.print("|");
                }
                if (i < 2 && j == 2) {
                    System.out.println("\n---+---+---");
                }
            }
        }
        System.out.println("\n-------------");
    }

    public void updateBoard(int row, int col) {
        board[row][col] = currentPlayer;
        int idx = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    System.out.print(" " + idx + " ");
                } else {
                    System.out.print(" " + board[i][j] + " ");
                }
                idx++;
                if (j < 2) {
                    System.out.print("|");
                }
                if (i < 2 && j == 2) {
                    System.out.println("\n---+---+---");
                }
            }
        }
        System.out.println("\n-------------");
    }

    public void startGame() {
        Scanner inp = new Scanner(System.in);
        int selectedMode;
        int selectDifficulty;

        System.out.println("Select mode\n1] Players\n2] Computer");
        selectedMode = inp.nextInt();
        if (selectedMode == 2) {
            System.out.println("Select difficulty level\n1] Easy\n2] Hard");
            selectDifficulty = inp.nextInt();
            selectPlayer(inp);
            if (selectDifficulty == 1) {
                isEasy = true;
                botMode();
            } else if (selectDifficulty == 2) {
                isEasy = false;
                botMode();
            } else {
                System.out.println("Please enter a valid difficulty level");
            }
        } else if (selectedMode == 1) {
            selectPlayer(inp);
            initializeBoard();
            playerMode();
        } else {
            System.out.println("Please, select a valid mode");
        }
    }

    public void selectPlayer(Scanner inp) {
        System.out.println("Select Player X or O\n1] Player X\n2] Player O");
        userInput = inp.nextInt();
        if (userInput == 1) {
            currentPlayer = playerX;
        } else if (userInput == 2) {
            currentPlayer = playerO;
        } else {
            System.out.println("Please enter a valid player");
        }
    }

    public void playerMode() {
        Scanner inp = new Scanner(System.in);
        int row = -1;
        int col = -1;

        System.out.println("Player " + currentPlayer + "'s turn");
        System.out.print("Select cell number :");
        userInput = inp.nextInt();

        if (userInput > 0 && userInput < 10) {
            row = (userInput - 1) / 3;
            col = (userInput - 1) % 3;
        } else {
            System.out.println("Sorry, out of bound input");
            playerMode();
        }
        if (board[row][col] == ' ') {
            updateBoard(row, col);
            turns++;
            checkWinner();
            if (!gameOver) {
                currentPlayer = currentPlayer == playerX ? playerO : playerX;
                playerMode();
            }
        } else {
            System.out.println("Sorry, invalid cell number");
            playerMode();
        }
    }

    public void botMode() {
        initializeBoard();
        if (currentPlayer == playerX) {
            player = playerX;
            computer = playerO;
            playerTurn();
        } else if (currentPlayer == playerO) {
            player = playerO;
            computer = playerX;
            playerTurn();
        }
    }

    public void easyBotTurn() {
        Random rand = new Random();
        int row = rand.nextInt(3);
        int col = rand.nextInt(3);

        if (board[row][col] == ' ') {
            System.out.println("Computer's turn");
            updateBoard(row, col);
            turns++;
            checkWinner();
            if (!gameOver) {
                currentPlayer = player;
                playerTurn();
            }
        } else {
            easyBotTurn();
        }
    }

    public void playerTurn() {
        Scanner inp = new Scanner(System.in);
        int row = Integer.MIN_VALUE;
        int col = Integer.MIN_VALUE;

        System.out.println("Your turn");
        System.out.print("Select cell number :");
        userInput = inp.nextInt();

        if (userInput > 0 && userInput < 10) {
            row = (userInput - 1) / 3;
            col = (userInput - 1) % 3;
        } else {
            System.out.println("Sorry, out of bound input");
            playerTurn();
        }
        if (board[row][col] == ' ') {
            updateBoard(row, col);
            turns++;
            checkWinner();
            if (!gameOver) {
                currentPlayer = computer;
                if (isEasy) {
                    easyBotTurn();
                } else {
                    hardBotTurn();
                }
            }
        } else {
            System.out.println("Sorry, invalid cell number");
            playerTurn();
        }
    }

    public void hardBotTurn() {
        System.out.println("Computer's turn");
        int move = minimax(currentPlayer, 0);

        if (move >= 1 && move <= 9) {
            int row = (move - 1) / 3;
            int col = (move - 1) % 3;
            updateBoard(row, col);
            turns++;
            checkWinner();
            if (!gameOver) {
                currentPlayer = player;
                playerTurn();
            }
        } else {
            System.out.println("Invalid move value from minimax : " + move);
        }
    }

    public char checkWinner() {
        //horizontal check
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == ' ') continue;
            if (board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                gameOver = true;
                setWinner();
            }
        }

        //vertical check
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == ' ') continue;
            if (board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
                gameOver = true;
                setWinner();
            }
        }

        //diagonal check
        if (board[0][0] != ' ' || board[0][2] != ' ') {
            if (board[0][0] == board[1][1] && board[0][0] == board[2][2] ||
                    board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
                gameOver = true;
                setWinner();
            }
        }

        //tie check
        if (turns == 9) {
            gameOver = true;
            System.out.println("It's a tie!");
            System.out.println("==================================");
            return ' ';
        }

        return currentPlayer;
    }

    public void setWinner() {
        System.out.println(currentPlayer + " is the Winner!");
        System.out.println("==================================");
    }


    // Minimax algorithm
    public int minimax(char currentPlayer, int depth) {
        if (checkWinner() == computer) {
            return 1;
        } else if (checkWinner() == player) {
            return -1;
        } else if (checkWinner() == ' ' || depth > maxDepth) {
            return 0;
        }

        int bestScore = (currentPlayer == computer) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r][c] == ' ') {
                    board[r][c] = currentPlayer;
                    int score = minimax((currentPlayer == player) ? computer : player, depth++);
                    board[r][c] = ' ';

                    if (currentPlayer == player) {
                        bestScore = Math.max(bestScore, score);
                    } else {
                        bestScore = Math.min(bestScore, score);
                    }
                }
            }
        }
        return bestScore;
    }
}
