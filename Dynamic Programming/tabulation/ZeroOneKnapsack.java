package tabulation;

import java.util.Arrays;
import java.util.List;

public class ZeroOneKnapsack {
    public static void main(String[] args) {
        List<Integer> profit = List.of(1,2,3);
        List<Integer> weights = List.of(4,5,2);
        int n = profit.size();
        int W = 7;
        //naive approach
        System.out.println(helper(n-1,W,profit,weights));

        //using memoization
        int [][] dp = new int[n+1][W+1];
        for(int [] arr : dp) Arrays.fill(arr,-1);
        System.out.println(helperUsingMemoization(n-1,W,profit,weights,dp));

        //using Tabulation
        System.out.println(helperUsingTabulation(n-1,W,profit,weights,dp));

        //UsingTabulationSpaceOptimisation
        System.out.println(UsingTabulationSpaceOptimisation(n-1,W,profit,weights));

    }

    private static int UsingTabulationSpaceOptimisation(int idx, int w, List<Integer> profit, List<Integer> weights) {
        int [] prev = new int[w+1];
        int [] curr = new int[w+1];

        for (int i = 0; i <= w; i++) {
            if (i >= weights.get(0)) prev[i] = profit.get(0);
            else prev[i] = 0;
        }
        // Fill the dp table
        for (int i = 1; i < profit.size(); i++) {
//            curr = new int[w+1]; // Reinitialize curr for each item
            for (int j = 0; j <= w; j++) {
                int pick = 0;
                if (j >= weights.get(i)) pick = profit.get(i) + prev[j - weights.get(i)];
                int notpick = prev[j];
                curr[j] = Math.max(pick, notpick);
            }
            prev = curr.clone();
}
        return prev[w];

    }

    private static int helperUsingTabulation(int idx, int w, List<Integer> profit, List<Integer> weights, int[][] dp) {
    // Initialize dp[0][..] based on the first item
    for (int i = 0; i <= w; i++) {
        if (i >= weights.get(0)) dp[0][i] = profit.get(0);
        else dp[0][i] = 0;
    }
    // Fill the dp table
    for (int i = 1; i < profit.size(); i++) {
        for (int j = 0; j <= w; j++) {
            int pick = 0;
            if (j >= weights.get(i)) pick = profit.get(i) + dp[i - 1][j - weights.get(i)];
            int notpick = dp[i - 1][j];
            dp[i][j] = Math.max(pick, notpick);
        }
    }
    return dp[profit.size() - 1][w];
}

    private static int helperUsingMemoization(int i, int w, List<Integer> profit, List<Integer> weights, int[][] dp) {
        if(dp[i][w] != -1) return dp[i][w];
        if(i==0){
            if(w>=weights.get(0)) return profit.get(0);
            else return 0;
        }
        int pick = 0;
        if(w>=weights.get(i)) pick = profit.get(i) + helperUsingMemoization(i-1,w-weights.get(i),profit,weights,dp);
        int notpick = helperUsingMemoization(i-1,w,profit,weights,dp);
        return dp[i][w] = Math.max(pick,notpick);
    }

    private static int helper(int i, int W, List<Integer> profit, List<Integer> weights) {
        if(i==0){
            if(W>=weights.get(0)) return profit.get(0);
            else return 0;
        }
        int pick = 0;
        if(W>=weights.get(i)) pick = profit.get(i) + helper(i-1,W-weights.get(i),profit,weights);
        int notpick = helper(i-1,W,profit,weights);
        return Math.max(pick,notpick);
    }


}
