import java.util.*;
public class HangmanGame{
    private String wordToGuess;
    private StringBuilder currentGuess;
    private int maxAttempts;
    private int attemptsLeft;
    private Scanner scanner;

    public HangmanGame(String wordToGuess, int maxAttempts) {
        this.wordToGuess = wordToGuess.toLowerCase();
        this.maxAttempts = maxAttempts;
        this.attemptsLeft = maxAttempts;
        this.currentGuess = new StringBuilder("_".repeat(wordToGuess.length()));
        this.scanner = new Scanner(System.in);
    }

    public void play() {
        System.out.println("Welcome to Hangman!");
        System.out.println("Try to guess the word. You have " + maxAttempts + " attempts.");

        while (attemptsLeft > 0 && currentGuess.indexOf("_") != -1) {
            System.out.println("Current guess: " + currentGuess);
            System.out.println("Attempts left: " + attemptsLeft);
            System.out.print("Enter a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            if (!makeGuess(guess)) {
                attemptsLeft--;
            }
        }

        if (attemptsLeft > 0) {
            System.out.println("Congratulations! You guessed the word: " + wordToGuess);
        } else {
            System.out.println("Sorry, you ran out of attempts. The word was: " + wordToGuess);
        }
        scanner.close();
    }

    private boolean makeGuess(char guess) {
        boolean found = false;
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guess) {
                currentGuess.setCharAt(i, guess);
                found = true;
            }
        }
        return found;
    }

    public static void main(String[] args) {
        String wordToGuess = "hangman";
        int maxAttempts = 6; 

        HangmanGame game = new HangmanGame(wordToGuess, maxAttempts);
        game.play();
    }
}
