import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Display the Social Network Menu
 */
public class UserMenu {
    private String choice;
    private String switchChoice;
    private boolean exit = false;
    private boolean exitSwitch = false;
    private ArrayList<User> userlist = new ArrayList<>();
    private List<Message> messages = new ArrayList<>();

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
                    "8 - Administration                  " +
                    "                                  \n" +
                    "\u001B[36m0 - Back to the main menu \u001B[m");
            choice = getInput.nextLine();
            switch (choice) {
                case "1":
                    if(userlist.isEmpty()){
                        System.out.println("Prénom ?");
                        String fname = getInput.nextLine();
                        System.out.println("Nom ?");
                        String lname = getInput.nextLine();
                        System.out.println("Année de Naissance ?");
                        String birthdate = getInput.nextLine();
                        System.out.println("Niveau d'accréditation ?");
                        String acc = getInput.nextLine();
                        int accreditation = Integer.parseInt(acc);
                        Moderator user = new Moderator(fname,lname,birthdate,accreditation);
                        userlist.add(user);
                    } else {
                        Test.clear();
                        System.out.println(
                                        "\u001B[41m You already created a profile ! \u001B[m \n" +
                                        "\u001B[41m You can modify it with 2.       \u001B[m   ");
                    }

                    break;
                case "2":
                    if(userlist.isEmpty()){
                        Test.clear();
                        System.out.println("\u001B[41m You should create a profile first \u001B[m");
                    } else {
                        Moderator modo = (Moderator) userlist.get(0);
                        System.out.println(
                                "####################################################\n" +
                                        userlist.get(0).fname + " " + userlist.get(0).lname + " né(e) en " + userlist.get(0).birthdate + "\n" +
                                        "Accredité niveau " + modo.accreditation + "\n" +
                                        "####################################################\n" +
                                        "Do you want to modify it ?  [Y/n]                     ");
                        choice = getInput.nextLine();
                        switch (choice) {
                            case "y":
                            case "Y":
                                System.out.println("Prénom ?");
                                userlist.get(0).fname = getInput.nextLine();
                                System.out.println("Nom ?");
                                userlist.get(0).lname = getInput.nextLine();
                                System.out.println("Année de Naissance ?");
                                userlist.get(0).birthdate = getInput.nextLine();
                                break;
                            case "n":
                            case "N":
                                break;
                        }
                    }
                    break;
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
                    displayListUsers();
                    break;
                case "6":
                    exitSwitch = false;
                    do{
                        System.out.println("Prénom ?");
                        String fname = getInput.nextLine();
                        System.out.println("Nom ?");
                        String lname = getInput.nextLine();
                        System.out.println("Année de Naissance ?");
                        String birthdate = getInput.nextLine();
                        User user = new User(fname,lname,birthdate);
                        userlist.add(user);
                        System.out.println("Add more friends ? [Y/n]");
                        switchChoice = getInput.nextLine();
                        YesNoMenu();
                    } while(!exitSwitch);
                    break;
                case "7":
                    break;
                case "8":
                    if(userlist.isEmpty()){
                        Test.clear();
                        System.out.println("\u001B[41m No user has been allowed here \u001B[m");
                    } else {
                        Test.clear();
                        Moderator modo = (Moderator) userlist.get(0);
                        System.out.println(
                                " ******************************** \n" +
                                "          SOCIAL NETWORK          \n" +
                                " ******************************** \n" +
                                "                                  \n" +
                                "1 - Delete a message                ");
                            if(modo.accreditation == 2) {
                                System.out.println(
                                    "2 - Delete a profile                " +
                                    "                                    ");
                            }
                        System.out.println(
                                "\u001B[36m0 - Back to the network menu \u001B[m");
                            choice = getInput.nextLine();
                        switch(choice){
                            case "1":
                                displayListMessages();
                                System.out.println("");
                                break;
                            case "2":
                                displayListUsers();
                                System.out.println("\nEnter the ID of the user you want to delete\n");
                                choice = getInput.nextLine();
                                int userNumChoice = Integer.parseInt(choice) - 1;
                                if(userNumChoice > 0 && userNumChoice < userlist.size()){
                                    System.out.println("\u001B[31m Are you sure you want to delete user " + choice + " ?\u001B[m\n" +
                                            "If you are sure, type \u001B[31mDELETE\u001B[m then press enter. Otherwise, type anything");
                                    String confirm = getInput.nextLine();
                                    if(Objects.equals(confirm, "DELETE")){
                                        userlist.remove(userNumChoice);
                                        System.out.println("User " + choice + " has been \u001B[33msuccessfully\u001B[m deleted.");
                                    } else {
                                        System.out.println("\n\u001B[41m You didn't delete anything as the passphrase was wrong \u001B[m");
                                    }
                                } else {
                                    System.out.println("\u001B[41m User " + choice + " doesn't exist \u001B[m");
                                }
                                break;
                            case "0":
                                break;
                            default:
                                Test.clear();
                                System.out.println("\u001B[41m Option " + choice + " is invalid, please enter again \u001B[m");
                        }
                    }
                    break;
                case "0":
                    Test.clear();
                    break;

                case "bite":
                    Test.clear();
                    System.out.println("\u001B[31m You such a troll, I like you a lot :D \u001B[m");
                    break;

                case "clear":
                    Test.clear();
                    System.out.println("\u001B[33m Haha, les reflexes à la con ! \u001B[m");
                    break;

                default:
                    Test.clear();
                    System.out.println("\u001B[41m Option " + choice + " is invalid, please enter again \u001B[m");
            }
        }
    }
    boolean YesNoMenu() {
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
        return exitSwitch;
    }

    void displayListUsers() throws InterruptedException {
        if(userlist.size() < 1) {
            System.out.println("\u001B[41m There are no users yet ! \u001B[m");
            TimeUnit.SECONDS.sleep(1);
        } else {
            for(int i = 0; i< userlist.size(); i++){
                System.out.println((i+1) + " - " + userlist.get(i).fname + " " + userlist.get(i).lname + " né(e) en " + userlist.get(i).birthdate);
            }
        }
    }

    void displayListMessages() throws InterruptedException {
        if(messages.size() < 1) {
            System.out.println("\u001B[41m There are no users yet ! \u001B[m");
            TimeUnit.SECONDS.sleep(1);
        } else {
            for(int i = 0; i<messages.size();i++){
                System.out.println((i+1) + " - " + messages.get(i).content);
            }
        }
    }
}