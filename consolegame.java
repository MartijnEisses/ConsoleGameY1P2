import java.util.Scanner;

public class consolegame {
    // private static boolean gameRunning = true;
    // private static int currentRoom = 0; // Is used to get the items in a room and
    // to drop the items
    public static String name;
    static Scanner scanner = new Scanner(System.in);
    public static Rooms rooms;
    public static TextFromFile textFromFile;
    // public static void playerName(String name) {
    // boolean nameSet = false;
    // do {
    // menu.printHeading("what's your name?");
    // name = scanner.next();
    // } while (!nameSet);
    // }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Menu menu = new Menu();
        rooms = new Rooms();
        menu.printMenu();

        // rooms.play();

        // Game loop
        // while (gameRunning) {

        // gameRunning = false;
        // }
    }
}