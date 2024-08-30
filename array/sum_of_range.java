public class sum_of_range {
    static int[] presum(int [] arr){
        int p = 2;
        for(int i=1;i<arr.length;i++){
            arr[i] += arr[i-1];
        }
        return arr;
    }
    static int sumOGR(int [] arr,int l,int r){
        int [] pre = presum(arr);
        int ans = pre[r] - pre[l-1];
        return ans;
    }
    public static void main(String[] args) {
        int [] arr = {2,4,1,3,6,5};
        System.out.println(sumOGR(arr, 1,5));
        // System.out.println(a);
    }
}
