package com.project.game;

import com.project.game.ticTacToe.HomePanel;

import javax.swing.*;
import java.awt.*;


public class Main {
    public static final int WIDTH = 700;
    public static final int HEIGHT = 770;
    public static JFrame frame = new JFrame();
    public static JLabel nameLabel = new JLabel();

    Main(){
        frame.setTitle("Tic Tac Toe");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        nameLabel.setBackground(new Color(28, 28, 28));
        nameLabel.setForeground(Color.green);
        nameLabel.setHorizontalAlignment(JLabel.CENTER);
        nameLabel.setText("Tic Tac Toe");
        nameLabel.setPreferredSize(new Dimension(WIDTH, (HEIGHT - WIDTH)));
        nameLabel.setFont(new Font("Arial", Font.BOLD, 30));
        nameLabel.setOpaque(true);
        frame.add(nameLabel, BorderLayout.NORTH);

        frame.add(new HomePanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        //consoleGame termin = new consoleGame();
        new Main();


    }
}
