import java.util.LinkedList;
import java.util.Queue;

public class Order {
    private Menu menu; // Menu object for checking prices and product availability
    private Queue<Item> items; // Queue for managing incoming orders

    public Order(Menu menu) {
        this.menu = menu;
        items = new LinkedList<>();
    }

    public void addItem(String name, int quantity) {
        if (menu.checkAvailability(name, quantity)) {
            items.offer(new Item(name, quantity));
            menu.updateInventory(name, quantity);
        } else {
            System.out.println("Sorry, we are out of stock for " + name);
        }
    }

    public double getTotal() {
        double total = 0;
        for (Item item : items) {
            total += menu.getPrice(item.getName()) * item.getQuantity();
        }
        return total;
    }

    public String getSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("Order Summary:\n");
        for (Item item : items) {
            summary.append(item.getQuantity()).append(" x ").append(item.getName())
                    .append(" @ $").append(menu.getPrice(item.getName())).append(" = $")
                    .append(menu.getPrice(item.getName()) * item.getQuantity()).append("\n");
        }
        summary.append("Total: $").append(getTotal());
        return summary.toString();
    }

    private static class Item {
        private String name;
        private int quantity;

        public Item(String name, int quantity) {
            this.name = name;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public int getQuantity() {
            return quantity;
        }
    }
}