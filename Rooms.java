import java.util.HashMap;

public class Rooms {

    private Room currentRoom;
    private InputReader reader;
    private HashMap<String, Room> roomsMap;

    private Room one;
    private Room two;
    private Room three;
    private Room four;
    private Room five;
    private Room six;

    public Rooms() {
        reader = new InputReader();
        roomsMap = new HashMap<>();
        setRooms();
        addToMap();
    }

    public void play() {

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
                }
            } else {
                System.out.println("Commands are:\n" + "Open door one\n" + "What room am i in?\n" + "QUIT");
            }
        }
        System.out.println("Thx for playing!");
    }

    public void chooseDoor(int doorNumber) {
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
