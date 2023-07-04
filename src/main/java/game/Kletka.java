package game;

public class Kletka {
    private KletkaState state = KletkaState.EMPTY;

    private int x;
    private int y;

    //пустая по умолчанию
    public Kletka(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String getState() {
        switch (state) {
            case O: return "O";
            case X: return "X";
            default: return " ";
        }

    }

    public void useSymbol(char symbol) {

        this.state = symbol;
    }

}
