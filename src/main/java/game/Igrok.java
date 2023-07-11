package game;

import game.exc.IncorrectMoveException;

import java.util.Scanner;

public class Igrok {

    public boolean moiHod(Polushko pole) {
        Scanner scanner = new Scanner(System.in);

        boolean correctMove = true;
        do {
            int hod = scanner.nextInt();

            if (hod <= 0 || hod >= 10) {
                throw new IllegalArgumentException("Некорректные координаты хода.");
            }

            try {
                pole.sdelatHod(
                        (hod - 1) / Polushko.LENGTH,
                        (hod - 1) % Polushko.LENGTH,
                        KletkaState.X);

                correctMove = true;
            } catch (IncorrectMoveException e) {
                correctMove = false;
            }
        } while (!correctMove);

        return true;

    }
}