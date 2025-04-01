import java.util.InputMismatchException;
import java.util.Scanner;

public class Util {

    // Function to get valid input
    // intList and charList default to empty arrays
    public String getValidInput(Scanner scanner, boolean allowNum, boolean allowChar, int[] intList, char[] charList) {
        String input = "";
        boolean valid = false;

        while (!valid) {
            try {
                input = scanner.nextLine();

                if (input.length() != 1) {
                    throw new InputMismatchException("Error: Incorrect length, try again: ");
                }

                if (allowNum) { 
                    if (Character.isDigit(input.charAt(0))) {
                        int digitInput = Integer.parseInt(input);

                        if (intList.length > 0) {
                            for (int i = 0; i < intList.length; ++i) {
                                if (digitInput == intList[i]) {
                                    valid = true;
                                    break;
                                }
                            }
                        }
                        else {
                            valid = true;
                        }

                        if (!valid) {
                            throw new InputMismatchException("Error: Invalid number entered, try again: ");
                        }
                    }
                }

                if (!valid && allowChar) {
                    if (Character.isAlphabetic(input.charAt(0))) {
                        char charInput = Character.toLowerCase(input.charAt(0));

                        if (charList.length > 0) {
                            for (int i = 0; i < charList.length; ++i) {
                                if (charInput == Character.toLowerCase(charList[i])) {
                                    valid = true;
                                    break;
                                }
                            } 
                        }
                        else {
                            valid = true;
                        }

                        if (!valid) {
                            throw new InputMismatchException("Error: Invalid character entered, try again: ");
                        }
                        return "" + charInput; // Causes og input to be lower case
                    }
                }

                if (!valid) {
                    throw new InputMismatchException("Error: Invalid input entered, try again: ");
                }
            }
            catch (Exception e) {
                System.out.print(e.getMessage());
            }
        }

        return input;
    }
    
    // Overload for default charList being empty
    public String getValidInput(Scanner scanner, boolean allowNum, boolean allowChar, int[] intList) {
        char[] charList = new char[0];

        return getValidInput(scanner, allowNum, allowChar, intList, charList);
    }

    // Overload for default intList being empty
    public String getValidInput(Scanner scanner, boolean allowNum, boolean allowChar, char[] charList) {
        int[] intList = new int[0];

        return getValidInput(scanner, allowNum, allowChar, intList, charList);
    }

    // Overload for default intList and charList being empty
    public String getValidInput(Scanner scanner, boolean allowNum, boolean allowChar) {
        char[] charList = new char[0];
        int[] intList = new int[0];

        return getValidInput(scanner, allowNum, allowChar, intList, charList);
    }
}
