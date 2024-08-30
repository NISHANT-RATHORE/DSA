// TC : O(nlogn) 
// Here's a breakdown:
// The list of size n is divided into a max of log n parts, and
// The merging of all sublists into a single list takes O(n) time,
// So, the total time complexity is O(n log n).

public class merge_sort {
    static void displayArr(int[] arr){
        for(int val : arr){
            System.out.print(val + " ");
        }
    }
    static void merge(int[] arr, int l, int mid, int r){
        int n1 = mid-l+1;
        int n2 = r-mid;
        int[] left = new int[n1];
        int[] right = new int[n2];
        int i, j, k;
        for(i = 0; i < n1; i++) left[i] = arr[l+i];
        for(j = 0; j < n2; j++) right[j] = arr[mid+1+j];
        i = 0;
        j = 0;
        k = l;
        while(i < n1 && j < n2){
            if(left[i] < right[j])
                arr[k++] = left[i++];
            else
                arr[k++] = right[j++];
        }
        while(i < n1) 
            arr[k++] = left[i++];
        while (j < n2)
            arr[k++] = right[j++];
    }
    static void mergeSort(int[] arr, int l, int r){
        if(l >= r) return;
        int mid = (l+r)/2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);
        merge(arr, l, mid, r);
    } 

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        mergeSort(arr, 0, arr.length-1);
        displayArr(arr);
        
    }
}
