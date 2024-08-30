package Problems;

import TrieTemplate.TriesAC;

import java.util.*;

// unique substring of string are all unique prefix of a sufffix
public class CountUniqueSubstring {
    public static void main(String[] args) {
        TriesAC triesAC = new TriesAC();
        String str =  "abadefg";
        for(int i = 0;i < str.length();i++) {
            String suf = str.substring(i);
            TriesAC.insert(suf);
        }
        System.out.println(TriesAC.countNodes(triesAC.root));
    }
}
