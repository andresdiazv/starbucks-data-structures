/*
 * Stores ingredients in LinkedList with ingredient name and amount.
 */

 public class Ingredients{
    private Ingredient head = null;

    public void addIngredient(String ingredient, int amount){
        Ingredient i = new Ingredient(ingredient, amount);

        if(head == null){
            head = i;
        }
        else {
            Ingredient current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = i;
        }
    }

    private class Ingredient{

        private String ingredient;
        private int amount;
        private Ingredient next;

        public Ingredient(String i, int a){
            this.ingredient = i;
            this.amount = a;
            this.next = null;
        }

        // public String toString() {
        //     return amount + " " + ingredient;
        // }
    }   
}