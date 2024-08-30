// TC : O(n^2)
// reason : The worst case time complexity of quick sort is O(n^2) when the array is already sorted in ascending or descending order.
public class quick_sort {

    static void printarr(int [] arr){
        for(int i:arr){
            System.out.println(i+" ");
        }
    }
    static void swap(int [] arr,int x,int y){
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp; 
    }
    static void quick_sort(int [] arr,int st,int end){
        if(st>=end) return;
        int part = partition(arr,st,end);
        quick_sort(arr, st, part-1);
        quick_sort(arr, part+1, end);
    }
    static int partition(int[] arr, int st, int end){
        int pivot = arr[st];
        int cnt = 0;
        for(int i = st+1; i <= end; i++){
            if(arr[i] <= pivot) cnt++;
        }
        int pivotIdx = st + cnt;
        swap(arr, st, pivotIdx);
        int i = st, j = end;
        while(i < pivotIdx && j > pivotIdx){
            while (arr[i] <= pivot) i++;
            while (arr[j] > pivot) j--;
            if(i < pivotIdx && j > pivotIdx){
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        return pivotIdx;
    }
    public static void main(String[] args) {
        int [] arr = {5,4,3,2,1};
        quick_sort(arr,0,arr.length-1);
        printarr(arr);
    }
    
}
