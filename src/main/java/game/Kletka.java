package game;
public class Kletka {
    private KletkaState state = KletkaState.EMPTY;
    private final int x;
    private final int y;
    public Kletka(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public KletkaState getState() {
        return state;
        }
    public void useSymbol(KletkaState symbol) {
        this.state = symbol;
    }
}
