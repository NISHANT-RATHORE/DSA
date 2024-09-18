package Intermediate_Problems;

import TreeTemplate.Node;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidth {
    static class Pair{
        Node node;
        int num;
        public Pair(Node node, int num) {
            this.node = node;
            this.num = num;
        }
    }
    public static void main(String[] args) {
        Integer [] lot = {1,3,2,5,3,null,9};
        Node root = Node.constructTree(lot);
        System.out.println(widthOfBinaryTree(root));
    }
    public static int widthOfBinaryTree(Node root) {
        if(root==null) return 0;
        int ans = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root,0));
        while (!queue.isEmpty()){
            int size = queue.size();
            int mmin = queue.peek().num;
            int first = 0,last = 0;
            for(int i=0;i<size;i++){
                int curr_id = queue.peek().num - mmin;
                Node node = queue.peek().node;
                queue.poll();
                if(i==0) first = curr_id;
                if(i==size-1) last = curr_id;
                if(node.left!=null){
                    queue.offer(new Pair(node.left,curr_id*2 + 1));
                }
                if(node.right!=null){
                    queue.offer(new Pair(node.right,curr_id*2+2));
                }
            }
            ans = Math.max(ans,last-first+1);
        }
        return ans;
    }
}
