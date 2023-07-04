import game.Game;
import game.Igrok;
import game.Polushko;

import java.util.Random;
import java.util.Scanner;

public class Main {

    //логика игрового процесса
    public static void main(String[] args) {

        Game game = new Game();
        game.play();


    }

    //условия окончания игры
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
    //условия для возникновения ничьи
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
    //условия для определения победы
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
