import java.util.ArrayList;

class Drink {
    private String name;
    private Double price;
    private Ingredients ingredients;

    // constructor for Drink
    public Drink(String name, double price, Ingredients ingredients) {
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
    }

    // getters for Drink
    // gets name of drink
    public String getName() {
        return this.name;
    }

    // gets price of drink
    public double getPrice() {
        return this.price;
    }

    // gets ingredients of drink
    public Ingredients getIngredients() {
        return this.ingredients;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", ingredients=" + ingredients +
                '}';
    }

}