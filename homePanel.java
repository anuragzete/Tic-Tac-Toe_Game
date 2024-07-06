package Projects.tic_tac_toe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class homePanel extends JPanel {

    static final int WIDTH = 600;
    static final int HEIGHT = 670;
    static boolean isselectIncomp = true;
    static int selectSteps = 0;
    boolean isClassic;
    boolean isEasy;
    boolean isPlayerMode;

    JLabel nameLabel = new JLabel();
    JLabel optionLabel = new JLabel();
    JButton fstButton = new JButton();
    JButton secButton = new JButton();
    JPanel containerPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel inGamePanel = new JPanel();
    GridBagConstraints gbc = new GridBagConstraints();

    homePanel() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(new Color(26, 26, 26));
        this.setFocusable(true);
        this.setLayout(new BorderLayout());

        nameLabel.setBackground(new Color(28, 28, 28));
        nameLabel.setForeground(Color.green);
        nameLabel.setHorizontalAlignment(JLabel.CENTER);
        nameLabel.setText("Tic Tac Toe");
        nameLabel.setPreferredSize(new Dimension(WIDTH, (HEIGHT - WIDTH)));
        nameLabel.setFont(new Font("Arial", Font.BOLD, 30));
        nameLabel.setOpaque(true);
        optionLabel.setBackground(new Color(26,26,26));
        optionLabel.setForeground(Color.white);
        optionLabel.setHorizontalAlignment(JLabel.CENTER);
        optionLabel.setText("Select Game Type");
        optionLabel.setPreferredSize(new Dimension(WIDTH, 150));
        optionLabel.setFont(new Font("Arial", Font.BOLD, 40));
        optionLabel.setOpaque(true);

        containerPanel.setLayout(new BorderLayout());
        containerPanel.add(nameLabel,BorderLayout.NORTH);
        containerPanel.add(optionLabel);

        while (isselectIncomp){

            fstButton.setBackground(new Color(32,32,32));
            secButton.setBackground(new Color(32,32,32));
            fstButton.setPreferredSize(new Dimension(200,125));
            secButton.setPreferredSize(new Dimension(200,125));
            fstButton.setFont(new Font("Arial", Font.BOLD, 30));
            secButton.setFont(new Font("Arial", Font.BOLD, 30));
            fstButton.setForeground(Color.white);
            secButton.setForeground(Color.white);
            fstButton.setText("Classic");
            secButton.setText("Ultimate");

            buttonPanel.setBackground(new Color(26,26,26));
            buttonPanel.setLayout(new GridBagLayout());
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(0, 0, 50, 0);
            buttonPanel.add(fstButton, gbc);
            gbc.gridy = 1;
            gbc.insets = new Insets(0, 0, 130, 0);
            buttonPanel.add(secButton, gbc);

            this.add(containerPanel, BorderLayout.NORTH);
            this.add(buttonPanel, BorderLayout.CENTER);

            fstButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    isselectIncomp = false;
                    new gameLogic();
                }
            });
        }
    }

    public void gameType(JButton but){

    }

    public void gameMode(){
        optionLabel.setText("Select Game Mode");
        fstButton.setText("Player");
        secButton.setText("Computer");
    }

    public void difficultyLevel(){
        optionLabel.setText("Select Difficulty Level");
        fstButton.setText("Easy");
        secButton.setText("Hard");
    }

    public void playerType(){
        optionLabel.setText("Select Player 1");
        fstButton.setText("X");
        secButton.setText("O");
    }
}
