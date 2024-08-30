import java.util.*;
public class traversals {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    public static void printNthlevel(Node root,int n){
        if(root == null) return;
        if(n == 1){
            System.out.print(root.val+" ");
            return;
        }
        printNthlevel(root.left,n-1);
        printNthlevel(root.right, n-1);
    }
    public static int height(Node root){
        if(root == null) return 0;
        return 1 + Math.max(height(root.left),height(root.right));
    }
    public static void BFS(Node root){
        int levels = height(root) + 1;
        if(root == null) return;
        for(int i=1;i<=levels;i++){
            printNthlevel(root,i);
            System.out.println();
        }
    }
    public static void real_BFS(Node root){
        Queue<Node> q = new LinkedList<>();
        if(root!=null) q.add(root);
        while(q.size()>0){
            Node tmp = q.peek();
            if(tmp.left != null) q.add(tmp.left);
            if(tmp.right != null)q.add(tmp.right);
            System.out.print(tmp.val+" ");
            q.remove();
        }
    }
    public static void DFS(Node root){
        if(root == null) return;
        Stack<Node> st = new Stack<>();
        st.add(root);
        while (st.size()>0) {
            Node tmp = st.peek();
            if(tmp.left != null){
                st.add(tmp.left);
                tmp.left = null; //vimp
            }
            else{
                st.pop();
                System.out.print(tmp.val+" ");
                if(tmp.right!=null) st.add(tmp.right);
            }
            
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
        //left nodes
        root.left = a;
        a.left = c;
        b.left = e;
        
        // right nodes 
        root.right = b;
        a.right = d;
        b.right = f;
        
        DFS(root);
    }
}
