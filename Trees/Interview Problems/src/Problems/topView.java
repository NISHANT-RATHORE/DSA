package Problems;

import TreeTemplate.Node;

import java.util.*;

class CustomNode{
    Node node;
    int col;
    public CustomNode(Node node, int col) {
        this.node = node;
        this.col = col;
    }
}
public class topView {
    public static void main(String[] args) {
        Integer [] lot = {1,2,3,4,5,6,7};
        Node root = Node.constructTree(lot);
        ArrayList<Integer> res = topView(root);
        System.out.println(res);
    }
    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Queue<CustomNode> queue = new LinkedList<>();
        queue.offer(new CustomNode(root,0));
        TreeMap<Integer,Integer> mp = new TreeMap<>();
        while (!queue.isEmpty()){
            CustomNode customNode = queue.poll();
            Node node = customNode.node;
            int col = customNode.col;
            if(!mp.containsKey(col)){
                mp.put(col,node.data);
            }
            if(node.left!=null){
                queue.offer(new CustomNode(node.left,col-1));
            }
            if(node.right!=null){
                queue.offer(new CustomNode(node.right,col+1));
            }
        }
        res.addAll(mp.values());
        return res;
    }
}

