import java.util.*;
public class BFS {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    public static int helper(Node root){
        if(root == null) return 0;
        return 1 + Math.max(helper(root.left),helper(root.right));
    }
    public static void BFS1(Node root){
        int levels = helper(root);
        for(int i=0;i<=levels;i++){
            printNthlevel(root,i);
        }
    }
    public static void BFS2(Node root){
        Queue<Node> q = new LinkedList<>();
        if(root!=null) q.add(root);
        while (q.size()>0) {
            Node tmp = q.peek();
            if(tmp.left!=null) q.add(tmp.left);
            if(tmp.right !=null) q.add(tmp.right);
            System.out.print(tmp.val+" ");
            q.poll();
        }

    }
    public static void printNthlevel(Node root,int n){
        if(root == null) return;
        if(n==1) System.out.print(root.val+" ");
        printNthlevel(root.left, n-1);
        printNthlevel(root.right,n-1);
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
        System.out.println("BFS traversal for a tree is: ");
        BFS1(root);
        System.out.println();
        BFS2(root);
        
    }
}