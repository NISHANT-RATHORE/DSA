package GraphTraversals;

import GraphTemplate.GraphUsingAdjList;
import GraphTemplate.GraphUsingAdjMatrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        int [][] edges = {{0,1},{0,2},{0,3},{2,4}};
        int nodes = 5;
        GraphUsingAdjList graph = new GraphUsingAdjList(5);
        graph.addEdgesInList(edges,false);
        List<Integer> defal = bfsOfGraph(nodes,graph.adjList);
        for (int val : defal) System.out.print(val+ " ");
    }

    private static List<Integer> bfsOfGraph(int nodes, List<List<Integer>> adjList) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        boolean [] isVisited = new boolean[nodes];
        Queue<Integer> queue = new LinkedList<>();
        isVisited[0]=true;
        queue.offer(0);
        while(queue.size()>0){
            int node = queue.poll();
            res.add(node);
            for(int neighbour : adjList.get(node)){
                if(!isVisited[neighbour]){
                    isVisited[neighbour]=true;
                    queue.offer(neighbour);
                }
            }
        }
        return res;
    }
}
