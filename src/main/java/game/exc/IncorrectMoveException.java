package game.exc;

public class IncorrectMoveException extends Exception {
    public IncorrectMoveException(String message) {
        super(message);
    }

    public String toString() {
        return getMessage();
    }
}
