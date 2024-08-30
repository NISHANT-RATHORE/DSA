package Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SDEcoinChannge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> coins = List.of(1, 2, 5, 10, 20, 50, 100, 200, 500, 2000);
        List<Integer> ans = minPartition2(n, coins);
        ans.forEach(x -> System.out.print(x + " "));
    }

    private static List<Integer> minPartition2(int n, List<Integer> coins) {
        int[] dp = new int[n + 1];
        int[] coinUsed = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] + 1 < dp[i]) {
                    dp[i] = dp[i - coin] + 1;
                    coinUsed[i] = coin;
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = n; i > 0; i -= coinUsed[i]) {
            ans.add(coinUsed[i]);
        }
        return ans;
    }
}