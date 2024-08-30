package InterviewProblems2;

import java.util.Arrays;
import java.util.List;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        List<Integer> dimensions = List.of(40,20,30,10,30);
        int n = dimensions.size();
        System.out.println(rec(1,n-1,dimensions));

        int [][] dp = new int[n][n];
        for(int [] arr : dp) Arrays.fill(arr,-1);
        System.out.println(recUsingMemoization(1,n-1,dimensions,dp));

        System.out.println(recUsingTabulation(dimensions));
    }

    private static int recUsingTabulation(List<Integer> dimensions) {
        int n = dimensions.size();
        int[][] dp = new int[n][n];

        // Base case is implicitly handled by initializing dp array with 0s

        // l is the chain length
        for (int l = 2; l < n; l++) {
            for (int i = 1; i < n - l + 1; i++) {
                int j = i + l - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    // cost/scalar multiplications
                    int cost = dp[i][k] + dp[k + 1][j] + dimensions.get(i - 1) * dimensions.get(k) * dimensions.get(j);
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                    }
                }
            }
        }
        return dp[1][n - 1];
}

    private static int recUsingMemoization(int i, int j, List<Integer> dimensions, int[][] dp) {
        if(dp[i][j] != -1) return dp[i][j];
        if(i==j) return 0;
        int min = Integer.MAX_VALUE;
        for(int k = i ; k < j ; k++){
            int cost = recUsingMemoization(i,k,dimensions,dp) + recUsingMemoization(k+1,j,dimensions,dp) + ( dimensions.get(i - 1) * dimensions.get(k) * dimensions.get(j));
            if(cost<min){
                min = cost;
            }
        }
        return dp[i][j] =  min;
    }

    private static int rec(int i,int j,List<Integer> dimensions){
        if(i==j) return 0;
        int min = Integer.MAX_VALUE;
        for(int k = i ; k < j ; k++){
            int cost = rec(i,k,dimensions) + rec(k+1,j,dimensions) + ( dimensions.get(i - 1) * dimensions.get(k) * dimensions.get(j));
            if(cost<min){
                min = cost;
            }
        }
        return min;
    }
}
