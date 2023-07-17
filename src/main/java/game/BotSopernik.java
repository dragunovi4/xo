package game;


import java.util.Random;

public class BotSopernik extends Player {
    Random sluchainost = new Random();

    protected int hodyra() {
        return sluchainost.nextInt(Polushko.LENGTH * Polushko.LENGTH) + 1;
    }
}

