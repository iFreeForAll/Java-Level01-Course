package Lesson04;

import java.util.Random;
import java.util.Scanner;

/**
 * Simple game Tic Tac Toe in console
 *
 * @version     1.0 05 Sep 2019
 * @author      Oleg Khlebnikov
 */

public class TicTacToe {

    static Scanner sc = new Scanner(System.in);
    static final Random rnd = new Random();

    static final int SIZE_X = 5; //vertical
    static final int SIZE_Y = 3; //horizontal
    static final int WIN_CONDITION = 3;

    /** 2D array, first come rows, then columns, hence first Y, then X */
    static char[][] field = new char[SIZE_Y][SIZE_X];

    static final char PLAYER_DOT = 'X';
    static final char AI_DOT = 'O';
    static final char EMPTY_DOT = '*';

    /**
     * printing line of '-' so the field will look better
     * @param count tells how many symbols we need
     */
    public static void printBorder(int count) {
        System.out.print("  -");
        for (int i = 0; i < count; i++) System.out.print("-");
        System.out.println();
    }

    /**
     * initializing our field, filling it with '*'
     */
    public static void initField() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }

    /**
     * printing the field in console
     */
    public static void printField() {
        System.out.print("   ");
        for (int i = 0; i < SIZE_X; i++) System.out.print(i + 1 + " ");
        System.out.println();
        printBorder(SIZE_X * 2);
        for (int i = 0; i < SIZE_Y; i++) {
            System.out.print(i + 1 + " |");
            for (int j = 0; j < SIZE_X; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
        printBorder(SIZE_X * 2);
    }

    /**
     * setting a symbol in the field
     * @param y row
     * @param x column
     * @param sym symbol, user or AI
     */
    public static void setSymbol(int y, int x, char sym) {
        field[y][x] = sym;
    }

    /**
     * checking whether we can set a symbol in the field at this position
     * @param y row
     * @param x column
     * @return boolean value
     */
    public static boolean isStepValid(int y, int x) {
        if(x < 0 || y < 0 || x >= SIZE_X || y >= SIZE_Y) {
            return false;
        }
        return(field[y][x] == EMPTY_DOT);
    }

    /**
     * asking user to choose coordinates to set PLAYER_DOT in the field
     */
    public static void playerStep() {
        int x, y;

        do {
            System.out.println("Enter coordinates!");
            System.out.print ("Row coordinate (1 to " + SIZE_Y + "): ");
            y = sc.nextInt() - 1;
            System.out.print ("Column coordinate (1 to " + SIZE_X + "): ");
            x = sc.nextInt() - 1;
        } while (!isStepValid(y, x));

        setSymbol(y, x, PLAYER_DOT);
    }

    /**
     * setting AI_DOT in the field
     */
    public static void aiStep() {
        int x, y;

        //first AI checks if it can win, and sets its dot there
        for (int i = 1; i <= SIZE_Y; i++) { //3
            for (int j = 1; j <= SIZE_X; j++) { //5
                if(isStepValid(i-1, j-1)) {
                    setSymbol(i-1, j-1, AI_DOT);
                    if(checkWin()) {
                        return;
                    } else {
                        setSymbol(i-1, j-1, EMPTY_DOT);
                    }
                }
            }
        }

        //after, it checks of a player can win and tries to prevent it
        for (int i = 1; i <= SIZE_X; i++) {
            for (int j = 1; j <= SIZE_Y; j++) {
                if (isStepValid(i-1, j-1)) {
                    setSymbol(i-1, j-1, PLAYER_DOT);
                    if(checkWin()) {
                        setSymbol(i-1, j-1, AI_DOT);
                        return;
                    } else {
                        setSymbol(i-1, j-1, EMPTY_DOT);
                    }
                }
            }
        }

        //otherwise it puts a dot in a random place on the field
        do {
            x = rnd.nextInt(SIZE_X);
            y = rnd.nextInt(SIZE_Y);
        } while (!isStepValid(y, x));

        setSymbol(y, x, AI_DOT);
    }

    /**
     * checking if the field is full
     * @return boolean value
     */
    public static boolean isFieldFull() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                if(field[i][j] == EMPTY_DOT) {
                    return false;
                }
            }
        }
        System.out.println("DRAW!");
        return true;
    }

    /**
     * checking if there's a win condition on the field
     * it uses algebraic vectors
     * works for any field size
     */
    public static boolean checkWin() {
        //we have 4 directions (vectors) to check all possible win conditions in a 2D array
        //{0, 1} - vertical, {1, 1} - diagonal up, {1, 0} - horizontal, {1, -1} - diagonal down
        int[][] vectors = {{0, 1}, {1, 1}, {1, 0}, {1, -1}};
        int count;

        for (int[] d : vectors) {
            int dx = d[0]; //x
            int dy = d[1]; //y

            //going through each element of the field
            for (int i = 0; i < SIZE_Y; i++) { //5
                for (int j = 0; j < SIZE_X; j++) { //3
                    count = 0; //for the future to check win condition

                    //these are coordinates of the last element from the initial one
                    int lastX = i + (WIN_CONDITION - 1) * dx; //2
                    int lastY = j + (WIN_CONDITION - 1) * dy; //2

                    //checking if these coordinates are in the field bounds
                    if(lastX >= 0 && lastX < SIZE_Y && lastY >= 0 && lastY < SIZE_X) {
                        char dot = field[i][j]; //dot in the initial element

                        //checking if all elements between the initial and the last one are equal
                        for (int k = 1; k < WIN_CONDITION; k++) {
                            if(dot != EMPTY_DOT && field[i + k*dx][j + k*dy] == dot) {
                                count++;
                            }

                            if(count == WIN_CONDITION - 1) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        initField();
        printField();

        while (true) {
            playerStep();
            printField();

            if (checkWin()) {
                System.out.println("You WIN!");
                break;
            }
            if(isFieldFull()) {
                System.out.println("DRAW!");
                break;
            }

            aiStep();
            printField();

            if (checkWin()) {
                System.out.println("AI WIN!");
                break;
            }
            if (isFieldFull()) {
                System.out.println("DRAW");
                break;
            }
        }
    }
}