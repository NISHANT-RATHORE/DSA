import java.util.*;

public class longestSubarrayOfSizeK {
    public static void main(String[] args){
        int arr[] = {10, 5, 2, 7, 1, 9};
        int k = 15;
        System.out.println(lenOfLongSubarr(arr,arr.length,k));
    }
    public static int lenOfLongSubarr(int[] arr, int n, int k) {
        // Complete the function
        int maxLength= 0,sum=0;
        List<Integer> al = new ArrayList<>();
        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0,-1);
        for(int i=0;i<n;i++){
            int currlength = 0;
            sum += arr[i];
            int rem = sum - k;
            if(mp.containsKey(rem)){
                currlength = i - mp.get(rem);
                maxLength = Math.max(maxLength,currlength);
            }
            if(!mp.containsKey(sum)){
                mp.put(sum,i);
            }
        }
        return maxLength;
    }
}
