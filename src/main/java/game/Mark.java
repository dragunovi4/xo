package game;
public enum Mark {
    X("  X  "),
    O("  O  "),
    BLANK(" ‡†‡ ");
    private final String mark;
    Mark(String initMark) {
        this.mark = initMark;
    }
    public String getMark() {
        return this.mark;
    }
    //Маркировка клетки(уже занята)
    public boolean isMarked() {
        return this != BLANK;
    }
}