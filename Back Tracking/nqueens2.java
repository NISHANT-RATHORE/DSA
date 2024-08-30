
public class nqueens2 {
    static int nqueen(char [][] board,int row){
        int n = board.length,count = 0;
        if(row==n){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
            count++;
            System.out.println();
            return count;
        }
        for(int j=0;j<n;j++){
            if(isSafe(board,row,j)){
                board[row][j] = 'Q';
                nqueen(board, row+1);
                board[row][j] = '.';
            }
        }
        return -1;
    }
    static boolean isSafe(char [][] board,int rows,int cols){
        int n = board.length;
        for(int j=0;j<n;j++){
            if(board[rows][j]=='Q') return false;
        }
        for(int i=0;i<n;i++){
            if(board[i][cols]=='Q') return false;
        }
        int i = rows;
        int j = cols;
        while(i>=0 && j<n){
            if(board[i][j]=='Q') return false;
            i--;
            j++;
        }
        i = rows;
        j = cols;
        while(i<n && j>=0){
            if(board[i][j]=='Q') return false;
            i++;
            j--;
        }

        i = rows;
        j = cols;
        while(i>=0 && j>=0){
            if(board[i][j]=='Q') return false;
            i--;
            j--;
        }

        i = rows;
        j = cols;
        while(i<n && j<n){
            if(board[i][j]=='Q') return false;
            i++;
            j++;
        }
        return true;
    }
    public static void main(String[] args) {
        int n = 4;
        char [][] board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        int ans = nqueen(board,0);
        System.out.println(ans);
    }
}