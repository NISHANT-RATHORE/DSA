public class height{
    public static int helper(Node root){
        if(root == null) return 0;
        return 1 + Math.max(helper(root.left),helper(root.right));
    }
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
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
        int height = helper(root);
        System.out.println("height/depth of a tree is: "+height);
        
    }
}