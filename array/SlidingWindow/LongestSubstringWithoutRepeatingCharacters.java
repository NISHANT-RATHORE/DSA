import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));
    }
    public static int lengthOfLongestSubstring(String s) {
        int maxLen = Integer.MIN_VALUE;
        int windowStart = 0;
        int windowEnd = 0;
        int n = s.length();
        Map<Character, Integer> mp = new HashMap<>();
        while (windowEnd < n ) {
            char ch = s.charAt(windowEnd);
            if (mp.containsKey(ch) && mp.get(ch) >= windowStart) {
                windowStart = mp.get(ch) + 1;
            }
            mp.put(ch, windowEnd);
            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
            windowEnd++;
        }
        return maxLen;
    }
    }
