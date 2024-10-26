package Advanced_Problems;

import TreeTemplate.Node;

import java.util.ArrayList;
import java.util.List;

public class HeightofBinaryTreeAfterSubtreeRemovalQueries {
    public static void main(String[] args) {
        Integer[] arr = {5,8,9,2,1,3,7,4,6};
        int[] queries = {3,2,4,8};

        Node root = Node.constructTree(arr);
        int [] res = treeQueries(root, queries);
        for (int val : res) System.out.print(val + " ");
    }

    public static int [] treeQueries(Node root, int[] queries) {
        List<Integer> result = new ArrayList<>();
        for (int query : queries) {
            int height = calcHeight(root, query);
            result.add(height-1);
        }
        int[] res = new int[result.size()];
        for(int i=0;i<result.size();i++){
            res[i] = result.get(i);
        }
        return res;
    }

    private static int calcHeight(Node root, int query) {
        if (root == null) return 0;
        if (root.data == query) return 0;
        return 1 + Math.max(calcHeight(root.left, query), calcHeight(root.right, query));
    }
}