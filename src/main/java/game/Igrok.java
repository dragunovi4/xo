package game;

import java.util.Scanner;

public class Igrok {

    public boolean moiHod(Polushko pole) {
        Scanner scanner = new Scanner(System.in);
        int hod = scanner.nextInt();

        if (hod <= 0 || hod >= 10) {
            throw new IllegalArgumentException("Некорректные координаты хода.");
        }

        Kletka[][] cell = pole.sdelatHod(
                (hod - 1) / Polushko.LENGTH,
                (hod - 1) % Polushko.LENGTH,
                    KletkaState.X);


        if (cell.equals(KletkaState.X) || cell.equals(KletkaState.O)) {
            System.out.println("ЗАНЯТО");
            return false;
        }


        return true;
    }
}
