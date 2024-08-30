package practice;

import TreeTemplate.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IncreasingOrder {
    public static void main(String[] args) {
        Integer [] lot = {5,3,6,2,4,null,8,1,null,null,null,7,9};
        Node root = Node.constructTree(lot);
        Node incorder = increasingBST(root);
        Node.BFS(incorder);
    }
    public static Node increasingBST(Node root) {
        List<Node> al = new LinkedList<>();
        helper(root, al);
        Node ans = al.get(0);
        Node tmp = ans;
        for (int i = 1; i < al.size(); i++) {
            tmp.left = null;
            tmp.right = al.get(i);
            tmp = tmp.right;
        }
        tmp.left = null;
        tmp.right = null;
        return ans;
    }
    private static void helper(Node root,List<Node> al){
        if(root==null) return;
        helper(root.left,al);
        al.add(root);
        helper(root.right,al);
    }

}
