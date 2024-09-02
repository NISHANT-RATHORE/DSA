package BST;

import TreeTemplate.Node;

public class LCAinBST {
    public static void main(String[] args) {
        Integer [] lot = {6,2,8,0,4,7,9,null,null,3,5};
        Node root = Node.constructTree(lot);
        Node p = new Node(2);
        Node q = new Node(8);
        System.out.println(lowestCommonAncestor(root,p,q).data);
    }
    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        if(root==null || root==p || root==q) return root;
        if(root.data > p.data && root.data > q.data) return lowestCommonAncestor(root.left,p,q);
        if(root.data < p.data && root.data < q.data) return lowestCommonAncestor(root.right,p,q);
        return root;
    }
}
