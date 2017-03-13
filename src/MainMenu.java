import java.util.Scanner;

/**
 * Generates the main Menu
 */
public class MainMenu{
    boolean exit = false;

    /***/
    public MainMenu() throws InterruptedException {
        showMenu();
    }

    void showMenu() throws InterruptedException {
        do{
        Scanner getInput = new Scanner(System.in);
        System.out.println( "                                  \n" +
                            " To start, choose an option, then \n" +
                            "press Enter :                     \n" +
                            "                                  \n" +
                            "1 - Play Guess my Number          \n" +
                            "2 - Access the social network     \n" +
                            "3 - Divide !                      \n" +
                            "\u001B[36m4 - Exit the program \u001B[m");
        String choice = getInput.nextLine();

            switch (choice) {
                case "1":
                    Test.clear();
                    guessNbr.guessNbr();
                    break;
                case "2":
                    Test.clear();
                    UserMenu menu = new UserMenu();
                    menu.showMenu();
                    break;
                case "3":
                    Test.clear();
                    System.out.println("Dividende");
                    int a = getInput.nextInt();
                    getInput.nextLine();
                    System.out.println("Diviseur");
                    int b = getInput.nextInt();
                    getInput.nextLine();
                    try {
                        System.out.println(a/b);
                    } catch(ArithmeticException e) {
                        System.out.println("\u001B[41;30m Do not divide by zero, you fool !\u001B[m");
                    }
                    break;
                case "4":
                    exit = true;
                    break;
                default:
                    Test.clear();
                    System.out.println("\u001B[41;30m Option " + choice + " is invalid, please enter again \u001B[m");
            }
        } while(!exit);
    }

//    double divide(int a, int b){
//        double res;
//        try {
//            res = a/b;
//        } catch (ArithmeticException e){
//            System.out.println("Do not divide by zero, you fool !");
//        } finally {
//            return res;
//        }
//    }
}