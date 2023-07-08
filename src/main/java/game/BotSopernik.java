package game;

import java.util.Random;

public class BotSopernik {

    public static boolean botaHod(Polushko pole){
        Random sluchainost = new Random();
        int hod = sluchainost.nextInt(pole.LENGTH * Polushko.LENGTH) + 1;

        Kletka[][] cell = pole.sdelatHod(
                (hod - 1) / Polushko.LENGTH,
                (hod - 1) % Polushko.LENGTH,
                KletkaState.O);

        if (cell.equals(KletkaState.X) || cell.equals(KletkaState.O)) {
            return false;
        }

        return true;
    }
}
