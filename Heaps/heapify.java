import java.util.*;
// heapify min heap
public class heapify {
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
    public static void heapify(List<Integer> l){
        int first_non_leaf = ((l.size()-1)-1)/2;
        for(int i=first_non_leaf;i>=0;i--){
            push_down_in_minheap(l, i);
        }
    }
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>(Arrays.asList(50,40,30,20,10));
        System.out.println(l);
        heapify(l);
        System.out.println(l);
    }
}