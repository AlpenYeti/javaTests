import java.util.Scanner;

/**
 * Generates the main Menu
 */
public class MainMenu{
    boolean exit = false;

    /***/
    public MainMenu() {
    }

    public void showMenu() {
        do{
        Scanner getInput = new Scanner(System.in);
        System.out.println( "                                  \n" +
                            " To start, choose an option, then \n" +
                            "press Enter :                     \n" +
                            "                                  \n" +
                            "1 - Play Guess my Number          \n" +
                            "2 - Access the social network     \n" +
                            "\u001B[36m3 - Exit the program \u001B[m");
        int choice = getInput.nextInt();

            switch (choice) {
                case 1:
                    guessNbr.guessNbr();
                    break;
                case 2:
                    UserMenu menu = new UserMenu();
                    menu.showMenu();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("\u001B[41m Option " + choice + " is invalid, please enter again \u001B[m");
            }
        } while(!exit);
    }
}