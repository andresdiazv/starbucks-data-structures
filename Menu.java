import java.util.HashMap;
import java.util.Map;

public class Menu {
    private HashMap<String, Drink> menuItems;

    public Menu(InventoryBST inventory) {
        menuItems = new HashMap<>();
        addDefaultItems(inventory);
    }

    private void addDefaultItems(InventoryBST inventory) {
        HashMap<String, Integer> americanoIngredients = new HashMap<>();
        americanoIngredients.put("Espresso", 2);
        americanoIngredients.put("Water", 1);
        inventory.put("Espresso", 20);
        inventory.put("Water", 50);
        menuItems.put("Americano", new Drink("Americano", 2.75, americanoIngredients));

        HashMap<String, Integer> latteIngredients = new HashMap<>();
        latteIngredients.put("Espresso", 1);
        latteIngredients.put("Milk", 1);
        inventory.put("Milk", 50);
        menuItems.put("Latte", new Drink("Latte", 3.25, latteIngredients));

        HashMap<String, Integer> cappuccinoIngredients = new HashMap<>();
        cappuccinoIngredients.put("Espresso", 1);
        cappuccinoIngredients.put("Milk", 1);
        cappuccinoIngredients.put("Foam", 1);
        inventory.put("Foam", 50);
        menuItems.put("Cappuccino", new Drink("Cappuccino", 3.50, cappuccinoIngredients));

        HashMap<String, Integer> mochaIngredients = new HashMap<>();
        mochaIngredients.put("Espresso", 1);
        mochaIngredients.put("Milk", 1);
        mochaIngredients.put("Chocolate", 1);
        inventory.put("Chocolate", 50);
        menuItems.put("Mocha", new Drink("Mocha", 3.75, mochaIngredients));
    }

    public Drink getDrink(String drinkName) {
        return menuItems.get(drinkName);
    }

    public boolean isDrinkAvailable(String drinkName, InventoryBST inventory) {
        Drink drink = menuItems.get(drinkName);
        if (drink == null) {
            return false;
        }

        for (Map.Entry<String, Integer> ingredient : drink.getIngredients().entrySet()) {
            String ingredientName = ingredient.getKey();
            int requiredAmount = ingredient.getValue();

            if (inventory.get(ingredientName) < requiredAmount) {
                return false;
            }
        }

        return true;
    }

    public void displayMenu() {
        System.out.println("\nMenu:");
        for (Map.Entry<String, Drink> entry : menuItems.entrySet()) {
            Drink drink = entry.getValue();
            System.out.printf("%s - $%.2f%n", drink.getName(), drink.getPrice());
        }
        System.out.print("\n");
    }

    public void updateDrinkPrice(String drinkName, double newPrice) {
        Drink drink = menuItems.get(drinkName);
        if (drink != null) {
            HashMap<String, Integer> ingredients = drink.getIngredients();
            menuItems.put(drinkName, new Drink(drinkName, newPrice, ingredients));
        }
    }
}
