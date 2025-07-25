import java.util.Random;
import java.util.Scanner;

public class guessTheNumber {
    private int target;
    private int intUserInput;
    private String userInput;
    private int numPoints;
    private int round;
    private int maxPossibleTarget;
    private int minPossibleTarget;
    private Util util;
    private Scanner scanner;

    public guessTheNumber() {
        target = -1;
        intUserInput = -1;
        userInput = "";
        numPoints = 0;
        round = 0;
        maxPossibleTarget = 100;
        minPossibleTarget = 0;
        util = new Util();
        scanner = new Scanner(System.in);
    }

    public void game() {
        while (!userInput.equals("q")) {
            menu();
            // 1 is to play, 2 is to change max/min numbers
            userInput = util.getValidInput(scanner, true, false, new int[]{1, 2});

            if (userInput.equals("1")) {
                changeMaxMinTarget();
            }
            else if (userInput.equals("2")) {
                System.out.println("Game is starting now!");
                // Repeats gameRound
                gameStart();
            }
        }
        

        return;
    }

    private void menu() {
        System.out.println("Welcome to Guess The Number!");
        if (round != 0) {
            System.out.println("\tHighest rounds played: " + round);
            System.out.println("\tHighest points gained: " + numPoints);
        }
        System.out.println("Pick an option below: ");
        System.out.println("1: Play");
        System.out.println("2: Change max/min possible number");
        System.out.println("(Currently, max: " + maxPossibleTarget + " min: " + minPossibleTarget + ")");
        System.out.println("q: Quit");
    }
    
    private void changeMaxMinTarget() {
        while(userInput.equals("y")) {
            System.out.println("-Changing the max/min possible number-");
            
            System.out.println("Enter the maximum number the target can be: ");
            userInput = util.getValidInput(scanner, true, false);
            intUserInput = Integer.parseInt(userInput);
            maxPossibleTarget = intUserInput;

            boolean isValidMin = false;
            while (!isValidMin) {
                System.out.println("Enter the minimum number the target can be: ");
                userInput = util.getValidInput(scanner, true, false);
                intUserInput = Integer.parseInt(userInput);
                
                if (maxPossibleTarget == intUserInput) {
                    System.out.println("Invalid minimum: Minimum target allowed is equal to maximum target allowed");
                    continue;
                }
                else if (maxPossibleTarget < intUserInput) {
                    System.out.println("Minimum is larger than maximum, would you like to switch the two? (y/n)");
                    userInput = util.getValidInput(scanner, false, true, new char[]{'y','n'});

                    if (userInput.equals("y")) {
                        minPossibleTarget = maxPossibleTarget;
                        maxPossibleTarget = intUserInput;
                    }
                    else {
                        System.out.println("Invalid minimum: Minimum target allowed is larger than maximum target allowed");
                        continue;
                    }
                }
                else {
                    isValidMin = true;
                }
            }

            System.out.println("Currently, max: " + maxPossibleTarget + " min: " + minPossibleTarget);
            System.out.println("Would you like to change them again? (y/n)");
            userInput = util.getValidInput(scanner, false, true, new char[]{'y','n'});

        }
    }

    private void gameStart() {
        while (!userInput.equals("q")) {
            round++;
            System.out.println("---Round " + round + "---");
            System.out.println("Current points: " + numPoints);

            gameRound();
            
            if (userInput.equals("q")) {
                System.out.println("Would you like to keep playing?");
                userInput = util.getValidInput(scanner, false, true, new char[]{'y','n'});
                
                if (userInput.equals("n")) {
                    System.out.println("Are you sure? You will not be able to pick up where you left off.");
                    userInput = util.getValidInput(scanner, false, true, new char[]{'y','n'});

                    if (userInput.equals("y")) {
                        return;
                    }
                }
            }
        }
        
    }

    private void gameRound() {
        while (!userInput.equals("q")) {
            System.out.println("Pick a number between " + minPossibleTarget + " and " + maxPossibleTarget + " (q to quit)");

        }
    }

}
