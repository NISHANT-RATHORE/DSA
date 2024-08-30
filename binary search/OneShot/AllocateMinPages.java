import java.util.Arrays;

public class AllocateMinPages {
    public static void main(String[] args) {
        int [] arr = {12, 34, 67, 90};
        int m = 2;
        System.out.println(findPages(arr.length,arr,m));
    }
    public static long findPages(int n, int[] arr, int m) {
        // Your code here
        if(m > n) return -1;
        long ans = -1;
        int st = Integer.MIN_VALUE;
        int end = 0;
        // range of binary search
        for(int i=0;i<n;i++){
            if(arr[i] > st){
                st = arr[i];
            }
            end += arr[i];
        }
        //Binary search
        while (st<=end){
            int mid = st + (end - st)/2;
            if(allocationPossible(m,mid,arr)){
                ans = mid;
                end = mid - 1;
            } else st = mid + 1;
        }
        return ans;
    }

    private static boolean allocationPossible(int students, int MaxPages, int[] arr) {
        int currentStudent = 1;
        int pages = 0;
        for(int i = 0;i<arr.length;i++){
            pages += arr[i];
            if(pages > MaxPages){
                currentStudent++;
                pages = arr[i];
            }
            if(currentStudent > students) return false;
        }
        return true;
    }
}
