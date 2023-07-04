package main.java;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Polushko polushkoObject = new Polushko();
        polushkoObject.vyvodPole();

        boolean gameOver;
        boolean playerMove = true;

        while (true) {
            if (playerMove ? igrok.moiHod(polushkoObject.getPole()) : botSopernik.botaHod(polushkoObject.getPole())) {
                System.out.println(playerMove ? "Ваш ход" : "Ход Бота");

                polushkoObject.vyvodPole();

                gameOver = konecIgry(polushkoObject.getPole(), playerMove);

                if (gameOver) {
                    break;
                }

                playerMove = !playerMove;
            }
        }
        polushkoObject.vyvodPole();
    }


    public static boolean konecIgry(char[][] pole, boolean cheyHod) {
        boolean varikPobedit = pobeda(pole, cheyHod ? 'X' : 'O');
        boolean nichiy = uslovieNichi(pole);

        if (varikPobedit & cheyHod) {
               System.out.println("ПОБЕДА!");
            return true;
        } else if (varikPobedit) {
            System.out.println("ПОРАЖЕНИЕ!");
            return true;
        } else if (nichiy) {
            System.out.println("НИЧЬЯ!");
            return true;
        }

        return false;
    }

    public static boolean uslovieNichi(char[][]pole) {
        for (char[] strings : pole) {
            for (char string : strings) {
                if (string != 'X' && string != 'O') {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean pobeda(char[][]pole, int symbol) {
        for (int i = 0; i < pole.length; i++) {
            char[] stroka = pole[i];
            if (stroka[0] == symbol && stroka[1] == symbol && stroka[2] == symbol) {
                return true;
            }

            if (pole[0][i] == symbol && pole[1][i] == symbol && pole[2][i] == symbol) {
                return true;
            }
        }
        return (pole[0][0] == symbol && pole[1][1] == symbol && pole[2][2] == symbol)
                || (pole[0][2] == symbol && pole[1][1] == symbol && pole[2][0] == symbol);
    }
}
