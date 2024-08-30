import java.util.*;

public class BFS {
    List<List<Integer>> adjList;
    BFS(int nodes) {
        adjList = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList<>()); // Initialize adjacency list for each node
        }
    }
    public void addEdgeToList(int [][] edges){
        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
    }

    public static void main(String[] args) {
        int [][] edges = {{0,1},{0,2},{0,3},{2,4}};
        int nodes = 5;
        DFS graph = new DFS(5);
        graph.addEdgeToList(edges);
        List<Integer> defal = bfsOfGraph(nodes,graph.adjList);
        for (int val : defal) System.out.print(val+ " ");
    }
    public static ArrayList<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {
        // Code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        boolean [] isVisited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        isVisited[0]=true;
        queue.offer(0);
        while(queue.size()>0){
            int node = queue.poll();
            res.add(node);
            for(int neighbour : adj.get(node)){
                if(!isVisited[neighbour]){
                    isVisited[neighbour]=true;
                    queue.offer(neighbour);
                }
            }
        }
        return res;
    }
}
