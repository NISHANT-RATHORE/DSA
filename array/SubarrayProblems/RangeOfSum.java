import java.util.*;
public class RangeOfSum {
    public static void main(String[] args) {
        int [] arr = {2,8,2,6,-6,3,2};
        ArrayList<Integer> range = subarraySum(arr,arr.length,5);
        System.out.println(range);
    }
    public static ArrayList<Integer> subarraySum(int[] arr, int n, int k) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        res.add(-1);
        Map<Integer,Integer> mp = new HashMap<>();
        int sum = 0;
        mp.put(0,0);
        int idx = 1;
        for(int i=0;i<n;i++){
            sum += arr[i];
            if(mp.containsKey(sum-k)){
                res.set(0,mp.get(sum-k) + 1);
                res.add(i+1);
                break;
            }
            mp.put(sum,idx++);
        }
        return res;
    }
}
