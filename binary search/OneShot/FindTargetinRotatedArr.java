public class FindTargetinRotatedArr {
    public static void main(String[] args) {
        int [] arr = {4,5,6,7,0,1,2};
        int target = 0;
        int findIdx = search(arr,target);
        System.out.println(findIdx);
    }
    public static int search(int[] nums, int target) {
        int ans = -1;
        int n = nums.length;
        int st = 0;
        int end = n-1;
        while (st<=end){
            int mid = st + (end - st) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[st] <= nums[mid]){
                if(target >= nums[st] && target < nums[mid]){
                    end = mid - 1;
                }
                else st = mid + 1;
            } else {
                if(target > nums[mid] && target <= nums[end]){
                    st = mid + 1;
                }
                else end = mid - 1;
            }
        }
        return ans;
    }
}
