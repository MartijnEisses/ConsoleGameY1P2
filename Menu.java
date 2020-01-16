
/**
 * Write a description of class Quit here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Menu
{
    public static void printSeperator(int n){
        for(int i = 0; i < n; i++)
            System.out.println("-");
        System.out.println();
    }

    public static void clearConsole(){
        for(int i=0; i < 100; i++)
            System.out.println();
    }

    public static void printHeading(String title){
        printSeperator(30);
        System.out.println(title);
        printSeperator(30);
    }

    //Print het menu.
    public static void printMenu(){
        clearConsole();
        printHeading("MENU");
        System.out.println("Choose an action:");
        printSeperator(20);
        System.out.println("(1) Continue on your journey");
        System.out.println("(2) Character Info");
        System.out.println("(3) Exit Game");
    }
}
