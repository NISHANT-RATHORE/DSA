public class MinimumAbsoluteDifference {
    public static void main(String[] args) {
        int [] arr = {2,4,8,13,17,19};
        int target = 12;
        System.out.println(minAbsDiff(arr,target));
    }

    private static int minAbsDiff(int[] arr, int target) {
        int ans = -1;
        int st = 0;
        int n = arr.length;
        int end = n-1;
        while (st <= end){
            int mid = st + (end - st) / 2;
            if(arr[mid] == target) return 0;
            else if(arr[mid] < target){
                st = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        int res = 0;
        if(ans == -1){
            if(end == -1){
                res = Math.abs(target - arr[st]);
            }
            else if(st == n){
                res = Math.abs(target - arr[end]);
            }
            else {
                int ans1 = Math.abs(target - arr[st]);
                int ans2 = Math.abs(target - arr[end]);
                res = Math.min(ans1,ans2);
            }
        } else return res;
        return res;
    }
}
