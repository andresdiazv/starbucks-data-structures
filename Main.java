public class Main {
    public static void main(String[] args) {
        // Create inventory
        Inventory inventory = new Inventory();

        // Add products to inventory
        inventory.addProduct("Coffee", 10);
        inventory.addProduct("Tea", 5);

        // Create a new menu
        Menu menu = new Menu(inventory);

        // Create a new order
        Order order = new Order(menu);

        // Add items to order
        order.addItem("Coffee", 2);
        order.addItem("Tea", 1);

        // Print order summary
        System.out.println(order.getSummary());
    }
}
