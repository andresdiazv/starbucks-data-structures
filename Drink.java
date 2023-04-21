import java.util.ArrayList;

class Drink{
    private String name;
    private Double price;
    private Ingredients ingredients;

    public Drink(String n, double p, Ingredients i){
        this.name = n;
        this.price = p;
        this.ingredients = i;
    }

    public double getPrice(){
        return this.price;
    }

    public Ingredients getIngredients(){
        return this.ingredients;
    }

    public ArrayList<String> toStringArrayList(){
        ArrayList<String> drinkString = new ArrayList<>();
        drinkString.add(name);
        drinkString.add(price.toString());
        drinkString.add(ingredients.toString());
        return drinkString;
    }
}