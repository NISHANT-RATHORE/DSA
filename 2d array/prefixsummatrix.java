import java.util.Scanner;

public class prefixsummatrix {
    static int bruteforce(int[][] arr, int l1, int l2, int r1, int r2) {
        int sum = 0;
        for (int i = l1; i <= l2; i++) {
            for (int j = r1; j <= r2; j++) {
                sum += arr[i][j];
            }
        }
        return sum;
    }

    static void prefixarr(int[][] arr) {
        int r = arr.length;
        int c = arr[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 1; j < c; j++) {
                arr[i][j] += arr[i][j - 1];
            }
        }
    }

    static int prefixsum(int[][] arr, int l1, int l2, int r1, int r2) {
        int sum = 0;
        prefixarr(arr);
        for (int i = l1; i <= l2; i++) {
            if (r1 > 0) {
                sum += arr[i][r2] - arr[i][r1 - 1];
            } else {
                sum += arr[i][r2];
            }
        }
        return sum;
    }

    static void prefixarralongc(int[][] arr) {
        int r = arr.length;
        int c = arr[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 1; j < c; j++) {
                arr[i][j] += arr[i][j - 1];
            }
        }

        for (int j = 0; j < c; j++) {
            for (int i = 1; i < r; i++) {
                arr[i][j] += arr[i - 1][j];
            }
        }
    }

    static int prefixsumRandC(int[][] arr, int l1, int l2, int r1, int r2) {
        int sum = 0, left = 0, total = 0, up = 0, upleft = 0;
        prefixarralongc(arr);
        total = arr[l2][r2];
        // System.out.println("total is" + " " + total);
        if (l1 >= 1) {
            up = arr[l1 - 1][r2];
            // System.out.println("up is" + " " + up);
        }
        if (r1 >= 1) {
            left = arr[l2][r1 - 1];
            // System.out.println("left is" + " " + left);
        }
        if (l1 >= 1 && r1 >= 1) {
            upleft = arr[l1 - 1][r1 - 1];
            // System.out.println("upleft is" + " " + upleft);
        }
        sum = total - up - left + upleft;
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int l1 = sc.nextInt();
        int l2 = sc.nextInt();
        int r1 = sc.nextInt();
        int r2 = sc.nextInt();
        int[][] arr = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println("sum of given range is" + " " + bruteforce(arr, l1, l2, r1, r2));
        // System.out.println("sum of given range is" + " " + prefixsum(arr, l1, l2, r1, r2));
        System.out.println("sum of given range is" + " " + prefixsumRandC(arr, l1, l2, r1, r2));

    }
}
