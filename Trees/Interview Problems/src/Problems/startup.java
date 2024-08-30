package Problems;

import TreeTemplate.Node;

public class startup {

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

        //traversals
        Node.inorder(a);
        System.out.println();

        Node.preorder(a);
        System.out.println();

        Node.postorder(a);
        System.out.println();

        //size of a tree
        System.out.println(Node.size(a));

        //sum of nodes in a tree
        System.out.println(Node.sum(a));

        //max node in a tree
        System.out.println(Node.max(a));

        //height of a tree
        System.out.println(Node.height(a));

        //level of a tree = height + 1
        int level = Node.height(a)+1;
        System.out.println(level);

        //print tree level wise
        for(int i=1;i<=level;i++){
            Node.printnthlevel(a,i);
        }
        System.out.println();

        //BFS traversal
        Node.BFS(a);
        System.out.println();

        //DFS Traversal
        Node.DFS(a);
    }
}
