//package game;
//
//public class Game {
//
//    Board pole;
//    Gamer gamer;
//    Ai ai;
//
//    public Game() {
//        pole = new Board();
//        gamer = new Gamer();
//        ai = new Ai();
//    }
//
//    public void play( boolean gameOver) {
//        pole.initialiseBoard();
//
//        boolean playerMove = true;
//
//        while (!gameOver) {
//            if (playerMove ? gamer.moiHod(pole, Mark.X) : ai.moiHod(pole, Mark.O)) {
//                System.out.println(playerMove ? "Ваш ход" : "Ход Бота");
//
//                pole.initialiseBoard();
//
//                gameOver = GameConditions.konecIgry(pole.getBoard(), playerMove);
//
//                playerMove = !playerMove;
//            }
//        }
//        pole.initialiseBoard();
//    }
//}
