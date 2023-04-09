import java.util.HashMap;
import java.util.Map;

public class Order {
    private Map<MenuItem, Integer> items;
    private double total;
    
    public Order() {
        items = new HashMap<>();
        total = 0.0;
    }

    // Methods for managing items and calculating the order total
}
