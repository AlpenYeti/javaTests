import java.util.Scanner;

/**
 * Define a User
 */
public class User {
    int choice;
    boolean exit = false;
    String fname;
    String lname;
    String birthdate;
    static String[] messages = new String[5];
    Scanner getInput = new Scanner(System.in);

//    static String[][] userlist = new String[3][3];

    /**
     * User Constructor
     */
    public User() {
        setFname();
        setLname();
        setBirthdate();
        System.out.println(fname + " " + lname + " né(e) en " + birthdate);
        userMenu();
    }

    public String setFname() {
        System.out.println("Prénom ?");
        fname = getInput.nextLine();
        return fname;
    }

    public String setLname() {
        System.out.println("Nom ?");
        lname = getInput.nextLine();
        return lname;
    }

    public String setBirthdate() {
        System.out.println("Année de Naissance ?");
        birthdate = getInput.nextLine();
        return birthdate;
    }




    public void userMenu(){
        do {
            Scanner getInput = new Scanner(System.in);
            System.out.println( "                                  \n" +
                                " To start, choose an option, then \n" +
                                "press Enter :                     \n" +
                                "                                  \n" +
                                "1 - Show my profile               \n" +
                                "2 - Edit my profile               \n" +
                                "3 - Write a message               \n" +
                                "4 - Read a message                \n" +
                                "5 - Add a friend                  \n" +
                                "6 - Show a friend's profile       \n" +
                                "                                  \n" +
                                "0 - Back to the main menu           ");
            choice = getInput.nextInt();
            switch (choice) {
                case 1:
                    System.out.println( "####################################################\n" +
                                        fname+" "+lname+" né(e) en "+birthdate+"\n" +
                                        "####################################################");
                    break;
                case 2:

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
                    System.out.println("This option is invalid, please enter again");
            }
        } while(!exit);
    }








//    public Userlist() {
//        for (int i=0;i<userlist.length;i++) {
//            new User();
//            userlist[i][0] = fname;
//            userlist[i][1] = lname;
//            userlist[i][2] = birthdate;
//            System.out.println("New User : " + userlist[i][0] + " " + userlist[i][1] + ", né(e) en " + userlist[i][2]);
//        }
//        for(String[] t:userlist) {
//            System.out.println("User : " + t[0] + " " + t[1] + ", né(e) en " + t[2]);
//        }
//    }

}//End of class User
