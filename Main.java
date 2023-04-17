import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        InventoryBST inventory = new InventoryBST();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter an operation: insert, delete, search, or exit");
            String operation = scanner.nextLine();

            if (operation.equals("insert")) {
                System.out.println("Enter the item name:");
                String name = scanner.nextLine();
                System.out.println("Enter the item quantity:");
                int quantity = Integer.parseInt(scanner.nextLine());
                inventory.put(quantity, name);
                System.out.println("Item added to inventory.");

            } else if (operation.equals("delete")) {
                System.out.println("Enter the item name:");
                String name = scanner.nextLine();
                int quantity = findQuantity(inventory, name);
                if (quantity == -1) {
                    System.out.println("Item not found in inventory.");
                } else {
                    inventory.delete(quantity);
                    System.out.println("Item deleted from inventory.");
                }

            } else if (operation.equals("search")) {
                System.out.println("Enter the item name:");
                String name = scanner.nextLine();
                int quantity = findQuantity(inventory, name);
                if (quantity == -1) {
                    System.out.println("Item not found in inventory.");
                } else {
                    System.out.println("Item quantity: " + quantity);
                }

            } else if (operation.equals("exit")) {
                break;

            } else {
                System.out.println("Invalid operation.");
            }
        }

        scanner.close();
    }

    private static int findQuantity(InventoryBST inventory, String name) {
        for (int i = 0; i < inventory.size(); i++) {
            String item = inventory.get(i);
            if (item != null && item.equals(name)) {
                return i;
            }
        }
        return -1;
    }
}
