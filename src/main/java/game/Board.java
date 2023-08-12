package game;

import game.exc.IncorrectMoveException;
import game.Cell;
import game.Mark;
import static game.Mark.*;

public class Board {
    public static final int BOARD_WIDTH = 3;
    private final Cell[][] board = new Cell[BOARD_WIDTH][BOARD_WIDTH];
    private boolean crossTurn = true;
    private boolean gameOver = false;
    private Mark winningMark = BLANK;

    private int availableMoves = BOARD_WIDTH * BOARD_WIDTH;

    public Board() {
        initialiseBoard();
    }

    public Cell[][] getBoard() {
        return board;
    }

    public boolean isTileMarked(int row, int column) {
        return board[row][column].isMarked();
    }

//    public void sdelatHod(int x, int y, Mark getZnachenie) throws IncorrectMoveException {
//
//        Cell cell = board[x][y];
//        Mark status = cell.getState();
//
//        if (status == Mark.X || status == Mark.O) {
//            throw new IncorrectMoveException("Выбранная клетка уже занята.");
//        }
//
//        cell.useSymbol(getZnachenie);
//    }
    public boolean placeMark(int row, int col) {
        Cell cell = board[row][col];
            if (row < 0 || row >= BOARD_WIDTH || col < 0 || col >= BOARD_WIDTH
                    || isTileMarked(row, col) || gameOver) {
                return false;
            }
            availableMoves--;
            Cell.useSymbol(crossTurn ? X : O);
            togglePlayer();
            checkWin(row, col);

        return true;
    }

            private void togglePlayer() {
            crossTurn = !crossTurn;
        }
    private void initialiseBoard() {
        for (int row = 0; row < BOARD_WIDTH; row++) {
            for (int col = 0; col < BOARD_WIDTH; col++) {
                board[row][col] = new Cell(row, col);
            }
        }
    }
}
