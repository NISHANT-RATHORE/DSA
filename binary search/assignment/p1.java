import java.util.*;
public class p1{
    static int TargetIdx(int [] arr,int target){
        int n = arr.length,st = 0,end = n-1;
        while(st<=end){
            int mid = st + (end-st)/2;
            if(arr[mid] == target) return mid;
            else if(arr[mid]<target) st = mid+1;
            else end = mid-1;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println("found at"+" "+TargetIdx(arr,target));
        sc.close();

    }
}