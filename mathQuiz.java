import java.util.Scanner;
import java.util.Random;

public class mathQuiz {
    private String question;
    private int answer;
    private String userInput;
    private int difficulty;
    private int maxNum;
    private int minNum;
    private int maxOp;
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
        maxOp = 1;
        points = 0;
        round = 0;
        util = new Util();
        scanner = new Scanner(System.in);
        }

    public void game() {
        System.out.println("Welcome to Math Quiz!");
        if (round == 0) {
            System.out.println("It's your first time playing, please adjust the settings to your likings");
            settingsMenu();
        }
        
    }

    private void settingsMenu() {
        System.out.println("--Settings--");

        // Current/default settings
        System.out.println("Current settings are: ");
        System.out.println("\tDifficult: " + difficulty);
        System.out.println("\tMaximum number allowed: " + maxNum);
        System.out.println("\tMinimum number allowed: " + minNum);
        System.out.println("\tMaximum number of operations allowed: " + maxOp);

        System.out.println("\nWould you like to change the settings? (y/n)");
        userInput = util.getValidInput(scanner, false, true, new char[]{'y', 'n'});

        if (userInput.equals("n")) {
            return;
        }

        while (userInput.charAt(0) != 'q') {
            // Print settings menu
            System.out.println("Choose a setting to change: ");
            System.out.println("\t1: Difficult (" + difficulty + ")");
            System.out.println("\t2: Maximum and minimum numbers used for questions (" + 
                                    maxNum + ", " + minNum + ")");
            System.out.println("\t3: Maximum number of operations allowed (" + maxOp + ")");
            System.out.println("\tq: Quit back to menu");

            userInput = util.getValidInput(scanner, true, true, new int[]{1,2,3}, new char[]{'q'});            

            switch (userInput) {
                case "1":
                    settingDifficulty();
                    break;
                case "2":
                    settingMaxAndMin();
                    break;
                case "3":
                    settingMaxOp();
                    break;
                case "q":
                    return;
                default:
                    System.out.println("Error with setting menu");
            }
        }

        System.out.println("Returning back to menu...");
    }

    private void settingDifficulty() {
        boolean confirm = false;

        while (!confirm) {
            // FIXME: add multiplication and division
            System.out.println("Please set the difficulty (currently: " + difficulty + "): ");
            System.out.println("\t1: Addition and subtraction only");
            // System.out.println("\t2: Above plus multiplication and division");
            userInput = util.getValidInput(scanner, true, false, new int[]{1,2});

            int tempDiff = Integer.parseInt(userInput);

            System.out.println("Difficulty will be set to: " + tempDiff);
            System.out.println("Confirm? (y/n)");
            userInput = util.getValidInput(scanner, false, true, new char[]{'y', 'n'});

            if (userInput.charAt(0) == 'y') {
                difficulty = tempDiff;
                confirm = true;
            }
        }
    }

    private void settingMaxAndMin() {
        boolean confirm = false;

        while (!confirm) {
            System.out.println("Please set the maximum and minimum numbers used for questions.");
            System.out.println("\tMaximum number (currently: " + maxNum + "): ");
            userInput = util.getValidInput(scanner, true, false);
            int tempMaxNum = Integer.parseInt(userInput);

            System.out.println("\tMinimum number (currently: " + minNum + "): ");
            userInput = util.getValidInput(scanner, true, false);
            int tempMinNum = Integer.parseInt(userInput);

            if (tempMaxNum < tempMinNum) {
                System.out.println("Maximum is smaller than minimum, swapping the two.");
                int temp = tempMaxNum;
                tempMaxNum = tempMinNum;
                tempMinNum = temp;
            }

            System.out.println("Maximum will be set to: " + tempMaxNum + "\nMinimum will be set to: " + tempMinNum);
            System.out.println("Confirm? (y/n)");
            userInput = util.getValidInput(scanner, false, true, new char[]{'y', 'n'});

            if (userInput.charAt(0) == 'y') {
                maxNum = tempMaxNum;
                minNum = tempMinNum;
                confirm = true;
            }
        }
    }

    private void settingMaxOp() {
        boolean confirm = false;

        while (!confirm) {
            System.out.println("Please set the maximum number of operations allowed in questions: ");
            userInput = util.getValidInput(scanner, true, false);
            int tempMaxOp = Integer.parseInt(userInput);

            System.out.println("The maximum number of operations will be set to: " + tempMaxOp);
            System.out.println("Confirm? (y/n)");
            userInput = util.getValidInput(scanner, false, true, new char[]{'y', 'n'});

            if (userInput.charAt(0) == 'y') {
                maxOp = tempMaxOp;
                confirm = true;
            }
        }
    }

    private void round() {
        // Playing round: try to figure out the answer, can skip questions -> reveal answer
        // s = skip, q = quit the round and go back to menu

    }

    // Chooses what number and operation
    private void generateQuestion() {
        Random rand = new Random(System.currentTimeMillis());

        // Chosing random operation - 1: Addition, 2: Subtraction, 3: Multiplication, 4: Division
        int operationChosen = 0;
        if (difficulty == 1) {
            operationChosen = rand.nextInt(2) + 1;
        }
        else if (difficulty == 2) {
            operationChosen = rand.nextInt(4) + 1;
        }

        question += rand.nextInt(maxNum) + minNum + 1;
        switch (operationChosen) {
            case 1:
                question += " + ";
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                System.out.println("Error with choosing operation");
                break;
        }
    }
 }
