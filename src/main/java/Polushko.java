package main.java;

public class Polushko {

    private final char[][] pole;

    public Polushko() {
        pole = new char[][]{
                {'+', '+', '+'},
                {'+', '+', '+'},
                {'+', '+', '+'}
            }
        ;
    }

    public char[][] getPole() {
        return pole;
    }

    public void vyvodPole() {
        System.out.println("----------------------");
        for (int i = 0; i < 3; i++) {
            System.out.print(" |  ");
            for (int j = 0; j < 3; j++) {
                System.out.print(pole[i][j] + "  |  ");
            }
            System.out.println();
            System.out.println("----------------------");
        }
    }
}
