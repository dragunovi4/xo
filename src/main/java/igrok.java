package main.java;

import java.util.Scanner;

public class igrok {
    /*
    Механика работы игрока с отслеживанием нужного поля и присваивания клетке символ игрока с проверкой и механикой при условии занятой клетки
     */
    public static boolean moiHod(char[][] pole){
        Scanner scannera = new Scanner(System.in);
        int hod = scannera.nextInt();

        int i = (hod - 1) / pole.length;
        int j = (hod - 1) % pole.length;

        if (pole[i][j] == 'X' || pole[i][j] == 'O') {
            System.out.println("ЗАНЯТО");
            return false;
        }

        char cimbol = 'X';

        pole[i][j] = cimbol;
        return true;
    }
}
