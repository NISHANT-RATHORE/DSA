package InterviewProblems;

import java.util.Arrays;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String s1 = "CDEECDCBAEDAB";
        String s2 = "EABCEAECBAAB";
        int m = s1.length();
        int n = s2.length();
        //Using Recursion
        System.out.println(helper(s1, s2, m - 1, n - 1));  // Output should be 3

        //Using Memoization
        int [][] dp = new int[m+1][n+1];
        for (int [] arr : dp) Arrays.fill(arr,-1);
        System.out.println(helperUsingMemoization(s1,s2,m,n,dp));

        //Using Tabulation
        System.out.println(helperUsingTabulation(s1,s2,m,n));

        //Using TabulationSpaceOptimisation
        System.out.println(TabulationSpaceOptimisation(s1,s2,m,n));
    }

    private static int helper(String s1, String s2, int i, int j) {
        if (i < 0 || j < 0) return 0;
        if (s1.charAt(i) == s2.charAt(j)) return 1 + helper(s1, s2, i - 1, j - 1);
        return Math.max(helper(s1, s2, i - 1, j), helper(s1, s2, i, j - 1));
    }

    private static int helperUsingMemoization(String s1, String s2, int i, int j, int[][] dp) {
        if (i == 0 || j == 0) {
            return 0;
        }
        if (dp[i][j] != -1) { // Directly return the memoized result if already computed
            return dp[i][j];
        }
        if (s1.charAt(i-1) == s2.charAt(j-1)) {
            dp[i][j] = 1 + helperUsingMemoization(s1, s2, i - 1, j - 1, dp);
        } else {
            dp[i][j] = Math.max(helperUsingMemoization(s1, s2, i - 1, j, dp), helperUsingMemoization(s1, s2, i, j - 1, dp));
        }
        return dp[i][j];
}

    private static int helperUsingTabulation(String s1, String s2, int m, int n){
        int [][] dp = new int[m+1][n+1];
        for(int j=0;j<=n;j++){
            dp[0][j] = 0;
        }

        for (int i=0;i<=m;i++){
            dp[i][0] = 0;
        }

        for(int i = 1;i <= m ; i++){
            for (int j = 1;j <= n;j++){
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    static int TabulationSpaceOptimisation(String s1, String s2, int m, int n){
        int max = Math.max(m,n);
        int[] prev = new int[max+1];
        int[] curr = new int[max+1];

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    curr[j] = 1 + prev[j-1];
                } else {
                    curr[j] = Math.max(prev[j], curr[j-1]);
                }
            }
            System.arraycopy(curr, 0, prev, 0, n+1); // Correct way to copy curr to prev
        }
        return prev[n];
}
}

