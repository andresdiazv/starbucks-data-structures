import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    private String customerName;
    private ArrayList<Drink> customerOrder;
    private double orderPrice;

    private Menu menu;
    private DrinkHashTable drinks;
    private Customers customers;
    private InventoryBST inventory;

    public Order(String name, Menu menu, DrinkHashTable drinks, Customers customers, InventoryBST inventory) {
        this.customerName = name;
        this.customerOrder = new ArrayList<>();
        this.orderPrice = 0;

        this.menu = menu;
        this.drinks = drinks;
        this.customers = customers;
        this.inventory = inventory;
    }

    public void getOrder() throws InsufficientInventoryException {
        Scanner scanner = new Scanner(System.in);
        boolean orderComplete = false;
        while(!orderComplete){
            System.out.println("Would you like to add a drink to your order? (y/n)");
            String response = scanner.nextLine();
            if(response.equals("y")) {
                menu.displayMenu(inventory);
                System.out.println("Please select a drink:");
                String selection = scanner.nextLine();
                Drink tempDrink = drinks.getDrink(selection);
                if(tempDrink == null) {
                    System.out.println("Invalid selection. Please try again.");
                    continue;
                }
                if(inventory.get(tempDrink.getName()) <= 0) {
                    System.out.println("Sorry, we are out of " + tempDrink.getName() + ". Please select a different drink.");
                    continue;
                }
                double totalPrice = orderPrice + tempDrink.getPrice();
                if(Payment.sufficientFunds(customers, customerName, totalPrice)){
                    addToOrder(tempDrink);
                    System.out.println(tempDrink.getName() + " has been added to your order.");
                    orderPrice = totalPrice;
                }
                else{
                    System.out.println("You don't have sufficient funds for that item.");
                }
            } else {
                orderComplete = true;
            }
        }
        Payment.makePayment(customers, customerName, orderPrice);
       // Prepare prepare = new Prepare(customerOrder);
      //  prepare.executeOrder(inventory);
        System.out.println(customerName + ", your order of " + customerOrder.toString() + " is being prepared.");
    }

    public void addToOrder(Drink drink){
        customerOrder.add(drink);
    }

    public void removeFromOrder(String drinkName){
        customerOrder.remove(drinks.getDrink(drinkName));
    }

    public double getOrderPrice() {
        return this.orderPrice;
    }
}
