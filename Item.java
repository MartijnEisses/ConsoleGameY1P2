public class Item {
    private String name;
    private int weight;
    private int roomNumber;

    public Item(String name, int weight, int roomNumber) {

        this.name = name;
        this.weight = weight;
        this.roomNumber = roomNumber;
    }

    public String GetName() {
        return name;
    }

    public int GetWeigth() {
        return weight;
    }

    public int GetRoomNumber() {
        return roomNumber;
    }

    public void SetRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

}