package com.project.game.ticTacToe;

import javax.swing.*;
import java.awt.*;

/*
issues : setBoard method implementation is wrong ,correction is required.
*/

public class UltimateGameLogic extends UltimateGamePanel {
    static boolean isFirstTurn = true;
    static int maxTurn = 0;
    static int prevCell;
    static String playerX = "X";
    static String playerO = "O";

    public static void gameStarted(JButton cell) {
        if (gameOver) {
            return;
        }

        if (getIndex(cell) == prevCell || isFirstTurn) {
            if (isFirstTurn){
                isFirstTurn = false;
            }
            if (cell.getText().isEmpty()) {
                cell.setText(currentPlayer);
                prevCell = (int) cell.getClientProperty("k");
                checkBoard(cell);
                if (!gameOver) {
                    currentPlayer = currentPlayer.equals(playerX) ? playerO : playerX;
                    label.setText(currentPlayer + "'s turn");
                }
                //cell.getParent().repaint();
            }
        }
    }

    public static int getIndex(JButton cell) {
        JPanel parentBoard = (JPanel) cell.getParent();
        int row = (int) parentBoard.getClientProperty("i");
        int col = (int) parentBoard.getClientProperty("j");

        return ((row * 3) + col);
    }

    public static void checkBoard(JButton cell) {
        try {
            JPanel parentBoard = (JPanel) cell.getParent();
            int row = (int) parentBoard.getClientProperty("i");
            int col = (int) parentBoard.getClientProperty("j");

            //horizontal check
            for (int i = 0; i < 9; i = i + 3) {
                try {
                    System.out.println("\ncontrol is in checkboard and horizon loop "+i);

                    if (buttons[row][col][i % 3].getText().isEmpty()) continue;

                    if ((buttons[row][col][i].getText().equals(buttons[row][col][i + 1].getText())) && (buttons[row][col][i + 1].getText().equals(buttons[row][col][i + 2].getText()))) {
                        System.out.println("\ncontrol is in checkboard and horizon loop and in cond");
                        setBoard(parentBoard);
                    }
                } catch (Exception e) {
                    System.out.println("\n" + e.getMessage());
                }
            }

            //vertical check
            for (int i = 0; i < 3; i++) {
                try {
                    System.out.println("\ncontrol is in checkboard and vert loop "+i);

                    if (buttons[row][col][i].getText().isEmpty()) continue;

                    if (buttons[row][col][i].getText().equals(buttons[row][col][i + 3].getText()) &&
                            buttons[row][col][i + 3].getText().equals(buttons[row][col][i + 6].getText())) {
                        System.out.println("\ncontrol is in checkboard and vert loop and in cond");
                        setBoard(parentBoard);
                    }
                } catch (Exception e) {
                    System.out.println("\n" + e.getMessage());
                }
            }

            try {
                System.out.println("\ncontrol is in checkboard and digon");

                //diagonal check
                if ((buttons[row][col][0].getText().equals(buttons[row][col][4].getText())) &&
                        (buttons[row][col][4].getText().equals(buttons[row][col][8].getText())) &&
                        (!buttons[row][col][0].getText().isEmpty())) {
                    System.out.println("\ncontrol is in checkboard and digon and in cond");
                    setBoard(parentBoard);
                }
            } catch (Exception e) {
                System.out.println("\n" + e.getMessage());
            }

            try {
                System.out.println("\ncontrol is in checkboard and anti-digon");

                //anti-diagonal check
                if ((buttons[row][col][2].getText().equals(buttons[row][col][4].getText())) &&
                        (buttons[row][col][4].getText().equals(buttons[row][col][6].getText())) &&
                        (!buttons[row][col][2].getText().isEmpty())) {
                    System.out.println("\ncontrol is in checkboard and anti-digon and in cond");
                    setBoard(parentBoard);
                }
            } catch (Exception e) {
                System.out.println("\n" + e.getMessage());
            }

            try {
                //tie check
                for (int i = 0; i < 9; i++) {
                    if (buttons[row][col][i].getText().isEmpty()) break;
                    else {
                        JLabel boardLabel = new JLabel();
                        boardLabel.setBackground(Color.GRAY);
                        boardLabel.setForeground(Color.ORANGE);
                        boardLabel.setFont(new Font("Arial", Font.BOLD, 120));
                        boardLabel.setText("-");
                        parentBoard.add(boardLabel);
                        parentBoard.putClientProperty("winner", "tie");
                    }
                }
            } catch (Exception e) {
                System.out.println("\n" + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println(e.getCause() + " __checkboard__ " + e.getMessage());
        }
    }

    public static void setBoard(JPanel board) {
        if (board == null){
            System.out.println("board is null");
            return;
        }

        try {
            System.out.println("\ncontrol is in setboard");
            Dimension boardSize = board.getSize();
            //board.removeAll();

            JLabel boardLabel = new JLabel(currentPlayer,SwingConstants.CENTER);
            label.setPreferredSize(boardSize);
            boardLabel.setBackground(Color.GRAY);
            boardLabel.setForeground(Color.GREEN);
            boardLabel.setFont(new Font("Arial", Font.BOLD, 120));
            //boardLabel.setLocation(null);

            board.setLayout(new OverlayLayout(board));
            board.add(boardLabel,0);
            board.revalidate();
            board.repaint();

            board.putClientProperty("winner", currentPlayer);
            maxTurn++;
            checkWinner();
        } catch (Exception e) {
            System.out.println(e.getCause() + " " + e.getMessage());
        }
    }

    public static void checkWinner() {
        try {
            //horizontal check
            for (int r = 0; r < 3; r++) {
                if ((smallBoards[r][0].getClientProperty("winner") == "no") ||
                        (smallBoards[r][0].getClientProperty("winner") == "tie")) continue;

                if ((smallBoards[r][0].getClientProperty("winner") == smallBoards[r][1].getClientProperty("winner")) &&
                        (smallBoards[r][1].getClientProperty("winner") == smallBoards[r][2].getClientProperty("winner"))) {
                    for (int i = 0; i < 3; i++) {
                        setWinner();
                    }
                }
            }

            //vertical check
            for (int c = 0; c < 3; c++) {
                if ((smallBoards[0][c].getClientProperty("winner") == "no") ||
                        (smallBoards[0][c].getClientProperty("winner") == "tie")) continue;

                if ((smallBoards[0][c].getClientProperty("winner") == smallBoards[1][c].getClientProperty("winner")) &&
                        (smallBoards[1][c].getClientProperty("winner") == smallBoards[2][c].getClientProperty("winner"))) {
                    for (int i = 0; i < 3; i++) {
                        setWinner();
                    }
                }
            }

            //diagonal check
            if (((smallBoards[0][0].getClientProperty("winner") != "no") ||
                    (smallBoards[0][0].getClientProperty("winner") == "tie")) &&
                    (smallBoards[0][0].getClientProperty("winner") == smallBoards[1][1].getClientProperty("winner")) &&
                    (smallBoards[1][1].getClientProperty("winner") == smallBoards[2][2].getClientProperty("winner"))) {
                setWinner();

            }

            //anti-diagonal check
            if (((smallBoards[0][2].getClientProperty("winner") != "no") ||
                    (smallBoards[0][2].getClientProperty("winner") == "tie")) &&
                    (smallBoards[0][2].getClientProperty("winner") == smallBoards[1][1].getClientProperty("winner")) &&
                    (smallBoards[1][1].getClientProperty("winner") == smallBoards[2][0].getClientProperty("winner"))) {
                setWinner();
            }

            //tie check
            if (maxTurn == 9) {
                gameOver = true;
                label.setText("It's a Tie!");
                new GameEndPanel(currentPlayer);
            }
        } catch (Exception e) {
            System.out.println(e.getCause() + " __setboard__ " + e.getMessage());
        }
    }

    public static void setWinner() {
        gameOver = true;
        label.setText(currentPlayer + " is Winner!");
    }
}
