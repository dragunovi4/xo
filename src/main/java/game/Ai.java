package game;


import java.util.Random;

public class Ai extends Player {
    Random sluchainost = new Random();

    protected int hodyra() {
        return sluchainost.nextInt(Board.BOARD_WIDTH * Board.BOARD_WIDTH) + 1;
    }
}

