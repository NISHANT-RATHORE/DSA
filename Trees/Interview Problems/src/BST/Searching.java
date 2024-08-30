package BST;

import TreeTemplate.Node;

public class Searching {
    public static void main(String[] args) {
        Integer [] lot = {4,2,7,1,3};
        Node root = Node.constructTree(lot);
        Node search = sarchIntoBST(root,5);
        Node.BFS(search);
    }

    private static Node sarchIntoBST(Node root, int val) {
        if(root==null) return null;
        if(root.data == val) return root;
        Node tmp = root;
        if(root.data < val){
            return sarchIntoBST(root.right,val);
        }
        else return sarchIntoBST(root.left,val);
    }
}
