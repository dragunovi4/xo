package game;
public class Cell {
    private Mark state = Mark.BLANK;
    private final int x;
    private final int y;
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Mark getState() {
        return state;
    }

    public void useSymbol(Mark symbol) {
        this.state = symbol;
    }
    
}
