public class EX5 {
    static void sort(int []arr){
        int Zc = 0,Oc=0,Tc =0;
        for(int i:arr){
            if(i==0) Zc++;
            if(i==1) Oc++;
            if(i==2) Tc++;
        }
        int k = 0;
        while(Zc-->0){
            arr[k++] = 0;
        }
        while(Oc-->0){
            arr[k++] = 1;
        }
        while(Tc-->0){
            arr[k++] = 2;
        }
    }
    static void swap(int []arr,int x,int y){
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
    static void sort2(int [] arr){
        int lo=0,mid=0,hi=arr.length-1;
        while(mid<=hi){
            if(arr[mid]==0){
                swap(arr,mid,lo);
                mid++;
                lo++;
            }
            else if(arr[mid]==1) mid++;
            else{
                swap(arr,mid,hi);
                hi--;
            }
        }


    }
    public static void main(String[] args) {
        int []arr = {0,2,1,2,0,0};
        sort2(arr);
        for(int val:arr){
            System.out.print(val+" ");
        }
    }
    
}
