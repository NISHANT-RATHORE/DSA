import java.util.Scanner;

public class p1 {
    static int []  insertion_sort(int [] arr){
        int n = arr.length;
        for(int i=1;i<n;i++){
            int j = i;
            while (j>0 && arr[j]<arr[j-1]) {
                int tmp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = tmp;
                j--;
            }
        }
        return arr;
    }
    static int ansarr(int [] arr,int k){
        int [] ans = insertion_sort(arr);
        return ans[k-1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] arr = {5,4,3,2,1};
        int k = sc.nextInt();
        System.out.println(ansarr(arr,k));
    }
}
