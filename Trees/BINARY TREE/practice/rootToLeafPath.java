import java.util.*;
public class rootToLeafPath {
    public static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }
    public static List<List<Integer>> rootToLeafPath(Node root){
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        List<Integer> arr = new ArrayList<>();
        helper(root,arr,ans);
        return ans;        
    }
    public static void helper(Node root, List<Integer> arr, List<List<Integer>> ans) {
        if (root == null) return;
        arr.add(root.val);
        if (root.left == null && root.right == null) {
            ans.add(new ArrayList<>(arr));
        } else {
            helper(root.left, new ArrayList<>(arr), ans);
            helper(root.right, new ArrayList<>(arr), ans);
        }
    }
    public static void main(String[] args) {
        Node root = new Node(2);
        Node a = new Node(4);
        Node b = new Node(10);
        Node c = new Node(6);
        Node d = new Node(5);
        Node e = new Node(11);
        Node f = new Node(12);
        Node g = new Node(13);
        root.left = a;
        a.left = c;
        b.left = e;
        f.left = g;

        root.right = b;
        b.right = f;
        a.right = d;
        List<List<Integer>> path = rootToLeafPath(root);
        for(List<Integer> fina:path){
            for(int i:fina){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}