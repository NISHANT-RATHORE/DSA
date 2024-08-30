import java.util.*;

public class deletion_in_max_heap {
    public static void swap(List<Integer> l,int lo,int hi){
        int tmp = l.get(lo);
        l.set(lo,l.get(hi));
        l.set(hi,tmp);
    }
    public static void push_down_in_maxheap(List<Integer> l,int index){
        int n = l.size()-1;
        if(index == n) return;
        int left = 2*index + 1;
        int right = 2*index + 2;
        int biggest = index;
        if(left <= n && l.get(left)>l.get(biggest)) biggest = left;
        if(right <= n && l.get(right)>l.get(biggest)) biggest = right;
        if(biggest == index) return;
        swap(l, index, biggest); // added this line
        push_down_in_maxheap(l, biggest);
    }
    public static void deletion(List<Integer> l){
        swap(l, 0, l.size()-1);
        l.remove(l.size()-1);
        push_down_in_maxheap(l,0); // changed from n to 0
    }
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>(Arrays.asList(60,50,40,30,20,10));
        System.out.println(l);
        deletion(l);
        System.out.println(l);
    }
}