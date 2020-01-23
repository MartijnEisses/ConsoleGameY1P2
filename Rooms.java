import java.util.HashMap;
import java.util.Stack;
public class Rooms {
    private Room currentRoom;
    private InputReader reader;
    private HashMap<String, Room> roomsMap;
    private TextFromFile lines;
    private Inventory inventory;
    private Room one, two, three, four, five, six;
    private Stack <Room>kamer;

    public Rooms() {
        reader = new InputReader();
        roomsMap = new HashMap<>();
        lines = new TextFromFile();
        inventory = new Inventory();
        SetRooms();
        AddToMap();
        SetDoors();
    }

    public void Play() {
        System.out.println(lines.GetLine(2));
        System.out.println(lines.GetLine(3));
        System.out.println(lines.GetLine(4));
        System.out.println(lines.GetLine(5));
        System.out.println(lines.GetLine(6));
        System.out.println(lines.GetLine(7));
        System.out.println(lines.GetLine(8));
        System.out.println(lines.GetLine(9));

        boolean finished = false;
        CheckRoom();
        while (!finished) {

            String input = reader.GetInput().toLowerCase();

            if (input.equals("quit")) {
                finished = true;
            } else if (input.equals("what room am i in?")) {
                CheckRoom();
            } else if (input.equals("open door one")) {
                NextRoom(1);
            } else if (input.equals("open door two")) {
                NextRoom(2);
            } else if (input.equals("open door three")) {
                NextRoom(3);
            } else if (input.equals("how many doors are there?")) {
                int numberOfDoors = currentRoom.GetDoors();
                System.out.println("There are: " + numberOfDoors + " doors");
            } else if (input.equals("where does door one lead?")) {
                GetDoorDescription(1);
            } else if (input.equals("where does door two lead?")) {
                GetDoorDescription(2);
            } else if (input.equals("where does door three lead?")) {
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
            } else if(input.equals("back")) {
                back();
            } else {
                Help();
            }
        }
        System.out.println("Thanks for playing!");
    }

    public void ChooseDoor(int doorNumber) {
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
    }

    private void SetRooms() {
        // Rooms are created
        one = new Room(1, "Room 1 - Barn");
        two = new Room(2, "Room 2 - Stalls");
        three = new Room(3, "Room 3 - Work room");
        four = new Room(4, "Room 4 - Kitchen");
        five = new Room(5, "Room 5 - Trapdoor Kitchen");
        six = new Room(6, "Room 6 - Empty room");

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

    public void back()
    {
       if(kamer != null) 
       {
           currentRoom = kamer.pop();
           System.out.println(currentRoom = roomsMap.get());
       }
    }

    public void SetDoors() {
        // All the doors needed to get to each room
        Door doorOne = new Door(1, 2, "This door leads to the stalls", true);
        Door doorTwo = new Door(2, 3, "This door leads to the work room", true);
        Door doorThree = new Door(3, 6, "This door leads to a dark room", false);
        Door doorFour = new Door(4, 1, "This door leads to the barn", true);
        Door doorFive = new Door(5, 4, "This door leads to the kitchen", true);
        Door doorSix = new Door(6, 5, "This hatch leads to a space under the kitchen", true);

        // Set doors for the different room
        one.SetDoor(1, doorOne);
        one.SetDoor(2, doorTwo);
        one.SetDoor(3, doorThree);
        two.SetDoor(1, doorFour);
        three.SetDoor(1, doorFour);
        three.SetDoor(2, doorFive);
        four.SetDoor(1, doorTwo);
        four.SetDoor(2, doorSix);
        five.SetDoor(1, doorFive);
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

    public void NextRoom(int number) {
        int roomNumber = currentRoom.GetRoomNumberByDoor(number);
        String roomNumberToString = String.valueOf(roomNumber);
        currentRoom = roomsMap.get(roomNumberToString);
        CheckRoom();
    }

}
