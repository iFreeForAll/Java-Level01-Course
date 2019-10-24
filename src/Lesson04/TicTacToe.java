package Lesson04;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Random;
import java.util.Scanner;

/**
 * Simple game Tic Tac Toe in console
 *
 * @version     2.0 24 Oct 2019
 * @author      Oleg Khlebnikov
 */

public class TicTacToe {

    static Scanner sc = new Scanner(System.in);
    static final Random rnd = new Random();

    /** Game field parameters */
    static final int SIZE_X = 5; //vertical
    static final int SIZE_Y = 5; //horizontal
    static final int WIN_CONDITION = 3;

    /** 2D array, first come rows, then columns, hence first Y, then X */
    static char[][] field = new char[SIZE_Y][SIZE_X];

    /** Game elements for UI */
    static final char PLAYER_DOT = 'X';
    static final char AI_DOT = 'O';
    static final char EMPTY_DOT = '*';

    /**
     * initializing our field, filling it with EMPTY_DOTs
     */
    public static void initField() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }

    /**
     * borders for top and bottom of the field
     * @param count tells how many symbols we need
     */
    public static void printBorder(int count) {
        System.out.print("  -");
        for (int i = 0; i < count; i++) System.out.print("-");
        System.out.println();
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
     * set a symbol on the field
     * @param y row
     * @param x column
     * @param sym symbol, user or AI
     */
    public static void setSymbol(int y, int x, char sym) {
        field[y][x] = sym;
    }

    /**
     * Player step
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
     * AI step
     */
    public static void aiStep() {
        int x, y;

        /** check if there's a winning condition */
        for (int v = 0; v < SIZE_Y; v++) {
            for (int h = 0; h < SIZE_X; h++) {
                if (h + WIN_CONDITION <= SIZE_X) {
                    //horizon check
                    if (checkHorizon(v, h, AI_DOT) == WIN_CONDITION - 1) {
                        if (aiMoveHorizontal(v, h, AI_DOT)) return;
                    }

                    //up diagonal check
                    if (v - WIN_CONDITION > -2) {
                        if (checkDiagonalUp(v, h, AI_DOT) == WIN_CONDITION - 1) {
                            if (aiMoveDiagonalUp(v, h, AI_DOT)) return;
                        }
                    }

                    //down diagonal check
                    if (v + WIN_CONDITION <= SIZE_Y) {
                        if (checkDiagonalDown(v, h, AI_DOT) == WIN_CONDITION) {
                            if (aiMoveDiagonalDown(v, h, AI_DOT)) return;
                        }
                    }
                }

                //vertical check
                if (v + WIN_CONDITION <= SIZE_Y) {
                    if (checkVertical(v, h, AI_DOT) == WIN_CONDITION) {
                        if (aiMoveVertical(v, h, AI_DOT)) return;
                    }
                }
            }
        }

        /** check if a player can win */
        for (int v = 0; v < SIZE_Y; v++) {
            for (int h = 0; h < SIZE_X; h++) {
                if (h + WIN_CONDITION <= SIZE_X) {
                    //horizon check
                    if (checkHorizon(v, h, PLAYER_DOT) == WIN_CONDITION - 1) {
                        if (aiMoveHorizontal(v, h, AI_DOT)) return;
                    }

                    //up diagonal check
                    if (v - WIN_CONDITION > -2) {
                        if (checkDiagonalUp(v, h, PLAYER_DOT) == WIN_CONDITION - 1) {
                            if (aiMoveDiagonalUp(v, h, AI_DOT)) return;
                        }
                    }

                    //down diagonal check
                    if (v + WIN_CONDITION <= SIZE_Y) {
                        if (checkDiagonalDown(v, h, PLAYER_DOT) == WIN_CONDITION) {
                            if (aiMoveDiagonalDown(v, h, AI_DOT)) return;
                        }
                    }
                }

                //vertical check
                if (v + WIN_CONDITION <= SIZE_Y) {
                    if (checkVertical(v, h, PLAYER_DOT) == WIN_CONDITION) {
                        if (aiMoveVertical(v, h, AI_DOT)) return;
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
     * AI step diagonal up
     * @param v vertical
     * @param h horizontal
     * @param dot player/AI dot
     * @return
     */
    private static boolean aiMoveDiagonalUp(int v, int h, char dot) {
        for (int i = 0, j = 0; j < WIN_CONDITION; i--, j++) {
            if(field[i + v][j + h] == EMPTY_DOT) {
                field[i + v][j + h] = dot;
                return true;
            }
        }
        return false;
    }

    /**
     * AI step diagonal down
     * @param v vertical
     * @param h horizontal
     * @param dot player/AI dot
     * @return
     */
    private static boolean aiMoveDiagonalDown(int v, int h, char dot) {
        for (int i = 0; i < WIN_CONDITION; i++) {
            if(field[i + v][i + h] == EMPTY_DOT) {
                field[i + v][i + h] = dot;
                return true;
            }
        }
        return false;
    }

    /**
     * AI step horizontal
     * @param v vertical
     * @param h horizontal
     * @param dot player/AI dot
     * @return
     */
    private static boolean aiMoveHorizontal(int v, int h, char dot) {
        for (int i = h; i < WIN_CONDITION + h; i++) {
            if(field[v][i] == EMPTY_DOT) {
                field[v][i] = dot;
                return true;
            }
        }
        return false;
    }

    /**
     * AI step vertical
     * @param v vertical
     * @param h horizontal
     * @param dot player/AI dot
     * @return
     */
    private static boolean aiMoveVertical(int v, int h, char dot) {
        int count = 0;
        for (int i = v; i < WIN_CONDITION + v; i++) {
            if(field[i][h] == EMPTY_DOT) {
                field[i][h] = dot;
                return true;
            }
        }
        return false;
    }

    /**
     * check if step is on the field and if it's valid or not
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
     */
    public static boolean checkWin(char dot) {
        for (int v = 0; v < SIZE_Y; v++) {
            for (int h = 0; h < SIZE_X; h++) {
                if (h + WIN_CONDITION <= SIZE_X) {
                    //horizon check
                    if (checkHorizon(v, h, dot) >= WIN_CONDITION) return true;

                    //up diagonal check
                    if (v - WIN_CONDITION > -2) {
                        if (checkDiagonalUp(v, h, dot) >= WIN_CONDITION) return true;
                    }

                    //down diagonal check
                    if (v + WIN_CONDITION <= SIZE_Y) {
                        if (checkDiagonalDown(v, h, dot) >= WIN_CONDITION) return true;
                    }
                }

                //vertical check
                if (v + WIN_CONDITION <= SIZE_Y) {
                    if (checkVertical(v, h, dot) >= WIN_CONDITION) return true;
                }
            }
        }
        return false;
    }

    /**
     * checks diagonal line up for filling
     * @param v vertical
     * @param h horizontal
     * @param dot player/AI dot
     * @return
     */
    private static int checkDiagonalUp(int v, int h, char dot) {
        int count = 0;
        for (int i = 0, j = 0; j < WIN_CONDITION; i--, j++) {
            if(field[i + v][j + h] == dot)
                count++;
        }
        return count;
    }

    /**
     * checks diagonal line down for filling
     * @param v vertical
     * @param h horizontal
     * @param dot player/AI dot
     * @return
     */
    private static int checkDiagonalDown(int v, int h, char dot) {
        int count = 0;
        for (int i = 0; i < WIN_CONDITION; i++) {
            if(field[i + v][i + h] == dot)
                count++;
        }
        return count;
    }

    /**
     * checks horizontal line for filling
     * @param v vertical
     * @param h horizontal
     * @param dot player/AI dot
     * @return
     */
    private static int checkHorizon(int v, int h, char dot) {
        int count = 0;
        for (int i = h; i < WIN_CONDITION + h; i++) {
            if(field[v][i] == dot)
                count++;
        }
        return count;
    }

    /**
     * checks vertical line for filling
     * @param v vertical
     * @param h horizontal
     * @param dot player/AI dot
     * @return
     */
    private static int checkVertical(int v, int h, char dot) {
        int count = 0;
        for (int i = v; i < WIN_CONDITION + v; i++) {
            if(field[i][h] == dot)
                count++;
        }
        return count;
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
                break;
            }

            aiStep();
            printField();

            if (checkWin(AI_DOT)) {
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