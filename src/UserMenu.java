import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Display the Social Network Menu
 */
public class UserMenu {
    String choice;
    String switchChoice;
    boolean exit = false;
    boolean exitSwitch = false;
    List<User> list = new ArrayList<>();
    List<Message> messages = new ArrayList<>();

    public UserMenu() throws InterruptedException {
        showMenu();
    }

    void showMenu() throws InterruptedException {
        while(!exit) {
            Scanner getInput = new Scanner(System.in);
            System.out.println(
                    "                                  \n" +
                    " ******************************** \n" +
                    "          SOCIAL NETWORK          \n" +
                    " ******************************** \n" +
                    "                                  \n" +
                    "1 - Create my profile             \n" +
                    "2 - Edit my profile               \n" +
                    "3 - Write a message               \n" +
                    "4 - Read a message                \n" +
                    "5 - Display users                 \n" +
                    "6 - Create a new user (friend)    \n" +
                    "7 - Show a friend's profile       \n" +
                    "                                  \n" +
                    "\u001B[36m0 - Back to the main menu \u001B[m");
            choice = getInput.nextLine();
            switch (choice) {
                case "1":
                    if(list.isEmpty()){
                        System.out.println("Prénom ?");
                        String fname = getInput.nextLine();
                        System.out.println("Nom ?");
                        String lname = getInput.nextLine();
                        System.out.println("Année de Naissance ?");
                        String birthdate = getInput.nextLine();
                        User user = new User(fname,lname,birthdate);
                        list.add(user);
                    } else {
                        Test.clear();
                        System.out.println(
                                        "\u001B[41m You already created a profile ! \u001B[m \n" +
                                        "\u001B[41m You can modify it with 2.       \u001B[m   ");
                    }

                    break;
                case "2":
                    if(list.isEmpty()){
                        Test.clear();
                        System.out.println("\u001B[41m You should create a profile first \u001B[m");
                    } else {
                        System.out.println(
                                "####################################################\n" +
                                list.get(0).fname + " " + list.get(0).lname + " né(e) en " + list.get(0).birthdate + "\n" +
                                "####################################################\n" +
                                "Do you want to modify it ?  [Y/n]                     ");
                        choice = getInput.nextLine();
                        switch (choice) {
                            case "y":
                            case "Y":
                                System.out.println("Prénom ?");
                                list.get(0).fname = getInput.nextLine();
                                System.out.println("Nom ?");
                                list.get(0).lname = getInput.nextLine();
                                System.out.println("Année de Naissance ?");
                                list.get(0).birthdate = getInput.nextLine();
                                break;
                            case "n":
                            case "N":
                                break;
                        }
                        break;
                    }
                case "3":
                    do{
                        System.out.println("What's your message ?");
                        String content = getInput.nextLine();

                        Message message = new Message(content);
                        messages.add(message);
                        System.out.println("Do you write to write another one ? [Y/n]");
                        switchChoice = getInput.nextLine();
                        YesNoMenu();
                    } while(!exitSwitch);
                    break;
                case "4":
                    System.out.println(
                            "There are "+ messages.size() + " messages." +
                            "Choose the message you want to read.");
                    choice = getInput.nextLine();
                    int numChoice = Integer.parseInt(choice)-1;
                    System.out.println((numChoice+1) + " - " + messages.get(numChoice).content);
                    break;
                case "5":
                    if(list.size() < 1) {
                        System.out.println("\u001B[41m There are no users yet ! \u001B[m");
                        TimeUnit.SECONDS.sleep(1);
                    } else {
                        for(int i = 0; i<list.size();i++){
                            System.out.println(i + " - " + list.get(i).fname + " " + list.get(i).lname + " né(e) en " + list.get(i).birthdate);
                        }
                    }
                    break;
                case "6":
                    boolean exitSwitch = false;
                    do{
                        System.out.println("Prénom ?");
                        String fname = getInput.nextLine();
                        System.out.println("Nom ?");
                        String lname = getInput.nextLine();
                        System.out.println("Année de Naissance ?");
                        String birthdate = getInput.nextLine();
                        User user = new User(fname,lname,birthdate);
                        list.add(user);
                        System.out.println("Add more friends ? [Y/n]");
                        switchChoice = getInput.nextLine();
                        YesNoMenu();
                    } while(!exitSwitch);
                    break;
                case "7":
                    break;
                case "0":
                    exit = true;
                    break;
                default:
                    Test.clear();
                    System.out.println("\u001B[41m Option " + choice + " is invalid, please enter again \u001B[m");
            }
        }
    }
    void YesNoMenu() {
        switch (switchChoice){
            case "y":
            case "Y":
                Test.clear();
                break;
            case "n":
            case "N":
                exitSwitch = true;
                Test.clear();
                break;
        }
    }
}
