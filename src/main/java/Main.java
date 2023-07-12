import game.Game;
import game.exc.IncorrectMoveStateException;

public class Main {

    public static void main(String[] args) throws IncorrectMoveStateException {

        Game game = new Game();
        game.play();
    }
}
