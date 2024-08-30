import java.util.*;
public class LOT_to_tree {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }

    public static void BFS(Node root){
        int levels = height(root) + 1;
        if(root == null) return;
        for(int i=1;i<=levels;i++){
            printNthlevel(root,i);
            System.out.println();
        }
    }
    public static int height(Node root){
        if(root == null || (root.left==null && root.right == null)) return 0;
        return 1+Math.max(height(root.left),height(root.right));
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
    public static Node constructbfs(String[] LOT){
        int n = LOT.length;
        int x = Integer.parseInt(LOT[0]);
        Node root = new Node(x);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while(i<n-1){
            Node tmp = q.remove();
            Node left = new Node(0);
            Node right = new Node(0);
            if(LOT[i].equals("")) left = null;
            else{
                int l = Integer.parseInt(LOT[i]);
                left.val = l;
                q.add(left);
            }
            if(LOT[i+1].equals("")) right = null;
            else{
                int r = Integer.parseInt(LOT[i+1]);
                right.val = r;
                q.add(right);
            }
            tmp.left = left;
            tmp.right = right;
            i += 2;
    }
    return root;
}
    
    public static void main(String[] args) {
        String[] LOT = {"1","2","3","4","5","","6","","7","","","8","","","","9",""};
        Node root = constructbfs(LOT);
        int levels = height(root) + 1;
        for(int i=1;i<=levels;i++){
            printNthlevel(root,i);
            System.out.println();
        }
    }
}
