import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.util.Scanner;
import java.util.Random;

/**
 * Created by josselin.perez on 08/03/2017.
 * Ce programme fait deviner un nombre au user.
 */
public class guessNbr {
    public static void main(String[ ] args) {
        Scanner getInput = new Scanner(System.in);
        System.out.println("Saisis le nombre maximum que tu veux deviner :");
        int limit = (getInput.nextInt());
        Random randomGenerator = new Random();
        int x = randomGenerator.nextInt(limit);
        System.out.println("Je pense à un nombre entre 1 et " + limit);
        int guess = (getInput.nextInt());
        int score = 1;

        while(guess != x){
            if(guess < x){
                System.out.println("C'est plus grand !");
                guess = (getInput.nextInt());
                score++;
            } else {
                System.out.println("C'est plus petit !");
                guess = (getInput.nextInt());
                score++;
            }
        }
        if(score == 1){
            System.out.println("Wow ! Du premier coup, bravo !");
        } else if(score < 6) {
            System.out.println("Très le GG ! " +  score + " essais !");
        } else {
            System.out.println("Eh ben, " + score + " essais ?! On a vu mieux hein !");
        }
    }
}
