/*
 * Takes in a linked list of ingredients.
 * Removes each ingredient from the inventory. 
 * Produces a drink. 
 * Outputs: [Customer name] here is your order of [drinks array].
 * Most methods need to be repaired. Specifically, execute order has to work with inventory.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Prepare{
    private ArrayList<Drink> orderItems;

    private DrinkHashTable drinks = new DrinkHashTable();
    private InventoryBST inventory = new InventoryBST();
    
    public Prepare(ArrayList<Drink> items) {
        this.orderItems = items;
    }

    public void executeOrder(Map<String, Integer> order) throws InsufficientInventoryException {
        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            String drinkName = entry.getKey();
            int quantity = entry.getValue();
            if (!inventory.containsKey(drinkName) || inventory.get(drinkName) < quantity) {
                throw new InsufficientInventoryException(drinkName + " is not available in sufficient quantity.");
            }
            inventory.put(drinkName, inventory.get(drinkName) - quantity);
            double totalPrice = prices.get(drinkName) * quantity;
            System.out.println(quantity + "x " + drinkName + ": $" + totalPrice);
        }
        System.out.println("Order prepared successfully.");
    }

    public Map<String, Double> getPrices() {
        return prices;
    }

    public void setPrices(Map<String, Double> prices) {
        this.prices = prices;
    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }

    public void setInventory(Map<String, Integer> inventory) {
        this.inventory = inventory;
    }

    public void executeOrder() {
    }
}
