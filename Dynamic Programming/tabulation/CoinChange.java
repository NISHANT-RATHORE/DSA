package tabulation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CoinChange {
    public static void main(String[] args) {
        List<Integer> al = List.of(1,2,3);
        Set<Integer> st = new HashSet<>();

        int n = al.size();
        int sum = 4;
        //using simple recursion
        System.out.println(coinchange(al,sum,n-1));

        //using memoization
        int [][] dp = new int[n+1][sum+1];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        System.out.println(coinchangeUsingMemoization(al,sum,n-1,dp));

        //using Tabulation
        System.out.println(coinchangeUsingTabulation(al,sum,n-1,dp));

        //using Tabulation with Space Optimisation TC : O(n*sum) SC : (sum)
        System.out.println(coinchangeUsingTabulationSpaceOptimisation(al,sum,n-1));
    }

    private static int coinchangeUsingTabulationSpaceOptimisation(List<Integer> al, int sum, int idx) {
        int [] prev = new int[sum+1];
        int [] curr = new int[sum+1];

        for(int i=0; i<=sum; i++){
            if(i % al.get(0) == 0) prev[i] = 1;
            else prev[i] = 0;
        }

        for(int i=1; i<al.size(); i++){
            for (int s=0; s<=sum; s++){
                int pick = 0;
                if(s >= al.get(i)) pick = curr[s-al.get(i)];
                int notpick = prev[s];
                curr[s] = pick + notpick;
            }
            prev = curr;
        }
        return prev[sum];
    }

    private static int coinchangeUsingTabulation(List<Integer> al, int sum, int idx, int[][] dp) {
    // Initialize the first row of dp table
    for(int i=0; i<=sum; i++){
        if(i % al.get(0) == 0) dp[0][i] = 1; // If the sum can be formed by only using the first coin
        else dp[0][i] = 0;
    }
    // Fill the rest with the dp table
    for(int i=1; i<al.size(); i++){
        for (int s=0; s<=sum; s++){
            int pick = 0;
            if(s >= al.get(i)) pick = dp[i][s-al.get(i)]; // Use the coin, check the remaining sum in the previous row
            int notpick = dp[i-1][s]; // Do not use the coin, take the value from the previous row
            dp[i][s] = pick + notpick;
        }
    }
    return dp[idx][sum]; // Return the result from the last coin and the desired sum
}

    private static int coinchangeUsingMemoization(List<Integer> al, int sum, int idx, int[][] dp) {
        if(dp[idx][sum] != -1) return dp[idx][sum];
        if(idx == 0){
            if(sum % al.get(idx) == 0) return 1;
            else return 0;
        }
        int pick = 0;
        if(sum >= al.get(idx)) pick = coinchangeUsingMemoization(al,sum - al.get(idx),idx,dp);
        int notpick = coinchangeUsingMemoization(al,sum,idx-1,dp);
        return dp[idx][sum] = pick + notpick;
    }

    private static int coinchange(List<Integer> al, int sum,int idx) {
        int pick = 0;
        if(idx == 0){
            if(sum % al.get(idx) == 0 ) return 1;
            else return 0;
        }
        if(sum >= al.get(idx)) pick = coinchange(al,sum - al.get(idx),idx);
        int notpick = coinchange(al,sum,idx-1);
        return pick + notpick;
    }
}
