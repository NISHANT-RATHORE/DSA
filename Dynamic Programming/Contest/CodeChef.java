package Contest;

import java.util.Scanner;

public class CodeChef {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int x = sc.nextInt();
            int maxCoins = helper(n,x);
            System.out.println(maxCoins);
        }
    }
    private static int helper(int n,int x){
        int total = sum(2,n);
        int lose = n-x;
        int loseSum = sum(2,lose);
        int winSum = total - loseSum;
        return winSum - loseSum;
    }
    private static int sum(int a,int n){
        return 2 * ((int)Math.pow(2,n) - 1);
    }
}
