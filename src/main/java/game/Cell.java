package game;
public class Cell {
    private Mark state = Mark.BLANK;
    private int row;
    private int col;

    public Cell(int x, int y) {
        row = x;
        col = y;
    }
    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }
    public Mark getState() {
        return state;
    }
    public void useSymbol(Mark symbol) {
        this.state = symbol;
    }

}
