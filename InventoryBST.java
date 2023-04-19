public class InventoryBST {

    private Node root;

    private class Node {
        private String key;
        private int value;
        private Node left, right;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(String key, int value) {
        root = put(root, key, value);
    }

    private Node put(Node x, String key, int value) {
        if (x == null)
            return new Node(key, value);
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = put(x.left, key, value);
        else if (cmp > 0)
            x.right = put(x.right, key, value);
        else
            x.value = value;
        return x;
    }

    public int get(String key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0)
                x = x.left;
            else if (cmp > 0)
                x = x.right;
            else
                return x.value;
        }
        return -1;
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
