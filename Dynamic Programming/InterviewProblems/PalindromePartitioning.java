package InterviewProblems;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String str = "aabaa";
        List<List<String>> result = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        helper(0,str,result,ans);
        System.out.println(result);
    }

    private static void helper(int idx, String str, List<List<String>> result, List<String> ans) {
        if(idx == str.length()){
            result.add(new ArrayList<>(ans));
            return;
        }

        for (int i = idx ; i < str.length() ; i++){
            String tmp = str.substring(idx,i+1);
            if(isPalindrome(tmp)){
                ans.add(tmp);
                helper(i+1,str,result,ans);
                ans.remove(ans.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String s){
        int i = 0, j = s.length()-1;
        while (i<j){
            if(s.charAt(i++)!=s.charAt(j--)) return false;
        }
        return true;
    }

}
