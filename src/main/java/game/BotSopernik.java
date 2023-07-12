package game;

import game.exc.IncorrectMoveException;

import java.util.Random;


public class BotSopernik {

    public static boolean botaHod(Polushko pole){
        Random sluchainost = new Random();

        boolean korrectnyiHod = true;

        do {
            int hod = sluchainost.nextInt(pole.LENGTH * pole.LENGTH) + 1;

            try {
                pole.sdelatHod(
                        (hod - 1) / Polushko.LENGTH,
                        (hod - 1) % Polushko.LENGTH,
                        KletkaState.O);
                korrectnyiHod = true;
            } catch (IncorrectMoveException e) {
                korrectnyiHod = false;
            }
        } while (!korrectnyiHod);


        return true;

    }
}
