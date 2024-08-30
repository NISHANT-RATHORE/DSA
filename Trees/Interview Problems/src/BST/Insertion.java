package BST;

import TreeTemplate.Node;

public class Insertion {
    public static void main(String[] args) {
        Integer [] lot = {4,2,7,1,3};
        Node root = Node.constructTree(lot);
        Node insertion = insertIntoBST(root,5);
        Node.BFS(root);
    }
    public static Node insertIntoBST(Node root, int val) {
        if(root==null) return new Node(val);
        else if(root.data < val) root.right = insertIntoBST(root.right,val);
        else root.left = insertIntoBST(root.left,val);
        return root;
    }
}
