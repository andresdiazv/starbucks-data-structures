import java.util.Collection;
import java.util.HashMap;

// class to store drinks in a hash table
public class DrinkHashTable {
    private HashMap<String, Drink> drinks = new HashMap<>();

    // adds a drink to the hash table
    public void addDrink(String name, Double price, Ingredients ingredients){
        Drink drink = new Drink(name, price, ingredients);
        drinks.put(name, drink); 
    }

    // gets a drink from the hash table
    // returns a collection of drinks (used when retrieving all drinks)
    public Collection<Drink> getDrinks(){
        return drinks.values();
    }

    // gets a drink from the hash table
    // returns a drink (used when retrieving a specific drink)
    public Drink getDrink(String name){
        return drinks.get(name);
    }
}
