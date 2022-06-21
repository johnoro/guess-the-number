import java.util.InputMismatchException;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Hello! What is your name?");
        String name = s.nextLine();

        while (true) {
            System.out.println("Well, " + name + ", I'm thinking of a number between 1 and 20.");

            int guess = -999; // default number for first loop
            int numGuesses = 0;
            // rand decimal * range + min #
            int number = (int) (Math.random() * 20) + 1;

            do {
                if (guess != -999) {
                    if (guess > 20 || guess < 1) {
                        System.out.println("Remember, the number is between 1 and 20!");
                    } else {
                        if (guess > number) System.out.println("Your guess is too high.");
                        else System.out.println("Your guess is too low.");
                    }
                }

                System.out.println("Take a guess.");
                try {
                    guess = s.nextInt();
                    numGuesses++;
                } catch (InputMismatchException ime) {
                    System.out.println("Please enter a number.");
                    guess = -999;
                }
                s.nextLine(); // clears out newline for playAnswer y/n

            } while (guess != number);

            System.out.println("Good job, " + name + "! You guessed my number in " + numGuesses + " guesses!");
            System.out.println("Would you like to play again? (y or n)");

            String playAnswer = s.nextLine();

            if (playAnswer.compareTo("n") == 0) break;
            else if (playAnswer.compareTo("y") != 0) {
                System.out.println("A \"y\" or \"n\" wasn't detected.");
                System.out.println("I'll just assume you meant yes for simplicity's sake.");
            }

        }
    }
}