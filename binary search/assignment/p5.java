//find max in arr: compare each element with the last element
import java.util.*;
public class p5 {
    static int Max(int [] arr){
        int n = arr.length,st = 0,end = n-1,ans=-1;
        while(st<=end){
            int mid = st + (end-st)/2;
            if(arr[mid]>arr[n-1]){
                ans = Math.max(ans,mid);
                st = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(arr[Max(arr)]);
    }
}
