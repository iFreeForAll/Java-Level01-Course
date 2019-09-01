package Lesson02;

import java.util.Arrays;

public class HW2 {
    public static void main(String[] args) {
        int[] testArray1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        zeroToOneAndOneToZero(testArray1);

        int[] testArray2 = new int[8];
        arithmeticProgressionArray(testArray2);

        int[] testArray3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        multiplyLessThanSix(testArray3);

        System.out.println();
        int[][] testArray4 = new int[5][5];
        diagonalArrayWithOnes(testArray4);
        System.out.println();

        int[] testArray5 = {8, 3, 10, 8, 6, -1, 9, -2};
        minMaxElement(testArray5);

        int[] testArray6 = {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println(isArrayPartsEqual(testArray6));

        int[] arrMove = {9, 23, -2, 1, 5, 111, -59, 5};
        rotateElements(arrMove, -3);
    }

    // Here we change elements in array, 0 to 1 and 1 to 0
    public static void zeroToOneAndOneToZero(int[] arr) {
        for (int i : arr) {
            if(arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    // Here we fill empty array with an arithmetic progression sequence, where n = 3
    public static void arithmeticProgressionArray(int[] arr) {
        int num = 0;
        for (int i : arr) {
            arr[i] = num;
            num += 3;
        }
        System.out.println(Arrays.toString(arr));
    }

    // Here we multiply each array element that is less than 6 by 2
    public static void multiplyLessThanSix(int[] arr) {
        for (int i : arr) {
            if(arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    // Here we fill diagonals of 2D array with 1's
    public static void diagonalArrayWithOnes(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(i == j || j == (arr.length - 1 - i)) {
                    arr[i][j] = 1;
                }
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    // Here we find max and min elements in the array
    public static void minMaxElement(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            } else if(arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("Max number is: " + max + ", and min number is: " + min);
    }

    //This method returns true if there's a place in array where the sum of left parts equals to the sum of right parts
    public static boolean isArrayPartsEqual(int[] arr) {
        int sumLeft = 0;
        int sumRight;
        for (int i = 0; i < arr.length; i++) {
            sumLeft += arr[i];
            sumRight = 0;
            for (int j = i + 1; j < arr.length; j++) {
                sumRight += arr[j];
            }
            if(sumLeft == sumRight) {
                return true;
            }
        }
        return false;
    }

    // This method rotate the elements of array n times
    public static void rotateElements(int[] arr, int n) {
        if(n >= 0) { //check whether we rotate elements to the right or left (to the right here)
            for (int i = 0; i < n; i++) { //indicates how many time we rotate the elements (n times)
                int lastElement = arr[arr.length - 1]; //store last element of an array for the future
                for (int j = arr.length - 1; j > 0; j--) { //move elements by 1 position to the right
                    arr[j] = arr[j - 1];
                }
                arr[0] = lastElement;
            }
        } else {
            for (int i = 0; i > n; i--) { //basically the same thing, but now we move to the left
                int firstElement = arr[0]; //store first element of an array for the future
                for (int j = 0; j < arr.length - 1; j++) { //move elements by 1 position to the left
                    arr[j] = arr[j + 1];
                }
                arr[arr.length - 1] = firstElement;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}