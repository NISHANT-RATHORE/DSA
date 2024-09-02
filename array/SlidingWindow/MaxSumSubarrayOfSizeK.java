import java.util.*;
public class MaxSumSubarrayOfSizeK {
    public static void main(String[] args) {
        int N = 4, K = 2;
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(100, 200, 300, 400));
        System.out.println(maximumSumSubarray(K,  arr,N));
    }
    static long maximumSumSubarray(int K, ArrayList<Integer> arr,int N){
        // code here
        long sum= 0;
        long maxSum = 0;
        int idx = 0;
        while (idx < N && idx < K) {
            sum += arr.get(idx++);
        }
        maxSum  = sum;
        for (int i=1;i<N-K+1;i++){
            sum = sum - arr.get(i-1) + arr.get(i+K-1);
            maxSum = Math.max(maxSum,sum);
        }
        return maxSum;
    }
}
