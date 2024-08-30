public class prefixsum {
        static void printarr(int [] arr){
            for(int i:arr){
                System.out.print(i+" ");
            }
        }
    static void presum(int [] arr){
        int p = 2;
        for(int i=1;i<arr.length;i++){
            arr[i] += arr[i-1];
        }
        printarr(arr);
    }
    public static void main(String[] args) {
        int arr[] = {2,1,3,4,5};
        presum(arr);
    }
}
