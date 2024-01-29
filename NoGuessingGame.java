import java.util.Random;
import java.util.Scanner;

public class NoGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int min_range = 1;
        int max_range = 100;
        int max_attempts = 5;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess the number between " + min_range + " and " + max_range);

        boolean playAgain = true;
        while (playAgain) {
            int targetNo = random.nextInt(max_range - min_range + 1) + min_range;
            int attempts = 0;
            boolean guessedCorrectly = false;

            while (attempts < max_attempts && !guessedCorrectly) {
                System.out.print("Enter your guess (Attempt " + (attempts + 1) + "): ");
                int userGuess = scanner.nextInt();

                if (userGuess == targetNo) {
                    System.out.println("Congratulations! You guessed the correct number: " + targetNo);
                    guessedCorrectly = true;
                    score++;
                } else if (userGuess < targetNo) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }

                attempts++;
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + targetNo);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");

            if (playAgain) {
                System.out.println("Let's play again!");
            } else {
                System.out.println("Thanks for playing! Your final score: " + score);
            }
        }

        scanner.close();
    }
}
