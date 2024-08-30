package TreeTemplate;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Node {
    public int data;
    public Node left;
    public Node right;
    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public static void inorder(Node root){
        if(root==null) return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void preorder(Node root){
        if(root==null) return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void postorder(Node root){
        if(root==null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }

    public static void printnthlevelReversed(Node root,int level){
        if(root==null) return;;
        if(level==1) System.out.print(root.data+" ");
        printnthlevelReversed(root.right,level-1);
        printnthlevelReversed(root.left,level-1);
    }

    public static void printnthlevel(Node root,int level){
        if(root==null) return;;
        if(level==1) System.out.print(root.data+" ");
        printnthlevel(root.left,level-1);
        printnthlevel(root.right,level-1);
    }

    public static int size(Node root){
        if(root==null) return 0;
        return 1 + size(root.left) + size(root.right);
    }

    public static int sum(Node root){
        if(root==null) return 0;
        return root.data + sum(root.left) + sum(root.right);
    }

    public static int max(Node root){
        if(root == null) return Integer.MIN_VALUE;
        return Math.max(root.data,Math.max(max(root.left),max(root.right)));
    }

    public static int height(Node root){
        if(root == null || (root.left==null && root.right == null)) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return 1 + Math.max(leftHeight,rightHeight);
    }

    public static void BFS(Node root){ //iterative method
        Queue<Node> queue = new LinkedList<>();
        if(root!=null) queue.add(root);
        while(queue.size()>0){
            Node tmp = queue.peek();
            if(tmp.left!=null) queue.add(tmp.left);
            if(tmp.right!=null) queue.add(tmp.right);
            System.out.print(tmp.data + " ");
            queue.remove();
        }
    }

    public static void DFS(Node root){  //inorder iterative method
        if(root==null) return;
        Stack<Node> st = new Stack<>();
        st.push(root);
        while(st.size()>0){
            Node tmp = st.peek();
            if(tmp.left!=null) {
                st.push(tmp.left);
                tmp.left = null;
            } else{
                st.pop();
                System.out.print(tmp.data+" ");
                if(tmp.right!=null) st.push(tmp.right);
            }
        }
    }

    public static Node constructTree(Integer [] arr){
        Node root = new Node(arr[0]);
        int n = arr.length;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (i<n-1){
            Node tmp = q.remove();
            Node left = new Node(-1);
            Node right = new Node(-1);
            //left
            if(arr[i]==null){
                tmp.left = null;
            }
            else{
                left = new Node(arr[i]);
                tmp.left = left;
                q.add(left);
            }

            //right
            if(arr[i+1]==null) {
                tmp.right = null;
            }
            else{
                right = new Node(arr[i+1]);
                tmp.right = right;
                q.add(right);
            }

            i += 2;
        }
        return root;
    }
}
