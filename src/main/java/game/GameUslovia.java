package game;

public class GameUslovia {
    public static boolean konecIgry(Kletka[][] pole, boolean cheyHod) {
        boolean varikPobedit = pobeda(pole, cheyHod ? KletkaState.X : KletkaState.O);
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

    public static boolean uslovieNichi(Kletka[][] pole) {
        for (Kletka[] strings : pole) {
            for (Kletka string : strings) {
                if (string.equals(KletkaState.X) || string.equals(KletkaState.O)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean pobeda(Kletka[][]pole, KletkaState getState) {
        for (int i = 0; i < pole.length; i++) {
            Kletka[] stroka = pole[i];
            if (stroka[0].equals(getState) && stroka[1].equals(getState) && stroka[2].equals(getState)) {
                return true;
            }

            if (pole[0][i].equals(getState) && pole[1][i].equals(getState) && pole[2][i].equals(getState)) {
                return true;
            }
        }
        return (pole[0][0].equals(getState) && pole[1][1].equals(getState) && pole[2][2].equals(getState))
                || (pole[0][2].equals(getState) && pole[1][1].equals(getState) && pole[2][0].equals(getState));
    }

}
