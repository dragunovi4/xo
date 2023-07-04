package game;

public class Game {

    Polushko pole;
    Igrok igrok;

    public Game() {
        pole = new Polushko();
        igrok = new Igrok();
    }

    public void play() {
        pole.vyvodPole();

        // botSopernik...

        boolean gameOver;
        boolean playerMove = true;

        while (true) {
            if (playerMove ? igrok.moiHod(pole) : botSopernik.botaHod(pole.getPole())) {
                System.out.println(playerMove ? "Ваш ход" : "Ход Бота");

                pole.vyvodPole();

                gameOver = konecIgry(pole.getPole(), playerMove);

                if (gameOver) {
                    break;
                }

                playerMove = !playerMove;
            }
        }
        pole.vyvodPole();

    }
}
