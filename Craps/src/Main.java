import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        while (playAgain) {
            System.out.println("Press Enter to roll the dice...");
            scanner.nextLine();
            int dice1 = rollDice(random);
            int dice2 = rollDice(random);
            int sum = dice1 + dice2;
            System.out.println("You rolled: " + dice1 + " + " + dice2 + " = " + sum);
            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You lose.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You win.");
            } else {
                System.out.println("Point is set to " + sum + ". Rolling for point...");
                int point = sum;
                boolean rollingForPoint = true;
                while (rollingForPoint) {
                    System.out.println("Press Enter to roll the dice again...");
                    scanner.nextLine();
                    dice1 = rollDice(random);
                    dice2 = rollDice(random);
                    sum = dice1 + dice2;
                    System.out.println("You rolled: " + dice1 + " + " + dice2 + " = " + sum);
                    if (sum == point) {
                        System.out.println("You hit the point! You win.");
                        rollingForPoint = false;
                    } else if (sum == 7) {
                        System.out.println("You rolled a 7! You lose.");
                        rollingForPoint = false;
                    }
                }
            }
            System.out.println("Do you want to play again? (yes/no)");
            playAgain = scanner.nextLine().equalsIgnoreCase("yes");
        }
        System.out.println("Thanks for playing Craps!");
        scanner.close();
    }
    private static int rollDice(Random random) {
        return random.nextInt(6) + 1;
    }
}
