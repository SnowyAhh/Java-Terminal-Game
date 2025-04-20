import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        Menu menu = new Menu();
        Util util = new Util();
        String input = " ";
        Scanner scanner = new Scanner(System.in);
        rockPaperScissors rpsGame = new rockPaperScissors();
        mathQuiz mathQuiz = new mathQuiz();

        while (input.charAt(0) != 'q') {
            menu.mainMenu();
            input = util.getValidInput(scanner, true, true, new char[]{'q'});
            switch (input) {
                case "1":
                    rpsGame.game();
                    break;
                case "2":
                    // FIXME: add guess the number
                    break;
                case "3":
                    mathQuiz.game();
                    break;
            }
        }
        
        scanner.close();
    }

}