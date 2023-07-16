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

    public void play() {
        pole.vyvodPole();


        boolean gameOver = false; //убрать в ебеня
        boolean playerMove = true;

        while (!gameOver) {
            if (playerMove ? igrok.moiHod(pole, KletkaState.X) : botSopernik.botaHod(pole, KletkaState.O)) {
                System.out.println(playerMove ? "Ваш ход" : "Ход Бота");

                pole.vyvodPole();

                gameOver = GameUslovia.konecIgry(pole.getPole(), playerMove);


                playerMove = !playerMove;
            }
        }
        pole.vyvodPole();
        System.out.println("ПОМЯНЕМ!");

    }
}
