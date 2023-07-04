package game;

public class Polushko {
    /*
    Инициализация и механика игрового поля с условиями вывода
     */

    /**
     * Константа, ширина поля
     */
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

    public Kletka sdelatHod(int x, int y) {
        // Найти клетку в массиве pole и попробовать сделать ход c проверкой

        // исключения, если нужно сругаться

        return pole[x][y]; // ...
    }

    public void vyvodPole() {
        System.out.println("----------------------");
        for (int i = 0; i < 3; i++) {
            System.out.print(" |  ");
            for (int j = 0; j < 3; j++) {
                System.out.print(pole[i][j].getState() + "  |  ");
            }
            System.out.println();
            System.out.println("----------------------");
        }
    }
}
