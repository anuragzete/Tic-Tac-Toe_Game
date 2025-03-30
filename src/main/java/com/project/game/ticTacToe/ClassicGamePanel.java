package com.project.game.ticTacToe;

import com.project.game.Main;

import javax.swing.*;
import java.awt.*;

public class ClassicGamePanel extends JPanel {
    static JPanel boardPanel = new JPanel();
    static JButton[][] board = new JButton[3][3];
    static boolean gameOver = false;
    static String playerX = "X";
    static String playerO = "O";
    static String currentPlayer = HomePanel.currentPlayer;
    static JLabel label = Main.nameLabel;
    //gameBot bot;

    ClassicGamePanel() {
        //bot = new gameBot(this);
        this.setPreferredSize(new Dimension(Main.WIDTH, (Main.HEIGHT - 70)));
        this.setBackground(new Color(28, 28, 28));
        this.setFocusable(true);
        this.setLayout(new BorderLayout());

        boardPanel.setLayout(new GridLayout(3, 3));
        this.add(boardPanel);
        label.setText(currentPlayer + "'s turn");

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                JButton cell = new JButton();
                board[r][c] = cell;
                cell.putClientProperty("row",r);
                cell.putClientProperty("col",c);
                boardPanel.add(cell);
                cell.setBackground(new Color(32, 32, 32));
                cell.setForeground(Color.white);
                cell.setFont(new Font("Arial", Font.BOLD, 120));

                cell.addActionListener(e -> {
                    JButton cell1 = (JButton) e.getSource();
                    if (HomePanel.isNormal){
                        NormalGameLogic.gameStarted(cell1);
                    }else {
                        InfiniteGameLogic.gameStarted(cell1);
                    }
                });



            }
        }

        /*if (gameOver) {
            ticTacToe.frame.remove(this);
            ticTacToe.frame.validate();
            ticTacToe.frame.add(new gameEndPanel(currentPlayer));
            ticTacToe.frame.pack();
        }*/
    }

}



