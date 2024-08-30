package InterviewProblems;

import static InterviewProblems.LongestCommonSubsequence.TabulationSpaceOptimisation;

public class EditStr1toStr2 {
    public static void main(String[] args) {
        String s1 = "CUP";
        String s2 = "CUT";
        System.out.println(minoper(s1,s2,s1.length(),s2.length()));
    }
    private static int minoper(String s1,String s2,int m,int n){
        int lca = TabulationSpaceOptimisation(s1,s2,s1.length(),s2.length());
        if(s1.length()-lca==s2.length()-lca) return s1.length()-lca;
        int minoperation = Math.max(s1.length()-lca,s2.length()-lca);
        return minoperation;
    }
}
