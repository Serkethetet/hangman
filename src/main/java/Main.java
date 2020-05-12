package hangman;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println("Welcome to Hangman! :)");
        System.out.println("Please type a word to guess?!?");
        String word = reader.nextLine();
        int tries = word.length();
        char[] chars = word.toCharArray();
        char[] blanks = new char[word.length()];

        for (int i = 0; i < word.length(); i++) {
            blanks[i] = '*';
        }

        while (tries > 0) {
            System.out.println("Turns remaining: " + tries);
            System.out.println(blanks);
            System.out.println("Make a guess!");
            char guess = reader.nextLine().charAt(0);

            if (word.contains(String.valueOf(guess))) {
                System.out.println("Your guess was correct.");
                for (int i = 0; i < word.length(); i++) {
                    char aChar = chars[i];
                    if (aChar == guess) {
                        blanks[i] = guess;
                    }
                }
            } else {
                System.out.println("Wrong!");
                tries--;
            }

            if (Arrays.equals(blanks, chars)) {
                System.out.println(blanks);
                System.out.println("Congratulations, you won the game!");;
                break;
            }

            if (tries == 0) {
                System.out.println("No more guesses...GAMEOVER");
            }
        }
    }
}