package game;

import game.exc.IncorrectMoveException;
import game.exc.IncorrectMoveStateException;

public abstract class Player {
    protected abstract int hodyra();
    public boolean moiHod(Polushko pole, KletkaState state) {

        boolean korrectnyiHod = true;

        do {

            int hod = hodyra();

            try {
                if (hod <= 0 || hod >= 10) {
                    throw new IncorrectMoveStateException("Некорректные координаты хода.");
                }

                pole.sdelatHod(
                        (hod - 1) / Polushko.LENGTH,
                        (hod - 1) % Polushko.LENGTH,
                        state);

                korrectnyiHod = true;

            } catch (IncorrectMoveStateException e) {
                System.out.println(e + " Введите число от 1 до 9.");
                korrectnyiHod = false;

            } catch (IncorrectMoveException e) {
                if (state == KletkaState.X) {
                    System.out.println("WARNING!! " + e.getMessage());
                korrectnyiHod = false;
                } else {
                    korrectnyiHod = false;
                }
            }
        } while (!korrectnyiHod);

        return true;
    }
}