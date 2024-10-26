import java.util.*;
public class basic2 {
    public static void formtree(Node root){
        root.child.add(new Node(5));
        root.child.add(new Node(11));
        root.child.add(new Node(63));

        root.child.get(0).child.add(new Node(1));
        root.child.get(0).child.add(new Node(4));
        root.child.get(0).child.add(new Node(8));

        root.child.get(1).child.add(new Node(6));
        root.child.get(1).child.add(new Node(7));
        root.child.get(1).child.add(new Node(15));
        
        root.child.get(2).child.add(new Node(31));
        root.child.get(2).child.add(new Node(56));
        root.child.get(2).child.add(new Node(65));
        
    }
    public static class Node{
        int val;
        List<Node> child;
        Node(int val){
            this.val = val;
            child = new ArrayList<>();
        }
    }
    //DFS
    public static void preorder(Node root){
        if(root.child.isEmpty()){
            System.out.print(root.val+" ");
            return;
        }
        System.out.print(root.val+" ");
        int n = root.child.size();
        for(int i=0;i<n;i++){
            preorder(root.child.get(i));
        }
    }

    public static void mirrorimage(Node root){
        if(root.child.isEmpty()) return;
        int n = root.child.size();
        if(n == 1) return;
        for(int i=0;i<n;i++){
            mirrorimage(root.child.get(i));
            reverse(root.child);
        }
    }
    public static void reverse(List<Node> arr){
        Collections.reverse(arr);
        return;
    }

    public static void postorder(Node root){
        if(root.child.isEmpty()){
            System.out.print(root.val+" ");
            return;
        }
        int n = root.child.size();
        for(int i=0;i<n;i++){
            postorder(root.child.get(i));
        }
        System.out.print(root.val+" ");
    }
    //BFS
    public static void BFS(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.peek();
            System.out.print(curr.val+" ");
            q.poll();
            int n = curr.child.size();
            for(int i=0;i<n;i++){
                q.add(curr.child.get(i));
            }
        }
    }
    public static int max(Node root){
        if(root.child.isEmpty()) return root.val;
        int mx = root.val;
        int n = root.child.size();
        for(int i=0;i<n;i++){
            mx = Math.max(max(root.child.get(i)),mx);
        }
        return mx;
    }
    public static void main(String[] args) {
        Node root = new Node(30);
        formtree(root);
        System.out.println("preorder traversal:");
        preorder(root);
        System.out.println();
        System.out.println("postorder traversal:");
        postorder(root);
        System.out.println();
        System.out.println("BFS traversal:");
        BFS(root);
        System.out.println();
        System.out.println(max(root));
        mirrorimage(root);
        preorder(root);
    }
}