import java.util.HashMap;

public class Rooms {
    private Room currentRoom;
    private InputReader reader;
    private HashMap<String, Room> roomsMap;
    private TextFromFile lines;
    private Inventory inventory;
    private Room one, two, three, four, five, six ;

    public Rooms() {
        reader = new InputReader();
        roomsMap = new HashMap<>();
        lines = new TextFromFile();
        inventory = new Inventory();
        setRooms();
        addToMap();
        setDoors();
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
                }
            } else if (input.equals("how many doors are there?")) {
                int numberOfDoors = currentRoom.getDoors();
                System.out.println("There are: " + numberOfDoors + " doors");
            } else if (input.equals("where does door one lead?")){

                getDoorDescription("1");

            } else if (input.equals("where does door two lead?")){

                getDoorDescription("2");
                
            } else if (input.equals("where does door three lead?")){

                getDoorDescription("3");
                
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

    public void setDoors(){

        //Set doors for the different rooms
        Door roomOneDoorOne = new Door(1, 2, "This door leads to the stalls", true);
        Door roomOneDoorTwo = new Door(2, 3, "This door leads to the work room", true);
        Door roomOntDoorThree = new Door(2, 6, "Find the key to unlock this door!", false);
        one.setDoor("1", roomOneDoorOne);
        one.setDoor("2", roomOneDoorTwo);
        one.setDoor("3", roomOntDoorThree);

    }

    public void checkRoom() {
        String roomName = currentRoom.getRoom();
        System.out.println(roomName);
    }

    public void getDoorDescription(String number){

        String useDoorDescr = currentRoom.getDoorDescription(number);
        System.out.println(useDoorDescr);

    }

    public void nextRoom() {

        

        System.out.println("items in this room are:");
        inventory.GetItemsInRoom(currentRoom.getRoomNumber());
    }

}
