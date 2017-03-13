/**
 * Define a User
 */
public class User {
    protected String fname;
    protected String lname;
    protected String birthdate;
    int choice;
    boolean exit = false;

    /**
     * User Constructor
     *
     * @param fname
     * @param lname
     * @param birthdate
     */
 public User(String fname,String lname,String birthdate) {
        this.fname = fname;
        this.lname = lname;
        this.birthdate = birthdate;
        System.out.println(fname + " " + lname + " né(e) en " + birthdate);
  }
}//End of class User
