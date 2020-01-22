
/*
* Martijn Eisses
* January 2020 
* Create a Console Game
*/
import java.util.*;

public class Inventory {

    public List<Item> allItems = new ArrayList<>(); // Holds all the items
    private List<Item> inventory = new ArrayList<>(); // Holds all the items of the player
    private int strength = 5; // The weigth that the player can carry
    private TextFromFile lines;

    public Inventory() {
        CreateValuableItems();
        CreateWorthlessItems();
        lines = new TextFromFile();
    }

    // Shows all the items currently in the inventory
    public void ShowInventory() {
        int weight = 0;
        System.out.println("==============Inventory==============");
        int pos = 0;
        for (Item item : inventory) {
            System.out.println("  " + "[" + pos + "] " + item.GetName() + " weighs: " + item.GetWeigth());
            weight += item.GetWeigth();
            pos++;
        }
        System.out.println("=====================================");
        System.out.println("  Carrying: " + weight + " out of " + strength);
        System.out.println("");
    }

    // Adds an item to the inventory and removes it from the allItems list when the
    // player picks it up
    // If it is too heavy the player can't pick it up
    public void AddItemToInventory(String itemName, int roomNumber) {
        Iterator<Item> it = allItems.iterator();
        while (it.hasNext()) {
            // Checks if there is an item with that name and if it's in the current room
            if (it.next().GetName().equals(itemName) && it.next().GetRoomNumber() == roomNumber) {
                Item temp = it.next();
                // Gets the current weight in the inventory
                int weight = 0;
                for (Item invItem : inventory) {
                    weight += invItem.GetWeigth();
                }
                // Cant add the item because the player isn't strong enough
                if (weight + temp.GetWeigth() > strength) {
                    System.out.println(lines.GetLine(0));
                }
                // Can add the item
                else {
                    inventory.add(temp);
                    allItems.remove(temp);
                    ShowInventory();
                }
            }
        }
    }

    public void RemoveItemFromInventory(String itemName, int roomNumber) {
        Iterator<Item> it = inventory.iterator();
        while (it.hasNext()) {
            if (it.next().GetName().equals(itemName)) {
                Item temp = it.next();
                temp.SetRoomNumber(roomNumber);
                allItems.add(temp);
                inventory.remove(temp);
                System.out.print("Dropped " + temp.GetName());
            }
        }
    }

    // Creates a random roomnumber for items (between 0(incl.) and 6(excl.))
    private int RandomizeRoom() {
        Random random = new Random();
        return random.nextInt(6);
    }

    // Creates all the valuable items that the player needs to finish the game
    // These are all placed in a set room to make the playthrough easier
    private void CreateValuableItems() {
        Item crowbar = new Item("Crowbar", 5, 1);
        allItems.add(crowbar);
        Item flashlight = new Item("Flashlight", 2, 0);
        allItems.add(flashlight);
        Item key = new Item("Key", 1, 3);
        allItems.add(key);
    }

    // Creates all the worthless items and places them in a random room
    private void CreateWorthlessItems() {
        Item pen = new Item("Pen", 1, RandomizeRoom());
        allItems.add(pen);
        Item hammer = new Item("Hammer", 2, RandomizeRoom());
        allItems.add(hammer);
        Item rope = new Item("Rope", 2, RandomizeRoom());
        allItems.add(rope);
        Item ducttape = new Item("Duct tape", 1, RandomizeRoom());
        allItems.add(ducttape);
        Item radio = new Item("Radio", 3, RandomizeRoom());
        allItems.add(radio);
        Item crate = new Item("Crate", 3, RandomizeRoom());
        allItems.add(crate);
    }

    public void GetItemsInRoom(int roomNumber) {
        for (Item item : allItems) {
            if (item.GetRoomNumber() == roomNumber) {
                System.out.println("-  " + item.GetName());
            }
        }
    }
}
