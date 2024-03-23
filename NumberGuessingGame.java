import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a random number between 1 and 100. Your task is to guess it.");

        // Generate a random number between 1 and 100
        Random random = new Random();
        int secretNumber = random.nextInt(100) + 1;
        int attempts = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter your guess: ");

            // Get user input for the guess
            if (scanner.hasNextInt()) {
                int guess = scanner.nextInt();
                attempts++;

                // Check if the guess is correct
                if (guess == secretNumber) {
                    System.out.println("Congratulations! You guessed the correct number " + secretNumber + " in " + attempts + " attempts.");
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear the invalid input from the scanner
            }
        }

        scanner.close();
    }
}
