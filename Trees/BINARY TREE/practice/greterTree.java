import java.util.*;

public class greterTree {
    static int tmp = 0;
    public static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
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
    public static void convertBST(Node root){
        if(root == null) return;
        convertBST(root.right);
        root.val += tmp;
        tmp = root.val;
        convertBST(root.left);
    }

    public static void main(String[] args) {
        Node root = new Node(2);
        Node a = new Node(4);
        Node b = new Node(10);
        Node c = new Node(6);
        Node d = new Node(5);
        Node e = new Node(11);
        Node f = new Node(12);
        // Node g = new Node(13);
        root.left = a;
        a.left = c;
        b.left = e;
        // f.left = g;

        root.right = b;
        b.right = f;
        a.right = d;
        convertBST(root);
        BFS2(root);
    }
}