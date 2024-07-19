package tic_tac_toe;

import javax.swing.*;
import java.awt.*;

/*
issues : game starts successfully but after one or two turns graphics collapses in respected board
        issue must be at checkboard or setboard.
*/

public class ultimateGameLogic extends ultimateGamePanel {
    static int minTurn = 0;
    static int maxTurn = 0;
    static int prevCell;
    static String playerX = "X";
    static String playerO = "O";

    public static void gameStarted(JButton cell) {
        if (gameOver) {
            return;
        }

        if (getIndex(cell) == prevCell || minTurn == 0) {
            if (cell.getText().isEmpty()) {
                minTurn++;
                cell.setText(currentPlayer);
                prevCell = (int) cell.getClientProperty("k");
                checkBoard(cell);
                if (!gameOver) {
                    currentPlayer = currentPlayer.equals(playerX) ? playerO : playerX;
                    label.setText(currentPlayer + "'s turn");
                }
                cell.getParent().repaint();
            }
        }
    }

    public static int getIndex(JButton cell) {
        JPanel parentBoard = (JPanel) cell.getParent();
        int row = (int) parentBoard.getClientProperty("i");
        int col = (int) parentBoard.getClientProperty("j");

        return ((row*3)+col);
    }

    public static void checkBoard(JButton cell) {
        JPanel parentBoard = (JPanel) cell.getParent();
        int row = (int) parentBoard.getClientProperty("i");
        int col = (int) parentBoard.getClientProperty("j");

        //horizontal check
        for (int i = 0; i < 3; i = i + 3) {
            if (buttons[row][col][i % 3].getText().isEmpty()) continue;

            if ((buttons[row][col][i].getText().equals(buttons[row][col][i + 1].getText())) && (buttons[row][col][i + 1].getText().equals(buttons[row][col][i + 2].getText()))) {
                setBoard(parentBoard);
            }
        }

        //vertical check
        for (int i = 0; i < 3; i++) {
            if (buttons[row][col][i].getText().isEmpty()) continue;

            if (buttons[row][col][i % 3].getText().equals(buttons[row][col][(i + 3) % 3].getText()) &&
                    buttons[row][col][(i + 3) % 3].getText().equals(buttons[row][col][(i + 6) % 3].getText())) {
                setBoard(parentBoard);
            }
        }

        //diagonal check
        if ((buttons[row][col][0].getText().equals(buttons[row][col][4].getText())) &&
                (buttons[row][col][4].getText().equals(buttons[row][col][8].getText())) &&
                (!buttons[row][col][0].getText().isEmpty())) {
            setBoard(parentBoard);
        }

        //anti-diagonal check
        if ((buttons[row][col][2].getText().equals(buttons[row][col][4].getText())) &&
                (buttons[row][col][4].getText().equals(buttons[row][col][6].getText())) &&
                (!buttons[row][col][2].getText().isEmpty())) {
            setBoard(parentBoard);
        }

        //tie check
        if (minTurn == 10) {
            JLabel boardLabel = new JLabel();
            boardLabel.setBackground(Color.GRAY);
            boardLabel.setForeground(Color.ORANGE);
            boardLabel.setFont(new Font("Arial", Font.BOLD, 120));
            boardLabel.setText("-");
            parentBoard.add(boardLabel);
            parentBoard.putClientProperty("winner",'t');
        }
    }

    public static void setBoard(JPanel board) {
        JLabel boardLabel = new JLabel();
        boardLabel.setBackground(Color.GRAY);
        boardLabel.setForeground(Color.GREEN);
        boardLabel.setFont(new Font("Arial", Font.BOLD, 120));
        boardLabel.setText(currentPlayer);
        board.add(boardLabel);
        board.putClientProperty("winner", currentPlayer);
        maxTurn++;
        checkWinner();
    }

    public static void checkWinner() {
        //horizontal check
        for (int r = 0; r < 3; r++) {
            if (((char) smallBoards[r][0].getClientProperty("winner") == 'n') ||
                    ((char) smallBoards[r][0].getClientProperty("winner") == 't')) continue;

            if (((char) smallBoards[r][0].getClientProperty("winner") == (char) smallBoards[r][1].getClientProperty("winner")) &&
                    ((char) smallBoards[r][1].getClientProperty("winner") == (char) smallBoards[r][2].getClientProperty("winner"))) {
                for (int i = 0; i < 3; i++) {
                    setWinner();
                }
            }
        }

        //vertical check
        for (int c = 0; c < 3; c++) {
            if (((char) smallBoards[0][c].getClientProperty("winner") == 'n') ||
                    ((char) smallBoards[0][c].getClientProperty("winner") == 't')) continue;

            if (((char) smallBoards[0][c].getClientProperty("winner") == (char) smallBoards[1][c].getClientProperty("winner")) &&
                    ((char) smallBoards[1][c].getClientProperty("winner") == (char) smallBoards[2][c].getClientProperty("winner"))) {
                for (int i = 0; i < 3; i++) {
                    setWinner();
                }
            }
        }

        //diagonal check
        if ((((char) smallBoards[0][0].getClientProperty("winner") != 'n') ||
                ((char) smallBoards[0][0].getClientProperty("winner") == 't')) &&
                ((char) smallBoards[0][0].getClientProperty("winner") == (char) smallBoards[1][1].getClientProperty("winner")) &&
                ((char) smallBoards[1][1].getClientProperty("winner") == (char) smallBoards[2][2].getClientProperty("winner"))) {
            setWinner();

        }

        //anti-diagonal check
        if ((((char) smallBoards[0][2].getClientProperty("winner") != 'n') ||
                ((char) smallBoards[0][2].getClientProperty("winner") == 't')) &&
                ((char) smallBoards[0][2].getClientProperty("winner") == (char) smallBoards[1][1].getClientProperty("winner")) &&
                ((char) smallBoards[1][1].getClientProperty("winner") == (char) smallBoards[2][0].getClientProperty("winner"))) {
            setWinner();
        }

        //tie check
        if (maxTurn == 10) {
            gameOver = true;
            label.setText("It's a Tie!");
            new gameEndPanel(currentPlayer);
        }
    }

    public static void setWinner() {
        gameOver = true;
        label.setText(currentPlayer + " is Winner!");
    }
}
