public class depth {
    static int height = -1;

    public static int depth(Node root, int val) {
        if (root == null)
            return -1;
        int dist = -1;
        if (root.val == val || (dist = depth(root.left, val)) >= 0 || (dist = depth(root.right, val)) >= 0) {
            return dist + 1;
        }
        return dist;
    }

    public static int findHeightUtil(Node root, int val) {
        if (root == null)
            return -1;
        if (root == null) {
            return -1;
        }

        // Store the maximum height of
        // the left and right subtree
        int leftHeight = findHeightUtil(root.left, val);

        int rightHeight = findHeightUtil(root.right, val);

        // Update height of the current node
        int ans = Math.max(leftHeight, rightHeight) + 1;

        // If current node is the required node
        if (root.val == val)
            height = ans;

        return ans;
    }

    static int findHeight(Node root, int x) {

        // Stores height of the Tree
        findHeightUtil(root, x);

        // Return the height
        return height;
    }

    public static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(2);
        Node a = new Node(4);
        Node b = new Node(10);
        Node c = new Node(6);
        Node d = new Node(5);
        Node e = new Node(11);
        Node f = new Node(12);
        Node g = new Node(13);
        root.left = a;
        a.left = c;
        b.left = e;
        f.left = g;

        root.right = b;
        b.right = f;
        a.right = d;
        int depth = depth(root, 11);
        int height = findHeight(root, 6);
        System.out.println("depth of a tree is: " + depth);
        System.out.println("height of node 11 is: " + height);

    }
}