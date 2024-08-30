//TIME COMPLEXITY: O(n^2)
import java.util.*;
public class nextGreaterElementUsingArr {
    static int [] nextGreaterUsingArr(int [] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int [] res = new int[n];
        for(int i=0;i<n;i++){
            res[i] = -1;
            for(int j=i+1;j<n;j++){
                if(arr[j]>arr[i]){
                    res[i] = arr[j];
                    break;
                }
            }
        }
        return res;

    }
    public static void main(String[] args) {
        int [] arr = {1,3,2,1,8,6,3,4};
        int [] ans = nextGreaterUsingArr(arr);
        for(int val:ans){
            System.out.print(val+" ");
        }
    }
}