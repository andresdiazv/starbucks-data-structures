import java.util.Scanner;
import java.util.Map;
import java.util.Random;

public class HandleOperations {

    public void handleManagerOperations(Scanner scanner, InventoryBST inventory, Menu menu) {
        while (true) {
            System.out.println("Enter an operation: display, inventory, or exit");
            String operation = scanner.nextLine();

            if (operation.equalsIgnoreCase("display")) {
                menu.displayMenu();
            } else if (operation.equalsIgnoreCase("inventory")) {
                handleInventoryOperations(scanner, inventory);
            } else if (operation.equalsIgnoreCase("exit")) {
                break;
            } else {
                System.out.println("Invalid operation.");
            }
        }
    }

    public void handleInventoryOperations(Scanner scanner, InventoryBST inventory) {
        while (true) {
            System.out.println("Enter an operation: insert, delete, search, update, or exit");
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
            } else if (operation.equalsIgnoreCase("update")) {
                System.out.println("Enter the item name:");
                String name = scanner.nextLine();
                if (inventory.contains(name)) {
                    System.out.println("Enter the new quantity:");
                    int newQuantity = Integer.parseInt(scanner.nextLine());
                    inventory.put(name, newQuantity);
                    System.out.println("Item quantity updated.");
                } else {
                    System.out.println("Item not found in inventory.");
                }
            } else if (operation.equalsIgnoreCase("exit")) {
                break;
            } else {
                System.out.println("Invalid operation.");
            }
        }
    }

    public void handleCustomerOperations(Scanner scanner, InventoryBST inventory, Menu menu) {
        Customer customer = selectCustomerRole(scanner);
        if (customer == null) {
            return;
        }

        while (true) {
            System.out.println("Enter an operation: display or purchase (or type 'exit' to go back)");
            String operation = scanner.nextLine();

            if (operation.equalsIgnoreCase("display")) {
                menu.displayMenu();
            } else if (operation.equalsIgnoreCase("purchase")) {
                handlePurchaseOperation(scanner, inventory, menu, customer);
            } else if (operation.equalsIgnoreCase("exit")) {
                break;
            } else {
                System.out.println("Invalid operation.");
            }
        }
    }

    private Customer selectCustomerRole(Scanner scanner) {
        Random random = new Random();

        while (true) {
            System.out.println("Choose a customer role: 'Rich' or 'Poor' (or type 'exit' to go back)");
            String customerRole = scanner.nextLine();

            if (customerRole.equalsIgnoreCase("Rich")) {
                return new Customer(1000);
            } else if (customerRole.equalsIgnoreCase("Mystery")) {
                double mysteryBalance = 1 + random.nextInt(200);
                return new Customer(mysteryBalance);
            } else if (customerRole.equalsIgnoreCase("Poor")) {
                return new Customer(5);
            } else if (customerRole.equalsIgnoreCase("exit")) {
                return null;
            } else {
                System.out.println("Invalid role. Please enter 'Rich', 'Poor', or 'Mystery'.");
            }
        }
    }

    private void handlePurchaseOperation(Scanner scanner, InventoryBST inventory, Menu menu, Customer customer) {
        System.out.println("Enter the drink name:");
        String drinkName = scanner.nextLine();

        if (menu.isDrinkAvailable(drinkName, inventory)) {
            Drink drink = menu.getDrink(drinkName);
            double drinkPrice = drink.getPrice();

            if (customer.getBalance() >= drinkPrice) {
                for (Map.Entry<String, Integer> ingredientEntry : drink.getIngredients().entrySet()) {
                    String ingredientName = ingredientEntry.getKey();
                    int ingredientQuantity = ingredientEntry.getValue();
                    inventory.put(ingredientName, inventory.get(ingredientName) - ingredientQuantity);
                }
                customer.setBalance(customer.getBalance() - drinkPrice);
                System.out.println("Drink purchased. Remaining balance: $" + customer.getBalance());
            } else {
                System.out.println("Insufficient balance. Drink not purchased.");
            }
        } else {
            System.out.println("Drink not available.");
        }
    }
}