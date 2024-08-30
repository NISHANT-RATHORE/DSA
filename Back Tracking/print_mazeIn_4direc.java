public class print_mazeIn_4direc {
    static void print(int sr,int sc,int er,int ec,String s,boolean [][] isVisited){
        if(sr<0 || sc<0) return;
        if(sr>er || sc>ec) return ;
        if(isVisited[sr][sc]==true) return;
        if(sr==er && sc==ec){
            System.out.println(s);
            return;
        }
        isVisited[sr][sc] = true;
        print(sr, sc+1, er, ec,s+"R",isVisited);
        print(sr+1, sc, er, ec,s+"D",isVisited);
        print(sr, sc-1, er, ec, s+"L", isVisited);
        print(sr-1, sc, er, ec, s+"U", isVisited);
        isVisited[sr][sc] = false;

    }
    public static void main(String[] args) {
        int rows = 3;
        int cols = 3;
        boolean [][] isVisited = new boolean[rows][cols];
        print(0,0,rows-1,cols-1,"",isVisited);
    }
}

//
//class Solution {
//
//    int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
//    String[] dirStr={"U","D","L","R"};
//
//    void findPaths(int[][] mat,int n,int i,int j,StringBuilder str,ArrayList<String> res){
//
//        if(i>=n || j>=n || i<0 || j<0 || mat[i][j]==0)
//            return;
//
//        if((i==n-1) && (j==n-1)){
//            res.add(str.toString());
//            return;
//        }
//
//
//        for(int k=0;k<4;k++){
//            int ii=dir[k][0];
//            int jj=dir[k][1];
//
//            str.append(dirStr[k]);
//            mat[i][j]=0;
//            findPaths(mat,n,i+ii,j+jj,str,res);
//            mat[i][j]=1;
//            str.deleteCharAt(str.length()-1);
//
//        }
//
//    }
//
//    public ArrayList<String> findPath(int[][] mat) {
//        // Your code here
//
//        ArrayList<String> res=new ArrayList<>();
//        StringBuilder str=new StringBuilder();
//
//        findPaths(mat,mat.length,0,0,str,res);
//
//        return res;
//    }
//}
