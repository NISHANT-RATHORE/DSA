package priority_queue;

import java.util.*;

public class k1k2smallestsum {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(20,8,22,4,12,10,14));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int k1 = 3,k2 = 6;
        for(int i=0;i<arr.size();i++){
            pq.add(arr.get(i));
            if(pq.size()>k2){
                pq.remove();
            }
        } //O(nlogn) + O(n-k2)
        pq.remove();
        int sum = 0;
        while(pq.size()!=k1){ //O(k2-k1)logk2
            sum += pq.remove(); 
        }
        System.out.println(sum);

    }
}