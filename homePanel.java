package tic_tac_toe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class homePanel extends JPanel {
    static int clickCount = 1;
    static boolean isClassic;
    static boolean isEasy;
    static boolean isPlayer;
    static boolean isNormal = true;
    static String currentPlayer = "X";

    JLabel label = new JLabel();
    JButton btn1 = new JButton();
    JButton btn2 = new JButton();
    Container buttonHolder = new Container();
    GridBagConstraints gbc = new GridBagConstraints();

    homePanel() {
        this.setPreferredSize(new Dimension(ticTacToe.WIDTH, (ticTacToe.HEIGHT - 70)));
        this.setBackground(new Color(25, 25, 25));
        this.setLayout(new BorderLayout());

        label.setForeground(Color.white);
        label.setFont(new Font("Arial", Font.BOLD, 50));
        label.setPreferredSize(new Dimension(ticTacToe.WIDTH, 150));
        label.setText("Select the type");
        label.setHorizontalAlignment(SwingConstants.CENTER);


        btn1.setBackground(new Color(32, 32, 32));
        btn2.setBackground(new Color(32, 32, 32));
        btn1.setPreferredSize(new Dimension(150, 100));
        btn2.setPreferredSize(new Dimension(150, 100));
        btn1.setFont(new Font("Arial", Font.BOLD, 25));
        btn2.setFont(new Font("Arial", Font.BOLD, 25));
        btn1.setForeground(Color.white);
        btn2.setForeground(Color.white);
        btn1.setText("Classic");
        btn2.setText("Ultimate");

        buttonHolder.setBackground(new Color(26, 26, 26));
        buttonHolder.setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 50, 0);
        buttonHolder.add(btn1, gbc);
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 70, 0);
        buttonHolder.add(btn2, gbc);

        this.add(label, BorderLayout.NORTH);
        this.add(buttonHolder, BorderLayout.CENTER);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (clickCount) {
                    case 1:
                        isClassic = true;
                        label.setText("Select the Opponent");
                        btn1.setText("Player");
                        btn2.setText("Computer");
                        clickCount++;
                        break;
                    case 2:
                        isPlayer = true;
                        label.setText("Select Game Mode");
                        btn1.setText("Normal");
                        btn2.setText("Infinite");
                        clickCount++;
                        break;
                    case 3:
                        isNormal = true;
                        isEasy = true;
                        playerType();
                        clickCount++;
                        break;
                    case 4:
                        currentPlayer = "X";
                        startGame();
                        break;
                }
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (clickCount) {
                    case 1:
                        isClassic = false;
                        playerType();
                        clickCount++;
                        break;
                    case 2:
                        if (isClassic){
                            isPlayer = false;
                            label.setText("Select Difficulty Level");
                            btn1.setText("Easy");
                            btn2.setText("Hard");
                            clickCount++;
                        }
                        else {
                        currentPlayer = "O";
                        startGame();
                        break;
                    }
                        break;
                    case 3:
                        if (!isPlayer){
                            isEasy = false;
                            isNormal = false;
                            playerType();
                            clickCount++;
                        }
                        break;
                    case 4:
                        currentPlayer = "O";
                        startGame();
                        break;
                }
            }
        });
    }

    public void playerType(){
        label.setText("Select the Player");
        btn1.setText("X");
        btn2.setText("O");
    }

    public void startGame(){
        ticTacToe.frame.remove(this);
        ticTacToe.frame.validate();

        if (!isClassic){
            ticTacToe.frame.add(new ultimateGamePanel());
        } else{
            ticTacToe.frame.add(new classicGamePanel());
        }

        ticTacToe.frame.pack();
    }
}
