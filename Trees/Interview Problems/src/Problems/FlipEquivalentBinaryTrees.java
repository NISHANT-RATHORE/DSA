package src.Problems;
import TreeTemplate.Node;

public class FlipEquivalentBinaryTrees {
    public static void main(String[] args) {
        Integer [] arr1 = {1,2,3,4,5,6,null,null,null,7,8};
        Integer [] arr2 = {1,3,2,null,6,4,5,null,null,null,null,8,7};

        Node root1 = Node.constructTree(arr1);
        Node root2 = Node.constructTree(arr2);

        boolean flipequiv = flipEquiv(root1,root2);
        System.out.println(flipequiv);
    }
    public static boolean flipEquiv(Node root1, Node root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.data != root2.data) return false;

        boolean isSame = flipEquiv(root1.left,root2.left) && flipEquiv(root1.right,root2.right);
        if(isSame) return true;

        return flipEquiv(root1.left,root2.right) && flipEquiv(root1.right,root2.left);
    }
}
