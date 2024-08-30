import java.util.LinkedList;
import java.util.Queue;

public class NoOfIslands {
    static int rows;
    static int cols;
    public static void main(String[] args) {
        char [][] land = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(numIslands(land));

        System.out.println(numIslandsBFS(land));
    }

    private static int numIslandsBFS(char[][] grid) {
    if (grid == null || grid.length == 0) {
        return 0;
    }
    rows = grid.length;
    cols = grid[0].length;
    boolean[][] isVisited = new boolean[rows][cols];
    int count = 0;
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (grid[i][j] == '1' && !isVisited[i][j]) {
                bfs(grid, i, j, isVisited);
                count++;
            }
        }
    }
    return count;
    }
    private static void bfs(char[][] grid, int sr, int sc, boolean[][] isVisited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        isVisited[sr][sc] = true;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int row = node[0];
            int col = node[1];
            int [][] adjMatrix = {{row-1,col},{row,col+1},{row+1,col},{row,col-1}};
            for (int[] neighbour : adjMatrix) {
                int r = neighbour[0];
                int c = neighbour[1];

                if (r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c] == '1' && !isVisited[r][c]) {
                    queue.offer(new int[]{r, c});
                    isVisited[r][c] = true;
                }
            }
        }
    }

    private static int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int island=0;
        boolean [][] isvisited = new boolean[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]=='1' && !isvisited[i][j]){
                    dfs(i,j,isvisited,grid);
                    island++;
                }
            }
        }
        return island;
    }
    private static void dfs(int row,int col,boolean [][] isVisited,char [][] grid){
        if(row<0 || row>=rows || col<0 || col>=cols || grid[row][col]=='0' || isVisited[row][col]){
            return;
        }
        isVisited[row][col] = true;
        int [][] adjMatrix = {{row-1,col},{row,col+1},{row+1,col},{row,col-1}};
        for(int [] neighbour : adjMatrix){
            dfs(neighbour[0],neighbour[1],isVisited,grid);
        }
    }
}
