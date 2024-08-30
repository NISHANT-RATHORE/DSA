public class uniqueno {
    static void printarr(int [] arr){
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
    static int unique(int [] arr){
        int ans = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    arr[i]=-1;
                    arr[j]=-1;
                }
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0){
                ans = arr[i];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int [] arr = {1,2,2,3,5,4,3,5,4};
        System.out.println(unique(arr));
    }
    
}
