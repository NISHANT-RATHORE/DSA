package Problems;

import TreeTemplate.Node;

public class SumTree {
    public static void main(String[] args) {
//        Node a = new Node(3);
//        Node b = new Node(1);
//        Node c = new Node(2);
//
//        a.left = b;
//        a.right = c;

        Node a = new Node(10);
        Node b = new Node(20);
        Node c = new Node(30);
        Node d = new Node(10);
        Node e = new Node(10);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;

        System.out.println(isSumTree(a));
    }
    static boolean isSumTree(Node root) {
        if(root == null || (root.left==null && root.right == null)) return true;
        int leftSum = Node.sum(root.left);
        int rightSum = Node.sum(root.right);
        return (root.data == (leftSum + rightSum)) && (isSumTree(root.left) && isSumTree(root.right));
    }
}
