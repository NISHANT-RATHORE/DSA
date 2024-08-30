package tabulation;

import java.util.Arrays;
import java.util.List;

public class FrogJumpProblem {
    public static void main(String[] args) {
        List<Integer> heights = List.of(10,30,40,50,20);
        int n = heights.size();
        //using Recursion
        System.out.println(helper(n-1,heights));

        //using Memoization
        int [] dp = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(helperUsingMemoization(n-1,heights,dp));

        //using Tabulation
        System.out.println(helperUsingTabulation(n-1,heights,dp));

        //using TabulationSpaceOptimisation
//        System.out.println(TabulationSpaceOptimisation(n-1,heights));
    }

    private static int helper(int idx, List<Integer> heights){
        if(idx==0) return 0;
        int jump_1 = Math.abs(heights.get(idx) - heights.get(idx-1)) + helper(idx-1,heights);
        int jump_2 = Integer.MAX_VALUE;
        if(idx>1) jump_2 =  Math.abs(heights.get(idx) - heights.get(idx-2)) + helper(idx-2,heights);
        return Math.min(jump_2,jump_1);
    }

    private static int helperUsingMemoization(int idx, List<Integer> heights,int [] dp){
        if(dp[idx] != -1) return dp[idx];
        if(idx==0) return 0;
        int jump_1 = Math.abs(heights.get(idx) - heights.get(idx-1)) + helperUsingMemoization(idx-1,heights,dp);
        int jump_2 = Integer.MAX_VALUE;
        if(idx>1) jump_2 =  Math.abs(heights.get(idx) - heights.get(idx-2)) + helperUsingMemoization(idx-2,heights,dp);
        return dp[idx] = Math.min(jump_2,jump_1);
    }

    private static int helperUsingTabulation(int idx, List<Integer> heights,int [] dp){
        if(idx==0) dp[idx] = 0;
        int jump_2 = Integer.MAX_VALUE;
        for(int i=heights.size()-1;i>=1;i--){
            int jump_1 = Math.abs(heights.get(i) - heights.get(i - 1)) + dp[i - 1];
            if (i > 1) jump_2 = Math.abs(heights.get(i) - heights.get(i - 2)) + dp[i - 2];
            dp[i] = Math.min(jump_2,jump_1);
        }
        return dp[idx];
    }

//    private static int TabulationSpaceOptimisation(int idx, List<Integer> heights){
//        for(int i=0;i<heights.size();i++) {
//            int jump_1 = Math.abs(heights.get(idx) - heights.get(idx - 1)) + dp[idx - 1];
//            int jump_2 = Integer.MAX_VALUE;
//            if (idx > 1) jump_2 = Math.abs(heights.get(idx) - heights.get(idx - 2)) + dp[idx - 2];
//            dp[idx] = Math.min(jump_2,jump_1);
//        }
//
//    }


}
