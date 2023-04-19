import java.util.HashMap;

public class Drink {
    private String name;
    private double price;
    private HashMap<String, Integer> ingredients;

    public Drink(String name, double price, HashMap<String, Integer> ingredients) {
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public HashMap<String, Integer> getIngredients() {
        return ingredients;
    }
}
