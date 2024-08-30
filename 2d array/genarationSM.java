import java.util.Scanner;

public class genarationSM {
    static void print2darr(int [][] arr,int r,int c){
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    static void genaration(int n){
        int tr = 0,br = n-1,lc = 0,rc = n-1;
        int [][] ans = new int[n][n];
        int curr = 1;
        while(curr <= n*n){
            for(int j=lc;j<=rc && curr <= n*n;j++){
                ans[tr][j] = curr;
                curr++;
            }
            tr++;

            for(int i=tr;i<=br && curr <= n*n;i++){
                ans[i][rc] = curr;
                curr++;
            }
            rc--;

            for(int j=rc;j>=lc && curr <= n*n;j--){
                ans[br][j] = curr;
                curr++;
            }
            br--;

            for(int i=br;i>=tr && curr <= n*n;i--){
                ans[i][lc] = curr;
                curr++;
            }
            lc++;
        }
        print2darr(ans, n, n);

    }
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      genaration(n);  
    }
}
