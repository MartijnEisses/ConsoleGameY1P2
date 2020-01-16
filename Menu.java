
/**
 * Shows menu
 *
 * @author (Martijn)
 * @version (16-01-2019)
 */
public class Menu
{
    //clears the console
    public static void clearConsole(){
        for(int i=0; i < 100; i++)
            System.out.println();
    }

    public static void printHeading(String title){
        
        System.out.println(title);
        
    }

    //moet afgemaakt worden....optioneel
    public static void characterInfo(){
        clearConsole();
        printHeading("CHARACTER INFO");
        System.out.println(/*playername*/);//hier moet de naam van player
    }
    
    //moet afgemaakt worden....verplicht
    public static void about(){
        clearConsole();
        System.out.println("Deze game is gemaakt door: ");
        System.out.println("Martijn Eisses");
        System.out.println("Hein Douwe Havik");
        System.out.println("Martijn Hofstra");
        System.out.println("Deze Text Based Game is gemaakt in Java");
    }
    
    //moet afgemaakt worden....verplicht
    public static void Quit(){
        System.out.println("Dit was de game");
    }

    //Print het menu.
    public static void printMenu(){
        clearConsole();
        printHeading(/*plek van character*/"");
        System.out.println("Choose an action:");
        System.out.println("-------------------");
        System.out.println("(1) Continue on your journey");//continue
        System.out.println("(2) Character Info");//info
        System.out.println("(3) Exit Game");//quit
        System.out.println("(4) About");//about
    }
}
