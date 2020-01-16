import java.util.Scanner;
/**
 * Dit laat het menu van de game zien.
 *
 * @author (Martijn Hofstra)
 * @version (16-01-2019)
 */
public class Menu
{
    static Scanner scanner = new Scanner(System.in);//used for console input

    //clears the console
    public static void clearConsole(){
        for(int i=0; i < 100; i++)
            System.out.println();
    }

    //prints title... nodig voor method character info
    public static void printHeading(String title){
        System.out.println(title);//prints a stringvalue
    }

    //Displays self-chosen playername
    public static void characterInfo(){
        clearConsole();//clears console
        printHeading("CHARACTER INFO");//uses method printheading to println
        System.out.println("Je naam is: " + consolegame.name);//prints name of player
    }

    //Displays About section
    public static void aboutSection(){
        clearConsole();//clears console
        System.out.println("Hallo" + consolegame.name + ", dit is welkom in de about section van deze game.");
        System.out.println("Deze game is gemaakt door: ");
        System.out.println("Martijn Eisses");
        System.out.println("Hein Douwe Havik");
        System.out.println("Martijn Hofstra");
        System.out.println("Deze Text Based Game is gemaakt in Java.");
        System.out.println("Deze game is gemaakt in blok 2 van jaar 1.");
    }

    public static void continueJourney(){
        System.out.println("Deze functionaliteit moet nog worden toegevoegd");//no functionality
    }

    //Displaying end of game
    public static void quitJourney(){
        clearConsole();//clears console
        System.out.println("Bedankt voor het spelen van de game.");
        System.out.println("Hopelijk heb je van de game genoten.");
        System.out.println("");
        System.out.println("Deze game is gemaakt door: ");
        System.out.println("Martijn Eisses");
        System.out.println("Hein Douwe Havik");
        System.out.println("Martijn Hofstra");
        consolegame.gameRunning = false;//ends game
    }

    //Prints menu.!!De continue journey moet nog worden toegevoegd.
    public static void printMenu(){
        clearConsole();//clears console
        System.out.println("Choose an action:");
        System.out.println("-------------------");
        System.out.println("(1) Continue on your journey");//continue
        System.out.println("(2) Character Info");//info
        System.out.println("(3) Exit Game");//quit
        System.out.println("(4) About");//about
        if(scanner.next() == "1"){
            continueJourney();//wanneer "1" de console in word gestuurd word de methode continueJourney() aangeroepen
        } else if(scanner.next() == "2"){
            characterInfo();//wanneer "2" de console in word gestuurd word de methode characterinfo() aangeroepen
        } else if(scanner.next() == "3"){
            quitJourney();//wanneer "3" de console in word gestuurd word de methode quitJourney() aangeroepen
        } else if(scanner.next() == "4"){
            aboutSection();//wanneer "4" de console in word gestuurd word de methode aboutSection() aangeroepen
        }
    }
}
