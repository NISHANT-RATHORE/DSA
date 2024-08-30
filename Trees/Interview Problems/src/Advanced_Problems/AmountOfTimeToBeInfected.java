package Advanced_Problems;
import java.util.*;
import TreeTemplate.Node;

public class AmountOfTimeToBeInfected {
    public static void main(String[] args) {
        Integer [] lot = {1,5,3,null,4,10,6,9,2};
        int start = 3;
        Node root = Node.constructTree(lot);
        int time = amountOfTime(root,start);
        System.out.println(time);
    }
    public static int amountOfTime(Node root, int start) {
        Node target = getNode(root,start);
        Map<Node,Node> parent = new HashMap<>();
        preorder(root,parent);
        Queue<Node> q = new LinkedList<>();
        q.offer(target);
        Map<Node,Integer> v = new HashMap<>();
        v.put(target,0);
        while (!q.isEmpty()){
            Node tmp = q.peek();
            int level = v.get(tmp);
            if(tmp.left!=null && !v.containsKey(tmp.left)){
                q.offer(tmp.left);
                v.put(tmp.left,level+1);
            }
            if(tmp.right!=null && !v.containsKey(tmp.right)){
                q.offer(tmp.right);
                v.put(tmp.right,level+1);
            }
            if(parent.containsKey(tmp) && !v.containsKey(parent.get(tmp))){
                q.offer(parent.get(tmp));
                v.put(parent.get(tmp),level+1);
            }
            q.remove();
        }
        int mx = -1;
        for(int level : v.values()){
            mx = Math.max(mx,level);
        }
        return mx;
    }

    private static void preorder(Node root,Map<Node,Node> parent){
        if(root==null) return;
        if(root.left!=null) parent.put(root.left,root);
        if(root.right!=null) parent.put(root.right,root);
        preorder(root.left,parent);
        preorder(root.right,parent);
    }
    private static Node getNode(Node root, int start) {
        if(root==null) return null;
        if(root.data == start) return root;
        Node left = getNode(root.left,start);
        Node right = getNode(root.right,start);
        if(right==null) return left;
        else return right;
    }
}
