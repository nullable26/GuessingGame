import java.util.Random;
import java.util.Scanner;
import java.lang.Exception;

public class Main {

    // Initialize input object
    private static final Scanner input = new Scanner(System.in);

    // Five chances.. every time every loop, a random number will be generated
    // each round the range of numbers generated will increase, for e.g.: 1st round -> 1 to 2
    // 2nd round -> 1 to 10
    // 3rd -> 1 to 15
    // so on ...
    // each round, it will take input.. if the input number is same as generated number, move to next round, else game
    // over and start over again.
    public static void main(String[] args) {
        roundOne();
    }

    private static void roundOne() {
        // Round 1
        System.out.println("Round 1:\n");
        int ans = getInput("Guess a number.. 1 or 2: "); // it takes parameter whatToAsk

        int generated = new Random().nextInt(2) + 1;   // generate a number from 1 to 2

        if (ans == generated) {
            System.out.println("Woohoo... \n");
            roundTwo();
        } else {
            gameOver(generated);
        }
    }

    private static void roundTwo() {
        // Round 2
        System.out.println("Round 2:\n");
        int ans = getInput("Guess a number.. 1 or 5: "); // it takes parameter whatToAsk

        int generated = new Random().nextInt(5) + 1;   // generate a number from 1 to 5

        if (ans == generated) {
            System.out.println("Woohoo...You move onto the next round! \n");
            roundThree();
        } else {
            gameOver(generated);
        }
    }

    private static void roundThree() {
        // Round 3
        System.out.println("Round 3:\n");
        int ans = getInput("Guess a number.. 1 or 10: "); // it takes parameter whatToAsk

        int generated = new Random().nextInt(10) + 1;   // generate a number from 1 to 10

        if (ans == generated) {
            // game finish here
            System.out.println("You have mastered the randomness of the universe ( ._.)");
        } else {
            gameOver(generated);
        }
    }

    private static void gameOver(int number) {
        System.out.println("The number was " + number);
        System.out.print("Game Over...\nDo you want to start again ?[Y/n]: ");
        String ans = input.nextLine();
        if (!ans.equals("n") && !ans.equals("N")) {
            roundOne(); // start over again
        }
    }

    // incase the user enter a string input..
    private static int getInput(String whatToAsk) {
        // so we use try and catch.. to try the input and catch the error..
        // and loop until we get correct input format
        try {
            System.out.print(whatToAsk);
            // catch error here...
            return Integer.parseInt(input.nextLine()); // because nextInt() can glitch sometimes
        } catch (Exception e) {
            System.out.println("Invalid input.. Try again..");
            return getInput(whatToAsk); // loop here
        }
    }
}
