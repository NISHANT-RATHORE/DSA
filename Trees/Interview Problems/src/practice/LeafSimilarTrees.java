package practice;

import TreeTemplate.Node;

import java.util.*;

public class LeafSimilarTrees {
    public static void main(String[] args) {
        Integer[] lot1 = {3, 5, 1, 6, 2, 9, 8, null, null, 7, 4};
        Integer[] lot2 = {3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8};
        Node root1 = Node.constructTree(lot1);
        Node root2 = Node.constructTree(lot2);
        boolean isSameLeaf = leafSimilar(root1, root2);
        System.out.println(isSameLeaf);
    }

    public static boolean leafSimilar(Node root1, Node root2) {
        List<Integer> al = new ArrayList<>();
        List<Integer> al2 = new ArrayList<>();
        helper(al, root1);
        helper(al2, root2);
        if (al.size() != al2.size()) return false;
        for (int i = 0; i < al.size(); i++) {
            if (!al.get(i).equals(al2.get(i))) return false;
        }
        return true;
    }

    private static void helper(List<Integer> al, Node root) {
        if (root == null) return;
        if (root.left == null && root.right == null) al.add(root.data);
        helper(al, root.left);
        helper(al, root.right);
    }
}