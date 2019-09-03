package Lesson03;

import java.util.Random;
import java.util.Scanner;

public class HW3 {
    public static Scanner sc = new Scanner(System.in);
    public static Random rnd = new Random();

    public static void main(String[] args) {
        //guessTheNumber();

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};
        guessTheWord(words);
    }

    //First task was to create a simple Guess the Number game
    //User guesses a random number in range from 0 to 9 and has 3 attempts
    //Whether he loses or wins he can play again or quit
    public static void guessTheNumber() {
        int num = rnd.nextInt(10);
        int guessedNumber;
        int i = 0;
        boolean isPlay = true;

        do {
            System.out.println(num);
            System.out.print("Please guess the number from 0 to 9: ");
            guessedNumber = sc.nextInt();
            if (guessedNumber == num) {
                System.out.println("Yes! I guessed " + num + ", and you got it right! Congratulations!");
                System.out.println("Wanna try again? 1 - yes, 0 - no: ");
                int playAgain = sc.nextInt();
                if (playAgain == 0) {
                    isPlay = false;
                } else {
                    i = 0;
                    num = rnd.nextInt(10);
                }
            } else if (guessedNumber < num && i < 2) {
                System.out.println("My number is bigger than " + guessedNumber + ", try again!");
                i++;
            } else if (guessedNumber > num && i < 2) {
                System.out.println("My number is lower than " + guessedNumber + ", try again!");
                i++;
            } else if (i == 2) {
                System.out.println("You didn't guess my number in 3 attempts, GAME OVER!");
                System.out.print("Wanna try again? 1 - yes, 0 - no: ");
                int playAgain = sc.nextInt();
                if(playAgain == 0) {
                    isPlay = false;
                } else {
                    i = 0;
                    num = rnd.nextInt(10);
                }
            }
        } while (isPlay);
    }

    //Second task was to create a Guess the Word game
    //We have an array of strings, we take a random word from it, and user has to guess the word
    //If the position of the letter in the guessed word is the same as in the random word, user gets a string with such letters
    public static void guessTheWord (String[] arr) {
        int rndNum = rnd.nextInt(arr.length);
        String word = arr[rndNum];
        String rightPos = "";

        outer: do {
            System.out.print("Please guess the word: ");
            String guessedWord = sc.nextLine();

            if(word.equals(guessedWord)) {
                System.out.println("Yes! I guessed the word '" + word + "'. Congratulations!");
                break outer;
            }

            for (int i = 0; i < arr.length && i < guessedWord.length(); i++) {
                char a = word.charAt(i);
                char b = guessedWord.charAt(i);
                if(a == b) {
                    rightPos += a;
                }
            }
            System.out.println(rightPos + "###############");
            rightPos = "";
        } while (true);
    }
}