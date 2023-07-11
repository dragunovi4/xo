package game;

import java.util.Random;

public class BotSopernik {

    public static boolean botaHod(Polushko pole){
        Random sluchainost = new Random();
        int hod = sluchainost.nextInt(pole.LENGTH * pole.LENGTH) + 1;


        pole.sdelatHod(
                (hod - 1) / Polushko.LENGTH,
                (hod - 1) % Polushko.LENGTH,
                KletkaState.O);

        return true;

    }
}

//        if (pole[a][b] == 'X' || pole[a][b] == 'O') {
//                return false;
//                }