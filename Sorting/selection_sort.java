import java.util.*;
public class selection_sort {
    static void selection_sort(int []arr){
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            int min_index = i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[min_index]){
                    min_index = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = tmp;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] arr = {7,5,4,3};
        selection_sort(arr);
        for(int i:arr){
            System.out.print(i+" ");
        }

    }
}
