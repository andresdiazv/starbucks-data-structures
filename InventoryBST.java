public class InventoryBST {

    private Node root;

    // Inner class representing a single node in the binary search tree
    private class Node {
        private int key;
        private String value;
        private Node left, right;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    // Inserts a new node into the binary search tree with the given key and value
    public void put(int key, String value) {
        root = put(root, key, value);
    }

    // Recursive helper method for put()
    private Node put(Node x, int key, String value) {
        if (x == null) return new Node(key, value);
        if (key < x.key) x.left = put(x.left, key, value);
        else if (key > x.key) x.right = put(x.right, key, value);
        else x.value = value;
        return x;
    }

    // Retrieves the value associated with the given key in the binary search tree
    public String get(int key) {
        Node x = root;
        while (x != null) {
            if (key < x.key) x = x.left;
            else if (key > x.key) x = x.right;
            else return x.value;
        }
        return null;
    }

    // Deletes the node with the given key from the binary search tree
    public void delete(int key) {
        root = delete(root, key);
    }

    // Recursive helper method for delete()
    private Node delete(Node x, int key) {
        if (x == null) return null;
        if (key < x.key) x.left = delete(x.left, key);
        else if (key > x.key) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        return x;
    }

    // Deletes the minimum node from the binary search tree
    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        return x;
    }

    // Returns the minimum node in the binary search tree
    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    // Returns true if the binary search tree contains the given key, false otherwise
    public boolean contains(int key) {
        return get(key) != null;
    }

    // Returns true if the binary search tree is empty, false otherwise
    public boolean isEmpty() {
        return root == null;
    }

    // Returns the number of nodes in the binary search tree
    public int size() {
        return size(root);
    }

    // Recursive helper method for size()
    private int size(Node x) {
        if (x == null) return 0;
        return 1 + size(x.left) + size(x.right);
    }

    // Returns the height of the binary search tree
    public int height() {
        return height(root);
    }

    // Recursive helper method for height()
    private int height(Node x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }
}
