//package game;
//
//import game.exc.IncorrectMoveException;
//import game.exc.IncorrectMoveStateException;
//
//public abstract class Player {
//    protected abstract int hodyra();
//    public boolean moiHod(Board pole, Mark state) {
//
//        boolean korrectnyiHod;
//
//        do {
//
//            int hod = hodyra();
//
//            try {
//                if (hod <= 0 || hod >= 10) {
//                    throw new IncorrectMoveStateException("Некорректные координаты хода.");
//                }
//
//                pole.placeMark(
//                        (hod - 1) / Board.BOARD_WIDTH,
//                        (hod - 1) % Board.BOARD_WIDTH
//                );
//
//                korrectnyiHod = true;
//
//            } catch (IncorrectMoveStateException e) {
//                System.out.println(e + " Введите число от 1 до 9.");
//                korrectnyiHod = false;
//
//            } catch (IncorrectMoveException e) {
//                if (state == Mark.X) {
//                    System.out.println("WARNING!! " + e.getMessage());
//                }
//                korrectnyiHod = false;
//            }
//        } while (!korrectnyiHod);
//
//        return true;
//    }
//}
