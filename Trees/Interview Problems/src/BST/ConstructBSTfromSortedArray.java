package BST;

import TreeTemplate.Node;

public class ConstructBSTfromSortedArray {
    public static void main(String[] args) {
        int [] nums = {-10,-3,0,5,9};
        Node root = ConstructBSTfromSortedArray(nums);
        Node.BFS(root);
    }
    public static Node ConstructBSTfromSortedArray(int [] nums){
        return helper(nums,0,nums.length-1);
    }
    private static Node helper(int [] nums,int st,int end){
        if(st>end) return null;
        int mid = st + (end - st)/2;
        Node root = new Node(nums[mid]);
        root.left = helper(nums,st,mid-1);
        root.right = helper(nums,mid+1,end);
        return root;
    }
}
