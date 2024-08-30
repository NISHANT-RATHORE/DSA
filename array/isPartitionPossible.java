// wrong answer aa rha hai 
public class isPartitionPossible {
    static int[] presum(int [] arr){
        int p = 2;
        for(int i=1;i<arr.length;i++){
            arr[i] += arr[i-1];
        }
        return arr;
    }
    static boolean partition(int [] arr){
        int total = 0;
        for(int i:arr){
            total+=arr[i];
        }
        int [] pre = presum(arr);
        for(int i:arr){
            int suf = total-pre[i];
            if(suf==pre[i]){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int [] a = {2,1,3,4,5,6};
        System.out.println(partition(a));

    }
}
