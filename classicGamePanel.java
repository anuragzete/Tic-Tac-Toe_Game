package tic_tac_toe;

import javax.swing.*;
import java.awt.*;

public class classicGamePanel extends JPanel {
    static JPanel boardPanel = new JPanel();
    static JButton[][] board = new JButton[3][3];
    static boolean gameOver = false;
    static String playerX = "X";
    static String playerO = "O";
    static String currentPlayer = homePanel.currentPlayer;
    static JLabel label = ticTacToe.nameLabel;
    //gameBot bot;

    classicGamePanel() {
        //bot = new gameBot(this);
        this.setPreferredSize(new Dimension(ticTacToe.WIDTH, (ticTacToe.HEIGHT - 70)));
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
                    if (homePanel.isNormal){
                        normalGameLogic.gameStarted(cell1);
                    }else {
                        infiniteGameLogic.gameStarted(cell1);
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



