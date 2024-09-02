package Advanced_Problems;

import TreeTemplate.Node;

public class MaxSumPath {
    public static void main(String[] args) {
        Integer[] lot = {-2,1,null};
        Node root = Node.constructTree(lot);
        int maxSum = maxPathSum(root);
        System.out.println(maxSum);
    }

    public static int maxPathSum(Node root) {
        int[] sum = new int[]{Integer.MIN_VALUE};
        sum(root, sum);
        return sum[0];
    }

    private static int sum(Node root, int[] sum) {
        if (root == null) return 0;
        int left = Math.max(0, sum(root.left, sum));
        int right = Math.max(0, sum(root.right, sum));
        sum[0] = Math.max(sum[0], left + right + root.data);
        return Math.max(left, right) + root.data;
    }
}