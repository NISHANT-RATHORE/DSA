package GraphProblems;

import java.util.*;

public class UndirectedGraphCycle {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        Collections.addAll(adjList,
                    new ArrayList<>(List.of(1)),
                    new ArrayList<>(List.of(0,2,4)),
                    new ArrayList<>(List.of(1,3)),
                    new ArrayList<>(List.of(2,4)),
                    new ArrayList<>(List.of(1,3))
                );
        System.out.println(isCycle(adjList));
    }
    public static boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int V = adj.size();
        boolean [] isVisited = new boolean[V];
        for (int i=0;i<V;i++){
            if(!isVisited[i] && bfs(i,adj,isVisited)){
                return true;
            }
        }
        return false;
    }

    private static boolean bfs(int src, ArrayList<ArrayList<Integer>> adj, boolean[] isVisited) {
        Queue<int []> queue = new LinkedList<>();
        isVisited[src] = true;
        queue.offer(new int[]{src,-1});
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int [] node = queue.poll();
                int val = node[0];
                int parent = node[1];
                for (int neighbour : adj.get(src)){
                    if (neighbour == parent) continue;
                    if (isVisited[neighbour]) return true;
                    else {
                        isVisited[neighbour] = true;
                        queue.offer(new int[]{neighbour,val});
                    }
                }
            }
        }
        return false;
    }
}
