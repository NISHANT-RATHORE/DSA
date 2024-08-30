package Problems;

import TreeTemplate.Node;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPath {
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

        List<String> RootToLeafPath = binaryTreePaths(a);
        System.out.println(RootToLeafPath);
    }
    public static List<String> binaryTreePaths(Node root) {
        List<String> ans = new ArrayList<>();
        helper(root,ans,new StringBuilder());
        return ans;
    }

    private static void helper(Node root, List<String> ans,StringBuilder s) {
        if(root == null) return;
        if(root.left==null && root.right==null){
            s.append(root.data);
            ans.add(s.toString());
        }
        helper(root.left, ans, new StringBuilder(s).append(root.data).append("->"));
        helper(root.right, ans, new StringBuilder(s).append(root.data).append("->"));
    }
}
