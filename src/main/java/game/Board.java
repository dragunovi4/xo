package game;

import game.exc.IncorrectMoveException;
import game.Cell;
import static game.Mark.*;

public class Board {
    public static final int BOARD_WIDTH = 3;
    private final Cell[][] board;
    private boolean crossTurn;
    private boolean gameOver;
    private Mark winningMark;

    public Board() {
        board = new Cell[BOARD_WIDTH][BOARD_WIDTH];
        crossTurn = true;
        gameOver = false;
        winningMark = BLANK;
//    {
//                {new Cell(0, 0), new Cell(1, 0), new Cell(2, 0)},
//                {new Cell(0, 1), new Cell(1, 1), new Cell(2, 1)},
//                {new Cell(0, 2), new Cell(1, 2), new Cell(2, 2)}
//        };
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

    public void initialiseBoard() {
        for (int row = 0; row < BOARD_WIDTH; row++) {
            for (int col = 0; col < BOARD_WIDTH; col++) {
                board[row][col] = BLANK;
            }
        }
    }
}
