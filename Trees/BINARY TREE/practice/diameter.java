public class diameter {
    public static int helper(Node root){
        if(root == null) return 0;
        return 1 + Math.max(helper(root.left),helper(root.right));
    }
    public static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }
    public static int diameter(Node root){
        if(root == null) return 0;
        int lh = helper(root.left);
        int rh = helper(root.right);
        int lftd = diameter(root.left);
        int rgtd = diameter(root.right);
        return Math.max(lh+rh,Math.max(lftd,rgtd));
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
        int diameter = diameter(root);
        System.out.println("height/depth of a tree is: " + diameter);

    }
}