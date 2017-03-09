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
                            "3 - Exit the programm               ");
        int choice = getInput.nextInt();

            switch (choice) {
                case 1:
                    guessNbr.guessNbr();
                    break;
                case 2:
                    new User();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("This option is invalid, please enter again");
            }
        } while(!exit);
    }
}