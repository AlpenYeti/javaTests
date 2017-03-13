import java.util.concurrent.TimeUnit;
import java.util.Random;

/**
 *  Main program
 */
public class Test {
    public static void main(String[ ] args) throws InterruptedException {
        System.out.println( "##################################\n" +
                            "#  Welcome to this test program  #\n" +
                            "##################################");
        fakeWait(3);
        MainMenu menu = new MainMenu();
        menu.showMenu();
    }



    /**
     * Prints 25 lines to clear the view
     */
    public static void clear(){
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n‌​\n\n\n\n");
    }

    /**
     * Generates random dots for good'ol wait animation
     * @param limit
     * @throws InterruptedException
     */
    private static void fakeWait(int limit) throws InterruptedException {
        for(int i=0;i<limit;i++){
            Random randomGenerator = new Random();
            int x = randomGenerator.nextInt(3000);
            TimeUnit.MILLISECONDS.sleep(x);
            System.out.println(".");
        }
    }
}
