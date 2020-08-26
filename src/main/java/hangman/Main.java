package hangman;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println("Welcome to Hangman!");

        //mysql database access
        //MySQLAccess mySQLAccess = new MySQLAccess();
        //List<String> words = mySQLAccess.getWords();

        //webscraper access
        List<String> words = WordProvider.getWords();


        if (words.isEmpty()) {
            System.out.println("Failed to retrieve words.");
            return;
        }

        Random dice = new Random();
        String word = words.get(dice.nextInt(words.size()));



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
        //System.out.println("Do you want to play again? Y/N");
        //char playing = reader.nextLine().charAt(0);
        //if (playing == 'Y' && playing == 'y') {
        //  gameloop = true;
        //}
        //if (playing == 'N' && playing == 'n') {
        //    gameloop = false;
        //}
    }
}