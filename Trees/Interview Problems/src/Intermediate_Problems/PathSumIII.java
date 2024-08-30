package Intermediate_Problems;

import TreeTemplate.Node;

public class PathSumIII {
    static int ways = 0;
    public static void main(String[] args) {
        Integer [] lot = {5,4,8,11,null,13,4,7,2,null,null,5,1};
        Node root = Node.constructTree(lot);
        int ways = pathSum(root,22);
        System.out.println(ways);
    }
    public static int pathSum(Node root, int targetSum) {
        if(root==null) return 0;
        int count = noOfPath(root,targetSum);
        count += noOfPath(root.left,targetSum) + noOfPath(root.right,targetSum);
        return count;
    }

    private static int noOfPath(Node root, int targetSum) {
        if(root==null)return 0;
        if(root.data==targetSum) return 1;
        return noOfPath(root.left,targetSum-root.data) + noOfPath(root.right,targetSum-root.data);
    }
}
