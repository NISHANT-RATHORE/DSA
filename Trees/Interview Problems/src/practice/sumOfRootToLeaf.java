package practice;

import TreeTemplate.Node;

import java.util.ArrayList;
import java.util.List;

public class sumOfRootToLeaf {
    static List<String> num = new ArrayList<>();
    public static void main(String[] args) {
        Integer [] lot = {1,0,1,0,1,0,1};
        Node root = Node.constructTree(lot);
        int sum = sumRootToLeaf(root);
        System.out.println(sum);
    }
    public static int sumRootToLeaf(Node root) {
        List<String> nums = helper(root, new StringBuilder());
        int sum = 0;
        for (String num : nums) {
            sum += Integer.parseInt(num, 2); // Convert binary string to integer
        }
        return sum;
    }
    private static List<String> helper(Node root, StringBuilder path) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        path.append(root.data);
        if (root.left == null && root.right == null) {
            result.add(path.toString());
        } else {
            result.addAll(helper(root.left, new StringBuilder(path)));
            result.addAll(helper(root.right, new StringBuilder(path)));
        }
        return result;
    }
}
