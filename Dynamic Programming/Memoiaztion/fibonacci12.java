package Memoiaztion;

public class fibonacci12 {
    static int calls = 0; // Move the calls variable inside the fib method
    public static int fib(int n, int[] dp) {
        calls++;
        if (n == 0 || n == 1) {
            return n;
        }
        if (dp[n] != -1) {
            return dp[n];
        }

        return dp[n] = fib(n - 1, dp) + fib(n - 2, dp);
    }

    public static void main(String[] args) {
        int n = 10;
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        System.out.println(fib(n, dp));
        System.out.println("calls: " + calls ); // Print the value of calls
    }
}