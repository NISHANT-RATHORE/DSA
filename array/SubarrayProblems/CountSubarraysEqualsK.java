import java.util.HashMap;
import java.util.Map;

public class CountSubarraysEqualsK {
    public static void main(String[] args) {
        int [] nums = {-1,1,0};
        int k = 0;
        int countSubarray = subarraySum(nums,k);
        System.out.println(countSubarray);
    }
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            int rem = sum - k;
            count += mp.getOrDefault(rem,0);
            mp.put(rem,mp.getOrDefault(rem,0)+1);
        }
        return count;
    }
}
