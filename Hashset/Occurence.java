import java.util.*;
public class Occurence {
    public static void main(String[] args) {
		int [] a = {1, 7, 4, 3, 4, 8, 7};
		LinkedHashMap<Integer,Integer> mp = new LinkedHashMap<>();
		for(int i=0;i<a.length;i++) mp.put(a[i],i);
		System.out.println(mp);
	}
}
