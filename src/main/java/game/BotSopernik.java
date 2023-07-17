package game;


import java.util.Random;

public class BotSopernik extends Player {
    Random sluchainost = new Random();

    protected int hodyra() {
        Polushko pole = new Polushko();
        return sluchainost.nextInt(pole.LENGTH * pole.LENGTH) + 1;
    }
}

