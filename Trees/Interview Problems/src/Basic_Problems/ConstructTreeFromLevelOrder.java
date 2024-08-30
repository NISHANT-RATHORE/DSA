package Basic_Problems;

import TreeTemplate.Node;

import java.util.LinkedList;
import java.util.Queue;

public class ConstructTreeFromLevelOrder {
    public static void main(String[] args) {
        Integer [] arr = {1,2,3,4,5,6,7};
        Integer [] arr2 = {1,2,3,4,5,null,6,null,7,null,null,8,null,null,null,9,null};
        Node root = Node.constructTree(arr2);
        Node.BFS(root);
    }
    private static Node constructTree(Integer [] arr){
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
