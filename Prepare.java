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




public class Prepare {
    private ArrayList<Drink> orderItems;
    private Map<String, Double> prices;
    private InventoryBST inventory;

    public Prepare(ArrayList<Drink> items, Map<String, Double> prices, InventoryBST inventory) {
        this.orderItems = items;
        this.prices = prices;
        this.inventory = inventory;
    }

    public void executeOrder(Map<String, Integer> order) throws InsufficientInventoryException {
        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            String drinkName = entry.getKey();
            int quantity = entry.getValue();
            double totalPrice = prices.get(drinkName) * quantity;
            System.out.println(quantity + "x " + drinkName + ": $" + totalPrice);
        }
        inventory.processOrder(order);
        System.out.println("Order prepared successfully.");
    }

    public Map<String, Double> getPrices() {
        return prices;
    }

    public void setPrices(Map<String, Double> prices) {
        this.prices = prices;
    }

    public InventoryBST getInventory() {
        return inventory;
    }

    public void setInventory(InventoryBST inventory) {
        this.inventory = inventory;
    }
}

