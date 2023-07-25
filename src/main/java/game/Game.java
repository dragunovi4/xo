package game;

public class Game {

    Polushko pole;
    Igrok igrok;
    BotSopernik botSopernik;

    public Game() {
        pole = new Polushko();
        igrok = new Igrok();
        botSopernik = new BotSopernik();
    }

    public void play(boolean gameOver, KletkaState statusIgroka, KletkaState statusBota) {
        pole.vyvodPole();

        boolean playerMove = true;

        while (!gameOver) {
            if (playerMove ? igrok.hodHodych(pole, statusIgroka) : botSopernik.hodHodych(pole, statusBota)) {
                System.out.println(playerMove ? "Ваш ход" : "Ход Бота");

                pole.vyvodPole();
                if (statusIgroka == KletkaState.X) {
                    gameOver = GameUslovia.konecIgry(pole.getPole(), playerMove);
                } else {
                    gameOver = GameUslovia.konecIgruli(pole.getPole(), playerMove);
                }

                playerMove = !playerMove;
            }
        }
        pole.vyvodPole();
    }
}
