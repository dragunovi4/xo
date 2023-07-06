package game;

import java.util.Scanner;

public class Igrok {

    public boolean moiHod(Polushko pole) {
        Scanner scanner = new Scanner(System.in);
        int hod = scanner.nextInt();

        Kletka cell = pole.sdelatHod(
                (hod - 1) / Polushko.LENGTH,
                (hod - 1) % Polushko.LENGTH
        );

        //        if (pole[i][j] == 'X' || pole[i][j] == 'O') {
//            System.out.println("ЗАНЯТО");
//            return false;
//        }
//
//        char cimbol = 'X';
//
//        pole[i][j] = cimbol;
        return true;
    }
}
