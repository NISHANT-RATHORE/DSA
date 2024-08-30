import java.util.ArrayList;
import java.util.List;

public class DFS {
    List<List<Integer>> adjList;
    DFS(int nodes) {
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
        List<Integer> defal = dfsOfGraph(nodes,graph.adjList);
        for (int val : defal) System.out.print(val+ " ");
    }
    public static List<Integer> dfsOfGraph(int V, List<List<Integer>> adjList){
        List<Integer> res = new ArrayList<>();
        boolean [] isVisited = new boolean[V];
        for(int i=0;i<V;i++){
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
