package tic_tac_toe;

import javax.swing.*;
import java.awt.*;

public class normalGameLogic extends classicGamePanel {

    static int turns = 0;
    static boolean botPlayed = true;

    public static void gameStarted(JButton cell) {
        if (gameOver) {
            return;
        }
        if (cell.getText().isEmpty()) {
            System.out.println("in cell.empty for player " + currentPlayer);
            turns++;
            cell.setText(currentPlayer);
            checkWinner();
            if (!gameOver) {
                currentPlayer = currentPlayer.equals(playerX) ? playerO : playerX;
                label.setText(currentPlayer + "'s turn");
                if (!homePanel.isPlayer) {
                    if (homePanel.isEasy) {
                        System.out.println("before easymode is called");
                        botPlayed = !botPlayed;
                        gameBot.easyMode();
                    } else {
                        //ai integration
                    }
                }
            }
        }
    }


    public static void checkWinner() {
        //check winner
        infiniteGameLogic.checkWinner();

        //tie check
        if (turns == 9) {
            gameOver = true;
            label.setText("It's a Tie!");
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    board[r][c].setBackground(Color.gray);
                    board[r][c].setForeground(Color.orange);
                }
            }
        }
    }
}