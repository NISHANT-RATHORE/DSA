package priority_queue;

import java.util.*;

public class kthLargest {
    public static int helper(List<Integer> arr,int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<arr.size();i++){
            if(pq.size()==k){
                if(arr.get(i)>pq.peek()){
                    pq.poll();
                    pq.add(arr.get(i));
                }
            } else {
                pq.add(arr.get(i));
            }
        }
        System.out.println(pq);
        return pq.peek();
    }
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(3,7,2,9,5));
        int kthLargest = helper(arr,3);
        System.out.println(kthLargest);
    }
}