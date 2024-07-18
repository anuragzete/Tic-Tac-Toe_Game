package tic_tac_toe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class classicGamePanel extends JPanel {
    static JPanel boardPanel = new JPanel();
    static JButton[][] board = new JButton[3][3];
    //gameBot bot;

    classicGamePanel() {
        //bot = new gameBot(this);
        this.setPreferredSize(new Dimension(ticTacToe.WIDTH, (ticTacToe.HEIGHT - 70)));
        this.setBackground(new Color(28, 28, 28));
        this.setFocusable(true);
        this.setLayout(new BorderLayout());

        boardPanel.setLayout(new GridLayout(3, 3));
        this.add(boardPanel);


        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                JButton cell = new JButton();
                board[r][c] = cell;
                boardPanel.add(cell);
                cell.setBackground(new Color(32, 32, 32));
                cell.setForeground(Color.white);
                cell.setFont(new Font("Arial", Font.BOLD, 120));

                cell.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton cell = (JButton) e.getSource();
                        if (homePanel.isNormal){
                            normalGameLogic.gameStarted(cell);
                        }else {
                            infiniteGameLogic.gameStarted(cell);
                        }
                    }
                });
            }
        }
    }



}



