// to check whether a string is anagram or not

import java.util.HashMap;

public class p1{
    public static HashMap<Character,Integer> freq(String st){
        HashMap<Character,Integer> mp = new HashMap<>();
        for(int i = 0;i<st.length();i++){
            char ch = st.charAt(i);
            if(!mp.containsKey(ch)){
                mp.put(ch, 1);
            }
            else mp.put(ch, mp.get(ch)+1);
        }
        return mp;
    }
    public static boolean isAnagram(String st1,String st2){
        if(st1.length() != st2.length()) return false;
        HashMap<Character,Integer> mp1 = freq(st1);
        HashMap<Character,Integer> mp2 = freq(st2);
        return mp1.equals(mp2);
    }

    public static boolean isAnagram2(String st1,String st2){ //less space
        if(st1.length() != st2.length()) return false;
        HashMap<Character,Integer> mp1 = freq(st1);
        for(int i=0;i<st2.length();i++){
            Character ch = st2.charAt(i);
            if(!mp1.containsKey(ch)) return false;
            mp1.put(ch, mp1.get(ch)-1);
        }
        for(var i:mp1.values()){
            if(i!=0)return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String st1 = "listen";
        String st2 = "tislee";
        boolean ans = (isAnagram2(st1,st2))?true:false;
        System.out.println(ans);
        
    }
}