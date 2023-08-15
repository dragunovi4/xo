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
    public boolean isMarked() {
        return this != BLANK;
    }
}