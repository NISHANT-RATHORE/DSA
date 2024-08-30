public class count_sort {
    //countv sort
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
    static void countsort(int [] arr){
        int mx = max(arr, 0);
        int [] freq = new int[mx+1];
        for(int i=0;i<arr.length;i++){
            freq[arr[i]]++;
        }
        int k = 0;
        for(int i=0;i<freq.length;i++){
            for(int j=0;j<freq[i];j++){
                arr[k++] = i;
            }
        }
        displayarr(arr);
    }
    static int [] prefix(int []arr){
        for(int i=1;i<arr.length;i++){
            arr[i] += arr[i-1];
        }
        return arr;
    }
    static void countsort_Stable_ver(int [] arr){
        int n = arr.length;
        int mx = max(arr, 0);
        int [] freq = new int[mx+1];
        for(int i=0;i<arr.length;i++){
            freq[arr[i]]++;
        }
        freq = prefix(freq);
        int [] ans = new int[n];
        for(int i=n-1;i>=0;i--){
            int idx = freq[arr[i]]-1;
            ans[idx] = arr[i];
            freq[arr[i]]--;
        }
        displayarr(ans);
    }

    public static void main(String[] args) {
        int [] arr = {4,3,1,5,3,1,3,5};
        int [] arr2  = {2,3,2,4,0,1,4,1,0,2};
        // countsort(arr,);
        // countsort_Stable_ver(arr2);


    }
    
}