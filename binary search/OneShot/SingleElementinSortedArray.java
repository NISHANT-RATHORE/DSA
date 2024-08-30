public class SingleElementinSortedArray {
    public static void main(String[] args) {
        int [] arr = {1,1,2,3,3,4,4,8,8};
        int single = singleNonDuplicate(arr);
        System.out.println(single);
    }
    public static int singleNonDuplicate(int[] nums) {
        int st = 0;
        int end = nums.length - 2;
        while(st<=end){
            int mid = st + (end - st)/2;
            //left half
            if(nums[mid] == nums[mid^1]){
                st = mid + 1;
                // right half
            } else end = mid - 1;
        }
        return nums[st];
    }
}
