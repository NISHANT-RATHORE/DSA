//to check whether the given stirngs are isomorphic or not
import java.util.*;
public class p2 {
    public static boolean isIsomorphic(String st1,String st2){
        HashMap<Character,Character> mp = new HashMap<>();
        for(int i=0;i<st1.length();i++){
            Character sCh = st1.charAt(i);
            Character tCh = st2.charAt(i);
            if(mp.containsKey(sCh)){
                if(mp.get(tCh)!= tCh) return false;
                else if(mp.containsValue(tCh)) return false;
                else mp.put(sCh, tCh);
            }
        }
        return true;   
    }
    public static void main(String[] args) {
        String st1 = "aab";
        String st2 = "xxy";
        boolean ans = (isIsomorphic(st1,st2))?true:false;
        System.out.println(ans);
    }
}
