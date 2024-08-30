package Problems;

import TreeTemplate.Node;

import java.util.*;

public class RightSideView {
    public static void main(String[] args) {
        Integer[] lot = {1, 2, 3, null, 5, null, 4};
        Node root = Node.constructTree(lot);
        List<Integer> res = rightSideView(root);
        System.out.println(res);
    }
    public static List<Integer> rightSideView(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            int size = q.size();
            while (size>0){
                Node node = q.poll();
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
                size--;
                if(size==0) res.add(node.data);
            }
        }
        return res;
    }
}
