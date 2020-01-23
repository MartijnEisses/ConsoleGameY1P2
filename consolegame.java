import java.util.Scanner;

public class consolegame {
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
        Menu menu = new Menu();
        rooms = new Rooms();
        menu.PrintMenu();
    }
}