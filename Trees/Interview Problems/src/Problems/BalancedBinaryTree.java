package Problems;

import TreeTemplate.Node;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);

        root.right = b;
        b.right = c;

//        System.out.println(Node.height(root));

        System.out.println(isBalanced(root));
    }
    public static boolean isBalanced(Node root) {
        if(root==null) return true;
        int leftHeight = 0;
        int rightHeight = 0;
        if(root.left!=null) leftHeight = Node.height(root.left)+1;
        if(root.right!=null) rightHeight = Node.height(root.right)+1;
        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
}
