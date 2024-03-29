package game;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static game.Mark.*;

public class Board {
    public static final int BOARD_WIDTH = 3;
    private static final Cell[][] board = new Cell[BOARD_WIDTH][BOARD_WIDTH];
    private boolean crossTurn = true;

    public Board() {
        initialiseBoard();
    }

    public boolean isTileMarked(int row, int column) {
        Cell cell = board[row][column];
        return cell.getState().isMarked();
    }
    public void placeMark(int row, int col) {
        Cell cell = board[row][col];
        if (isTileMarked(row, col)) {
            return;
        }

        cell.useSymbol(crossTurn ? X : O);
        crossTurn = !crossTurn;

        GameCondition.checkWin(row, col);
    }

    public static Mark getMarkAt(int row, int column) {
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
        List<Cell> freeCell = new ArrayList<>();
        for (int row = 0; row < BOARD_WIDTH; row++) {
            for (int col = 0; col < BOARD_WIDTH; col++){
                if (!isTileMarked(row,col)) {
                    freeCell.add(board[row][col]);
                }
            }
        }
        return freeCell;
    }
}
