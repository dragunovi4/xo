package game;
public enum KletkaState {
    X("  X  "),
    O("  O  "),
    EMPTY(" ‡†‡ ");
    private final String znachenie;
    KletkaState(String znachenie) {
        this.znachenie = znachenie;
    }
    public String getZnachenie() {
        return znachenie;
    }

}