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
    private HashMap<String, Drink> drinksMenu = new HashMap<>();

    public Menu(InventoryBST inventory) {
        addDrinks(inventory);
    }

    private void addDrinks(InventoryBST inventory) {
        Ingredients americanoIngredients = new Ingredients();
        americanoIngredients.addIngredient("Espresso", 3);
        americanoIngredients.addIngredient("Water", 1);
        drinksMenu.put("Americano", new Drink("Americano", 2.50, americanoIngredients));

        Ingredients latteIngredients = new Ingredients();
        latteIngredients.addIngredient("Espresso", 2);
        latteIngredients.addIngredient("Steamed Milk", 1);
        drinksMenu.put("Latte", new Drink("Latte", 3.00, latteIngredients));

        Ingredients cappuccinoIngredients = new Ingredients();
        cappuccinoIngredients.addIngredient("Espresso", 2);
        cappuccinoIngredients.addIngredient("Foamed Milk", 1);
        drinksMenu.put("Cappuccino", new Drink("Cappuccino", 3.00, cappuccinoIngredients));

        Ingredients mochaIngredients = new Ingredients();
        mochaIngredients.addIngredient("Espresso", 2);
        mochaIngredients.addIngredient("Mocha Syrup", 1);
        mochaIngredients.addIngredient("Steamed Milk", 1);
        drinksMenu.put("Mocha", new Drink("Mocha", 3.50, mochaIngredients));

    }

    public void displayMenu(InventoryBST inventory) {
        List<Drink> drinks = new ArrayList<>(drinksMenu.values());
        List<Drink> sortedDrinks = DrinkSorter.sortDrinks(drinks);

        System.out.println("\nMenu:");
        for (Drink drink : sortedDrinks) {
            String availability;
            if (isDrinkAvailable(drink.getName(), inventory)) {
                availability = "Available";
            } else {
                availability = "Unavailable";
            }
            System.out.printf("%s - $%.2f (%s)%n", drink.getName(), drink.getPrice(), availability);
        }
        System.out.print("\n");
    }

    public boolean isDrinkAvailable(String drinkName, InventoryBST inventory) {

        Drink drink = drinksMenu.get(drinkName);
        if (drink == null) {
            return false;
        }

        Ingredients requiredIngredients = drink.getIngredients();
        Ingredients.Ingredient currentIngredient = requiredIngredients.getHead();

        while (currentIngredient != null) {
            String ingredientName = currentIngredient.getIngredient();
            int requiredQuantity = currentIngredient.getAmount();

            int availableQuantity = inventory.get(ingredientName);
            if (availableQuantity < requiredQuantity) {
                return false;
            }
            currentIngredient = currentIngredient.getNext();
        }

        return true;
    }

    public void updateDrinkPrice(String drinkName, double newPrice) {
        // gets the drink from the menu
        Drink drink = drinksMenu.get(drinkName);

        // if the drink exists, update the price
        if (drink != null) {
            // gets ingredients to keep the same ingredients as before
            Ingredients ingredients = drink.getIngredients();
            // updates the drink in the menu with the new price
            drinksMenu.put(drinkName, new Drink(drinkName, newPrice, ingredients));
        }
    }

    public Drink getDrink(String drinkName) {
        return drinksMenu.get(drinkName);
    }

}
