import java.util.Scanner;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        InventoryBST inventory = new InventoryBST();
        Menu menu = new Menu(inventory);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEnter your role: 'Manager' or 'Customer' (or type 'exit' to quit)");
            String userRole = scanner.nextLine();

            if (userRole.equalsIgnoreCase("Manager")) {
                handleManagerOperations(scanner, inventory, menu);
            } else if (userRole.equalsIgnoreCase("Customer")) {
                handleCustomerOperations(scanner, inventory, menu);
            } else if (userRole.equalsIgnoreCase("exit")) {
                break;
            } else {
                System.out.println("Invalid role. Please enter 'Manager' or 'Customer'.");
            }
        }

        scanner.close();
    }

    private static void handleManagerOperations(Scanner scanner, InventoryBST inventory, Menu menu) {
        while (true) {
            System.out.println("Enter an operation: display, update, inventory, or exit");
            String operation = scanner.nextLine();

            if (operation.equalsIgnoreCase("display")) {
                menu.displayMenu();
            } else if (operation.equalsIgnoreCase("update")) {
                System.out.println("Enter the drink name:");
                String drinkName = scanner.nextLine();
                System.out.println("Enter the new price:");
                double newPrice = Double.parseDouble(scanner.nextLine());
                menu.updateDrinkPrice(drinkName, newPrice);
                System.out.println("Drink price updated.");
            } else if (operation.equalsIgnoreCase("inventory")) {
                handleInventoryOperations(scanner, inventory);
            } else if (operation.equalsIgnoreCase("exit")) {
                break;
            } else {
                System.out.println("Invalid operation.");
            }
        }
    }

    private static void handleCustomerOperations(Scanner scanner, InventoryBST inventory, Menu menu) {
        while (true) {
            System.out.println("Enter an operation: display or purchase (or type 'exit' to go back)");
            String operation = scanner.nextLine();

            if (operation.equalsIgnoreCase("display")) {
                menu.displayMenu();
            } else if (operation.equalsIgnoreCase("purchase")) {
                System.out.println("Enter the drink name:");
                String drinkName = scanner.nextLine();

                if (menu.isDrinkAvailable(drinkName, inventory)) {
                    Drink drink = menu.getDrink(drinkName);
                    for (Map.Entry<String, Integer> ingredientEntry : drink.getIngredients().entrySet()) {
                        String ingredientName = ingredientEntry.getKey();
                        int ingredientQuantity = ingredientEntry.getValue();
                        inventory.put(ingredientName, inventory.get(ingredientName) - ingredientQuantity);
                    }
                    System.out.println("Drink purchased.");
                } else {
                    System.out.println("Drink not available.");
                }
            } else if (operation.equalsIgnoreCase("exit")) {
                break;
            } else {
                System.out.println("Invalid operation.");
            }
        }
    }

    private static void handleInventoryOperations(Scanner scanner, InventoryBST inventory) {
        System.out.println("Enter an operation: insert, delete, search, or exit");
        String operation = scanner.nextLine();

        if (operation.equalsIgnoreCase("insert")) {
            System.out.println("Enter the item name:");
            String name = scanner.nextLine();
            System.out.println("Enter the item quantity:");
            int quantity = Integer.parseInt(scanner.nextLine());
            inventory.put(name, quantity);
            System.out.println("Item added to inventory.");
        } else if (operation.equalsIgnoreCase("delete")) {
            System.out.println("Enter the item name:");
            String name = scanner.nextLine();
            if (inventory.contains(name)) {
                inventory.delete(name);
                System.out.println("Item deleted from inventory.");
            } else {
                System.out.println("Item not found in inventory.");
            }
        } else if (operation.equalsIgnoreCase("search")) {
            System.out.println("Enter the item name:");
            String name = scanner.nextLine();
            int quantity = inventory.get(name);
            if (quantity != -1) {
                System.out.println("Item quantity: " + quantity);
            } else {
                System.out.println("Item not found in inventory.");
            }
        } else if (operation.equalsIgnoreCase("exit")) {
            return;
        } else {
            System.out.println("Invalid operation.");
        }
    }
}