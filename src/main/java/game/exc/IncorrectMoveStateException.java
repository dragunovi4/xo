package game.exc;

public class IncorrectMoveStateException extends Exception {
    public IncorrectMoveStateException(String message) {
        super(message);
    }

    public String toString() {
        return getMessage();
    }
}
