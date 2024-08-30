public class FindElementInBitonicArray {
    public static void main(String[] args) {
        int [] arr = {5,6,8,10,14,15,12,9,7,4};
        int target = 5;
        int foundElement = findInPivot(arr,target);
        System.out.println(foundElement);
    }
    private static int findInPivot(int [] arr,int target){
        int n = arr.length;
        int peak = peakIndexInMountainArray(arr);
        if(arr[peak] == target) return peak;
        if(arr[peak] < target) return -1;
        int ans = binarySearchInc(arr, target, 0, peak);
        if (ans != -1) return ans;
        return binarySearchDec(arr, target, peak + 1, n - 1);
    }
    public static int binarySearchInc(int [] arr,int target,int st,int end){
        int n = arr.length;
        while (st<=end){
            int mid = st + (end-st)/2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] < target) st = mid+1;
            else end = mid - 1;
        }
        return -1;
    }
    public static int binarySearchDec(int [] arr,int target,int st,int end){
        int n = arr.length;
        while (st<=end){
            int mid = st + (end-st)/2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] < target) end = mid - 1;
            else st = mid+1;
        }
        return -1;
    }
    public static int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int st = 0;
        int end = n-1;
        while(st<=end){
            int mid = st + (end - st)/2;
            int next = (mid + 1) % n;
            int prev = (mid - 1 + n) % n;
            if(arr[mid]>arr[prev] && arr[mid]>arr[next]) return mid;
            else if(mid == 0 && arr[mid] < arr[next]) st = mid+1;
            else if(arr[mid] > arr[prev]) st = mid+1;
            else end = mid-1;
        }
        return -1;
    }
}
