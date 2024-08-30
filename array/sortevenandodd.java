public class sortevenandodd {
    static void printarr(int[]arr){
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
    static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    static void sortEandO(int []arr){
        int n = arr.length;
        int i=0;
        int j = n-1;
        while(i<j){
            if(arr[i]%2==1 && arr[j]%2==0){
                swap(arr,arr[i],arr[j]);
                i++;
                j--;
            }
            if(arr[i]%2==0){
                i++;
            }
            if(arr[j]%2==1){
                j--;
            }
        }
        printarr(arr);
    }
    public static void main(String[] args) {
        int [] a = {2,3,4,5,6,7,8,9,10};
        sortEandO(a);
    }    
}