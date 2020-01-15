public class consolegame {
    private static boolean gameRunning = true;

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        while (gameRunning) {
            inventory.ShowInventory();
            inventory.AddItemToInventory(inventory.allItems.get(5));
            gameRunning = false;
        }
    }
}