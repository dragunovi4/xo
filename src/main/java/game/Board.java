package game;

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
            checkWin(row, col);
        return true;
    }

    private void togglePlayer() {
            crossTurn = !crossTurn;
        }

    public Mark getMarkAt(int row, int column) {
        return board[row][column].getState();
    }
    public boolean isCrossTurn() {
        return crossTurn;
    }

    public Mark getWinningMark() {
        return winningMark;
    }

    private void initialiseBoard() {
        for (int row = 0; row < BOARD_WIDTH; row++) {
            for (int col = 0; col < BOARD_WIDTH; col++) {
                board[row][col] = new Cell(row, col);
            }
        }
    }
}