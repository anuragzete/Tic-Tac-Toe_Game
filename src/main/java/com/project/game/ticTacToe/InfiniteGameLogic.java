package com.project.game.ticTacToe;

import javax.swing.*;
import java.awt.*;

public class InfiniteGameLogic extends ClassicGamePanel {

    static int turnX = 0;
    static int turnO = 0;
    static int[][] movePosX = new int[3][2];
    static int[][] movePosO = new int[3][2];

    public static void gameStarted(JButton cell) {
        if (gameOver) {
            return;
        }

        int idxX = turnX % 3;
        int idxO = turnO % 3;
        if (cell.getText().isEmpty()) {
            if (turnX >= 3 || turnO >= 3) {
                if (currentPlayer.equals(playerX)) {
                    int oldRow = movePosX[idxX][0];
                    int oldCol = movePosX[idxX][1];
                    movePosX[idxX][0] = (int) cell.getClientProperty("row");
                    movePosX[idxX][1] = (int) cell.getClientProperty("col");

                    for (int r = 0; r < 3; r++) {
                        for (int c = 0; c < 3; c++) {
                            if (board[r][c].getText().equals(currentPlayer)) {
                                if (r == oldRow && c == oldCol) {
                                    board[r][c].setText("");
                                }
                            }
                        }
                    }
                } else if (currentPlayer.equals(playerO)) {
                    int oldRow = movePosO[idxO][0];
                    int oldCol = movePosO[idxO][1];
                    movePosO[idxO][0] = (int) cell.getClientProperty("row");
                    movePosO[idxO][1] = (int) cell.getClientProperty("col");

                    for (int r = 0; r < 3; r++) {
                        for (int c = 0; c < 3; c++) {
                            if (board[r][c].getText().equals(currentPlayer)) {
                                if (r == oldRow && c == oldCol) {
                                    board[r][c].setText("");
                                }
                            }
                        }
                    }
                }
            }

            if (currentPlayer.equals(playerX)) {
                movePosX[idxX][0] = (int) cell.getClientProperty("row");
                movePosX[idxX][1] = (int) cell.getClientProperty("col");
                turnX++;
            } else if (currentPlayer.equals(playerO)) {
                movePosO[idxO][0] = (int) cell.getClientProperty("row");
                movePosO[idxO][1] = (int) cell.getClientProperty("col");
                turnO++;
            }
            cell.setText(currentPlayer);
            checkWinner();
            if (!gameOver) {
                currentPlayer = currentPlayer.equals(playerX) ? playerO : playerX;
                label.setText(currentPlayer + "'s turn");
            }
        }
    }


    public static void checkWinner() {
        //horizontal check
        for (int r = 0; r < 3; r++) {
            if (board[r][0].getText().isEmpty()) continue;

            if (board[r][0].getText().equals(board[r][1].getText()) && board[r][1].getText().equals(board[r][2].getText())) {
                for (int i = 0; i < 3; i++) {
                    setWinner(board[r][i]);
                }
            }
        }

        //vertical check
        for (int c = 0; c < 3; c++) {
            if (board[0][c].getText().isEmpty()) continue;

            if (board[0][c].getText().equals(board[1][c].getText()) && board[1][c].getText().equals(board[2][c].getText())) {
                for (int i = 0; i < 3; i++) {
                    setWinner(board[i][c]);
                }
            }
        }

        //diagonal check
        if (board[0][0].getText().equals(board[1][1].getText()) && board[1][1].getText().equals(board[2][2].getText()) && !board[0][0].getText().isEmpty()) {
            setWinner(board[0][0]);
            setWinner(board[1][1]);
            setWinner(board[2][2]);
        }

        //anti-diagonal check
        if (board[0][2].getText().equals(board[1][1].getText()) && board[1][1].getText().equals(board[2][0].getText()) && !board[0][2].getText().isEmpty()) {
            setWinner(board[0][2]);
            setWinner(board[1][1]);
            setWinner(board[2][0]);
        }
    }

    public static void setWinner(JButton cell) {
        cell.setBackground(Color.gray);
        cell.setForeground(Color.green);
        gameOver = true;
        label.setText(currentPlayer + " is Winner!");
    }
}