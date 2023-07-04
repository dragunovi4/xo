package main.java;

import java.util.Random;

public class botSopernik {

    public static boolean botaHod(char[][] pole){
        Random sluchainost = new Random();
        int hod = sluchainost.nextInt(pole.length * pole[0].length) + 1;

        int a = (hod - 1) / pole.length;
        int b = (hod - 1) % pole.length;


        if (pole[a][b] == 'X' || pole[a][b] == 'O') {
            return false;
        }

        char cimbol = 'O';

        pole[a][b] = cimbol;
        return true;
    }
}
