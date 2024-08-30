package Problems;

import TreeTemplate.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

class CustomNode2{
    Node node;
    int col;
    public CustomNode2(Node node, int col) {
        this.node = node;
        this.col = col;
    }
}
public class BottomView {
    public static void main(String[] args) {
        Integer [] lot = {1,2,3,4,5,6,7};
        Node root = Node.constructTree(lot);
        ArrayList<Integer> res = bottomView(root);
        System.out.println(res);
    }
    static ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Queue<CustomNode2> queue = new LinkedList<>();
        queue.offer(new CustomNode2(root,0));
        TreeMap<Integer,Integer> mp = new TreeMap<>();
        while (!queue.isEmpty()){
            CustomNode2 CustomNode2 = queue.poll();
            Node node = CustomNode2.node;
            int col = CustomNode2.col;
            // if(!mp.containsKey(col)){  // only change
            mp.put(col,node.data);
            // }
            if(node.left!=null){
                queue.offer(new CustomNode2(node.left,col-1));
            }
            if(node.right!=null){
                queue.offer(new CustomNode2(node.right,col+1));
            }
        }
        res.addAll(mp.values());
        return res;
        // add your code
    }
}

