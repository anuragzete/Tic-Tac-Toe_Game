package tic_tac_toe;

import javax.swing.*;
import java.awt.*;

public class normalGameLogic extends classicGamePanel {

    static boolean gameOver = false;
    static int turns = 0;
    static String playerX = "X";
    static String playerO = "O";
    static String currentPlayer = homePanel.currentPlayer;
    static JLabel label = ticTacToe.nameLabel;
    static boolean botPlayed = true;

    public static void gameStarted(JButton cell) {
        if (gameOver) {
            return;
        }
        if (cell.getText().isEmpty()) {
            turns++;
            cell.setText(currentPlayer);
            checkWinner();
            if (!gameOver) {
                currentPlayer = currentPlayer.equals(playerX) ? playerO : playerX;
                label.setText(currentPlayer + "'s turn");
                if (!homePanel.isPlayer) {
                    if (homePanel.isEasy) {
                        botPlayed = !botPlayed;
                        gameBot.easyMode();
                    } else {
                        //ai integration
                    }
                }
            }
        }
    }


    public static String checkWinner() {
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
        if (board[0][0].getText().equals(board[1][1].getText()) && board[1][1].getText().equals(board[2][2].getText()) && board[0][0].getText() != "") {
            setWinner(board[0][0]);
            setWinner(board[1][1]);
            setWinner(board[2][2]);

        }

        //anti-diagonal check
        if (board[0][2].getText().equals(board[1][1].getText()) && board[1][1].getText().equals(board[2][0].getText()) && board[0][2].getText() != "") {
            setWinner(board[0][2]);
            setWinner(board[1][1]);
            setWinner(board[2][0]);

        }

        //tie check
        if (turns == 10) {
            gameOver = true;
            label.setText("It's a Tie!");
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    board[r][c].setBackground(Color.gray);
                    board[r][c].setForeground(Color.orange);
                }
            }
        }
        return currentPlayer;
    }

    public static void setWinner(JButton cell) {
        cell.setBackground(Color.gray);
        cell.setForeground(Color.green);
        gameOver = true;
        label.setText(currentPlayer + " is Winner!");
        //new gameEndPanel();
    }
}