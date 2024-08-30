public class peakElementBitonicArray {
    public static void main(String[] args) {
        int [] arr = {5,6,7,9,8};
        int peakPointIdx = peakIndexInMountainArray(arr);
        System.out.println(peakPointIdx);
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
