import java.util.Scanner;
public class consolegame {
    private static boolean gameRunning = true;
    private static int currentRoom = 0; // Is used to get the items in a room and to drop the items
    public static String name;
    static Scanner scanner = new Scanner(System.in);
    
    public static void playerName(String name){
        boolean nameSet = false;
        do{
            Menu.clearConsole();
            Menu.printHeading("what's your name?");
            name = scanner.next();//
        }while(!nameSet);
    }
    
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        while (gameRunning) {
            gameRunning = false;
        }
    }
}