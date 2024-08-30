public class insertion_sort{
    static void insertion_sort(int [] arr){
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

    }
    public static void main(String[] args) {
        int [] arr = {5,4,3,2,1};
        insertion_sort(arr);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}