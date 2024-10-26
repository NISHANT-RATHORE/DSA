package GraphProblems;
import java.util.*;

public class MostStonesRemovedwithSameRoworColumn {
    public static void main(String[] args) {
        int [][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        System.out.println(removeStones(stones));
    }
    public static int removeStones(int[][] stones) {
        int n = stones.length;
        int components = 0;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        boolean [] isVisited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!isVisited[i]){
                dfs(i,adjList,isVisited);
                components++;
            }
        }
        return n - components;
    }
    public static void dfs(int src,List<List<Integer>> adjList,boolean [] isVisited){
        isVisited[src] = true;
        for (int neighbour : adjList.get(src)){
            if(!isVisited[neighbour]){
                dfs(neighbour,adjList,isVisited);
            }
        }
    }
}
