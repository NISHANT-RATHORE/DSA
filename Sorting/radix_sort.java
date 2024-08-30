public class radix_sort {
    static void displayarr(int [] arr){
        for(int val:arr){
            System.out.print(val+" ");
        }
    }
    static int max(int [] arr,int idx){
        int n = arr.length;
        if(idx == n) return 0;
        int subans = max(arr, idx+1);
        return Math.max(arr[idx], subans);
    }
    static int [] prefix(int []arr){
        for(int i=1;i<arr.length;i++){
            arr[i] += arr[i-1];
        }
        return arr;
    }
    static void countsort_Stable_ver(int [] arr,int p){
        int n = arr.length;
        int mx = max(arr, 0);
        int [] freq = new int[10];
        for(int i=0;i<arr.length;i++){
            freq[(arr[i]/p)%10]++;
        }
        freq = prefix(freq);
        int [] ans = new int[n];
        for(int i=n-1;i>=0;i--){
            int idx = freq[(arr[i]/p)%10]-1;
            ans[idx] = arr[i];
            freq[(arr[i]/p)%10]--;
        }
        for(int i=0;i<ans.length;i++){
            arr[i] = ans[i];
        }
    }
    static void radix_sort(int [] arr){
        int mx3 = max(arr, 0);
        for(int p=1;(mx3/p)>0;p*=10){
            countsort_Stable_ver(arr,p);
        }
        displayarr(arr);
    }
    public static void main(String[] args) {
        int [] arr = {170,45,75,90,802,2};
        radix_sort(arr);
    }
}
