import java.util.Scanner;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

/**
 * Created by josselin.perez on 08/03/2017.
 */
public class User {
    public static void main(String[ ] args) {
        Scanner getInput = new Scanner(System.in);
        System.out.println("Prénom ?");
        String fname = getInput.nextLine();
        System.out.println("Nom ?");
        String lname = getInput.nextLine();
        System.out.println("Année de Naissance ?");
        int birthdate = getInput.nextInt();

        System.out.println("Bonjour " + fname + " " + lname + ", vous êtes nés en " + birthdate + ".");
    }
}
