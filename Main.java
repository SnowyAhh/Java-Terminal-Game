import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        Menu menu = new Menu();
        Util util = new Util();
        char[] validCharList = new char[1];
        String input = " ";
        Scanner scanner = new Scanner(System.in);
        rockPaperScissors rpsGame = new rockPaperScissors();

        while (input.charAt(0) != 'q') {
            menu.mainMenu();
            input = util.getValidInput(scanner, true, true, new char[]{'q'});
            if (input.equals("1")) {
                rpsGame.game();
            }
        }
        
        scanner.close();
    }

}