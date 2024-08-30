package Basic_Problems;

import TreeTemplate.Node;

public class isSymmetric {
    public static void main(String[] args) {
//        1,2,2,3,4,4,3
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(2);
        Node d = new Node(3);
        Node e = new Node(4);
        Node f = new Node(4);
        Node g = new Node(3);


        //connect left pointers
        a.left = b;
        b.left = d;
        c.left = f;

        //connect right pointers
        a.right = c;
        c.right = g;
        b.right = e;
        boolean isSymmetric = isSymmetric(a);
        System.out.println(isSymmetric);
    }
    public static boolean isSymmetric(Node root){
        Node inverted = invertTree(root);
        return isSame(root,inverted);
    }
    public static boolean isSame(Node root1,Node root2){
        if(root1==null && root2==null) return true;
        if(root1==null || root2==null) return false;
        return root1.data == root2.data && isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
    }
    public static Node invertTree(Node root) {
        if(root==null) return null;
        Node ans = new Node(root.data);
        ans.left = invertTree(root.right);
        ans.right = invertTree(root.left);
        return ans;
    }
}
