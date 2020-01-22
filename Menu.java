/**
 * Dit laat het menu van de game zien.
 *
 * @author (Martijn Hofstra)
 * @version (16-01-2019)
 */
public class Menu {
    private InputReader reader;

    public Menu() {
        reader = new InputReader();
    }

    // clears the console
    public void ClearConsole() {
        for (int i = 0; i < 1; i++)
            System.out.println();
    }

    // prints title... nodig voor method character info
    public void PrintHeading(String title) {
        System.out.println(title);// prints a stringvalue
    }

    // Displays self-chosen playername
    public void CharacterInfo() {
        ClearConsole();// clears console
        PrintHeading("CHARACTER INFO");// uses method printheading to println
        System.out.println("Je naam is: " + consolegame.name);// prints name of player
    }

    // Displays About section
    public void AboutSection() {
        ClearConsole();// clears console
        System.out.println("Hallo" + consolegame.name + ", dit is welkom in de about section van deze game.");
        Credits();
        System.out.println("Deze Text Based Game is gemaakt in Java.");
        System.out.println("Deze game is gemaakt in blok 2 van jaar 1.");
    }

    // Starts the game
    public void ContinueJourney() {
        consolegame.rooms.Play();
    }

    private void Credits() {
        System.out.println("Deze game is gemaakt door: ");
        System.out.println("Martijn Eisses");
        System.out.println("Hein Douwe Havik");
        System.out.println("Martijn Hofstra");
    }

    // Displaying end of game
    public void QuitJourney() {
        ClearConsole();// clears console
        System.out.println("Bedankt voor het spelen van de game.");
        System.out.println("Hopelijk heb je van de game genoten.");
        System.out.println("");
        Credits();
    }

    // Prints menu.!!De continue journey moet nog worden toegevoegd.
    public void PrintMenu() {
        boolean correctInput = false;
        ClearConsole();// clears console
        System.out.println("Choose an action:");
        System.out.println("-------------------");
        System.out.println("(1) Start the game");// continue
        System.out.println("(2) Character Info");// info
        System.out.println("(3) Exit Game");// quit
        System.out.println("(4) About");// about

        while (correctInput == false) {

            String input = reader.GetInput().toLowerCase();
            if (input.equals("1")) {
                ContinueJourney();// wanneer "1" de console in word gestuurd word de methode continueJourney()
                correctInput = true; // aangeroepen
            } else if (input.equals("2")) {
                CharacterInfo();// wanneer "2" de console in word gestuurd word de methode characterinfo()
                correctInput = true; // aangeroepen
            } else if (input.equals("3")) {
                QuitJourney();// wanneer "3" de console in word gestuurd word de methode quitJourney()
                correctInput = true; // aangeroepen
            } else if (input.equals("4")) {
                AboutSection();// wanneer "4" de console in word gestuurd word de methode aboutSection()
                correctInput = true; // aangeroepen
            } else {
                System.out.println(input + " is an incorrect input. Please try again");
            }
        }
    }
}
