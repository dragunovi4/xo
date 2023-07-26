package game;

import game.exc.IncorrectMoveException;

public class Board {
    public static final int BOARD_WIDTH = 3;

    private final Cell[][] pole;

    public Board() {
        pole = new Cell[][]{
                {new Cell(0, 0), new Cell(1, 0), new Cell(2, 0)},
                {new Cell(0, 1), new Cell(1, 1), new Cell(2, 1)},
                {new Cell(0, 2), new Cell(1, 2), new Cell(2, 2)}
        };
    }

    public Cell[][] getPole() {
        return pole;
    }

    public void sdelatHod(int x, int y, Mark getZnachenie) throws IncorrectMoveException {

        Cell cell = pole[x][y];
        Mark status = cell.getState();

        if (status == Mark.X || status == Mark.O) {
            throw new IncorrectMoveException("Выбранная клетка уже занята.");
        }

        cell.useSymbol(getZnachenie);

    }

    public void vyvodPole () {
        System.out.println("--------------------------------");
        for (int i = 0; i < 3; i++) {
            System.out.print(" |  ");
            for (int j = 0; j < 3; j++) {
                System.out.print(pole[i][j].getState().getMark() + "  |  ");
            }
            System.out.println();
            System.out.println("---------------------------------");
        }
    }
}
