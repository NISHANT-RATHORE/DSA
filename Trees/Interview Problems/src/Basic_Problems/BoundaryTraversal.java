package Basic_Problems;
import java.util.*;
import TreeTemplate.Node;

public class BoundaryTraversal {
    public static void main(String[] args) {
        Integer [] arr2 = {1,2,3,4,5,null,6,null,7,null,null,8,null,null,null,9,null};
        Node root = Node.constructTree(arr2);
        List<Integer> boundary = boundaryTraversal(root);
        System.out.println(boundary);
    }

    private static List<Integer> boundaryTraversal(Node root) {
        List<Integer> ans = new ArrayList<>();
        leftBoundary(ans,root);
        rootNodes(ans,root);
        rightBoundary(ans,root.right);
        return ans;
    }
    private static void leftBoundary(List<Integer> ans,Node root){
        if(root==null) return;
        if(root.left==null && root.right==null) return;
        ans.add(root.data);
        if(root.left!=null) leftBoundary(ans,root.left);
        else leftBoundary(ans,root.right);
    }
    private static void rootNodes(List<Integer> ans,Node root){
        if(root==null) return;
        if(root.left==null && root.right==null) ans.add(root.data);
        rootNodes(ans,root.left);
        rootNodes(ans,root.right);
    }
    private static void rightBoundary(List<Integer> ans,Node root){
        if(root==null) return;
        if(root.right==null && root.left==null) return;
        if(root.right!=null) rightBoundary(ans,root.right);
        else rightBoundary(ans,root.left);
        ans.add(root.data);
    }
}
