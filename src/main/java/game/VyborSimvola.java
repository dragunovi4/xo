package game;

import java.util.Scanner;

public class VyborSimvola {
    public KletkaState statusIgroka;
    public KletkaState statusBota;

    public void vyborSimvola() {

        System.out.println("Выберите значение корорым ходите играть\nНажмите 1 если хотите выбрать \"X\".\nНажмите 2 если хотите выбрать \"O\". ");
        Scanner scanner = new Scanner(System.in);
        int otskaneno = scanner.nextInt();

        if (otskaneno == 1) {
            statusIgroka = KletkaState.X;
            statusBota = KletkaState.O;
        } else {
            statusIgroka = KletkaState.O;
            statusBota = KletkaState.X;
        }
    }
}