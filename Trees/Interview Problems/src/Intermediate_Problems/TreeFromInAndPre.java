package Intermediate_Problems;

import TreeTemplate.Node;
// revision
public class TreeFromInAndPre {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        Node root = buildTree(preorder, inorder);
        Node.BFS(root);
    }

    public static Node buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return helper(preorder, 0, n - 1, inorder, 0, n - 1);
    }

    public static Node helper(int[] preorder, int prel, int preh, int[] inorder, int inl, int inh) {
        if (prel > preh) return null;
        Node root = new Node(preorder[prel]);
        int i = inl;
        while (inorder[i] != preorder[prel]) i++;
        int leftsize = i - inl;
        root.left = helper(preorder, prel + 1, prel + leftsize, inorder, inl, i - 1);
        root.right = helper(preorder, prel + leftsize + 1, preh, inorder, i + 1, inh);
        return root;
    }
}
