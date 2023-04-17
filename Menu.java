import java.util.HashMap;

public class Menu {
    private HashMap<String, Double> prices; // Hash table for storing product prices
    private Inventory inventory; // Inventory object for checking product availability

    public Menu(Inventory inventory) {
        prices = new HashMap<>();
        this.inventory = inventory;
        // Set product prices
        prices.put("Coffee", 2.5);
        prices.put("Tea", 2.0);
    }

    public double getPrice(String name) {
        return prices.getOrDefault(name, 0.0);
    }

    public boolean checkAvailability(String name, int quantity) {
        return inventory.getProductQuantity(name) >= quantity;
    }

    public void updateInventory(String name, int quantity) {
        inventory.updateProductQuantity(name, inventory.getProductQuantity(name) - quantity);
    }
}
