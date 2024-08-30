package Problems;

import TrieTemplate.TriesAC;

public class wordBreakProblem {
    public static void main(String[] args) {
        TriesAC triesAC = new TriesAC();
        String [] dictionary = {"i","like","sam","samsung","mobile","ice"};
        String key = "ilikesam";
        for(String word : dictionary){
            triesAC.insert(word);
        }
        boolean isWordBreak = helper(key,triesAC);
        System.out.println(isWordBreak);
    }

    private static boolean helper(String key, TriesAC triesAC) {
        if(key.length()==0) return true;
        for(int i=1;i<=key.length();i++){
            String fisrtPart = key.substring(0,i);
            String secondPart = key.substring(i);
            if(triesAC.search(fisrtPart) && helper(secondPart,triesAC)) return true;
        }
        return false;
    }
}
