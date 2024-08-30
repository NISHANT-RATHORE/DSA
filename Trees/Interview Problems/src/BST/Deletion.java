package BST;

import TreeTemplate.Node;
// time complexity : O(H) Space Complexity : O(H)
public class Deletion {
    public static void main(String[] args) {
        Integer [] lot = {5,3,6,2,4,null,7};
        Node root = Node.constructTree(lot);
        Node deletion = deleteNode(root,2);
        Node.BFS(root);
    }
    public static Node deleteNode(Node root, int key) {
        if(root==null) return null;
        if(root.data > key){
            root.left = deleteNode(root.left,key);
        } else if(root.data < key){
            root.right = deleteNode(root.right,key);
        }
        else{
            //root child
            if(root.left == null && root.right==null) {
                return null;
            }
            // single child
            if(root.left == null){
                return root.right;
            } else if(root.right == null){
                return root.left;
            }
            // two child
            else{
                Node node = findSuccessor(root.right);
                root.data = node.data;
                root.right = deleteNode(root.right,node.data);
            }

//            else{
//                Node node = findPredessor(root.left);
//                root.data = node.data;
//                root.left = deleteNode(root.left,node.data);
//            }
        }
        return root;
    }
    public static Node findSuccessor(Node node){
        while(node.left!=null){
            node = node.left;
        }
        return node;
    }

//    public static Node findPredessor(Node node){
//        while(node.right!=null){
//            node = node.right;
//        }
//        return node;
//    }
}
