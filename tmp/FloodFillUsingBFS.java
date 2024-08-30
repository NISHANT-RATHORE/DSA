import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFillUsingBFS {
    static int rows;
    static int cols;
    public static void main(String[] args) {
        int [][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1, sc = 1, color = 2;
        int [][] res = floodFill(image,sr,sc,color);
        for(int [] arr : res){
            Arrays.stream(arr).forEach(x-> System.out.print(x+" "));
            System.out.println();
        }
    }
    private static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rows = image.length;
        cols = image[0].length;
        int currColor = image[sr][sc];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr,sc});
        image[sr][sc] = color;
        while (!queue.isEmpty()){
            int node[] = queue.poll();
            int row = node[0];
            int col = node[1];
            int [][] adjMatrix = {{row-1,col},{row,col+1},{row+1,col},{row,col-1}};
            for(int [] neighbour : adjMatrix){
                int r = neighbour[0];
                int c = neighbour[1];
                if(r<0 || r >= rows || c<0 || c >=cols || image[r][c]!=currColor){
                    continue;
                }
                queue.offer(new int[]{r,c});
                image[r][c] = color;
            }
        }
        return image;
    }
}
