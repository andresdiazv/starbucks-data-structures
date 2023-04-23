import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        InventoryBST inventory = new InventoryBST();
        Menu menu = new Menu(inventory);
        Scanner scanner = new Scanner(System.in);
        HandleOperations handleOperations = new HandleOperations();

        while (true) {
            System.out.println("\nEnter your role: 'Manager' or 'Customer' (or type 'exit' to quit)");
            String userRole = scanner.nextLine();

            if (userRole.equalsIgnoreCase("Manager")) {
                handleOperations.handleManagerOperations(scanner, inventory, menu);
            } else if (userRole.equalsIgnoreCase("Customer")) {
                handleOperations.handleCustomerOperations(scanner, inventory, menu,);
            } else if (userRole.equalsIgnoreCase("exit")) {
                break;
            } else {
                System.out.println("Invalid role. Please enter 'Manager' or 'Customer'.");
            }
        }

        scanner.close();
    }
}
