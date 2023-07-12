package game;

import game.exc.IncorrectMoveException;
import game.exc.IncorrectMoveStateException;

import java.util.Scanner;

public class Igrok {
    public boolean moiHod(Polushko pole) {
        Scanner scanner = new Scanner(System.in);

        boolean korrectnyiHod = true;

        do {
            int hod = scanner.nextInt();

            try {
                if (hod <= 0 || hod >= 10) {
                    throw new IncorrectMoveStateException("Некорректные координаты хода.");
                }

                pole.sdelatHod(
                        (hod - 1) / Polushko.LENGTH,
                        (hod - 1) % Polushko.LENGTH,
                        KletkaState.X);

                korrectnyiHod = true;

            } catch (IncorrectMoveStateException e) {
                System.out.println(e + " Введите число от 1 до 9.");
                korrectnyiHod = false;

            }catch (IncorrectMoveException e) {
                System.out.println("WARNING!! " + e.getMessage());
                korrectnyiHod = false;
            }

        } while (!korrectnyiHod);

        return true;

    }
}