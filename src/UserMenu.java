import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Display the Social Network Menu
 */
public class UserMenu {
    int choice;
    boolean exit = false;
    List<User> list = new ArrayList<>();

    public UserMenu() {
    }

    public void showMenu(){
//        new User();
        while(!exit) {
            Scanner getInput = new Scanner(System.in);
            System.out.println( "                                  \n" +
                    " To start, choose an option, then \n" +
                    "press Enter :                     \n" +
                    "                                  \n" +
                    "1 - Create my profile             \n" +
                    "2 - Edit my profile               \n" +
                    "3 - Write a message               \n" +
                    "4 - Read a message                \n" +
                    "5 - Add a friend                  \n" +
                    "6 - Show a friend's profile       \n" +
                    "                                  \n" +
                    "0 - Back to the main menu           ");
            choice =    getInput.nextInt();
                        getInput.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Prénom ?");
                    String fname = getInput.nextLine();
                    System.out.println("Nom ?");
                    String lname = getInput.nextLine();
                    System.out.println("Année de Naissance ?");
                    String birthdate = getInput.nextLine();
                    User user = new User(fname,lname,birthdate);
                    list.add(user);

                    break;
                case 2:
                    System.out.println( "####################################################\n" +
                                        list.get(0).fname + " " + list.get(0).lname + " né(e) en " + list.get(0).birthdate + "\n" +
                                        "####################################################");
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("\u001B[31m Option " + choice + " is invalid, please enter again \u001B[m");
            }
        }
    }
}
