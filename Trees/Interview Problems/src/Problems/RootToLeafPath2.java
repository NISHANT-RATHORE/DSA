package Problems;

import TreeTemplate.Node;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPath2 {
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(69);


        //connect left pointers
        a.left = b;
        b.left = d;
        c.left = f;

        //connect right pointers
        a.right = c;
        c.right = g;
        b.right = e;

        ArrayList<ArrayList<Integer>> RootToLeafPath = Paths(a);
        System.out.println(RootToLeafPath);
    }

    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        if(root==null) return ans;
        helper(root,arr,ans);
        return ans;
    }

    private static void helper(Node root,ArrayList<Integer> arr,ArrayList<ArrayList<Integer>> ans){
        if(root==null) return;
        arr.add(root.data);
        if(root.left==null && root.right==null){
            ans.add(arr);
            return;
        }
        helper(root.left,new ArrayList<Integer>(arr),ans);
        helper(root.right,new ArrayList<Integer>(arr),ans);
    }

}
