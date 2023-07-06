package game;

public class GameUslovia {
    public static boolean konecIgry(Kletka[][] pole, boolean cheyHod) {
        boolean varikPobedit = pobeda(pole, cheyHod ? 'X' : 'O');
        boolean nichiy = uslovieNichi(pole);

        if (varikPobedit & cheyHod) {
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
    //условия для возникновения ничьи
    public static boolean uslovieNichi(Kletka[][] pole) {
        for (Kletka[] strings : pole) {
            for (Kletka string : strings) {
                if (strings.equals(KletkaState.X) && string.equals(KletkaState.O)) {
                    return false;
                }
            }
        }
        return true;
    }
    //условия для определения победы
    public static boolean pobeda(Kletka[][] pole, char c) {
        for (int i = 0; i < Polushko.LENGTH; i++) {
            Kletka symbol = pole[i][0];
            if ((pole[i][0] == symbol) && (pole[i][1] == symbol) && (pole[i][2] == symbol)) {
                return true;
            }
            if ((pole[0][i] == symbol) && (pole[1][i] == symbol) && (pole[2][i] == symbol)) {
                return true;
            }
        }
        Kletka symbol = pole[1][1];
        if ((pole[0][0] == symbol) && (pole[1][1] == symbol) && (pole[2][2] == symbol)) {
            return true;
        }
        if ((pole[0][2] == symbol) && (pole[1][1] == symbol) && (pole[2][0] == symbol)) {
            return true;
        }
        return false;
    }
}
