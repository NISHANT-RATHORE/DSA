import java.util.Arrays;

public class operation_in_array {
    static void printarr(int [] arr){
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int len = arr.length;
        int [] b = new int [len];
        b=arr;
        b[0] = 10;
        // printarr(arr);
        // System.out.println();
        // printarr(b);
        int [] c = arr.clone();
        c[0] = 11;
        // printarr(arr);
        // System.out.println();
        // printarr(c);
        int [] d = Arrays.copyOf(arr, 5);
        printarr(d);
    }


    
}
