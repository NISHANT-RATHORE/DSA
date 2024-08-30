package tabulation;

public class fibonacci {
    static int CallUsingMemoization = 0;
    static int CallUsingTabulation = 0;
    public static void main(String[] args) {
        int n = 5;
        int [] dp = new int[n+1];
        for(int i=0;i<dp.length;i++){
            dp[i] = -1;
        }
        System.out.println(fibboUsingMemoization(n,dp));
        System.out.println(fibboUsingTabulation(n,dp));
        System.out.println("CallUsingTabulation "+CallUsingTabulation);
        System.out.println("CallUsingMemoization "+CallUsingMemoization);
        System.out.println(fibboUsingTabulationWithSpaceOptimisation(n));
    }

    private static int fibboUsingTabulationWithSpaceOptimisation(int n) { // TC : O(n) , SC : O(1)
        int p1 =1;
        int p2 = 1;
        int curr = 0;
        for(int i=3;i<=n;i++){
            curr = p1+p2;
            p1 = p2;
            p2 = curr;
        }
        return curr;
    }

    private static int fibboUsingTabulation(int n, int[] dp) { // TC : O(n) , SC : O(n) -> reduce stack space from recursion
        CallUsingTabulation++;
        dp[1] = 1;
        dp[2] = 1;
        for(int i=3;i<n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    private static int fibboUsingMemoization(int n,int [] dp) { //TC : O(n) , SC : O(n)
        CallUsingMemoization++;
        if(n==1 || n==2) return 1;
        if(dp[n]!=-1) return dp[n];
        return dp[n] = fibboUsingMemoization(n-1,dp) + fibboUsingMemoization(n-2,dp);
    }
}
