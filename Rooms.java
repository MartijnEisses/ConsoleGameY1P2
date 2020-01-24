import java.util.HashMap;
import java.util.Stack;
import java.util.*;

public class Rooms {
    private Room currentRoom;
    private InputReader reader;
    private HashMap<String, Room> roomsMap;
    private TextFromFile lines;
    private Inventory inventory;
    private Room one, two, three, four, five, six;
    private Stack<Integer> roomStacks;

    public Rooms() {
        reader = new InputReader();
        roomsMap = new HashMap<>();
        lines = new TextFromFile();
        inventory = new Inventory();
        roomStacks = new Stack<>();
        SetRooms();
        AddToMap();
        SetDoors();
    }

    public void Play() {

        System.out.println(lines.GetLine(2));
        System.out.println(lines.GetLine(3));
        System.out.println(lines.GetLine(4));
        Help();
        boolean finished = false;
        CheckRoom();
        while (!finished) {

            String input = reader.GetInput().toLowerCase();

            if (input.equals("quit")) {
                finished = true;
            } else if (input.equals("what room am i in")) {
                CheckRoom();
            } else if (input.equals("open door 1")) {
                NextRoom(1);
            } else if (input.equals("open door 2")) {
                NextRoom(2);
            } else if (input.equals("open door 3")) {
                NextRoom(3);
            } else if (input.equals("go down")) {
                if (currentRoom != four) {
                    System.out.println("WASTED! - You can't go down here...");
                    finished = true;
                } else {
                    trapDoorFunction(1);
                }
            } else if (input.equals("go up")) {
                if (currentRoom != five) {
                    System.out.println("WASTED! - You can't go up here...");
                    finished = true;
                } else {
                    trapDoorFunction(2);
                }
            } else if (input.equals("how many doors are there")) {
                int numberOfDoors = currentRoom.GetDoors();
                System.out.println("There are: " + numberOfDoors + " doors");
            } else if (input.equals("where does door 1 lead?")) {
                GetDoorDescription(1);
            } else if (input.equals("where does door 2 lead?")) {
                GetDoorDescription(2);
            } else if (input.equals("where does door 3 lead?")) {
                GetDoorDescription(3);
            } else if (input.contains("take")) {
                String temp = input.replace("take ", "");
                System.out.println(temp);
                TakeItem(temp);
            } else if (input.contains("drop")) {
                String temp = input.replace("drop ", "");
                DropItem(temp);
            } else if (input.equals("show inventory")) {
                inventory.ShowInventory();
            } else if (input.equals("back")) {
                back();
            } else if (input.contains("use")) {
                String temp = input.replace("use ", "");
                UseItemOnObject(temp);
            } else {
                Help();
            }
        }
        lines.GetLine(37);
    }

    private void UseItemOnObject(String input) {
        String[] splitted = input.split(" on ");
        boolean inInventory = false;
        Iterator<Item> it = inventory.GetInventory().iterator();
        while (it.hasNext()) {
            Item item = it.next();
            // Checks if there is an item with that name in the users inventory
            if (item.GetName().toLowerCase().equals(splitted[0])) {
                inInventory = true;
            }
        }
        if (inInventory) {

            if (splitted[0].equals("key")) {
                if (currentRoom.GetRoomNumber() == 1) {
                    if (splitted[1].equals("lock")) {
                        one.SetDoor(3, new Door(3, 6, "This door leads to a dark room", true));
                        inventory.DestroyItem(splitted[0]);
                    }
                }
            } else if (currentRoom.GetRoomNumber() == 6) {
                if (splitted[0].equals("flashlight")) {
                    if (splitted[1].equals("room")) {
                        System.out.println(lines.GetLine(32));
                        six.SetRoomDescription("Room 6 - Empty room");
                        one.SetDoor(3, new Door(3, 6, "This door leads a room with a boarded window", true));
                        inventory.DestroyItem(splitted[0]);
                    }
                } else if (splitted[0].equals("crowbar")) {
                    if (splitted[1].equals("window")) {
                        System.out.println(lines.GetLine(35));
                        System.out.println(lines.GetLine(36));
                        System.out.println(lines.GetLine(37));
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                        System.exit(0);
                    }
                }
            } else {
                System.out.println(lines.GetLine(38));
            }
        } else {
            System.out.println(lines.GetLine(41));
        }
    }

    private void TakeItem(String itemName) {
        inventory.AddItemToInventory(itemName, currentRoom.GetRoomNumber());
    }

    private void DropItem(String itemName) {
        inventory.RemoveItemFromInventory(itemName, currentRoom.GetRoomNumber());
    }

    private void Help() {
        System.out.println(lines.GetLine(5));
        System.out.println(lines.GetLine(6));
        System.out.println(lines.GetLine(7));
        System.out.println(lines.GetLine(8));
        System.out.println(lines.GetLine(9));
        System.out.println(lines.GetLine(42));
        System.out.println(lines.GetLine(43));
        System.out.println(lines.GetLine(44));
        System.out.println(lines.GetLine(45));
    }

    private void SetRooms() {

        // Rooms are created
        one = new Room(1, "Room 1 - Barn", new int[] { 10, 11, 12, 13 });
        two = new Room(2, "Room 2 - Stalls", new int[] { 14, 15, 16, 17, 18, 19 });
        three = new Room(3, "Room 3 - Work room", new int[] { 20, 21, 22 });
        four = new Room(4, "Room 4 - Kitchen", new int[] { 23, 24, 25, 26 });
        five = new Room(5, "Room 5 - Trapdoor Kitchen", new int[] { 27, 28, 29 });
        six = new Room(6, "Room 6 - Dark room", new int[] { 30, 31 });
        currentRoom = one;
    }

    private void AddToMap() {

        // Rooms are added to HashMap
        roomsMap.put("1", one);
        roomsMap.put("2", two);
        roomsMap.put("3", three);
        roomsMap.put("4", four);
        roomsMap.put("5", five);
        roomsMap.put("6", six);

    }

    public void SetDoors() {
        // All the doors needed to get to each room
        Door doorOne = new Door(1, 2, "This door leads to the stalls", true);
        Door doorTwo = new Door(2, 3, "This door leads to the work room", true);
        Door doorThree = new Door(3, 6, "This door leads to a dark room", false);
        Door doorFour = new Door(4, 1, "This door leads to the barn", true);
        Door doorFive = new Door(5, 4, "This door leads to the kitchen", true);

        // Set doors for the different room
        one.SetDoor(1, doorOne);
        one.SetDoor(2, doorTwo);
        one.SetDoor(3, doorThree);
        two.SetDoor(1, doorFour);
        three.SetDoor(1, doorFour);
        three.SetDoor(2, doorFive);
        four.SetDoor(1, doorTwo);
        six.SetDoor(1, doorFour);

    }

    private String GetRoomInformation() {
        String s = currentRoom.GetRoom() + "\n";
        for (int i = 1; i <= currentRoom.GetDoors(); i++) {
            s += currentRoom.GetDoorDescription(i) + "\n";
        }
        return s;
    }

    public void CheckRoom() {
        System.out.println("\n" + GetRoomInformation());
        for (Integer line : currentRoom.GetRoomLines()) {
            System.out.println(lines.GetLine(line));
        }
        System.out.println("\n");
        CheckItemsInRoom();
    }

    public void GetDoorDescription(int number) {
        String useDoorDescr = currentRoom.GetDoorDescription(number);
        System.out.println(useDoorDescr);
    }

    private void CheckItemsInRoom() {
        System.out.println("items in this room are:");
        inventory.GetItemsInRoom(currentRoom.GetRoomNumber());
    }

    public void trapDoorFunction(int number) {
        if (number == 1) {
            currentRoom = five;
            CheckRoom();
        } else if (number == 2) {
            currentRoom = four;
            CheckRoom();
        }
    }

    public void back() {
        if (roomStacks.empty() != true) {
            int thisRoomNumber = roomStacks.pop();
            currentRoom = roomsMap.get(String.valueOf(thisRoomNumber));
            CheckRoom();
        } else {
            System.out.println("You can't go back!");
        }
    }

    public void NextRoom(int number) {

        if (currentRoom.GetDoors() < number) {
            int numberOfDoors = currentRoom.GetDoors();
            if (numberOfDoors == 1) {
                System.out.println("There is only: " + numberOfDoors + " door");
            } else {
                System.out.println("There are only: " + numberOfDoors + " doors");
            }
        } else {
            if (currentRoom.checkDoorunlock(number) == true) {
                int test = currentRoom.GetRoomNumber();
                roomStacks.push(test);
                int roomNumber = currentRoom.GetRoomNumberByDoor(number);
                String roomNumberToString = String.valueOf(roomNumber);
                currentRoom = roomsMap.get(roomNumberToString);
                CheckRoom();
            } else {
                System.out.println("This door is yet to be unlocked!");
            }

        }

    }

}
