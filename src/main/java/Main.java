package main.java;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[][] pole = sobstvennoPole();
        vyvodPole(pole);

        for (boolean playerMove = true; !konecIgry(pole, playerMove);) {
            if (playerMove ? moiHod(pole) : botaHod(pole)) {
                System.out.println(playerMove ? "Ваш ход" : "Ход Бота");
                vyvodPole(pole);

                playerMove = !playerMove;
            }
        }
        vyvodPole(pole);
    }

    public static String[][] sobstvennoPole() {

      /*  int[][] pole1 = new int[][] {
            {1,  2,  3},
            {4, 5,  6},
            {7,  8,  9}
        }; */

        String[][] pole = new String[3][3];
        pole[0][0] = "1";
        pole[0][1] = "2";
        pole[0][2] = "3";
        pole[1][0] = "4";
        pole[1][1] = "5";
        pole[1][2] = "6";
        pole[2][0] = "7";
        pole[2][1] = "8";
        pole[2][2] = "9";

        return pole;
    }

//    public static void vyvodPole(String[][]pole){
//        for (String[] i : pole) {
//            System.out.println(Arrays.toString(i).replaceAll("[\\[\\], ]", ""));
//        }
//    }

    public static void vyvodPole(String[][]pole) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(pole[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public static boolean moiHod(String[][]pole){
        Scanner scannera = new Scanner(System.in);
        int hod = scannera.nextInt();

        int i = (hod - 1) / pole.length;
        int j = (hod - 1) % pole.length;

        if (pole[i][j].equals("X") || pole[i][j].equals("O")) {
            System.out.println("ЗАНЯТО");
            return false;
        }

        pole[i][j] = "X";
        return true;
    }

    public static boolean botaHod(String[][]pole){
        Random sluchainost = new Random();
        int hod = sluchainost.nextInt(pole.length * pole[0].length) + 1;

        int a = (hod - 1) / pole.length;
        int b = (hod - 1) % pole.length;


        if (pole[a][b].equals("X") || pole[a][b].equals("O")) {
            return false;
        }

        pole[a][b] = "O";
        return true;
    }

    public static boolean konecIgry(String[][] pole, boolean cheyHod) {
        boolean varikPobedit = pobeda(pole, cheyHod ? "X" : "O");
        boolean nichiy = uslovieNichi(pole);

        if (varikPobedit && cheyHod) {
               System.out.println("ПОБЕДА!");
            return true;
        } else if (varikPobedit && !cheyHod) {
            System.out.println("ПОРАЖЕНИЕ!");
            return true;
        } else if (nichiy) {
            System.out.println("НИЧЬЯ!");
            return true;
        }

        return false;
    }

    public static boolean uslovieNichi(String[][]pole) {
        for (String[] strings : pole) {
            for (String string : strings) {
                if (!string.equals("X") && !string.equals("O")) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean pobeda(String[][]pole, String symbol) {
        for (int i = 0; i < pole.length; i++) {
            String[] stroka = pole[i];
            if (stroka[0].equals(symbol) && stroka[1].equals(symbol) && stroka[2].equals(symbol)) {
                return true;
            }

            if (pole[0][i].equals(symbol) && pole[1][i].equals(symbol) && pole[2][i].equals(symbol)) {
                return true;
            }
        }
        return (pole[0][0].equals(symbol) && pole[1][1].equals(symbol) && pole[2][2].equals(symbol))
                || (pole[0][2].equals(symbol) && pole[1][1].equals(symbol) && pole[2][0].equals(symbol));
    }
}
