// TC : (nlogn)
public class chocolate{
    static boolean Ispossible(int [] arr,int m,int maxChocolate){
        int numofstudents = 1;
        int chocolate = 0;
        for(int i = 0;i < arr.length ; i++){
            if(arr[i] > maxChocolate) return false;
            if(chocolate + arr[i] <= maxChocolate){
                chocolate += arr[i];
            }
            else{
                numofstudents++;
                chocolate = arr[i];
            }
        }
        return numofstudents <= m;

    }
    static int chocolateDistr(int [] arr,int m){
        int st = 1 , end = (int)1e9 , ans = 0;
        while (st<=end) {
            int mid = st + (end-st)/2;
            if(Ispossible(arr,m,mid)){
                ans = mid;
                end = mid-1;
            }
            else{
                st = mid+1;
            }
        }
        return ans;
    }
    static boolean Ispossible2(int [] arr,int k, int minDistance){
        int kidsplaced = 1;
        int lastplace = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i] - lastplace >= minDistance){
                kidsplaced++;
                lastplace = arr[i];
            }
        }
        return kidsplaced >= k;
    }
    static int track(int [] arr,int k){
        int st = 1,end = (int)1e9 , ans = 0;
        while(st<=end){
            int mid = st + (end-st)/2;
            if(Ispossible2(arr, k, mid)){
                ans = mid;
                st = mid+1;
            }
            else{
                end = mid -1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int [] arr = {12,34,67,90};
        int m = 2;
        int [] arr2 = {1,2,4,8,9};
        int k = 3;
        // System.err.println(chocolateDistr(arr,m));
        System.out.println(track(arr2, k));
    }
}