package hangman;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class hangman {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scnr = new Scanner(System.in);

        System.out.println("Hi, Welcome to the hangman game.");
        System.out.println("");

        word hangmanWord = new word();
        hangmanWord.readFile();
        
        StringBuilder currentWord = new StringBuilder();

        int category;
        do {
            System.out.println("Please choose a category:");
            System.out.println("Press (1) for Food");
            System.out.println("Press (2) for Songs");
            System.out.println("Press (3) for Fruits");
            System.out.println("Press (4) for Movies");
            System.out.print("Category: ");
            
            category = scnr.nextInt();
            
            System.out.println("");
            
        } while (category < 1 || category > 4); //validation
        
       

        String guessWord = hangmanWord.generateRandomWord(category).toLowerCase();

        // Initialize currentWord with underscores representing letters
        for (int i = 0; i < guessWord.length(); i++) {
            char c = guessWord.charAt(i);

            if (Character.isWhitespace(c)) {
                currentWord.append(" ");
            } else {
                currentWord.append(".");
            }
        }

        System.out.println("Word to guess: " + currentWord.toString() );
        System.out.println(guessWord);

        int attempts = 6; // Number of attempts allowed
        boolean gameWon = false;

        while (attempts > 0) {
        	
            System.out.print("Type a letter to guess: ");
            String input1 = scnr.next().toLowerCase();
            char input = input1.charAt(0);

            // Check if the input character is present in the guessWord
            StringBuilder updatedWord = hangmanWord.guess(String.valueOf(input), guessWord, currentWord.toString());

            if (!currentWord.toString().equals(updatedWord.toString())) {
                System.out.println("Correct guess!");
                currentWord = updatedWord;
            } else {
                System.out.println("Incorrect guess. Attempts left: " + (attempts - 1));
                attempts--;
            }

            System.out.println("Current word: " + currentWord.toString());

            if (currentWord.toString().equals(guessWord)) {
                gameWon = true;
                break;
            }
        }

        if (gameWon) {
            System.out.println("Congratulations! You've won. The word was: " + guessWord);
        } else {
            System.out.println("Game over! You've run out of attempts. The word was: " + guessWord);
        }


        
    }
}