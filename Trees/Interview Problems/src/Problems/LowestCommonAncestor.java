package Problems;

import TreeTemplate.Node;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);


        //connect left pointers
        a.left = b;
        b.left = d;
        c.left = f;

        //connect right pointers
        a.right = c;
        c.right = g;
        b.right = e;

        Node commonAncestor = lowestCommonAncestor(a,d,e);
        System.out.println(commonAncestor.data);

    }
    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        if(root==null || root==p || root==q) return root;
        Node left = lowestCommonAncestor(root.left,p,q);
        Node right= lowestCommonAncestor(root.right,p,q);
        if(left!=null && right!=null) return root;
        return left!=null ? left : right;
    }

}
