package Basic_Problems;

import TreeTemplate.Node;

public class InvertingTree {
    public static void main(String[] args) {
        Node a = new Node(4);
        Node b = new Node(2);
        Node c = new Node(7);
        Node d = new Node(1);
        Node e = new Node(3);
        Node f = new Node(6);
        Node g = new Node(9);


        //connect left pointers
        a.left = b;
        b.left = d;
        c.left = f;

        //connect right pointers
        a.right = c;
        c.right = g;
        b.right = e;

        Node invertedTree = invertTree(a);
        Node.BFS(invertedTree);
    }
    public static Node invertTree(Node root) {
        if(root==null) return null;
        Node ans = new Node(root.data);
        ans.left = invertTree(root.right);
        ans.right = invertTree(root.left);
        return ans;
    }
}
