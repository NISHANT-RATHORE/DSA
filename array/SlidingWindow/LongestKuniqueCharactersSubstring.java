public class LongestKuniqueCharactersSubstring {
    public static void main(String[] args) {
        String S = "aabacbebebe";
        int K = 3;
        System.out.println(longestkSubstr(S, K));
    }

    public static int longestkSubstr(String str, int k) {
        int maxLen = -1;
        int n = str.length();
        int windowStart = 0;
        int currCount = 0;
        int[] freq = new int[26];

        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
            int idx = str.charAt(windowEnd) - 'a';
            if (freq[idx] == 0) {
                currCount++;
            }
            freq[idx]++;

            while (currCount > k) {
                int startIdx = str.charAt(windowStart) - 'a';
                freq[startIdx]--;
                if (freq[startIdx] == 0) {
                    currCount--;
                }
                windowStart++;
            }

            if (currCount == k) {
                maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
            }
        }

        return maxLen;
    }
}