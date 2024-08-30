package Problems;

import TreeTemplate.Node;

public class MaxPath {
    public static void main(String[] args) {
        Node root = new Node(3);
        Node a = new Node(4);
        Node b = new Node(5);
        Node c = new Node(-10);
        Node d = new Node(4);

        root.left = a;
        root.right = b;

        b.left = c;
        b.right = d;

        int maxpathSum = maxPathSum(root);
        System.out.println(maxpathSum);
    }
    private static int maxPathSum(Node root) {
        // code here
        if(root==null) return 0;
        if(root.right==null && root.left==null) return root.data;
        int leftans = maxPathSum(root.left);
        int rightans = maxPathSum(root.right);
        int left = Node.sum(root.left);
        int right = sum(root.right);
        int mid = root.data + leftans + rightans;
        return Math.max(leftans,Math.max(rightans,mid));
    }
    private static int sum(Node root){
        if(root==null) return 0;
        if(root.right==null && root.left==null) return root.data;
        return root.data + Math.max(sum(root.left),sum(root.right));
    }


}
