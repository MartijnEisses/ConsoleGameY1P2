import java.util.Scanner;
/**
 * Dit laat het menu van de game zien.
 *
 * @author (Martijn Hofstra)
 * @version (16-01-2019)
 */
public class Menu
{
    static Scanner scanner = new Scanner(System.in);

    //clears the console
    public static void clearConsole(){
        for(int i=0; i < 100; i++)
            System.out.println();
    }

    //prints title... nodig voor method character info
    public static void printHeading(String title){
        System.out.println(title);
    }

    //Displays self-chosen playername
    public static void characterInfo(){
        clearConsole();
        printHeading("CHARACTER INFO");
        System.out.println("Je naam is: " + consolegame.name);//hier moet de naam van player
    }

    //Displays About section
    public static void aboutSection(){
        clearConsole();
        System.out.println("Hallo" + consolegame.name + ", dit is welkom in de about section van deze game.");
        System.out.println("Deze game is gemaakt door: ");
        System.out.println("Martijn Eisses");
        System.out.println("Hein Douwe Havik");
        System.out.println("Martijn Hofstra");
        System.out.println("Deze Text Based Game is gemaakt in Java.");
        System.out.println("Deze game is gemaakt in blok 2 van jaar 1.");
    }

    public static void continueJourney(){
        System.out.println("Deze functionaliteit moet nog worden toegevoegd");
    }

    //Displaying end of game
    public static void quitJourney(){
        clearConsole();
        System.out.println("Bedankt voor het spelen van de game.");
        System.out.println("Hopelijk heb je van de game genoten.");
        System.out.println("");
        System.out.println("Deze game is gemaakt door: ");
        System.out.println("Martijn Eisses");
        System.out.println("Hein Douwe Havik");
        System.out.println("Martijn Hofstra");
        consolegame.gameRunning = false;
    }

    //Prints menu.!!De continue journey moet nog worden toegevoegd.
    public static void printMenu(){
        clearConsole();
        System.out.println("Choose an action:");
        System.out.println("-------------------");
        System.out.println("(1) Continue on your journey");//continue
        System.out.println("(2) Character Info");//info
        System.out.println("(3) Exit Game");//quit
        System.out.println("(4) About");//about
        if(scanner.next() == "1"){
            continueJourney();
        } else if(scanner.next() == "2"){
            characterInfo();
        } else if(scanner.next() == "3"){
            quitJourney();
        } else if(scanner.next() == "4"){
            aboutSection();
        }
    }
}
