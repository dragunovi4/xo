package game;

import game.exc.IncorrectMoveException;
import game.Cell;
import static game.Mark.*;

public class Board {
    public static final int BOARD_WIDTH = 3;
    private final Cell[][] board = new Cell[BOARD_WIDTH][BOARD_WIDTH];
    private boolean crossTurn = true;
    private boolean gameOver = false;
    private Mark winningMark = BLANK;

    public Board() {
        initialiseBoard();
    }

    public Cell[][] getBoard() {
        return board;
    }

    public void sdelatHod(int x, int y, Mark getZnachenie) throws IncorrectMoveException {

        Cell cell = board[x][y];
        Mark status = cell.getState();

        if (status == Mark.X || status == Mark.O) {
            throw new IncorrectMoveException("Выбранная клетка уже занята.");
        }

        cell.useSymbol(getZnachenie);

    }

    private void initialiseBoard() {
        for (int row = 0; row < BOARD_WIDTH; row++) {
            for (int col = 0; col < BOARD_WIDTH; col++) {
                board[row][col] = new Cell(row, col);
            }
        }
    }
}
