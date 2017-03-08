import java.util.Scanner;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

/**
 * Created by josselin.perez on 08/03/2017.
 */
public class User {
    static String fname;
    static String lname;
    static String birthdate;
    static String[][] userlist = new String[3][3];

    public static void main(String[ ] args) {
        for (int i=0;i<userlist.length;i++) {
            new User();
            userlist[i][0] = fname;
            userlist[i][1] = lname;
            userlist[i][2] = birthdate;
            System.out.println("New User : " + userlist[i][0] + " " + userlist[i][1] + ", né(e) en " + userlist[i][2]);
        }
        for(String[] t:userlist) {
            System.out.println("User : " + t[0] + " " + t[1] + ", né(e) en " + t[2]);
        }
    } //End of method main()

    //User constructor
    public User(){
        Scanner getInput = new Scanner(System.in);
        System.out.println("Prénom ?");
            fname = getInput.nextLine();
        System.out.println("Nom ?");
            lname = getInput.nextLine();
        System.out.println("Année de Naissance ?");
            birthdate = getInput.nextLine();
    }//End of method User()
}//End of class User
