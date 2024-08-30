//wrong answer AA rha hai 😣
public class sortArray {
    static void print(int [] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    static void sort(int [] arr){
        int n=arr.length;
        int i=0;
        int j=n-1;
        while (i<j) {
            if(arr[i]==1 && arr[j]==0){
                swap(arr,arr[i],arr[j]);
                i++;
                j--;
            }
            if(arr[i]==0){
                i++;
            }
            if(arr[j]==1){
                j--;
            }
        }
        print(arr);
    }
    public static void main(String[] args) {
        int [] arr = {0,1,1,0,1,1,0};
        sort(arr);
    }
}
