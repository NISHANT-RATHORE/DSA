public class FloorInArray {
    public static void main(String[] args) {
        long [] arr = {1,2,8,10,11,12,19};
        int n = arr.length;
        long x = 9;
        System.out.println(findFloor(arr,n,x));
    }
    static int findFloor(long[] arr, int n, long x) {
        int ans = -1;
        int st = 0;
        int end = n-1;
        while (st <= end){
            int mid = end + (st - end) / 2;
            if(arr[mid] == x){
                ans = mid;
                break;
            }
            else if(arr[mid] < x ){
                st = mid + 1;
                ans = mid;
            }
            else {
                end = mid-1;
            }

        }
        return ans;
    }
}
