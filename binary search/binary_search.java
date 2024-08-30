public class binary_search{
    static boolean binarysearch(int [] arr,int target){
        int n = arr.length;
        int st=0,end=n-1;
        while(st<=end){
            int mid = st + (end-st)/2;
            if(arr[mid]==target) return true;
            else if(target<arr[mid]) end = mid-1;
            else st = mid+1;
        }
        return false;
    }
    static boolean binarysearch2(int [] arr,int st,int end,int target){
        int mid = st + (end-st)/2;
        if(st>end) return false;
        if(target==arr[mid]) return true;
        else if(target<arr[mid]){
            return binarysearch2(arr, st,mid-1, target);
        }
        else{
            return binarysearch2(arr, mid+1, end, target);
        }
    }
    static int findFirstOccurence(int [] arr,int target){
        int n = arr.length;
        int st=0,end=n-1;
        int fo=-1;
        while(st<=end){
            int mid = st + (end-st)/2;
            if(arr[mid]==target){
               fo = mid;
               end = mid-1; 
            }
            else if(target<arr[mid]) end = mid-1;
            else st = mid+1;
        }
        return fo;
    }
    static int lastOccurence(int [] arr,int target){
        int n = arr.length;
        int st=0,end=n-1;
        int fo=-1;
        while(st<=end){
            int mid = st + (end-st)/2;
            if(arr[mid]==target){
               fo = mid;
               st = mid+1; 
            }
            else if(target<arr[mid]) end = mid-1;
            else st = mid+1;
        }
        return fo;
    }
    static int sqrt(int n){
        int st = 1, end = n;
        int ans = -1;
        while(st<=end){
            int mid = st + (end-st)/2;
            int val = mid*mid;
            if(val == n) return mid;
            else if(val < n){
                ans = mid;
                st = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8,9,10};
        int [] arr2 = {4,5,5,5,6,6,7,8,9};
        int target = 55;
        // System.out.println(binarysearch(arr,target));
        // System.out.println(binarysearch2(arr, 0, arr.length-1, 55));
        // System.out.println(findFirstOccurence(arr2, 69 ));
        // System.out.println(lastOccurence(arr2, 6));
        System.out.println(sqrt(25));
    }
}