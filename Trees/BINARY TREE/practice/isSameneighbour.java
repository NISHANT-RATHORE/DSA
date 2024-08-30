
public class isSameneighbour {
    public static class Node {
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }

    public static int level(Node root,int val,int level) {
        if(root == null) return 0;
        if(root.val == val) return level;
        int downlevel = level(root.left, val, level + 1);
        if (downlevel != 0)
            return downlevel;
        downlevel = level(root.right, val, level + 1);
        return downlevel;
    }
    public static boolean helper(int p,int q,Node root){
       return level(root, p, 1) == level(root, q, 1); 
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
        boolean isSameneighbour = helper(11,2,root);
        System.out.println(isSameneighbour);
    }
}
