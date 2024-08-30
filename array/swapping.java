public class swapping {
    static void printarr(int [] arr){
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
    // static void swap(int a,int b){
    //     a = a + b;
    //     b = a - b;
    //     a = a - b;

    // }
    static void swap_array(int[]arr){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        printarr(arr);
    }
    public static void main(String[] args) {
        int [] arr = {5,4,3,2,1};
        swap_array(arr);
    }
    
}
