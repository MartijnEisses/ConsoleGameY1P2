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

    // prints title... nodig voor method character info
    public void PrintHeading(String title) {
        System.out.println(title);// prints a stringvalue
    }

    // Displays About section
    public void AboutSection() {
        Credits();
        System.out.println("This textbased game was created in java");
        System.out.println("and was created in the second period of the first year");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        PrintMenu();
    }

    // Starts the game
    public void ContinueJourney() {
        consolegame.rooms.Play();
    }

    private static void Credits() {
        System.out.println("This game was made by: ");
        System.out.println("Martijn Eisses");
        System.out.println("Hein Douwe Havik");
        System.out.println("Martijn Hofstra");
    }

    // Displaying end of game
    public void QuitJourney() {
        Credits();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    // Prints menu.!!De continue journey moet nog worden toegevoegd.
    public void PrintMenu() {
        boolean correctInput = false;
        System.out.println("Choose an action:");
        System.out.println("-------------------");
        System.out.println("(1) Start the game");// continue
        System.out.println("(2) About");// about
        System.out.println("(3) Exit Game");// quit

        while (correctInput == false) {

            String input = reader.GetInput().toLowerCase();
            if (input.equals("1")) {
                ContinueJourney();// wanneer "1" de console in word gestuurd word de methode continueJourney()
                correctInput = true; // aangeroepen
            } else if (input.equals("2")) {
                AboutSection();
                correctInput = true; // aangeroepen
            } else if (input.equals("3")) {
                QuitJourney();// wanneer "3" de console in word gestuurd word de methode quitJourney()
                correctInput = true; // aangeroepen
            } else {
                System.out.println(input + " is an incorrect input. Please try again");
            }
        }
    }
}
