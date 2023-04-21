import java.util.Collection;
import java.util.HashMap;

public class DrinkHashTable {
    private HashMap<String, Drink> drinks = new HashMap<>();

    public void addDrink(String name, Double price, Ingredients ingredients){
        Drink drink = new Drink(name, price, ingredients);
        drinks.put(name, drink); 
    }

    public Collection<Drink> getDrinks(){
        return drinks.values();
    }

    public Drink getDrink(String name){
        return drinks.get(name);
    }
}
