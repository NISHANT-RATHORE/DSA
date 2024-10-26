package GraphProblems;

import java.util.*;

public class MinimumTimetoCollectAllApplesinaTree {
    public static void main(String[] args) {
        int n = 7;
        int [][] edges = {{0,2},{0,3},{1,2}};
        List<Boolean> hasApple = List.of(false,true,false,false);
        System.out.println(minTime(n,edges,hasApple));
    }
    public static int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int [] edge : edges){
            int from = edge[0];
            int to = edge[1];
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }

        return dfs(0,-1,adjList,hasApple);
    }
    public static int dfs(int src,int parent,List<List<Integer>> adjList,List<Boolean> hasApple){
        int totalTime = 0;
        for(int neighbour : adjList.get(src)){
            if (neighbour == parent) continue;
            int timeTaken = dfs(neighbour,src,adjList,hasApple);
            if (timeTaken > 0 || hasApple.get(neighbour)){
                totalTime += timeTaken + 2;
            }
        }
        return totalTime;
    }
}
