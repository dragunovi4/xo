package game;

import game.exc.IncorrectMoveStateException;

public class Game {

    Polushko pole;
    Igrok igrok;
    BotSopernik botSopernik;

    public Game() {
        pole = new Polushko();
        igrok = new Igrok();
        botSopernik = new BotSopernik();

    }

    public void play() throws IncorrectMoveStateException {
        pole.vyvodPole();


        boolean gameOver;
        boolean playerMove = true;

        while (true) {
            if (playerMove ? igrok.moiHod(pole) : botSopernik.botaHod(pole)) {
                System.out.println(playerMove ? "Ваш ход" : "Ход Бота");

                pole.vyvodPole();

                gameOver = GameUslovia.konecIgry(pole.getPole(), playerMove);

                if (gameOver) {
                    break;
                }

                playerMove = !playerMove;
            }
        }
        pole.vyvodPole();

    }
}
