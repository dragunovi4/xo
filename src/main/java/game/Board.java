package game;

import java.util.List;

import static game.Mark.*;

public class Board {
    public static final int BOARD_WIDTH = 3;
    private final Cell[][] board = new Cell[BOARD_WIDTH][BOARD_WIDTH];
    private boolean crossTurn = true;
    private final boolean gameOver = false;

    private int availableMoves = BOARD_WIDTH * BOARD_WIDTH;
    public Board() {
        initialiseBoard();
    }

    public boolean isTileMarked(int row, int column) {
        Cell cell = board[row][column];
        return cell.getState().isMarked();
    }
    public boolean placeMark(int row, int col) {
        Cell cell = board[row][col];
            if (row < 0 || row >= BOARD_WIDTH || col < 0 || col >= BOARD_WIDTH
                    || isTileMarked(row, col) || gameOver) {
                return false;
            }
            availableMoves--;
            cell.useSymbol(crossTurn ? X : O);
            togglePlayer();
            GameCondition.checkWin(row, col);
        return true;
    }
    private void togglePlayer() {
            crossTurn = !crossTurn;
        }
    public int getWidth() {
        return BOARD_WIDTH;
    }
    public Mark getMarkAt(int row, int column) {
        return board[row][column].getState();
    }
    public boolean isCrossTurn() {
        return crossTurn;
    }
    private void initialiseBoard() {
        for (int row = 0; row < BOARD_WIDTH; row++) {
            for (int col = 0; col < BOARD_WIDTH; col++) {
                board[row][col] = new Cell(row, col);
            }
        }
    }

    public List<Cell> getFreeCells() {
        return ...;
    }
}
