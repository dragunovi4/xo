package game;

import game.exc.IncorrectMoveException;

public class Polushko {
    public static final int LENGTH = 3;


    private Kletka[][] pole;

    public Polushko() {
        pole = new Kletka[][]{
                {new Kletka(0, 0), new Kletka(1, 0), new Kletka(2, 0)},
                {new Kletka(0, 1), new Kletka(1, 1), new Kletka(2, 1)},
                {new Kletka(0, 2), new Kletka(1, 2), new Kletka(2, 2)}
        };
    }

    public Kletka[][] getPole() {
        return pole;
    }

    public Kletka[][] sdelatHod(int x, int y, KletkaState getZnachenie) throws IncorrectMoveException {

        Kletka kletka = pole[x][y];
        KletkaState status = kletka.getState();

        if (status == KletkaState.X || status == KletkaState.O) {
            throw new IncorrectMoveException("Выбранная клетка уже занята.");
        }

        kletka.useSymbol(getZnachenie);


        return pole;
    }


    public void vyvodPole () {
        System.out.println("--------------------");
        for (int i = 0; i < 3; i++) {
            System.out.print(" |  ");
            for (int j = 0; j < 3; j++) {
                System.out.print(pole[i][j].getState().getZnachenie() + "  |  ");
            }
            System.out.println();
            System.out.println("---------------------");
        }
    }
}
