package tabulation;

import java.util.Arrays;
import java.util.List;

public class FrogJumpProblem2 {
    public static void main(String[] args) {
        List<Integer> heights = List.of(10,30,40,50,20);
        int n = heights.size();
        //using Recursion
        System.out.println(helper(n-1,heights,3));

        //using Memoization
        int [] dp = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(helperUsingMemoization(n-1,heights,3,dp));

        //Using Tabulation
        System.out.println(helperUsingTabulation( heights,3 ));
    }

    private static int helper(int idx,List<Integer> heights,int k){
        if(idx==0) return 0;
        int minCost = Integer.MAX_VALUE;
        for(int i=1;i<=k;i++){
            if(idx-i>=0) {
                int jump = Math.abs(heights.get(idx) - heights.get(idx - i)) + helper(idx - i, heights, k);
                minCost = Math.min(minCost, jump);
            }
        }
        return minCost;
    }

    private static int helperUsingMemoization(int idx,List<Integer> heights,int k,int [] dp){
        if(dp[idx]!=-1) return dp[idx];
        if(idx==0) return 0;
        int minCost = Integer.MAX_VALUE;
        for(int i=1;i<=k;i++){
            if(idx-i>=0) {
                int jump = Math.abs(heights.get(idx) - heights.get(idx - i)) + helperUsingMemoization(idx - i, heights, k,dp);
                minCost = Math.min(minCost, jump);
            }
        }
        return dp[idx]=minCost;
    }

//    private static int helperUsingTabulation(int idx,List<Integer> heights,int k,int [] dp){
//        int n = heights.size();
//        dp[0] = 0;
//        for(int j=1;j<n;j++){
//            int minCost = Integer.MAX_VALUE;
//            for(int i=1;i<=k;i++){
//                if(idx-i>=0) {
//                    int jump = Math.abs(heights.get(idx) - heights.get(idx - i)) + helperUsingTabulation(idx - i, heights, k,dp);
//                    minCost = Math.min(minCost, jump);
//                }
//            }
//            dp[j]=minCost;
//        }
//        return dp[idx];
//    }  // wrong code

    private static int helperUsingTabulation(List<Integer> heights, int k) {
        int n = heights.size();
        int[] dp = new int[n+1];
        dp[0] = 0; // Base case: cost of the first step is 0

        for (int j = 1; j < n; j++) {
            int minCost = Integer.MAX_VALUE;
            for (int i = 1; i <= k && j - i >= 0; i++) {
                int jumpCost = Math.abs(heights.get(j) - heights.get(j - i)) + dp[j - i];
                minCost = Math.min(minCost, jumpCost);
            }
            dp[j] = minCost;
        }

        return dp[n - 1]; // Return the minimum cost to reach the last stone
   }
}
