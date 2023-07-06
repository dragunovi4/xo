package game;

import java.util.Random;

public class BotSopernik {

    public static boolean botaHod(Polushko pole){
        Random sluchainost = new Random();
        int hod = sluchainost.nextInt(pole.LENGTH * Polushko.LENGTH) + 1;

        Kletka cell = pole.sdelatHod(
                (hod - 1) / Polushko.LENGTH,
                (hod - 1) % Polushko.LENGTH
        );

//        if (pole[x][y] == 'X' || pole[x][y] == 'O') {
//            return false;
//        }
//
//        char cimbol = 'O';
//
//        pole[x][y] = cimbol;
        return true;
    }
}
