package Problems;

import TrieTemplate.TriesAC;

public class startWith {
    public static void main(String[] args) {
        TriesAC triesAC = new TriesAC();
        String [] dict = {"apple","app","mango","man","women"};
        for(String word : dict) triesAC.insert(word);
        System.out.println(triesAC.searchPrefix("app"));
    }
}
