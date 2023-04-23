import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
public class InventoryBST {
    private Node root;
    public InventoryBST() {
        initializeInventory();
    }

    private void initializeInventory() {
        put("Espresso", 10);
        put("Water", 20);
    }
    private class Node {
        public Ingredients value;
        private String key;
        private int[] ingredients;
        private Node left, right;

        public Node(String key) {
            this.key = key;
            this.value = new Ingredients();
            this.ingredients = new int[0];

        }
    }


    public void put(String key, int value) {
        if (root == null) {
            root = new Node(key);
            root.value.addIngredient(key, value);
        }
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                if (x.left == null) {
                    x.left = new Node(key);
                    x.left.value.addIngredient(key, value);
                }
                x = x.left;
            } else if (cmp > 0) {
                if (x.right == null) {
                    x.right = new Node(key);
                    x.right.value.addIngredient(key, value);
                }
                x = x.right;
            } else {
                x.value.addIngredient(key, value);
                return;
            }
        }
    }

    public int get(String key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else {
                return x.value.getAmount(key);
            }
        }
        return 0;
    }

    public int[] getIngredients(String key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.ingredients.clone();
        }
        return null;
    }

    public boolean containsKey(String key) {
        return get(key) > 0;
    }

    public void processOrder(Map<String, Integer> order) throws InsufficientInventoryException {
        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            String drinkName = entry.getKey();
            int quantity = entry.getValue();
            int[] ingredients = getIngredients(drinkName);
            if (ingredients == null || get(drinkName) < quantity) {
                throw new InsufficientInventoryException(drinkName + " is not available in sufficient quantity.");
            }
            for (int i = 0; i < ingredients.length; i += 2) {
                String ingredientName = String.valueOf(ingredients[i]);
                int ingredientQuantity = ingredients[i + 1];
                put(ingredientName, get(ingredientName) - (ingredientQuantity * quantity));
            }
            put(drinkName, get(drinkName) - quantity);
        }
    }

    public void delete(String key) {
        root = delete(root, key);
    }

    private Node delete(Node x, String key) {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = delete(x.left, key);
        else if (cmp > 0)
            x.right = delete(x.right, key);
        else {
            if (x.right == null)
                return x.left;
            if (x.left == null)
                return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        return x;
    }

    private Node deleteMin(Node x) {
        if (x.left == null)
            return x.right;
        x.left = deleteMin(x.left);
        return x;
    }


    private Node min(Node x) {
        if (x.left == null)
            return x;
        return min(x.left);
    }

    public boolean contains(String key) {
        return get(key) != -1;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null)
            return 0;
        return 1 + size(x.left) + size(x.right);
    }

    public int height() {
        return height(root);
    }

    private int height(Node x) {
        if (x == null)
            return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }
}
