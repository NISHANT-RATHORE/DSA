public class EX3 {
    static void sortarr(int [] arr){
        int x =-1, y=-1 ,n=arr.length;
        if(n<=1) return;
        for(int i=1;i<n;i++){
            if(arr[i-1]>arr[i]){
                if(x==-1){
                    x=i-1;
                    y=i;
                }
                else y=i;
            }
        }
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;

    }
    public static void main(String[] args) {
        int [] arr = {3,8,6,7,5,9,10};
        sortarr(arr);
        for(int val:arr){
            System.out.print(val+" ");
        }
    }
}
