package main.java;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] pole = sobstvennoPole();
        vyvodPole(pole);

        boolean gameOver;
        boolean playerMove = true;

        while (true) {
            if (playerMove ? moiHod(pole) : botaHod(pole)) {
                System.out.println(playerMove ? "Ваш ход" : "Ход Бота");

                vyvodPole(pole);

                gameOver = konecIgry(pole, playerMove);

                if (gameOver) {
                    break;
                }

                playerMove = !playerMove;
            }
        }
    /*  for (boolean playerMove = true; !konecIgry(pole, playerMove);) {
            if (playerMove ? moiHod(pole) : botaHod(pole)) {
                System.out.println(playerMove ? "Ваш ход" : "Ход Бота");
                vyvodPole(pole);

                playerMove = !playerMove;
            }
        } */
        vyvodPole(pole);
    }

    public static int[][] sobstvennoPole() {

        return new int[][] {
                {1,  2,  3},
                {4, 5,  6},
                {7,  8,  9}
          };
    }

    public static void vyvodPole(int[][]pole) {
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

    public static boolean moiHod(int[][]pole){
        Scanner scannera = new Scanner(System.in);
        int hod = scannera.nextInt();

        int i = (hod - 1) / pole.length;
        int j = (hod - 1) % pole.length;

        if (pole[i][j] == 11 || pole[i][j] == -11) {
            System.out.println("ЗАНЯТО");
            return false;
        }

        pole[i][j] = 11;
        return true;
    }

    public static boolean botaHod(int[][]pole){
        Random sluchainost = new Random();
        int hod = sluchainost.nextInt(pole.length * pole[0].length) + 1;

        int a = (hod - 1) / pole.length;
        int b = (hod - 1) % pole.length;


        if (pole[a][b] == 11 || pole[a][b] == -11) {
            return false;
        }

        pole[a][b] = -11;
        return true;
    }

    public static boolean konecIgry(int[][] pole, boolean cheyHod) {
        boolean varikPobedit = pobeda(pole, cheyHod ? 11 : -11);
        boolean nichiy = uslovieNichi(pole);

        if (varikPobedit && cheyHod) {
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

    public static boolean uslovieNichi(int[][]pole) {
        for (int[] strings : pole) {
            for (int string : strings) {
                if (string != 11 && string != -11) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean pobeda(int[][]pole, int symbol) {
        for (int i = 0; i < pole.length; i++) {
            int[] stroka = pole[i];
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
