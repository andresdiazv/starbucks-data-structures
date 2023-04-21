/*
 * Menu is provided an ArrayList of items.
 * 
 * Need to compare with inventory. 
 */

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class Menu {
    private DrinkHashTable drinksMenu = new DrinkHashTable();
    
    public Menu(InventoryBST inventory) {
        addDrinks(inventory);
    }

    private void addDrinks(InventoryBST inventory) {
        Ingredients americanoIngredients = new Ingredients();
        americanoIngredients.addIngredient("Espresso", 2);
        americanoIngredients.addIngredient("Water", 1);
        americanoIngredients.addIngredient("Espresso", 2);
        drinksMenu.addDrink("americano", 2.75, americanoIngredients);

        Ingredients latteIngredients = new Ingredients();
        latteIngredients.addIngredient("Espresso", 1);
        latteIngredients.addIngredient("Milk", 1);
        drinksMenu.addDrink("Latte", 3.25, latteIngredients);

        Ingredients cappuccinoIngredients = new Ingredients();
        cappuccinoIngredients.addIngredient("Espresso", 1);
        cappuccinoIngredients.addIngredient("Milk", 1);
        cappuccinoIngredients.addIngredient("Foam", 1);
        drinksMenu.addDrink("Cappuccino", 3.50, cappuccinoIngredients);

        Ingredients mochaIngredients = new Ingredients();
        mochaIngredients.addIngredient("Espresso", 1);
        mochaIngredients.addIngredient("Milk", 1);
        mochaIngredients.addIngredient("Chocolate", 1);
        drinksMenu.addDrink("Mocha", 3.75, mochaIngredients);
    }

    public boolean isDrinkAvailable(String drinkName, InventoryBST inventory) {
        DrinkHashTable drink = menuItems.get(drinkName);
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
        List<DrinkHashTable> drinks = new ArrayList<>(menuItems.values());
        List<DrinkHashTable> sortedDrinks = DrinkSorter.sortDrinks(drinks);

        System.out.println("\nMenu:");
        for (DrinkHashTable drink : sortedDrinks) {
            System.out.printf("%s - $%.2f%n", drink.getName(), drink.getPrice());
        }
        System.out.print("\n");
    }

    public void updateDrinkPrice(String drinkName, double newPrice) {
        DrinkHashTable drink = menuItems.get(drinkName);
        if (drink != null) {
            HashMap<String, Integer> ingredients = drink.getIngredients();
            menuItems.put(drinkName, new DrinkHashTable(drinkName, newPrice, ingredients));
        }
    }
}
