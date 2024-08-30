public class LCA {
    public static boolean isContain(Node root,Node node){
        if(root == null) return false;
        if(root == node) return true;
        return isContain(root.left, node) || isContain(root.right, node);
    }
    public static Node helper(Node root,Node p,Node q){
        if(p==root && q==root) return root;
        if(p==q) return p;
        boolean leftp = isContain(root.left,p);
        boolean rightq = isContain(root.right,q);
        if((leftp && rightq) || (!leftp && !rightq)) return root;
        if(leftp && !rightq) return helper(root.left,p,q);
        if(!leftp && rightq) return helper(root.right,p,q);
        return null;
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
        Node LCA = helper(root,c,d);
        System.out.println("LCA of a tree is: " + LCA.val);

    }
}