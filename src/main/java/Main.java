import game.Game;
import game.VyborSimvola;

public class Main {

    public static void main(String[] args) {
        VyborSimvola vybor = new VyborSimvola();
        vybor.vyborSimvola();

        Game game = new Game();
        game.play(false, vybor.statusIgroka, vybor.statusBota);
    }
}
