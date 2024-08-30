public class FindMinInRotatedArr {
    public static void main(String[] args) {
        int [] arr = {3, 4, 5, 1, 2};
        //clockwise
        int index = findMin(arr);
        System.out.println("Rotation Count: " + index);
        //anticlockwise
        System.out.println("Rotation Count: " + (arr.length - index)%arr.length);

        int mxIdx = findMax(arr);
        System.out.println(mxIdx);
    }
    public static int findMin(int[] nums) {
        int n = nums.length;
        int st = 0;
        int end = n - 1;
        while (st < end) {
            int mid = st + (end - st) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return mid;
            } else if (nums[end] > nums[mid]) {
                end = mid - 1;
            } else {
                st = mid+1;
            }
        }
        return st;
    }
    public static int findMax(int[] nums){
        int n = nums.length;
        int st = 0;
        int end = n - 1;
        while (st < end) {
            int mid = st + (end - st) / 2;
            if (mid < n-1 && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[st] > nums[mid]) {
                end = mid - 1;
            } else {
                st = mid+1;
            }
        }
        return end;
    }
}
