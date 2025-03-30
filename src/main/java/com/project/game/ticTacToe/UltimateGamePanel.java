package com.project.game.ticTacToe;

import com.project.game.Main;

import javax.swing.*;
import java.awt.*;

public class UltimateGamePanel extends JPanel {
    static String currentPlayer = HomePanel.currentPlayer;
    static JLabel label = Main.nameLabel;
    static boolean gameOver = false;

    static JPanel[][] smallBoards;
    static JButton[][][] buttons;
    JPanel boardPanel = new JPanel();

    public UltimateGamePanel() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(Main.WIDTH, (Main.HEIGHT - 70)));
        this.setBackground(new Color(28, 28, 28));
        this.setFocusable(true);

        boardPanel.setLayout(new GridLayout(3, 3));
        this.add(boardPanel);
        label.setText(currentPlayer + "'s turn");

        smallBoards = new JPanel[3][3];
        buttons = new JButton[3][3][9];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                smallBoards[i][j] = new JPanel(new GridLayout(3, 3));
                smallBoards[i][j].putClientProperty("i",i);
                smallBoards[i][j].putClientProperty("j",j);
                smallBoards[i][j].putClientProperty("winner","no");
                boardPanel.add(smallBoards[i][j]);

                for (int k = 0; k < 9; k++) {
                    JButton cell = new JButton();
                    buttons[i][j][k] = cell;
                    cell.putClientProperty("i",i);
                    cell.putClientProperty("j",j);
                    cell.putClientProperty("k",k);
                    smallBoards[i][j].add(cell);
                    cell.setBackground(new Color(32, 32, 32));
                    cell.setForeground(Color.white);
                    cell.setFont(new Font("Arial", Font.BOLD, 35));

                    cell.addActionListener(e -> {
                        JButton cell1 = (JButton) e.getSource();
                        UltimateGameLogic.gameStarted(cell1);
                    });
                }
            }
        }

        /*if (gameOver){
            ticTacToe.frame.remove(this);
            ticTacToe.frame.validate();
            ticTacToe.frame.add(new gameEndPanel(currentPlayer));
            ticTacToe.frame.pack();
        }*/
    }
}
