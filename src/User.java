import java.util.Scanner;

/**
 * Define a User
 */
public class User {
    public String fname;
    protected String lname;
    protected String birthdate;
    int choice;
    boolean exit = false;

    Scanner getInput = new Scanner(System.in);

   // List<User> userList = new ArrayList<>();

    /**
     * User Constructor
     */
 public User(String fname,String lname,String birthdate) {
        this.fname = fname;
        this.lname = lname;
        this.birthdate = birthdate;
        System.out.println(fname + " " + lname + " né(e) en " + birthdate);
  }
}//End of class User
