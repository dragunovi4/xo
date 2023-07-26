package game;

import java.util.Scanner;

public class Gamer extends Player {
    Scanner scanner = new Scanner(System.in);

    @Override
    protected int hodyra() {
        return scanner.nextInt();
    }
}
