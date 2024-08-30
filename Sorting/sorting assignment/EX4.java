public class EX4{
    static void sort(int []arr,int l,int r){
        int n = arr.length;
        while(l<r){
            while(arr[l]<0) l++;
            while (arr[r]>=0) r--;
            if(l<r){
                int tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = arr[l];
            }
        }
    }

    public static void main(String[] args) {
        int [] arr = {19,-20,7,-4,-13,-5,7,11,19,3};
        sort(arr,0,arr.length-1);
        for(int val:arr){
            System.out.print(val+" ");
        }

    }
}