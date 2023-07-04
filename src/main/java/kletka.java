package main.java;

public class kletka {
    private char symbol;

    //пустая по умолчанию
    public kletka() {
        symbol = ' ';
    }

    public void useSymbol(char symbol) {

        this.symbol = symbol;
    }

    public char getSymbol() {

        return symbol;
    }

}
