package BST;

import TreeTemplate.Node;

public class ConstructBSTfromPreorder {
    static int preorderIdx = 0;
    public static void main(String[] args) {
        int [] preorder = {8,5,1,7,10,12};
        Node root = bstFromPreorder(preorder);
        Node.BFS(root);
    }
    public static Node bstFromPreorder(int[] preorder) {
        return ConstructBST(preorder,preorder[0],Integer.MIN_VALUE,Integer.MAX_VALUE,preorder.length);
    }
    private static Node ConstructBST(int [] preorder,int key,int min,int max,int n){
        if(preorderIdx >= n) return null;
        Node root = null;
        if(key>min && key<max){
            root = new Node(key);
            preorderIdx++;

            if(preorderIdx < n){
                root.left = ConstructBST(preorder,preorder[preorderIdx],min,key,n);
            }

            if(preorderIdx < n){
                root.right = ConstructBST(preorder,preorder[preorderIdx],key,max,n);
            }

        }
        return root;
    }
}
