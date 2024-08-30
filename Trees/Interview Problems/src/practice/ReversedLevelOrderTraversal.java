package practice;

import TreeTemplate.Node;

import java.util.*;

public class ReversedLevelOrderTraversal {
    public static void main(String[] args) {
        Integer[] lot = {3, 9, 20, null, null, 15, 7};
        Node root = Node.constructTree(lot);
        List<List<Integer>> res = levelOrderBottom(root);
        System.out.println(res);
    }

    public static List<List<Integer>> levelOrderBottom(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> arr = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node tmp = q.poll();
                arr.add(tmp.data);
                if (tmp.left != null) q.offer(tmp.left);
                if (tmp.right != null) q.offer(tmp.right);
            }
            res.addFirst(arr);
        }
        return res;
    }
}