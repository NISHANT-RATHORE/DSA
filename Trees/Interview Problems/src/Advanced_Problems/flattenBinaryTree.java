package Advanced_Problems;

import TreeTemplate.Node;

import java.util.ArrayList;
import java.util.List;
//revision
public class flattenBinaryTree {
    public static void main(String[] args) {
        Integer [] lot = {1,2,5,3,4,null,6};
        Node root = Node.constructTree(lot);
        flatten(root);
        Node.BFS(root);
    }
    public static void flatten(Node root) {
        Node curr = root;
        while(curr!=null){
            if(curr.left!=null){
                Node pred = curr.left;
                while (pred.right!=null) {
                    pred = pred.right;
                }
                    pred.right = curr.right;
                    curr.right = curr.left;
                    curr.left = null;

            }
            curr = curr.right;
        }
    }
}
