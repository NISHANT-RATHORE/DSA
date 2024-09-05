import java.util.Arrays;
import java.util.WeakHashMap;

public class CountingAnagrams {
    public static void main(String[] args) {
        String str = "eaylnlfdxf";
        String pat = "irc";
        System.out.println(search(pat,str));
    }
    public static int search(String pat, String txt) {
        // code here
        int res = 0;
        int n = txt.length();
        int k = pat.length();
        int [] patFreq = new int[26];
        int [] txtFreq = new int[26];
        for(int i=0;i<k;i++) patFreq[pat.charAt(i)-'a']++;
        for(int i=0;i<k;i++) txtFreq[txt.charAt(i)-'a']++;
        if(Arrays.equals(patFreq,txtFreq)) res++;
        for(int i=1;i<n-k+1;i++){
            int removedIndex = txt.charAt(i-1) - 'a';
            int addedIndex = txt.charAt(i+k-1) - 'a';
            txtFreq[removedIndex]--;
            txtFreq[addedIndex]++;
            if(Arrays.equals(patFreq,txtFreq)) res++;
        }
        return res;
    }
}
