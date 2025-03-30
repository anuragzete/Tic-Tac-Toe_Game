package com.project.game.ticTacToe;

import com.project.game.Main;

import javax.swing.*;
import java.awt.*;

/*
Issues : this panel implimentation is complete but only invocation logic is remaining in
    both classic panel and ultimate panel
*/

public class GameEndPanel extends JPanel {
    JLabel label = new JLabel();
    JButton restart = new JButton();
    JButton exit = new JButton();
    Container buttonHolder = new Container();
    GridBagConstraints gbc = new GridBagConstraints();

    GameEndPanel(String player) {
        this.setPreferredSize(new Dimension(Main.WIDTH, (Main.HEIGHT - 70)));
        this.setBackground(new Color(25, 25, 25));
        this.setLayout(new BorderLayout());

        label.setPreferredSize(new Dimension(Main.WIDTH, 150));
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 50));
        label.setText(player + " is Winner!");
        label.setHorizontalAlignment(JLabel.CENTER);

        restart.setBackground(new Color(32, 32, 32));
        exit.setBackground(new Color(32, 32, 32));
        restart.setPreferredSize(new Dimension(150, 100));
        exit.setPreferredSize(new Dimension(150, 100));
        restart.setFont(new Font("Arial", Font.BOLD, 25));
        exit.setFont(new Font("Arial", Font.BOLD, 25));
        restart.setForeground(Color.white);
        exit.setForeground(Color.white);
        restart.setText("Restart");
        exit.setText("Exit");

        buttonHolder.setBackground(new Color(26, 26, 26));
        buttonHolder.setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 50, 0);
        buttonHolder.add(restart, gbc);
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 70, 0);
        buttonHolder.add(exit, gbc);

        this.add(label, BorderLayout.NORTH);
        this.add(buttonHolder, BorderLayout.CENTER);

        restart.addActionListener(e -> {
            Main.frame.remove(this);
            Main.frame.validate();

            Main.frame.pack();
        });

        exit.addActionListener(e -> {
            Main.frame.remove(this);
            Main.frame.validate();
            Main.frame.add(new HomePanel());
            Main.frame.pack();
        });
    }
}
