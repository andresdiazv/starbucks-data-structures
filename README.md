<h1 align="center">Starbucks System</h1>

<h2 align="center">Dark Mode</h2>
<p align="center">
    <img width="800" src="https://user-images.githubusercontent.com/112414800/232595156-eb2e951a-3b94-48e7-a70d-da359de693a5.png" alt="Material Bread logo">
</p>
<h2 align="center">Light Mode</h2>
<p align="center">
    <img width="800" src="https://user-images.githubusercontent.com/112414800/232595099-61d788a4-ef69-4f77-83c6-b43512fd469d.png" alt="Material Bread logo">
</p>

Ingredients.java
- Creates a LinkedList of ingredient Objects to be stored for one Drink Object in the Drink HashMap
    Includes the following variables:
        Ingredient head
    Contains the following methods:
        void addIngredient(String ingredient, int amount)
            specify the name and amount of ingredients to be added to an Ingredients LL for a specific Drink Object
    Contains the following embedded class:
        Ingredient
            Includes the following variables
                String ingredient
                int amount
                Ingredient next
            Includes a constructor
                Ingredient(String i, int a)
                    sets next ingredient to null and otherwise initializes variables

Drink.java
    Includes the following variables:
        String name
        Double price
        Ingredients ingredients.
    Contains following methods:
        double getPrice()
            returns the price of a drink
        Ingredients getIngredients()
            returns the Ingredients Object of ingredients used for this drink
        ArrayList<String> toStringArrayList()
            returns an array with all the values of a Drink in String format in the following order:  name, price, ingredients

DrinkHashTable.java
    Includes the following variables:
        HashMap<String, Drink> drinks
    Contains the following methods:
        Collection<Drink> getDrink()
            returns all drinks stored in HashMap
        void addDrink(String name, Double price, Ingredients ingredients)
            allows the users to add a Drink Object to the HashMap
        Drink getDrink(String name)
            returns a Drink Object based on the name of the drink

Order.java


