import java.util.*;
public class UniqueMaxSumOfSubarrayOfSizeK {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 7, 8, 9};
        int k = 3;
        System.out.println(maximumSubarraySum(nums, k));
    }

    public static long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> st = new HashSet<>();
        long sum = 0, maxSum = 0;
        int n = nums.length, idx = 0;
        while (idx < n && idx < k) {
            if (st.contains(nums[idx])) {
                continue;
            }
            sum += nums[idx];
            st.add(nums[idx]);
            idx++;
        }
        maxSum = sum;
        for (int i = 1; i < n - k + 1; i++) {
            st.remove(nums[i - 1]);
            for (int j = i; j < i + k; j++) {
                st.add(nums[j]);
            }
            if(st.size()<k) {

                st.clear();
                continue;
            }
            sum = sum - nums[i - 1] + nums[i + k - 1];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}