public class InventoryBST {

    private Node root;

    private class Node {
        private int key;
        private String value;
        private Node left, right;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(int key, String value) {
        root = put(root, key, value);
    }

    private Node put(Node x, int key, String value) {
        if (x == null) return new Node(key, value);
        if (key < x.key) x.left = put(x.left, key, value);
        else if (key > x.key) x.right = put(x.right, key, value);
        else x.value = value;
        return x;
    }

    public String get(int key) {
        Node x = root;
        while (x != null) {
            if (key < x.key) x = x.left;
            else if (key > x.key) x = x.right;
            else return x.value;
        }
        return null;
    }

    public void delete(int key) {
        root = delete(root, key);
    }

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

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        return x;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    public boolean contains(int key) {
        return get(key) != null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        return 1 + size(x.left) + size(x.right);
    }

    public int height() {
        return height(root);
    }

    private int height(Node x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }
}
