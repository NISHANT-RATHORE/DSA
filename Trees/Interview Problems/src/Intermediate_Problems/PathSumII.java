package Intermediate_Problems;

import TreeTemplate.Node;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public static void main(String[] args) {
        Integer [] lot = {5,4,8,11,null,13,4,7,2,null,null,5,1};
        Node root = Node.constructTree(lot);
        int targetSum = 22;
        List<List<Integer>> pathSum = pathSum(root,targetSum);
        System.out.println(pathSum);
    }
    public static List<List<Integer>> pathSum(Node root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        helper(res,arr,root,targetSum);
        return res;
    }
    private static void helper(List<List<Integer>> res, List<Integer> arr, Node root, int targetSum) {
        if(root==null) return ;
        if(root.left==null && root.right==null){
            arr.add(root.data);
            if(root.data==targetSum){
                res.add(new ArrayList<>(arr));
            }
            arr.removeLast();
            return;
        }
        arr.add(root.data);
        helper(res,arr,root.left,targetSum-root.data);
        helper(res,arr,root.right,targetSum-root.data);
        arr.removeLast();
    }
}
