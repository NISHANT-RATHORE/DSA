package BST;

import TreeTemplate.Node;

public class dataidateBST {
    public static void main(String[] args) {
        Integer [] lot = {2,1,3};
        Node root = Node.constructTree(lot);
        System.out.println(isValidBST(root));
    }
    public static boolean isValidBST(Node root) {
        return validate(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public static boolean validate(Node root, long min, long max){
        if(root==null) return true;
        if(root.data <= min || root.data >= max) return false;
        boolean leftAns = validate(root.left,min,root.data);
        boolean rightAns = validate(root.right,root.data,max);
        return leftAns && rightAns;
    }
}
