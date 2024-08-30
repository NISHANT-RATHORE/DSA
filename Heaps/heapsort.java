import java.util.*;

public class heapsort {
    public static void swap(List<Integer> l,int lo,int hi){
        int tmp = l.get(lo);
        l.set(lo,l.get(hi));
        l.set(hi,tmp);
    }
    public static void push_down_in_maxheap(List<Integer> l,int index, int heapSize){
        int left = 2*index + 1;
        int right = 2*index + 2;
        int largest = index;
        if(left < heapSize && l.get(left)>l.get(largest)) largest = left;
        if(right < heapSize && l.get(right)>l.get(largest)) largest = right;
        if(largest == index) return;
        swap(l, index, largest);
        push_down_in_maxheap(l, largest, heapSize);
    }
    public static void heapify(List<Integer> l){
        int first_non_leaf = ((l.size()-1)-1)/2;
        for(int i=first_non_leaf;i>=0;i--){
            push_down_in_maxheap(l, i, l.size());
        }
    }
    public static void heapsort(List<Integer> l){
        heapify(l);
        int heapSize = l.size();
        for(int i=l.size()-1;i>=0;i--){
            swap(l, 0, i);
            heapSize--;
            push_down_in_maxheap(l, 0, heapSize);
        }
    }
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>(Arrays.asList(50,40,30,20,10));
        System.out.println(l);
        heapsort(l);
        System.out.println(l);
    }
}