package GraphTraversals;

import GraphTemplate.GraphUsingAdjList;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    public static void main(String[] args) {
        int [][] edges = {{0,1},{0,2},{0,3},{2,4}};
        int nodes = 5;
        GraphUsingAdjList graph = new GraphUsingAdjList(5);
        graph.addEdgesInList(edges,false);
        List<Integer> defal = dfsOfGraph(nodes,graph.adjList);
        for (int val : defal) System.out.print(val+ " ");
    }

    private static List<Integer> dfsOfGraph(int nodes, List<List<Integer>> adjList) {
        List<Integer> res = new ArrayList<>();
        boolean [] isVisited = new boolean[nodes];
        for(int i=0;i<nodes;i++){
            if(!isVisited[i]){
                dfs(i,isVisited,adjList,res);
            }
        }
        return res;
    }

    private static void dfs(int node, boolean[] isVisited, List<List<Integer>> adjList, List<Integer> res) {
        isVisited[node] = true;
        res.add(node);
        for(int neighbour : adjList.get(node)){
            if(!isVisited[neighbour]){
                dfs(neighbour,isVisited,adjList,res);
            }
        }
    }
}
