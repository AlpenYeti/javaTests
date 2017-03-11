import java.util.Scanner;
import java.util.Random;

/**
 * "Guess a Number" game
 */
public class guessNbr {
    private static int score;
    static Scanner getInput = new Scanner(System.in);

    public static void guessNbr() {
        System.out.println("Saisis le nombre maximum que tu veux deviner :");
        int limit = (getInput.nextInt());
        Random randomGenerator = new Random();
        int x = randomGenerator.nextInt(limit);
        Test.clear();
        System.out.println("Je pense à un nombre entre 1 et " + limit);
        int guess = (getInput.nextInt());
        score = 1;

        while(guess != x){
            if(guess < x){
                Test.clear();
                System.out.println("C'est plus grand !");
                guess = (getInput.nextInt());
                score++;
            } else {
                Test.clear();
                System.out.println("C'est plus petit !");
                guess = (getInput.nextInt());
                score++;
            }
        }//end while
    success();
    }

    public static void success() {
        Test.clear();
        if (score == 1) {
            System.out.println("Wow ! Du premier coup, bravo !");
        } else if (score < 6) {
            System.out.println("Très le GG ! " + score + " essais !");
        } else {
            System.out.println("Eh ben, " + score + " essais ?! On a vu mieux hein !");
        }
        System.out.println( "##################################\n" +
                            "           Play Again ?           \n" +
                            "##################################\n" +
                            "1 - Yes !                         \n" +
                            "2 - No, back to the menu please   \n");
        int choice = (getInput.nextInt());
        switch(choice){
            case 1:
                guessNbr();
                break;
            case 2:
                Test.clear();
                break;
        }
    }
}
