import java.util.Scanner;
import java.util.Random;

public class mathQuiz {
    private String question;
    private int answer;
    private String userInput;
    private int difficulty;
    private int maxNum;
    private int minNum;
    private int points;
    private int round;
    private Util util;
    private Scanner scanner;

    public mathQuiz() {
        question = "";
        answer = 0;
        difficulty = 1;
        maxNum = 10;
        minNum = 0;
        points = 0;
        round = 0;
    }

    public void game() {
        System.out.println("Welcome to Math Quiz!");
        if (round == 0) {
            System.out.println("It's your first time playing, please adjust the settings to your likings");
            settings();
        }
    }

    public void settings() {
        System.out.println("--Settings--");

        // Setting the difficulty
        boolean confirm = false;

        while (!confirm) {
            // FIXME: add multiplication and division
            System.out.println("Please set the difficulty: ");
            System.out.println("\t1: Addition and subtraction only");
            // System.out.println("\t2: Above plus multiplication and division");
            System.out.println("\tq: Quit");
            userInput = util.getValidInput(scanner, true, true, 
                                            new int[]{1,2}, new char[]{'q'});
            switch (userInput) {
                case "1":
                    difficulty = 1;
                    break;
                // case "2":
                //     difficulty = 2;
                //     break;
                case "q":
                    return;
            }

            System.out.println("Difficulty is set to: " + difficulty);
            System.out.println("Confirm? (y/n)");
            userInput = util.getValidInput(scanner, false, true, new char[]{'y', 'n'});

            if (userInput.charAt(0) == 'y') {
                confirm = true;
            }
        }

        // Setting the numbers possible
        confirm = false;

        while (!confirm) {
            System.out.println("Please set the maximum and minimum numbers used for questions.");
            System.out.println("\tMaximum number: ");
            userInput = util.getValidInput(scanner, true, false);
            maxNum = Integer.parseInt(userInput);

            System.out.println("\tMinimum number: ");
            userInput = util.getValidInput(scanner, true, false);
            minNum = Integer.parseInt(userInput);

            if (maxNum < minNum) {
                System.out.println("Minimum is larger than maximum, swapping the two.");
                int temp = maxNum;
                maxNum = minNum;
                minNum = temp;
            }

            System.out.println("Maximum is set to: " + maxNum + "\nMinimum is set to: " + minNum);
            System.out.println("Confirm? (y/n)");
            userInput = util.getValidInput(scanner, false, true, new char[]{'y', 'n'});

            if (userInput.charAt(0) == 'y') {
                confirm = true;
            }
        }

        System.out.println("Returning back to menu...");
    }
}
