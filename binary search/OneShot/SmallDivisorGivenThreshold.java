public class SmallDivisorGivenThreshold {
    public static void main(String[] args) {
        int [] nums = {1,2,5,9};
        int threshold = 6;
        System.out.println(smallestDivisor(nums,threshold));
    }
    public static int smallestDivisor(int[] nums, int threshold) {
        int ans = 0;
        int st = 1;
        int end = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i] > end){
                end = nums[i];
            }
        }
        while(st<=end){
            int mid = st + (end - st)/2;
            if(isPossible(nums,mid,threshold)){
                ans = mid;
                end = mid - 1;
            }
            else st = mid + 1;
        }
        return ans;
    }
    private static boolean isPossible(int[] nums, int divisor, int threshold){
        int currSum = 0;
        for(int i=0;i<nums.length;i++){
            currSum += (nums[i]%divisor == 0) ? nums[i]/divisor : nums[i]/divisor + 1;
            if(currSum > threshold) return false;
        }
        return true;
    }
}
