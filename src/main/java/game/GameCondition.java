package game;

import static game.Board.BOARD_WIDTH;
import static game.Mark.*;

public class GameCondition {
    private static Mark winningMark = BLANK;
    private static boolean gameOver = false;
    private static int availableMoves = BOARD_WIDTH * BOARD_WIDTH;

    public static void checkWin(int row, int col) {
        int rowSum = 0;
        for (int i = 0; i < BOARD_WIDTH; i++) {
            rowSum += Board.getMarkAt(row, i).getMark();
        }
        if (calcWinner(rowSum) != BLANK) {
            System.out.println(winningMark + " wins on row " + row);
        }
        rowSum = 0;
        for (int r = 0; r < BOARD_WIDTH; r++) {
            rowSum += Board.getMarkAt(r, col).getMark();
        }
        if (calcWinner(rowSum) != BLANK) {
            System.out.println(winningMark + " wins on column " + col);
            return;
        }

        rowSum = 0;
        for (int i = 0; i < BOARD_WIDTH; i++) {
            rowSum += Board.getMarkAt(i, i).getMark();
        }
        if (calcWinner(rowSum) != BLANK) {
            System.out.println(winningMark + " wins on the top-left to "
                    + "bottom-right diagonal");
            return;
        }

        rowSum = 0;
        int indexMax = BOARD_WIDTH - 1;
        for (int i = 0; i <= indexMax; i++) {
            rowSum += Board.getMarkAt(i, indexMax - i).getMark();
        }
        if (calcWinner(rowSum) != BLANK) {
            System.out.println(winningMark + " wins on the top-right to "
                    + "bottom-left diagonal.");
            return;
        }
        if (!anyMovesAvailable()) {
            gameOver = true;
            System.out.println("Tie!");
        }
    }
    private static Mark calcWinner(int rowSum) {
        int Xwin = X.getMark() * BOARD_WIDTH;
        int Owin = O.getMark() * BOARD_WIDTH;
        if (rowSum == Xwin) {
            gameOver = true;
            winningMark = X;
            return X;
        } else if (rowSum == Owin) {
            gameOver = true;
            winningMark = O;
            return O;
        }
        return BLANK;
    }
    public static boolean anyMovesAvailable() {
        return availableMoves > 0;
    }
    public static boolean isGameOver() {
        return gameOver;
    }
    public static Mark getWinningMark() {
        return winningMark;
    }
}
