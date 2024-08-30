import java.util.*;

public class Bubble_sort {
    static void printarr(int[] arr, int idx) {
        if (idx == arr.length) return;
        System.out.print(arr[idx] + " ");
        printarr(arr, idx + 1);
    }
    static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static void Bubble_sort(int[] arr) {
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    swap(arr,j,j+1);
                }
            }
            if(flag == false) return;
        }
        printarr(arr,0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Bubble_sort(arr);

    }
}