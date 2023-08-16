package game;
public enum Mark {
    X('X'),
    O('O'),
    BLANK(' ');
    private final char mark;
    Mark(char initMark) {
        this.mark = initMark;
    }
    public char getMark() {
        return this.mark;
    }
    public boolean isMarked() {
        return this != BLANK;
    }
    public String toString() {
        return String.valueOf(mark);
    }
}