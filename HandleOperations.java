import java.util.Scanner;
import java.util.Map;
import java.util.Random;

public class HandleOperations {

    public void handleManagerOperations(Scanner scanner, InventoryBST inventory, Menu menu) {
        while (true) {
            System.out.println("Enter an operation: display, inventory, or exit");
            String operation = scanner.nextLine();

            if (operation.equalsIgnoreCase("display")) {
                menu.displayMenu(inventory);
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

    public void handleCustomerOperations(Scanner scanner, InventoryBST inventory, Menu menu, Customers customers) {
        String customerName = selectCustomerRole(scanner, customers);
        if (customerName == null) {
            return;
        }

        while (true) {
            System.out.println("Enter an operation: display or purchase (or type 'exit' to go back)");
            String operation = scanner.nextLine();

            if (operation.equalsIgnoreCase("display")) {
                menu.displayMenu(inventory);
            } else if (operation.equalsIgnoreCase("purchase")) {
                handlePurchaseOperation(scanner, inventory, menu, customers);
            } else if (operation.equalsIgnoreCase("exit")) {
                break;
            } else {
                System.out.println("Invalid operation.");
            }
        }
    }

    private String selectCustomerRole(Scanner scanner, Customers customers) {
        Random random = new Random();

        while (true) {
            System.out.println("Enter customer name (or type 'exit' to go back):");
            String customerName = scanner.nextLine();

            if (customerName.equalsIgnoreCase("exit")) {
                return null;
            } else {
                System.out.println("Enter customer balance:");
                double customerBalance = Double.parseDouble(scanner.nextLine());
                customers.addCustomer(customerName, customerBalance);
                return customerName;
            }
        }
    }

    public void handlePurchaseOperation(Scanner scanner, InventoryBST inventory, Menu menu, Customers customers) {
        System.out.print("Enter the drink name: ");
        String drinkName = scanner.nextLine();

        if (menu.isDrinkAvailable(drinkName, inventory)) {
            Drink drink = menu.getDrink(drinkName);
            double drinkPrice = drink.getPrice();

            System.out.print("Enter the customer's name: ");
            String customerName = scanner.nextLine();

            double customerBalance = customers.getCustomerBalance(customerName);

            if (customerBalance >= drinkPrice) {
                double newBalance = customerBalance - drinkPrice;
                customers.updateCustomerBalance(customerName, newBalance);

                Ingredients requiredIngredients = drink.getIngredients();
                Ingredients.Ingredient currentIngredient = requiredIngredients.getHead();

                while (currentIngredient != null) {
                    String ingredientName = currentIngredient.getIngredient();
                    int requiredQuantity = currentIngredient.getAmount();
                    inventory.put(ingredientName, inventory.get(ingredientName) - requiredQuantity);
                    currentIngredient = currentIngredient.getNext();
                }

                System.out.println("Drink purchased successfully.");
                System.out.printf("New balance for %s: $%.2f%n", customerName, newBalance);
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Drink not available due to insufficient ingredients.");
        }
    }

}