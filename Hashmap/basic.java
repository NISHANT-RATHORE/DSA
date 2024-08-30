import java.util.*;
public class basic{
    public static void main(String [] args){
        HashMap<Integer,Integer> mp = new HashMap<>();
        int [] arr = {1,3,3,3,3,2,1,4,1};
        for(int e:arr){
            if(!mp.containsKey(e)) mp.put(e, 1);
            else{
                mp.put(e, mp.get(e)+1);
            }
        }
    
        System.out.println(mp.entrySet());
        int max = 0,anskey=-1;
        for(var freq:mp.entrySet()){
            if(freq.getValue()>max){
                max = freq.getValue();
                anskey  = freq.getKey();
            }
        }
        System.out.println(anskey);
        
        
    }
}