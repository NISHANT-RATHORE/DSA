package GraphProblems;

import java.util.*;

public class RottingOranges {
    public static void main(String[] args) {
        int [][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));
    }
    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int []> queue = new LinkedList<>();
        int freshCount = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1) freshCount++;
                if (grid[i][j] == 2) queue.offer(new int[]{i,j});
            }
        }
        if (freshCount == 0) return 0;
        int time = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i=0 ; i<size ; i++){
                int [] rotLoc = queue.poll();
                int r = rotLoc[0];
                int c = rotLoc[1];
                int[][] adjList = {{r + 1, c}, {r - 1, c}, {r, c + 1}, {r, c - 1}};
                for (int [] neighbour : adjList){
                    int row = neighbour[0];
                    int col = neighbour[1];
                    if(row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 2 || grid[row][col] == 0) continue;
                    grid[row][col] = 2;
                    queue.offer(new int[]{row,col});
                    freshCount--;
                    if (freshCount == 0){
                        return time + 1;
                    }
                }
            }
            time++;
        }
        return -1;
    }
}
