public class FindFirstAndLastOccuring {
    public static void main(String[] args) {
        int [] arr = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int [] ans = searchRange(arr,target);
        for(int val : ans) System.out.print(val + " ");
    }
    public static int[] searchRange(int[] nums, int target) {
        int [] ans = {-1,-1};
        ans [0] = helper(nums,target,true);
        ans [1] = helper(nums,target,false);
        return ans;
    }
    public static int helper(int[] nums, int target, boolean flag){
        int st = 0;
        int end = nums.length - 1;
        int ans = -1;
        while (st <= end){
            int mid = end + (st-end)/2;
            if(nums[mid] == target){
                ans = mid;
                if(flag) end = mid-1;
                else st = mid+1;
            }
            else if(nums[mid] < target) st = mid + 1;
            else end = mid - 1;
        }
        return ans;
    }
}
