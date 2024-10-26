package GraphProblems;

import java.util.*;


public class FloodFill {
    public static void main(String[] args) {
        int [][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1, sc = 1, color = 2;
        int [][] res = floodFill(image,1,1,2);
        for(int [] arr : res){
            Arrays.stream(arr).forEach(x-> System.out.print(x+" "));
            System.out.println();
        }
    }
    static int rows;
    static int cols;

    //BFS Approach
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rows = image.length;
        cols = image[0].length;
        int currColor = image[sr][sc];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr,sc});
        image[sr][sc] = color;
        while (!queue.isEmpty()){
            int [] node = queue.poll();
            int row = node[0];
            int col = node[1];
            int[][] adjList = {{row + 1, col}, {row - 1, col}, {row, col + 1}, {row, col - 1}};
            for(int [] neighbour : adjList){
                int r = neighbour[0];
                int c = neighbour[1];
                if(r<0 || r>=rows || c<0 || c>=cols || image[r][c]!=currColor || image[r][c] == color){
                    continue;
                }
                queue.offer(new int[]{r,c});
                image[r][c] = color;
            }
        }
        return image;
    }

    //DFS Approach
//    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
//        rows = image.length;
//        cols = image[0].length;
//        dfs(image,sr,sc,image[sr][sc],color);
//        return image;
//    }
//    public static void dfs(int[][] image, int sr, int sc, int currColor,int newColor){
//        if(sr<0 || sr>=rows || sc<0 || sc>=cols || image[sr][sc]!=currColor || image[sr][sc] == newColor){
//            return;
//        }
//        image[sr][sc] = newColor;
//        int[][] adjList = {{sr + 1, sc}, {sr - 1, sc}, {sr, sc + 1}, {sr, sc - 1}};
//        for(int [] neighbour : adjList){
//            dfs(image,neighbour[0],neighbour[1],currColor,newColor);
//        }
//    }

}
