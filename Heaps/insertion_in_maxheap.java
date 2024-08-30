import java.util.*;
public class insertion_in_maxheap {
    public static void swap(List<Integer> l,int lo,int hi){
        int tmp = l.get(lo);
        l.set(lo,l.get(hi));
        l.set(hi,tmp);
    }
    public static void helper(List<Integer> l,int index){
        int parent_index = (index-1)/2;
        if(index==0 || l.get(parent_index)>l.get(index)) return;
        swap(l,index,parent_index);
        helper(l, parent_index);
    }
    public static void insertion(List<Integer> l,int val){
        l.add(val);
        int n = l.size()-1;
        helper(l,n);
    }
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>(Arrays.asList(60,50,40,30,20,30,10));
        System.out.println(l);
        insertion(l,55);
        System.out.println(l);
    }
}
