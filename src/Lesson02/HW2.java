package Lesson02;

import java.util.Arrays;

public class HW2 {
    public static void main(String[] args) {
        int[] testArray1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        changeElement(testArray1);

        int[] testArray2 = new int[8];
        fillIn(testArray2);

        int[] testArray3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        doubleElement(testArray3);

        System.out.println();
        int[][] testArray4 = new int[5][5];
        crossFill(testArray4);
        System.out.println();

        int[] testArray5 = {8, 3, 10, 8, 6, -1, 9, -2};
        findMinMax(testArray5);

        int[] testArray6 = {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println(checkBalance(testArray6));

        int[] arrMove = {9, 23, -2, 1, 5, 111, -59, 5};
        shifter(arrMove, -3);

        System.out.println();
        int[] arr = {6, 5, 1, 3, 9};
        System.out.println("Initial array: " + Arrays.toString(arr));
        bubbleSort(arr);
    }

    // Here we change elements in array, 0 to 1 and 1 to 0
    public static void changeElement(int[] arr) {
        for (int i : arr) {
            arr[i] = (arr[i] == 1) ? 0 : 1;
        }
        System.out.println(Arrays.toString(arr));
    }

    // Here we fill empty array with an arithmetic progression sequence, where n = 3
    public static void fillIn(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3;
        }
        System.out.println(Arrays.toString(arr));
    }

    // Here we multiply each array element that is less than 6 by 2
    public static void doubleElement(int[] arr) {
        for (int i : arr) {
            if(arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    // Here we fill diagonals of 2D array with 1's
    public static void crossFill(int[][] arr) {
        for (int i = 0, j  = arr.length - 1; i < arr.length; i++, j--) {
            arr[i][j] = 1;
            arr[i][i] = 1;
            }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    // Here we find max and min elements in the array
    public static void findMinMax(int[] arr) {
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

    // This method returns true if there's a place in array where the sum of left parts equals to the sum of right parts
    public static boolean checkBalance(int[] arr) {
        int sumLeft = 0;
        int sumRight = 0;
        for (int i = 0; i < arr.length; i++) {
            sumLeft += arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                sumRight += arr[j];
            }
            if(sumLeft == sumRight) {
                return true;
            }
            sumRight = 0;
        }
        return false;
    }

    // This method rotate the elements of array n times
    public static void shifter(int[] arr, int n) {
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

    //This method uses "Bubble Sort" algorithm to sort an array
    public static void bubbleSort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("Array after bubble sort: " + Arrays.toString(arr));
    }
}