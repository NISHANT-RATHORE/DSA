public class NumberOfOccurence {
    public static void main(String[] args) {
        int [] arr = {1, 1, 2, 2, 2, 2, 3};
        int n = arr.length;
        int x = 27;
        System.out.println(count(arr,n,x));
    }
    public static int count(int[] arr, int n, int x) {
        // code here
        int ans = 0;
        int stIdx = helper(arr,x,true);
        int endIdx = helper(arr,x,false);
        if(stIdx==-1 && endIdx == -1) return 0;
        return endIdx - stIdx + 1;
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
