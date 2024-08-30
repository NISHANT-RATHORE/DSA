// return a pair of index of the targeted index 
import java.util.*;
public class p3 {
    public static int [] findindex(int [] arr,int target){
        HashMap<Integer,Integer> mp = new HashMap<>();
        int n = arr.length;
        int [] ans = {-1};
        for(int i=0;i<n;i++){
            int prtnr = target - arr[i];
            if(mp.containsKey(prtnr)){
                ans = new int[]{i,mp.get(prtnr)};
                return ans;
            }
            mp.put(arr[i], i);
        }
        return ans;
    }
    public static void main(String[] args) {
        int [] arr = {14,7,10,4,5,9,1,2};
        int target = 13;
        int [] ans = findindex(arr,target);
        for(var val:ans){
            System.out.print(val+" ");
        }
    }
}
