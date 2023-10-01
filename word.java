package hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//																	Instructions
/*

 1.Create a Word class with attributes for the actual word to be guessed and a masked version of the word.
 2.Implement a constructor to initialize the Word object with the chosen word and generate the initial masked word (using underscores for unrevealed letters).
 3.Write a method in the Word class to reveal letters in the word when the player guesses correctly.
 4.Implement a method to check if the word has been completely guessed.

read from a file
randomly use a word
identify which word cateogry is it

 */


public class word {
	
	ArrayList<String> food = new ArrayList<>();
	ArrayList<String> song = new ArrayList<>();
	ArrayList<String> fruit = new ArrayList<>();
	ArrayList<String> movie = new ArrayList<>();

	
	public void readFile() throws FileNotFoundException {
	    try {
	        File f = new File("/Users/prakarsha/eclipse-workspace/HangMan/src/words.txt");

	        Scanner scnr = new Scanner(f); // reads from file

	        String currentCategory = null;

	        while (scnr.hasNextLine()) { //  hasNextLine() as there could be spaces between
	        	
	            String line = scnr.nextLine().trim(); // Read the whole line and trim spaces

	            if (line.endsWith(":")) {
	                currentCategory = line.substring(0, line.length() - 1).trim(); // Trim spaces from category name
	                line = scnr.nextLine().trim(); // Read the next line and trim spaces
	            }

	            switch (currentCategory) {
	                case "Food":
	                    food.add(line);
	                    break;

	                case "Movie":
	                    movie.add(line);
	                    break;

	                case "Fruit":
	                    fruit.add(line);
	                    break;

	                case "Song":
	                    song.add(line);
	                    break;
	            }
	        }
	    } catch (FileNotFoundException e) {
	        throw new FileNotFoundException();
	    }
	}

	
	public String generateRandomWord(int input) {
		
		ArrayList<String> category = null;
		
		if(input == 1) {
			category = food;
		}
		else if(input == 2) {
			category = song;
		}
		
		else if(input == 3) {
			category = fruit;
		}
		
		else {
			category = movie;
		}
		
		Random rand = new Random();
		
		int end = category.size() ; // end bound
		
		
		int index = rand.nextInt(end); 
		
		String word = category.get(index);
		
		return word;
		
		
	}
	
	
	public StringBuilder guess(String input, String wordToGuess, String currentWordState) {
	    StringBuilder updatedWordState = new StringBuilder(currentWordState);
	    
	    wordToGuess = wordToGuess.toLowerCase();

	    for (int i = 0; i < wordToGuess.length(); i++) {
	        char guessedLetter = input.charAt(0); // Only one character is expected in the input

	        if ((wordToGuess.charAt(i)) == guessedLetter) { // Check if the guessed letter matches a character in the word
	            updatedWordState.setCharAt(i, guessedLetter);
	        }
	    }

	    return updatedWordState;
	}



}
