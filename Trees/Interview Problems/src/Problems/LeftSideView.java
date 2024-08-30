package Problems;

import TreeTemplate.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftSideView {
    public static void main(String[] args) {
        Integer[] lot = {1, 2, 3, null, 5, null, 4};
        Node root = Node.constructTree(lot);
        ArrayList<Integer> res = rightSideView(root);
        System.out.println(res);
    }
    public static ArrayList<Integer> rightSideView(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            int size = q.size();
            if(size>0){
                Node node = q.peek();
                res.add(node.data);
            }
            while (size>0){
                Node node = q.poll();
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
                size--;
            }
        }
        return res;
    }
}
