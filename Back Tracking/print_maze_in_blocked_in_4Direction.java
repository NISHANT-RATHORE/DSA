public class print_maze_in_blocked_in_4Direction {
        static void print(int sr,int sc,int er,int ec,String s,int [][] maze,boolean [][] isVisited){
            if(sr<0 || sc<0) return;
            if(sr>er || sc>ec) return ;
            if(isVisited[sr][sc]==true) return;
            if(sr==er && sc==ec){
                System.out.println(s);
                return;
            }
            if(maze[sr][sc] == 0) return;
            isVisited[sr][sc] = true;
            print(sr, sc+1, er, ec,s+"R",maze,isVisited);
            print(sr+1, sc, er, ec,s+"D",maze,isVisited);
            print(sr, sc-1, er, ec, s+"L",maze, isVisited);
            print(sr-1, sc, er, ec, s+"U",maze, isVisited);
            isVisited[sr][sc] = false;
    
        }
        public static void main(String[] args) {
            int rows = 4;
            int cols = 6;
            int [][] maze = {
                {1,0,1,1,1,1},
                {1,1,1,1,0,1},
                {0,1,1,1,1,1},
                {0,0,1,0,1,1}
            };
            boolean [][] isVisited = new boolean[rows][cols];
            print(0,0,rows-1,cols-1,"",maze,isVisited);
        }
    }

