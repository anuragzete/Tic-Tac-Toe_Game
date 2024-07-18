package tic_tac_toe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ultimateGamePanel extends JPanel {
    JPanel[][] smallBoards;
    JButton[][][] buttons;
    JPanel boardPanel = new JPanel();

    public ultimateGamePanel() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(ticTacToe.WIDTH, (ticTacToe.HEIGHT - 70)));
        this.setBackground(new Color(28, 28, 28));
        this.setFocusable(true);

        boardPanel.setLayout(new GridLayout(3, 3));
        this.add(boardPanel);
        smallBoards = new JPanel[3][3];
        buttons = new JButton[3][3][9];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                smallBoards[i][j] = new JPanel(new GridLayout(3, 3));
                boardPanel.add(smallBoards[i][j]);

                for (int k = 0; k < 9; k++) {
                    JButton cell = new JButton();
                    buttons[i][j][k] = cell;
                    smallBoards[i][j].add(cell);
                    cell.setBackground(new Color(32, 32, 32));
                    cell.setForeground(Color.white);
                    cell.setFont(new Font("Arial", Font.BOLD, 120));

                    cell.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            JButton cell = (JButton) e.getSource();
                            new ultimateGameLogic(cell);
                        }
                    });
                }
            }
        }
    }




}
