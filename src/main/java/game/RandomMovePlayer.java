package game;

import java.util.Random;
import java.util.List;


public class RandomMovePlayer {
    static Random random = new Random();
    public static Cell getBestMove(Board board) {
        List<Cell> freeCells = board.getFreeCells();
        if (freeCells.isEmpty()) {
            return null;
        } else {
            int randomIndex = random.nextInt(freeCells.size());
            Cell randomCell = freeCells.get(randomIndex);
            return randomCell;
        }
    }
}
