import java.util.Scanner;

public class pascaltriangle {
    static void print2darr(int [][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    static void pascaltriangle(int n){
        int [][] ans = new int [n][];
        for(int i=0;i<n;i++){
            ans[i] = new int [i+1];
            ans[i][0] = ans[i][i] = 1;
            for(int j=1;j<i;j++){
                ans[i][j] = ans[i-1][j] + ans[i-1][j-1];
            }    
        }
        print2darr(ans);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        pascaltriangle(n);
    }
    
}
