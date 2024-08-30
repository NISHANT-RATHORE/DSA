package YTProblems;

import TreeTemplate.Node;
import com.sun.source.tree.Tree;

import java.util.*;
//Imp Question
public class VerticalOrderTraversal {
    static TreeMap<Integer, TreeMap<Integer,ArrayList<Integer>>> mp = new TreeMap<>();
    public static void main(String[] args) {
        Integer [] lot = {1,2,3,4,5,6,7};
        Node root = Node.constructTree(lot);
        List<List<Integer>> verticalTraversal = verticalTraversal(root);
        System.out.println(verticalTraversal);
    }
    public static List<List<Integer>> verticalTraversal(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        dfs(root,0,0);
        for(Map.Entry<Integer, TreeMap<Integer,ArrayList<Integer>>> entry : mp.entrySet()){
            TreeMap<Integer,ArrayList<Integer>> levelMap = entry.getValue();
            ArrayList<Integer> list = new ArrayList<>();
            for(Map.Entry<Integer,ArrayList<Integer>> subentry : levelMap.entrySet()){
                ArrayList<Integer> sublist = subentry.getValue();
                Collections.sort(sublist);
                list.addAll(sublist);
            }
            res.add(list);
        }
        return res;
    }
    public static void dfs(Node root,int col,int level){
        if(root == null) return;
        if(!mp.containsKey(col)) mp.put(col,new TreeMap<>()); // add a column
        if(!mp.get(col).containsKey(level)) mp.get(col).put(level,new ArrayList<Integer>()); // add a level
        mp.get(col).get(level).add(root.data);
        dfs(root.left,col-1,level+1);
        dfs(root.right,col+1,level+1);
    }
}
