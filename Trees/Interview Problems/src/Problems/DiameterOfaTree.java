package Problems;

import TreeTemplate.Node;

public class DiameterOfaTree {
    public static void main(String[] args) {
        Integer [] lot = {1,2,3,4,5,null,null,6,null,null,7};
        Node root = Node.constructTree(lot);
        System.out.println(diameterOfBinaryTree2(root));
    }
    public static int diameterOfBinaryTree(Node root) {
        if(root==null) return 0;
        int leftans = diameterOfBinaryTree(root.left);
        int rightans = diameterOfBinaryTree(root.right);
        int mid = Node.height(root.left) + Node.height(root.right);
        if(root.left!=null) mid++;
        if(root.right!=null) mid++;
        return Math.max(leftans,Math.max(rightans,mid));
    }


    //optimised
    public static int diameterOfBinaryTree2(Node root) {
        int[] ans = new int[1];
        dfs(root,ans);
        return ans[0];
    }

    public static int dfs(Node root, int[] ans) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left, ans);
        int right = dfs(root.right,ans);

        ans[0] = Math.max(left + right, ans[0]);
        return Math.max(left,right) + 1;
    }
}
