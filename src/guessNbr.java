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
        getInput.nextLine();
        score = 1;

        while(guess != x){
            if(guess < x){
                Test.clear();
                System.out.println("C'est plus grand !");
                guess = (getInput.nextInt());
                getInput.nextLine();
                score++;
            } else {
                Test.clear();
                System.out.println("C'est plus petit !");
                guess = (getInput.nextInt());
                getInput.nextLine();
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
            System.out.println("Très le GG ! \u001B[32m" + score + "\u001B[0m essais !");
        } else {
            System.out.println("Eh ben, \u001B[31m" + score + "\u001B[0m essais ?! On a vu mieux hein !\n");
        }
        System.out.println( "##################################\n" +
                            "         Play Again ?  [Y/n]      \n" +
                            "##################################\n");
        String choice = (getInput.nextLine());
        switch(choice){
            case "y":
            case "Y":
                Test.clear();
                guessNbr();
                break;
            case "n":
            case "N":
                Test.clear();
                break;
        }
    }
}
