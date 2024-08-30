package priority_queue;

import java.util.*;

public class Kthoperation {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        int k = 3;
        arr.add(2);
        arr.add(4);
        arr.add(3);
        arr.add(1);
        arr.add(5);
        PriorityQueue<Integer> pq = new PriorityQueue<>(arr);
        for(int i=0;i<k;i++){
            int f = pq.remove();
            int s = pq.remove();
            pq.add(f*s);
        }
        while (pq.size()!=1) {
            pq.remove();
        }
        System.out.println(pq.peek());
    }
}
