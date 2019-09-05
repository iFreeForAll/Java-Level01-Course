package Lesson04;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static Scanner sc = new Scanner(System.in);
    static final Random rnd = new Random();

    static final int SIZE_X = 3;
    static final int SIZE_Y = 3;
    //2D array, first comes rows, then columns, hence first Y, then X
    static char[][] field = new char[SIZE_Y][SIZE_X];

    static final char PLAYER_DOT = 'X';
    static final char AI_DOT = 'O';
    static final char EMPTY_DOT = '*';

    //initializing our field with '*'
    public static void initField() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }

    //printing the field in console
    public static void printField() {
        System.out.println("-------");
        for (int i = 0; i < SIZE_Y; i++) {
            System.out.print("|");
            for (int j = 0; j < SIZE_X; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println("-------");
    }

    public static void setSymbol(int y, int x, char sym) {
        field[y][x] = sym;
    }

    public static boolean isStepValid(int y, int x) {
        if(x < 0 || y < 0 || x > SIZE_X - 1 || y > SIZE_Y - 1) {
            return false;
        }
        return(field[y][x] == EMPTY_DOT);
    }

    public static void playerStep() {
        int x, y;

        do {
            System.out.println("Enter coordinates: X Y (1 - " + SIZE_X + ")");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isStepValid(y, x));

        setSymbol(y, x, PLAYER_DOT);
    }

    public static void aiStep() {
        int x, y;

        do {
            x = rnd.nextInt(SIZE_X);
            y = rnd.nextInt(SIZE_Y);
        } while (!isStepValid(y, x));

        setSymbol(y, x, AI_DOT);
    }

    public static boolean isFieldFull() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                if(field[i][j] == EMPTY_DOT) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkWin(char sym) {
        if (field[0][0] == sym && field[0][1] == sym && field[0][2] == sym) {
            return true;
        }
        if (field[1][0] == sym && field[1][1] == sym && field[1][2] == sym) {
            return true;
        }
        if (field[2][0] == sym && field[2][1] == sym && field[2][2] == sym) {
            return true;
        }

        if (field[0][0] == sym && field[1][0] == sym && field[2][0] == sym) {
            return true;
        }
        if (field[0][1] == sym && field[1][1] == sym && field[2][1] == sym) {
            return true;
        }
        if (field[0][2] == sym && field[1][2] == sym && field[2][2] == sym) {
            return true;
        }

        if (field[0][0] == sym && field[1][1] == sym && field[2][2] == sym) {
            return true;
        }
        if (field[2][0] == sym && field[1][1] == sym && field[0][2] == sym) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        initField();
        printField();

        while (true) {
            playerStep();
            printField();

            if (checkWin(PLAYER_DOT)) {
                System.out.println("You WIN!");
                break;
            }
            if(isFieldFull()) {
                System.out.println("DRAW!");
            }

            aiStep();
            printField();

            if (checkWin(AI_DOT)) {
                System.out.println("AI WIN!");
                break;
            }
            if (isFieldFull()) {
                System.out.println("DRAW");
            }
        }
    }
}