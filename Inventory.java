import java.util.HashMap;

public class Inventory {
    private HashMap<String, Integer> products; // Hash table for storing and retrieving product data

    public Inventory() {
        products = new HashMap<>();
    }

    public void addProduct(String name, int quantity) {
        products.put(name, quantity);
    }

    public void removeProduct(String name) {
        products.remove(name);
    }

    public int getProductQuantity(String name) {
        return products.getOrDefault(name, 0);
    }

    public void updateProductQuantity(String name, int quantity) {
        products.put(name, quantity);
    }
}
