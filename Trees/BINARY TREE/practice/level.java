public class level {
    public static int level(Node root,int val,int level) {
        if(root == null) return 0;
        if(root.val == val) return level;
        int downlevel = level(root.left, val, level + 1);
        if (downlevel != 0)
            return downlevel;
        downlevel = level(root.right, val, level + 1);
        return downlevel;
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
        int levels = level(root,13,1);
        System.out.println("level of a tree is: " + levels);

    }
}