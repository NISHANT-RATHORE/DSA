//max length for the sum is zero

import java.util.HashMap;

public class p4 {
    public static int maxlength(int [] arr){
        int maxlen = 0 , pref = 0,n = arr.length;;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i=0;i<n;i++){
            pref += arr[i];
            if(map.containsKey(pref)){
                maxlen = Math.max(maxlen,i-map.get(pref));
            }
            else{
                map.put(pref, i);
            }
        }
        return maxlen;

    }
    public static void main(String[] args) {
        int [] arr  = {15,-2,2,-8,1,7,10};
        int ans = maxlength(arr);
        System.out.println(ans);
    }
    
}
