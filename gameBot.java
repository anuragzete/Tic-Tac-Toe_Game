package Projects.tic_tac_toe;

import java.util.*;

public class gameBot {
    gameLogic logic;
    static boolean botPlayed = false;

    gameBot(gameLogic logic) {
        this.logic = logic;
    }

    //easy mode
    public void easyMode() {
        Random rand = new Random();
        while (!botPlayed) {
            int row = rand.nextInt(3);
            int col = rand.nextInt(3);
            if (logic.board[row][col].getText() != "") {
                logic.turns++;
                logic.board[row][col].setText(logic.currentPlayer);
                botPlayed = true;
                logic.checkWinner();
                if (!logic.gameOver) {
                    logic.currentPlayer = logic.currentPlayer.equals(logic.playerX) ? logic.playerO : logic.playerX;
                    logic.label.setText(logic.currentPlayer + "'s turn");
                }
            }
        }
    }

    //hard mode
    /*
    void bestmove(){
        bestscore = -1000;
        move = -1,-1;

        for (int r = 0; r < ; r++) {
            for (int c = 0; c < ; c++) {
                if (board[r][c] == 0){
                    board[r][c] = plaver 2;
                    score = minimac(board,0,false)

                    board[r][c] =0;
                    if (score>bestscore){
                        bestscore=score
                                move = r,c
                    }
                }
            }
        }

        if move != -1,-1{
            marksquare(move0,move1,player 2)
            returm true;
        }
        reurn false;
    }


    // Minimax algorithm
    public int minimax(char currentPlayer) {
        if (logic.checkWinner().equals("X")) {
            return 1; // Player X wins
        } else if (logic.checkWinner().equals("O")) {
            return -1; // Player O wins
        } else if (logic.checkWinner().isEmpty()) {
            return 0; // It's a tie
        }

        int bestScore = (logic.currentPlayer.equals(logic.playerX)) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (logic.board[r][c].isEmpty()) {
                    logic.board[r][c] = currentPlayer;
                    int score = minimax((logic.currentPlayer.equals(logic.playerX)) ? logic.playerO : logic.playerX);
                    logic.board[r][c] = EMPTY; // Undo the move

                    if (logic.currentPlayer.equals(logic.playerX)) {
                        bestScore = Math.max(bestScore, score);
                    } else {
                        bestScore = Math.min(bestScore, score);
                    }
                }
            }
        }
        return bestScore;
    }
*/
}
