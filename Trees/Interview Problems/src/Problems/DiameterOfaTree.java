package Problems;

import TreeTemplate.Node;

public class DiameterOfaTree {
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(69);


        //connect left pointers
        a.left = b;
        b.left = d;
        c.left = f;

        //connect right pointers
        a.right = c;
        c.right = g;
        b.right = e;

        //diameter
        int diameter = diameterOfBinaryTree(a);
        int diameter2 = diameterOfBinaryTree2(a);
        System.out.println(diameter);
        System.out.println(diameter2);

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
