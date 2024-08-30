public class ass_1 {
    static int upperBound(int [] arr,int target){
        int st = 0,n = arr.length,end = n-1;
        while(st<=end){
            int mid = st + (end-st)/2;
            if(target == arr[mid]){
                if(arr[mid]==arr[mid+1]) st = mid+1;
                else return arr[mid+1];
            }
            if(target<arr[mid]) end = mid-1;
            else st = mid + 1;
        }
        return -1;
    }
    static int lowerBound(int [] arr,int target){
        int st = 0,n = arr.length,end = n-1,ans = -1;
        while(st<=end){
            int mid = st + (end-st)/2;
            if(arr[mid]==target){
                ans = mid;
                end = mid-1;
            }
            if(target<arr[mid]) end = mid-1;
            else st = mid+1;
        }
        return ans;
    }
    static int CountTarget(int [] arr,int target){
        int st = 0,n = arr.length, end = n-1,c=0;
        while(st<=end){
            int mid = st + (end-st)/2;
            if(arr[mid]==target){
                c++;
                st = mid+1;
            }
            else if(arr[mid]<target) st = mid+1;
            else end = mid-1;
        }
        return c;
    }
    static int max(int [] arr){
        int st = 0,n = arr.length, end = n-1,max = -1;
        while(st<=end){
            int mid = st + (end-st)/2;
            if(arr[mid]>arr[n-1]){
                max = Math.max(max,mid);
                st = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return arr[max];
    }
    public static void main(String[] args) {
        int [] arr = {1,3,3,4,5,8,9,11,15,15};
        int [] arr2 = {1,3,3,4,5,5,5,11,15,15};
        int [] arr3 = {7,11,13,15,1,2,3,4};
        // System.out.println(upperBound(arr,3));
        // System.out.println(lowerBound(arr, 4));
        // System.out.println(CountTarget(arr2, 5));
        System.out.println(max(arr3));
    }
    
}
