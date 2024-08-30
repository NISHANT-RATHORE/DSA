import java.util.*;
public class gfg_potd {
    static String LargestNum(int n,String [] arr){
        String ans =  "";
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
        for (String num : arr) {
            ans += num;
        }
        return ans;
    }
    public static void main(String[] args) {
            String [] arr = {"54", "546", "548", "60"};
        // String ans = LargestNum(arr.length,arr);
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
        // System.out.println(ans);
        for(var val:arr){
            System.out.println(val); // corrected here
        }
    }
}