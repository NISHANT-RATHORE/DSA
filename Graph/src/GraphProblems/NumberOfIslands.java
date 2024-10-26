package GraphProblems;

import java.util.*;

public class NumberOfIslands {
    public static void main(String[] args) {
        char [][] grid = {{'1','1','1','1','0'},
                          {'1','1','0','1','0'},
                          {'1','1','0','0','0'},
                          {'0','0','0','0','0'}};
        System.out.println(numIslands(grid));
    }
    static int rows;
    static int cols;

    public static int numIslands(char[][] grid) {
        int res = 0;
        rows = grid.length;
        cols = grid[0].length;
        boolean[][] isVisited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !isVisited[i][j]) {
                    bfs(grid, i, j, isVisited);
                    res++;
                }
            }
        }
        return res;
    }

    public static void bfs(char[][] grid, int sr, int sc, boolean[][] isVisited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        isVisited[sr][sc] = true;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int row = node[0];
            int col = node[1];
            int[][] adjList = {{row + 1, col}, {row - 1, col}, {row, col + 1}, {row, col - 1}};
            for (int[] neighbour : adjList) {
                int r = neighbour[0];
                int c = neighbour[1];
                if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] != '1' || isVisited[r][c]) {
                    continue;
                }
                queue.offer(new int[]{r, c});
                isVisited[r][c] = true;
            }
        }
    }

//    public static int numIslands(char[][] grid) {
//        int res = 0;
//        rows = grid.length;
//        cols = grid[0].length;
//        boolean[][] isVisited = new boolean[rows][cols];
//        for(int i=0;i<rows;i++){
//            for(int j=0;j<cols;j++){
//                if(grid[i][j] == '1' && !isVisited[i][j]){
//                    dfs(i,j,grid,isVisited);
//                    res++;
//                }
//            }
//        }
//        return res;
//    }
//    public static void dfs(int row,int col,char [][] grid,boolean [][] isVisited){
//        if(row<0 || row>=rows || col<0 || col>=cols || grid[row][col]!='1' || isVisited[row][col]){
//            return;
//        }
//        isVisited[row][col] = true;
//        int[][] adjList = {{row + 1, col}, {row - 1, col}, {row, col + 1}, {row, col - 1}};
//        for(int [] neighbour : adjList){
//            dfs(neighbour[0],neighbour[1],grid,isVisited);
//        }
//
//    }
}
