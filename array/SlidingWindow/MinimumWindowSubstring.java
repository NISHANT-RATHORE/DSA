import java.util.*;

//Review once more
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String str = "ADOBECODEBANC";
        String pat = "ABC";
        System.out.println(minWindow(str,pat));
    }
    public static String minWindow(String s, String t) {
        Map<Character,Integer> mp = new HashMap<>();
        for(char ch : t.toCharArray()) mp.put(ch,mp.getOrDefault(ch,0)+1);
        int uniqueCharCount = mp.size();
        int startIdx = -1;
        int windowStart = 0;
        int windowEnd = 0;
        int minLen = Integer.MAX_VALUE;
        int n = s.length();
        while(windowEnd < n){
            //Expansion Phase
            char ch = s.charAt(windowEnd);
            if(mp.containsKey(ch)){
                mp.put(ch,mp.get(ch)-1);
                if(mp.get(ch) == 0) uniqueCharCount--;
            }

            //Shrinking Phase
            while (uniqueCharCount==0){
                int len = windowEnd - windowStart + 1;
                if(len<minLen){
                    minLen = len;
                    startIdx = windowStart;
                }
                ch = s.charAt(windowStart);
                if(mp.containsKey(ch)){
                    mp.put(ch,mp.get(ch)+1);
                    if(mp.get(ch) > 0) uniqueCharCount++;
                }
                windowStart++;
            }
            windowEnd++;
        }
        if(startIdx==-1) return "";
        return  s.substring(startIdx,startIdx+minLen);
    }
}
