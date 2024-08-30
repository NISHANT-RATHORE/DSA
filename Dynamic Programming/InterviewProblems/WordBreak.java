package InterviewProblems;

import java.util.List;
import java.util.Set;


//-----------------------------------------------PENDING-----------------------------------------------------------------
public class WordBreak {
    public static void main(String[] args) {
        String s = "applepenapple";
        Set<String> wordDict = Set.of("apple","pen");
        System.out.println(isSegmented(0,s,wordDict));

//        int n = s.length();
//        int [] dp = new int[n];
//        for(int i=0;i<n;i++) dp[i] = -1;
//        System.out.println(isSegmentedUsingMemoization(0,s,wordDict,dp));
    }

    private static boolean isSegmented(int idx, String s, Set<String> wordDict) {
        if(idx==s.length()) return true;
        for (int i=idx;i<s.length();i++){
            String prefix = s.substring(idx,i+1);
            if(wordDict.contains(prefix)){
                return isSegmented(i+1,s,wordDict);
            }
        }
        return false;
    }}

//    private static boolean isSegmentedUsingMemoization(int idx, String s, Set<String> wordDict, int[] dp) {
//        if (idx >= dp.length) { // Check to prevent ArrayIndexOutOfBoundsException
//            return false;
//        }
//        if (dp[idx] != -1) {
//            return dp[idx] == 1;
//        }
//        if (idx == s.length()) return true;
//        for (int i = idx; i < s.length(); i++) {
//            String prefix = s.substring(idx, i + 1);
//            if (wordDict.contains(prefix) && isSegmentedUsingMemoization(i + 1, s, wordDict, dp)) {
//                dp[idx] = 1; // Update the dp array for idx, not i+1
//                return true;
//            }
//        }
//        dp[idx] = 0; // Mark this idx as false in dp array if no valid segmentation found
//        return false;
//}
//}
