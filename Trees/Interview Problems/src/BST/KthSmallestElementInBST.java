package BST;

import TreeTemplate.Node;

public class KthSmallestElementInBST {
    static int pos = 0;
    public static void main(String[] args) {
        Integer [] lot = {5,3,6,2,4,null,null,1};
        Node root = Node.constructTree(lot);
        System.out.println(kthSmallest(root,3));
    }
    public static int kthSmallest(Node root, int k) {
        return inorder(root,k).data;
    }
    private static Node inorder(Node root,int k){
        if(root==null) return null;
        Node left = inorder(root.left,k);
        if(left!=null) return left;
        pos++;
        if(pos==k) return root;
        Node right = inorder(root.right,k);
        if(right!=null) return right;
        return null;
    }
}
