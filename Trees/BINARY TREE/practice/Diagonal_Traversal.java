import java.util.*;
public class Diagonal_Traversal {
    public static void diagonaltraversal(Node root){
        if(root==null) return;
        Queue<Node> q = new LinkedList<>();
        if(root!=null) q.add(root);
        while(q.size()>0){
            Node current = q.poll();
            while(current != null){
                System.out.print(current.val+" ");
                if(current.left!=null) q.add(current.left);
                current = current.right;
            }
        }
    }
    public static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
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
        System.out.println("Diagonal Traversal");
        diagonaltraversal(root);
    }
}