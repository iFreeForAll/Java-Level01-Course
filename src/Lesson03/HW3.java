package Lesson03;

import java.util.Random;
import java.util.Scanner;

public class HW3 {
    public static Scanner sc = new Scanner(System.in);
    public static Random rnd = new Random();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        guessTheNumber();
        guessTheWord();
    }

    //First task was to create a simple 'Guess the Number' game
    //User guesses a random number in range from 0 to 9 and has 3 attempts
    //Whether he loses or wins he can play again or quit
    public static void guessTheNumber() {
        int num = rnd.nextInt(10);
        int guessedNumber;
        int i = 1;
        boolean win = false;

        do {
            System.out.print("Please guess the number from 0 to 9: ");
            guessedNumber = sc.nextInt();

            if (guessedNumber == num) {
                System.out.println("Yes! I guessed " + num + ", and you got it right! Congratulations!");
                win = playAgain();
                i = 1;
                num = rnd.nextInt(10);
            } else if (guessedNumber < num && i < 3) {
                System.out.println("My number is bigger than " + guessedNumber + ", try again!");
                i++;
            } else if (guessedNumber > num && i < 3) {
                System.out.println("My number is lower than " + guessedNumber + ", try again!");
                i++;
            } else {
                System.out.println("You didn't guess my number in 3 attempts, GAME OVER!");
                win = playAgain();
                i = 1;
                num = rnd.nextInt(10);
            }
        } while (!win);
    }

    //method that checks if player wants to play again
    public static boolean playAgain() {
        System.out.println("Wanna try again? 1 - yes, 0 - no: ");
        int userPrompt = sc.nextInt();
        if (userPrompt == 0) {
            return true;
        }
        return false;
    }

    //Second task was to create a 'Guess the Word' game
    //We have an array of strings, we take a random word from it, and user has to guess the word
    //If the position of the letter in the guessed word is the same as in the random word, user gets a string with such letters
    public static void guessTheWord () {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};

        int rndNum = rnd.nextInt(words.length);
        String answer;
        boolean win = false;

        do {
            System.out.print("Please guess the word: ");
            answer = sc.nextLine();

            if(words[rndNum].equals(answer.toLowerCase())) {
                System.out.println("Yes! I guessed the word '" + words[rndNum] + "'. Congratulations!");
                win = true;
            }

            if(!win) {
                for (int i = 0; i < words[rndNum].length(); i++) {
                    if(answer.length() > i && answer.charAt(i) == words[rndNum].charAt(i)) {
                        sb.append("(" + answer.charAt(i) + ")");
                    }
                }

                System.out.println("You got these letters in the right position: #####" + sb.toString() + "#####");
                sb.delete(0, sb.length());
                System.out.println();
            }
        } while (!win);
    }
}