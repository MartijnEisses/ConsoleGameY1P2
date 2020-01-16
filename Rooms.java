import java.util.HashMap;

public class Rooms {
    private Room currentRoom;
    private InputReader reader;
    private HashMap<String, Room> roomsMap;
    private TextFromFile lines;
    private Inventory inventory;
    private Room one;
    private Room two;
    private Room three;
    private Room four;
    private Room five;
    private Room six;

    public Rooms() {
        reader = new InputReader();
        roomsMap = new HashMap<>();
        lines = new TextFromFile();
        inventory = new Inventory();
        setRooms();
        addToMap();
    }

    public void play() {
        System.out.println(lines.GetLine(2));
        System.out.println(lines.GetLine(3));
        System.out.println(lines.GetLine(4));
        System.out.println(lines.GetLine(5));
        System.out.println(lines.GetLine(6));
        System.out.println(lines.GetLine(7));
        System.out.println(lines.GetLine(8));
        boolean finished = false;

        while (!finished) {
            String input = reader.getInput().toLowerCase();

            if (input.equals("quit")) {
                finished = true;
            } else if (input.equals("what room am i in?")) {
                checkRoom();
            } else if (input.equals("open door one")) {
                if (currentRoom.getRoomNumber() == 5) {
                    System.out.println("You are in the final room!");
                } else {
                    nextRoom();
                    System.out.println("You opened a door to the next room!");
                    System.out.println("items in this room are:");
                    inventory.GetItemsInRoom(currentRoom.getRoomNumber());
                }
            } else {
                Help();
            }
        }
        System.out.println("Thanks for playing!");
    }

    public void chooseDoor(int doorNumber) {
    }

    private void Help() {
        System.out.println(lines.GetLine(5));
        System.out.println(lines.GetLine(6));
        System.out.println(lines.GetLine(7));
        System.out.println(lines.GetLine(8));
    }

    private void setRooms() {

        // Rooms are created
        one = new Room(0, "Room 0 - Starting room");
        two = new Room(1, "Room 1 - Stalls");
        three = new Room(2, "Room 2 - Work room");
        four = new Room(3, "Room 3 - Kitchen");
        five = new Room(4, "Room 4 - Trapdoor Kitchen");
        six = new Room(5, "Room 5 - End Room");

        // Doors are being set
        one.setDoor("1", "Door to the stalls");
        two.setDoor("1", "Door to the work room");
        three.setDoor("1", "Door to the kitchen");
        four.setDoor("1", "Trapdoor of kitchen");

        currentRoom = one;

    }

    private void addToMap() {

        // Rooms are added to HashMap
        roomsMap.put("0", one);
        roomsMap.put("1", two);
        roomsMap.put("2", three);
        roomsMap.put("3", four);
        roomsMap.put("4", five);
        roomsMap.put("5", six);

    }

    public void checkRoom() {
        String roomName = currentRoom.getRoom();
        System.out.println(roomName);
    }

    public void nextRoom() {
        int RoomNumber = currentRoom.getRoomNumber();
        int nextRoom = RoomNumber + 1;
        String roomNumber = String.valueOf(nextRoom);
        currentRoom = roomsMap.get(roomNumber);

    }

}
