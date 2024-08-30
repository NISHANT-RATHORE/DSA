import java.util.PriorityQueue;
 
class MedianFinder {
    private PriorityQueue<Integer> maxHeap; // stores the lower half of the stream
    private PriorityQueue<Integer> minHeap; // stores the upper half of the stream
 
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }
 
    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }
 
        // balance the heaps
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
 
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }
}
 
public class Main {
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        System.out.println(mf.findMedian()); // Output: 1.5
        mf.addNum(3);
        System.out.println(mf.findMedian()); // Output: 2
        mf.addNum(4);
        mf.addNum(5);
        mf.addNum(6);
        System.out.println(mf.findMedian()); // Output: 3.5
        mf.addNum(7);
        System.out.println(mf.findMedian()); // Output: 4
    }
}