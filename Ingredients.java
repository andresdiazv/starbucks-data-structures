public class Ingredients {
    private Ingredient head = null;

    public void addIngredient(String ingredient, int amount) {
        if (head == null) {
            head = new Ingredient(ingredient, amount);
        } else {
            Ingredient current = head;
            while (current.next != null) {
                if (current.ingredient.equals(ingredient)) {
                    current.amount += amount;
                    return;
                }
                current = current.next;
            }
            if (current.ingredient.equals(ingredient)) {
                current.amount += amount;
            } else {
                current.next = new Ingredient(ingredient, amount);
            }
        }
    }

    public void removeIngredient(String ingredientName, int amount) {
        Ingredient current = head;
        Ingredient previous = null;

        while (current != null) {
            if (current.ingredient.equals(ingredientName)) {
                if (current.amount <= amount) {
                    // Remove the entire node
                    if (previous == null) {
                        // Remove the head node
                        head = current.next;
                    } else {
                        previous.next = current.next;
                    }
                } else {
                    // Decrease the amount in the node
                    current.amount -= amount;
                }
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    public int getAmount(String ingredientName) {
        Ingredient current = head;
        while (current != null) {
            if (current.ingredient.equals(ingredientName)) {
                return current.amount;
            }
            current = current.next;
        }
        return 0;
    }

    public Ingredient getHead() {
        return head;
    }

    public static class Ingredient {
        private String ingredient;
        private int amount;
        private Ingredient next;

        public Ingredient(String ingredient, int amount) {
            this.ingredient = ingredient;
            this.amount = amount;
            this.next = null;
        }

        public String getIngredient() {
            return this.ingredient;
        }

        public int getAmount() {
            return this.amount;
        }

        public Ingredient getNext() {
            return this.next;
        }
    }
}
