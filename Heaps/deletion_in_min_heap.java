import java.util.*;

public class deletion_in_min_heap {
    public static void swap(List<Integer> l,int lo,int hi){
        int tmp = l.get(lo);
        l.set(lo,l.get(hi));
        l.set(hi,tmp);
    }
    public static void push_down_in_minheap(List<Integer> l,int index){
        int n = l.size()-1;
        if(index == n) return;
        int left = 2*index + 1;
        int right = 2*index + 2;
        int smallest = index;
        if(left <= n && l.get(left)<l.get(smallest)) smallest = left;
        if(right <= n && l.get(right)<l.get(smallest)) smallest = right;
        if(smallest == index) return;
        swap(l, index, smallest); // added this line
        push_down_in_minheap(l, smallest);
    }
    public static void deletion(List<Integer> l){
        swap(l, 0, l.size()-1);
        l.remove(l.size()-1);
        push_down_in_minheap(l,0); // changed from n to 0
    }
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>(Arrays.asList(5,20,10,40,50,30,60));
        System.out.println(l);
        deletion(l);
        System.out.println(l);
    }
}