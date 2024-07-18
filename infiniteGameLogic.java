package tic_tac_toe;

import javax.swing.*;
import java.awt.*;

public class infiniteGameLogic extends classicGamePanel{

    static boolean gameOver = false;
    static int turnX = 0;
    static int turnY = 0;
    static String playerX = "X";
    static String playerO = "O";
    static String currentPlayer = homePanel.currentPlayer;
    static JLabel label = ticTacToe.nameLabel;
    static JButton[] cellPosX = new JButton[3];
    static JButton[] cellPosO = new JButton[3];

    public static void gameStarted(JButton cell) {
        if (gameOver) {
            return;
        }
        if (turnX == 3 || turnY == 3){
            if (currentPlayer.equals(playerX)) {
                turnX--;
            }else if (currentPlayer.equals(playerO)) {
                turnY--;
            }
        }

        if (turnX < 3 || turnY <3){
            if (cell.getText().isEmpty()) {
                if (currentPlayer.equals(playerX)) {
                    //cellPosX[0].;
                    turnX++;
                }else if (currentPlayer.equals(playerO)) {
                    turnY++;
                }
                cell.setText(currentPlayer);
                checkWinner();
                if (!gameOver) {
                    currentPlayer = currentPlayer.equals(playerX) ? playerO : playerX;
                    label.setText(currentPlayer + "'s turn");
                    //bot.easyMode();
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

        return currentPlayer;
    }

    public static void setWinner(JButton cell) {
        cell.setBackground(Color.gray);
        cell.setForeground(Color.green);
        gameOver = true;
        label.setText(currentPlayer + " is Winner!");
        new gameEndPanel();
    }
}