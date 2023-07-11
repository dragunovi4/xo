package game;

import game.exc.IncorrectMoveException;

import java.util.Random;

import static game.Polushko.LENGTH;

public class BotSopernik {

    public static boolean botaHod(Polushko pole){
        Random sluchainost = new Random();


        boolean correctMove = true;
        do {
            int hod = sluchainost.nextInt(LENGTH * LENGTH) + 1;

            try {
                pole.sdelatHod(
                        (hod - 1) / LENGTH,
                        (hod - 1) % LENGTH,
                        KletkaState.O);

                correctMove = true;
            } catch (IncorrectMoveException e) {
                correctMove = false;
            }
        } while (!correctMove);

        return true;

    }
}

//        if (pole[a][b] == 'X' || pole[a][b] == 'O') {
//                return false;
//                }