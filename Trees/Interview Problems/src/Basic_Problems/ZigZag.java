package Basic_Problems;

import TreeTemplate.Node;

import java.util.ArrayList;
import java.util.List;

public class ZigZag {
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

//        System.out.println(level(a));
//        Node.printnthlevelReversed(a,level(a));
        List<List<Integer>> al = zigzagLevelOrder(a);
        System.out.println(al);
    }
    public static int level(Node root){
        if(root==null) return 0;
        if(root.left==null && root.right == null) return 1;
        return 1 + Math.max(level(root.left),level(root.right));
    }
    public static List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        int level = level(root);
        for(int i=1;i<=level;i++){
            List<Integer> arr = new ArrayList<>();
            if(i%2!=0){
                printnthlevel(root,i,arr);
            }
            else printnthlevelReversed(root,i,arr);
            ans.add(arr);
        }
        return ans;
    }
    public static void printnthlevelReversed(Node root,int level,List<Integer> arr){
        if(root==null) return;;
        if(level==1) arr.add(root.data);
        printnthlevelReversed(root.right,level-1,arr);
        printnthlevelReversed(root.left,level-1,arr);
    }

    public static void printnthlevel(Node root,int level,List<Integer> arr){
        if(root==null) return;;
        if(level==1) arr.add(root.data);
        printnthlevel(root.left,level-1,arr);
        printnthlevel(root.right,level-1,arr);
    }

}
