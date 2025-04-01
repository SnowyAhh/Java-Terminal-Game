import java.util.Scanner;
import java.util.Random;

public class rockPaperScissors {
    private int round;
    private String playerInput;
    private int compPoint;
    private int playerPoint;
    private Util util;
    private Scanner scanner;
    
    public rockPaperScissors() {
        round = 0;
        playerInput = "";
        compPoint = 0;
        playerPoint = 0;
        util = new Util();
        scanner = new Scanner(System.in);
    }

    public void game() {
        System.out.println("Welcome to Rock Paper Scissors!");
        playerInput="";
        if (round != 0) {
            // Ask if the player wants to restart the game
            askIfRestart();
        }
        while (!playerInput.equals("q")) {
            printChoices();
            playerInput = util.getValidInput(scanner, true, true, new int[]{1,2,3}, new char[]{'q'});
            if (!(playerInput.equals("q"))) {
                gameRound();
            }
        }

    }

    private void printChoices() {
        System.out.println("Choose an option:");
        System.out.printf("%-15s%15s\n", "1: Rock", "2: Scissors");
        System.out.printf("%-15s%15s\n", "3: Paper", "q: Quit");
    }

    private void printChoicesChosen(int playerChoice, int compChoice) {
        System.out.print("You chose: ");
        switch(playerChoice) {
            case 1:
                System.out.println("Rock");
                break;
            case 2:
                System.out.println("Scissors");
                break;
            case 3:
                System.out.println("Paper");
                break;
            default:
                System.out.println("Error with printing chosen choice for player");
        }
        
        System.out.print("The computer chose: ");
        switch(compChoice) {
            case 1:
                System.out.println("Rock");
                break;
            case 2:
                System.out.println("Scissors");
                break;
            case 3:
                System.out.println("Paper");
                break;
            default:
                System.out.println("Error with printing chosen choice for computer");
        }
    }

    private void printPointInfo() {
        System.out.printf("\tPlayer: %d\n", playerPoint);
        System.out.printf("\tComputer: %d\n", compPoint);
    }

    private void printWinner(boolean playerWins, boolean compWins) {
        if (compWins && playerWins) {
            System.out.println("Tie!");
            compPoint++;
            playerPoint++;
        }
        else if(playerWins) {
            System.out.println("You win!");
            playerPoint++;
        }
        else if (compWins) {
            System.out.println("The computer wins!");
            compPoint++;
        }
        else {
            System.out.println("Error with tallying points!");
        }
    }

    private void askIfRestart() {
        System.out.println("You seem to have played before. The previous scores were:");
        printPointInfo();
        System.out.println("Do you want to continue? Otherwise the points will reset. (y/n)");
        playerInput = util.getValidInput(scanner, false, true, new char[]{'y', 'n'});
        if (playerInput.equals("y")) {
            System.out.println("Continuing the game.");
        }
        else {
            System.out.println("Restarting the points");
            compPoint = 0;
            playerPoint = 0;
        }
    }

    public void gameRound() {
        round++;
        System.out.println("---Round " + round + "---");

        Random rand = new Random(System.currentTimeMillis());

        int playerChoice = Integer.parseInt(playerInput);
        int compChoice = rand.nextInt(3) + 1;
        boolean playerWins = false;
        boolean compWins = false;

        printChoicesChosen(playerChoice, compChoice);

        switch (playerChoice) {
            case 1:
                switch (compChoice) {
                    case 1:
                        // P: Rock  C: Rock
                        playerWins = true;
                        compWins = true;
                        break;
                    case 2:
                        // P: Rock  C: Scissors
                        compWins = true;
                        break;
                    case 3:
                        // P: Rock C: Paper
                        playerWins = true;
                        break;
                    default:
                        break;
                }
                break;
            case 2:
                switch (compChoice) {
                    case 1:
                        // P: Scissors  C: Rock
                        compWins = true;
                        break;
                    case 2:
                        // P: Scissors  C: Scissors
                        compWins = true;
                        playerWins = true;
                        break;
                    case 3:
                        // P: Scissors C: Paper
                        playerWins = true;
                        break;
                    default:
                        break;
                }
            case 3:
                switch (compChoice) {
                    case 1:
                        // P: Paper  C: Rock
                        playerWins = true;
                        break;
                    case 2:
                        // P: Paper  C: Scissors
                        compWins = true;
                        break;
                    case 3:
                        // P: Paper C: Paper
                        playerWins = true;
                        compWins = true;
                        break;
                    default:
                        break;
                }
            default:
                System.out.println("Error with input!");
                break;
        }

        printWinner(playerWins, compWins);

        System.out.println("Current points: ");
        printPointInfo();
        System.out.println();

        return;
    }

}
