package tic_tac_toe;

import javax.swing.*;
import java.awt.*;

/*
Issues : this panel implimentation is complete but only invocation logic is remaining in
    both classic panel and ultimate panel
*/

public class gameEndPanel extends JPanel {
    JLabel label = new JLabel();
    JButton restart = new JButton();
    JButton exit = new JButton();
    Container buttonHolder = new Container();
    GridBagConstraints gbc = new GridBagConstraints();

    gameEndPanel(String player) {
        this.setPreferredSize(new Dimension(ticTacToe.WIDTH, (ticTacToe.HEIGHT - 70)));
        this.setBackground(new Color(25, 25, 25));
        this.setLayout(new BorderLayout());

        label.setPreferredSize(new Dimension(ticTacToe.WIDTH, 150));
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
            ticTacToe.frame.remove(this);
            ticTacToe.frame.validate();

            ticTacToe.frame.pack();
        });

        exit.addActionListener(e -> {
            ticTacToe.frame.remove(this);
            ticTacToe.frame.validate();
            ticTacToe.frame.add(new homePanel());
            ticTacToe.frame.pack();
        });
    }
}
