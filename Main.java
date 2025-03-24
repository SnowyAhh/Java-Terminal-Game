import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        Menu menu = new Menu();
        Util util = new Util();
        char[] validCharList = new char[1];
        validCharList[0] = 'q';
        String input = " ";
        Scanner scanner = new Scanner(System.in);

        while (input.charAt(0) != 'q') {
            menu.mainMenu();
            input = util.getValidInput(scanner, true, true, validCharList);
            if (input.equals("1")) {
                // Add game option here
            }
        }
        
        scanner.close();
    }

}