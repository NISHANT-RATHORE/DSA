import java.util.*;

public class FirstNegativeIntegerInSlidingWindow {
    public static void main(String[] args) {
        long[] arr = {-8, 2, 3, -6, 10};
        int k = 2;
        long[] ans = printFirstNegativeInteger(arr, arr.length, k);
        Arrays.stream(ans).forEach(x -> System.out.print(x + " "));
    }

    public static long[] printFirstNegativeInteger(long[] arr, int n, int k) {
        long [] res = new long[n-k+1];
        Queue<Long> queue = new LinkedList<>();
        int idx =0;
        while(idx<k){
            if(arr[idx]<0) queue.offer(arr[idx]);
            idx++;
        }
        res[0] = queue.isEmpty() ? 0L : queue.peek();
        for(int i=1;i<n-k+1;i++){
            //remove prev element
            if(arr[i-1]<0) queue.poll();

            //add next element
            if(arr[i+k-1]<0) queue.offer(arr[i+k-1]);

            //check if element can add or not
            res[i] = queue.isEmpty() ? 0L : queue.peek();
        }
        return res;
    }
}