/*
 *
 * Need to add: check for inventory, check for sufficient funds
 * 
 */
import java.util.ArrayList;
import java.util.Scanner;
public class Order {
    private String customerName;
    private ArrayList<Drink> customerOrder;
    private float orderPrice;

    private Menu menu = new Menu(null);
    private DrinkHashTable drinks = new DrinkHashTable();
    private Customers customers = new Customers();
    private InventoryBST inventory = new InventoryBST();

    public Order(String name) {
        this.customerName = name;
        this.customerOrder = new ArrayList<>();
        this.orderPrice = 0;
    }

    public void getOrder(){
        Scanner scanner = new Scanner(System.in);
        boolean orderComplete = false;
        while(!orderComplete){
            System.out.println("Would you like to add a drink to your order? (y/n)");
            String response = scanner.nextLine();
            if(response.equals("y")) {
                menu.displayMenu();
                System.out.println("Please select a drink:");
                String selection = scanner.nextLine();
                scanner.nextLine();
                Drink tempDrink = drinks.getDrink(selection);
                if(Payment.sufficientFunds(customers, customerName, orderPrice + tempDrink.getPrice())){
                    addToOrder(tempDrink);
                    System.out.println(selection + " has been added to your order.");    
                }
                else{
                    System.out.println("You don't have sufficient funds for that item.");
                }
            }
        }
        Payment.makePayment(customers, customerName, orderPrice);
        Prepare.prepareOrder(inventory, customerOrder);
        System.out.println(customerName + ", your order of " + customerOrder.toString() + " is being prepared.");
    }

    public void addToOrder(Drink drink){
        customerOrder.add(drink);
        orderPrice += drink.getPrice();
    }

    public void removeFromOrder(String drinkName){
        customerOrder.remove(drinks.getDrink(drinkName));
    }

    public float getOrderPrice() {
        return this.orderPrice;
    }
}