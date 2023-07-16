package game;
public enum KletkaState {
    X("  X  "),
    O("  O  "),
    EMPTY(" ‡†‡ ");
    private String znachenie;
    KletkaState(String znachenie) {
        this.znachenie = znachenie;
    }
    public String getZnachenie() {
        return znachenie;
    }

}