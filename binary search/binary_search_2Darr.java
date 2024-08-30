public class binary_search_2Darr {
    static boolean binarysearch2Darr(int [][] arr,int target){
        int st = 0,n = arr.length,m=arr[0].length,end = n*m-1;
        while(st<=end){
            int mid = st + (end-st)/2;
            int midElt = arr[mid/m][mid%m];
            if(midElt == target) return true;
            else if(midElt<target) st = mid + 1;
            else end = mid - 1;
        }
        return false;
    }
    static boolean binarysearch2DarrAlongCol(int[][] arr2,int target){
        int n = arr2.length,m = arr2[0].length;
        int i = 0,j = m-1;
        while(i<n && j>=0){
            if(arr2[i][j] == target) return true;
            if(target < arr2[i][j]) j--;
            else i++; 
        }
        return false;
    }
    static int peakIdx(int [] arr){
        int st = 0,n = arr.length,end = n-1,ans = -1;
        while (st<=end) {
            int mid = st + (end-st)/2;
            if(arr[mid]<arr[mid+1]){
                ans = mid + 1;
                st = mid+1;
            }
            else{
                end = mid-1;
            }  
        }
        return ans;
    }
    static int peakIdx2(int [] arr){
        int st = 0,n = arr.length,end = n-1,ans = -1;
        while (st<=end) {
            int mid = st + (end-st)/2;
            if(arr[mid]>arr[mid-1] && arr[mid] > arr[mid+1] ){
                ans = mid;
            }
            if(arr[mid]<arr[mid+1]){
                st = mid+1;
            } 
            else{
                end = mid - 1;
            } 
        }
        return ans;
    }
    public static void main(String[] args) {
        int [][] arr = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int [][] arr2 = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int [] mountain = {1,2,3,4,5,3,1,0};
        int [] hills = {1,2,1,3,5,6,4};
        // System.out.println(binarysearch2Darr(arr2,16));
        // System.out.println(peakIdx(mountain));
        System.out.println(peakIdx2(hills));

    }
    
}
