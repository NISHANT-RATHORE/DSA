public class basic{
    static int max = 0;
    static int size = 0;
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    public static int max(Node root){
        if(root == null) return Integer.MIN_VALUE;
        return Math.max(root.val,Math.max(max(root.left),max(root.right)));
    }
    public static int size(Node root){
        if(root == null) return 0;
        return 1 + size(root.left) + size(root.right);
    }
    public static int sum(Node root){
        if(root == null) return 0;
        return root.val + sum(root.left) + sum(root.right);
    }
    public static int height(Node root){
        if(root == null || (root.left==null && root.right == null)) return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }

    // preorder: root -> left -> right 
    public static void preorder(Node root){
        if(root == null) return;
        System.out.print(root.val+" ");
        preorder(root.left);
        preorder(root.right);
    }

    // inorder: left -> root -> right
    public static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }

    //postorder: left -> right -> root
    public static void postorder(Node root){
        if(root==null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val+" ");
    }
    //homework

    public static int min(Node root){
        if(root == null) return Integer.MAX_VALUE;
        return Math.min(root.val,Math.min(min(root.left),min(root.right)));
    }
    public static int multiply(Node root){
        if(root==null) return 1;
        return root.val*multiply(root.left)*multiply(root.right);
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
        System.out.println("preorder traversal is: ");
        preorder(root);
        System.out.println();
        System.out.println("--------------------------------------------");
        System.out.println("Inorder traversal is: ");
        inorder(root);
        System.out.println();
        System.out.println("--------------------------------------------");
        System.out.println("postorder traversal is: ");
        postorder(root);
        System.out.println();
        System.out.println("--------------------------------------------");
        int size = size(root);
        System.out.println("edges is: "+(size-1));
        System.out.println("--------------------------------------------");
        System.out.println("Maxnode is: "+max(root));
        System.out.println("--------------------------------------------");
        System.out.println("Minnode is: "+min(root));
        System.out.println("--------------------------------------------");
        System.out.println("sum of node is: "+sum(root));
        System.out.println("--------------------------------------------");
        System.out.println("multiply of node is: "+multiply(root));
        System.out.println("--------------------------------------------");
        System.out.println("height of node is: "+height(root));
        System.out.println("--------------------END---------------------");
    }
}