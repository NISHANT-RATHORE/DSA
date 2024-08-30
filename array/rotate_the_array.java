public class rotate_the_array {
    static void printarr(int [] arr){
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
    static int[] rotate(int[]arr,int k){
        int n = arr.length;
        k = k%n;
        int [] ans = new int[n];
        int j=0;
        for(int i=n-k;i<n;i++){
            ans[j++] = arr[i];
        }
        for(int i=0;i<n-k;i++){
            ans[j++] = arr[i];
        }
        return ans;
    }
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        int []ans = rotate(arr, 30);
        printarr(ans);
    }
    
}
