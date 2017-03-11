/**
 *  Main program
 */
public class Test {
    public static void main(String[ ] args) throws InterruptedException {
        System.out.println( "##################################\n" +
                            "#  Welcome to this test program  #\n" +
                            "##################################");
        MainMenu menu = new MainMenu();
        menu.showMenu();
    }
    public static void clear(){
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n‌​\n\n\n\n");
    }
}
