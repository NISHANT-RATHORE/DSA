public class botomview {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    public static void bottom(Node root){
        if(root == null) return;
        bottom(root.left);
        if(root.left == null && root.right==null) System.out.print(root.val+" ");
        bottom(root.right);
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
        System.out.println("bottom view of a tree is: ");
        bottom(root);
        
    }
}