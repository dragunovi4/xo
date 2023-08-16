package game;

import java.util.Random;

public class RandomMovePlayer {
    static Random random = new Random();
    public static int[] getBestMove(Board board) {
        //return new int[] {0, 0};
        return new int[]{random.nextInt(2) + 1 , random.nextInt(2) + 1};
    }
}
