import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[][] pole = sobstvennoPole();
        int kolvoHodov = 0;
        boolean konecIgry = false;
        vyvodPole(pole);

        while (!konecIgry) {

            if (kolvoHodov % 2 == 0) {
                if (moiHod(pole, "X")) {
                    kolvoHodov++;
                    System.out.println("Ваш ход");
                    vyvodPole(pole);
                }
                konecIgry = konecIgry(pole, "X", kolvoHodov);
            } else {
                if (botaHod(pole, "O")) {
                    kolvoHodov++;
                    System.out.println("Ход Бота");
                    vyvodPole(pole);
                }
                konecIgry = konecIgry(pole, "O", kolvoHodov);
            }
        }
          vyvodPole(pole);
    }

    public static String[][] sobstvennoPole() {
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

    public static void vyvodPole(String[][]pole){
        for (String[] i : pole) {
            System.out.println(Arrays.toString(i).replaceAll("\\[|\\]|\\,|\\ ", ""));
        }
    }

    public static boolean moiHod(String[][]pole, String symbol){
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

    public static boolean botaHod(String[][]pole, String symbol){
        Random sluchainost = new Random();
        int hb = sluchainost.nextInt(pole.length * pole[0].length) + 1;

        int a = (hb - 1) / pole.length;
        int b = (hb - 1) % pole.length;


        if (pole[a][b].equals("X") || pole[a][b].equals("O")) {
            return false;
        }

        pole[a][b] = "O";
        return true;
    }

    public static boolean konecIgry(String[][] pole, String hod, int kolvoHodov) {
        boolean varikPobedit = pobeda(pole, hod);
        boolean etoX = hod.equals("X");
        boolean etoO = hod.equals("O");

        if (varikPobedit && etoX) {
            System.out.println("ПОБЕДА!");
            return true;
        } else if (varikPobedit && etoO) {
            System.out.println("ПОРАЖЕНИЕ!");
            return true;
        } else if (kolvoHodov == 9) {
            System.out.println("НИЧЬЯ!");
            return true;
        }

        return false;
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
        if ((pole[0][0].equals(symbol) && pole[1][1].equals(symbol) && pole[2][2].equals(symbol))
                || (pole[0][2].equals(symbol) && pole[1][1].equals(symbol) && pole[2][0].equals(symbol))) {
            return true;
        }
        return false;
    }
}
