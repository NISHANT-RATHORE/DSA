public class inorder {
    public static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }
    public static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        inorder(root.right);
        System.out.print(root.val + " ");
    }

    public static void main(String[] args) {
        Node root = new Node(2);
        Node a = new Node(4);
        Node b = new Node(10);
        Node c = new Node(6);
        Node d = new Node(5);
        Node e = new Node(11);
        Node f = new Node(12);
        root.left = a;
        a.left = c;
        b.left = e;

        root.right = b;
        b.right = f;
        a.right = d;
        System.out.println("inorder traversal of a tree is: ");
        inorder(root);

    }
}