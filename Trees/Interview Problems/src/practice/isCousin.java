package practice;

import TreeTemplate.Node;

public class isCousin {
    public static void main(String[] args) {
        Integer [] lot = {1,2,3,null,4,null,5};
        Node root = Node.constructTree(lot);
        boolean isCousin = isCousins(root,5,4);
        System.out.println(isCousin);
    }
    public static boolean isCousins(Node root, int x, int y) {
        if (root == null) return false;
//        if((root.left.data==x && root.right.data==y) || (root.left.data==y && root.right.data==x)) return false;
        boolean a = findNode(root.right,x) &&  findNode(root.left,y);
        boolean b = findNode(root.right,y) &&  findNode(root.left,x);
        return (a || b) && Node.height(root.left) == Node.height(root.right);
    }

    private static boolean findNode(Node root, int val) {
        if(root==null) return false;
        if(root.data == val) return true;
        return findNode(root.left,val) || findNode(root.right,val);
    }
}
