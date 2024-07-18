package tic_tac_toe;

import javax.swing.*;
import java.awt.*;

public class gameEndPanel {
    JLabel major = new JLabel();
    JLabel minor = new JLabel();

    String player;

    gameEndPanel() {

        major.setForeground(Color.RED);
        major.setHorizontalAlignment(JLabel.CENTER);
        major.setText(player + " is Winner!");
        major.setPreferredSize(new Dimension(ticTacToe.WIDTH, 150));
        major.setFont(new Font("Arial", Font.BOLD, 30));
        major.setOpaque(true);

        minor.setForeground(Color.GRAY);
        minor.setHorizontalAlignment(JLabel.CENTER);
        minor.setText("Press ENTER to play again and ESC to exit.");
        minor.setPreferredSize(new Dimension(ticTacToe.WIDTH, 50));
        minor.setFont(new Font("Arial", Font.BOLD, 10));
        minor.setOpaque(true);

        ticTacToe.frame.setGlassPane(new JComponent() {
            public void paintComponent(Graphics g) {
                g.setColor(new Color(0, 0, 0, 100));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        });

        Container glassPane = (Container) ticTacToe.frame.getGlassPane();
        glassPane.setVisible(true);
        glassPane.setBackground(new Color(0, 0, 0, 150));
        glassPane.add(major);
        glassPane.add(minor);

        glassPane.setVisible(true);
    }
}
