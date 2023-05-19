import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class opasnost{
    public static void opasnost(String[] args) {
        String[][] pole = sobstvennoPole();
        boolean konecIgry = false;
        vyvodPole(pole);
        String symbol = "X";
//
//        while (!konecIgry) {
//
//            if (symbol.equals("X") ? moiHod(pole, symbol) : botaHod(pole, symbol)) {
//                System.out.println(symbol.equals("X") ? "Ваш ход" : "Ход Бота");
//                vyvodPole(pole);
//                konecIgry = konecIgry(pole, symbol);
//                symbol = symbol.equals("X") ? "O" : "X";
//            }
//        }
        while (!konecIgry) {
            boolean cheiHod = symbol.equals("X");
            boolean uspehHoda = false;

            if (cheiHod) {
                uspehHoda = moiHod(pole, symbol);
            } else {
                uspehHoda = botaHod(pole, symbol);
            }

            if (uspehHoda) {
                System.out.println(cheiHod ? "Ваш ход" : "Ход Бота");
                vyvodPole(pole);
                konecIgry = konecIgry(pole, symbol);
                symbol = cheiHod ? "O" : "X";
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

    public static boolean konecIgry(String[][] pole, String hod) {
        boolean varikPobedit = pobeda(pole, hod);
        boolean etoX = hod.equals("X");
        boolean etoO = hod.equals("O");
        boolean nichiy = uslovieNichi(pole);

        if (varikPobedit && etoX) {
            System.out.println("ПОБЕДА!");
            return true;
        } else if (varikPobedit && etoO) {
            System.out.println("ПОРАЖЕНИЕ!");
            return true;
        } else if (nichiy) {
            System.out.println("НИЧЬЯ!");
            return true;
        }

        return false;
    }

    public static boolean uslovieNichi(String[][]pole) {
        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j < pole[i].length; j++) {
                if (!pole[i][j].equals("X") && !pole[i][j].equals("O")) {
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
        if ((pole[0][0].equals(symbol) && pole[1][1].equals(symbol) && pole[2][2].equals(symbol))
                || (pole[0][2].equals(symbol) && pole[1][1].equals(symbol) && pole[2][0].equals(symbol))) {
            return true;
        }
        return false;
    }
}
