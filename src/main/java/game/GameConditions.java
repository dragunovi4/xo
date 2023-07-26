package game;
public class GameConditions {
    public static boolean konecIgry(Cell[][] pole, boolean cheyHod) {
        boolean varikPobedit = pobeda(pole, cheyHod ? Mark.X : Mark.O);
        boolean nichiy = uslovieNichi(pole);

        if (varikPobedit && cheyHod) {
            System.out.println("ПОБЕДА!");
            return true;
        } else if (varikPobedit) {
            System.out.println("ПОРАЖЕНИЕ!");
            return true;
        } else if (nichiy) {
            System.out.println("НИЧЬЯ!");
            return true;
        }
        return false;
    }
    public static boolean uslovieNichi(Cell[][] pole) {
        for (Cell[] strings : pole) {
            for (Cell string : strings) {
                 if (string.getState().equals(Mark.BLANK)) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean pobeda(Cell[][]pole, Mark getZnachenie) {
        for (int i = 0; i < pole.length; i++) {
            Cell[] stroka = pole[i];
            if (stroka[0].getState().equals(getZnachenie) && stroka[1].getState().equals(getZnachenie) && stroka[2].getState().equals(getZnachenie)) {
                return true;
            }
            if (pole[0][i].getState().equals(getZnachenie) && pole[1][i].getState().equals(getZnachenie) && pole[2][i].getState().equals(getZnachenie)) {
                return true;
            }
        }
        return (pole[0][0].getState().equals(getZnachenie) && pole[1][1].getState().equals(getZnachenie) && pole[2][2].getState().equals(getZnachenie))
                || (pole[0][2].getState().equals(getZnachenie) && pole[1][1].getState().equals(getZnachenie) && pole[2][0].getState().equals(getZnachenie));
    }
}
