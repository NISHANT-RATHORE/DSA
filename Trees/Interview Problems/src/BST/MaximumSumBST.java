package BST;

import TreeTemplate.Node;
//Revise this Code
public class MaximumSumBST {
    static int ans;
    public static void main(String[] args) {
        Integer [] lot = {1,4,3,2,4,2,5,null,null,null,null,null,null,4,6};
        Node root = Node.constructTree(lot);
        System.out.println(maxSumBST(root));
    }
    public static int maxSumBST(Node root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    public static int[] dfs(Node root) {
        if(root == null){
            return new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE,0};
        }
        //check of BST exists
        int [] leftSubTree = dfs(root.left);
        int [] rightSubTree = dfs(root.right);
        if(root.data > leftSubTree[1] && root.data < rightSubTree[0]){
            int currSum = root.data + leftSubTree[2] + rightSubTree[2];
            ans = Math.max(ans,currSum);
            int minVal = Math.min(leftSubTree[0],root.data);
            int maxVal = Math.max(rightSubTree[1],root.data);
            return new int[]{minVal,maxVal,currSum};
        }
        //else
        int maxSum = Math.max(leftSubTree[2],rightSubTree[2]);
        return new int[]{Integer.MIN_VALUE,Integer.MAX_VALUE,maxSum};
    }
}
