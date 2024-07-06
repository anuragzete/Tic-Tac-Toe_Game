package Projects.tic_tac_toe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class gameLogic extends JPanel {

    static final int WIDTH = 600;
    static final int HEIGHT = 670;
    static boolean gameOver = false;
    static int turns = 0;
    String playerX = "X";
    String playerO = "O";
    String currentPlayer = "X";
    JLabel label = new JLabel();
    JPanel boardPanel = new JPanel();
    JButton[][] board = new JButton[3][3];
    gameBot bot;

    gameLogic() {
        bot = new gameBot(this);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(new Color(28, 28, 28));
        this.setFocusable(true);
        this.setLayout(new BorderLayout());

        label.setBackground(new Color(28, 28, 28));
        label.setForeground(Color.white);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setText("Tic Tac Toe");
        label.setPreferredSize(new Dimension(WIDTH, (HEIGHT - WIDTH)));
        label.setFont(new Font("Arial", Font.BOLD, 30));
        label.setOpaque(true);
        boardPanel.setLayout(new GridLayout(3, 3));
        this.add(label, BorderLayout.NORTH);
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
                        gameStarted(cell);
                    }
                });
            }
        }
    }


    public void gameStarted(JButton cell) {
        if (gameOver) {
            return;
        }
        if (cell.getText().isEmpty()) {
            turns++;
            cell.setText(currentPlayer);
            checkWinner();
            if (!gameOver) {
                currentPlayer = currentPlayer.equals(playerX) ? playerO : playerX;
                label.setText(currentPlayer + "'s turn");
                bot.easyMode();
            }
        }
    }


    public String checkWinner() {
        //horizontal check
        for (int r = 0; r < 3; r++) {
            if (board[r][0].getText().isEmpty()) continue;

            if (board[r][0].getText().equals(board[r][1].getText()) && board[r][1].getText().equals(board[r][2].getText())) {
                for (int i = 0; i < 3; i++) {
                    setWinner(board[r][i]);
                }
            }
        }

        //vertical check
        for (int c = 0; c < 3; c++) {
            if (board[0][c].getText().isEmpty()) continue;

            if (board[0][c].getText().equals(board[1][c].getText()) && board[1][c].getText().equals(board[2][c].getText())) {
                for (int i = 0; i < 3; i++) {
                    setWinner(board[i][c]);
                }
            }
        }

        //diagonal check
        if (board[0][0].getText().equals(board[1][1].getText()) && board[1][1].getText().equals(board[2][2].getText()) && board[0][0].getText() != "") {
            setWinner(board[0][0]);
            setWinner(board[1][1]);
            setWinner(board[2][2]);

        }

        //anti-diagonal check
        if (board[0][2].getText().equals(board[1][1].getText()) && board[1][1].getText().equals(board[2][0].getText()) && board[0][2].getText() != "") {
            setWinner(board[0][2]);
            setWinner(board[1][1]);
            setWinner(board[2][0]);

        }

        //tie check
        if (turns == 10) {
            gameOver = true;
            label.setText("It's a Tie!");
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    board[r][c].setBackground(Color.gray);
                    board[r][c].setForeground(Color.orange);
                }
            }
        }
        return currentPlayer;
    }

    public void setWinner(JButton cell) {
        cell.setBackground(Color.gray);
        cell.setForeground(Color.green);
        gameOver = true;
        label.setText(currentPlayer + " is Winner!");
    }
}



