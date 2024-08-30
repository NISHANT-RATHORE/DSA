import java.util.Deque;
import java.util.LinkedList;

public class deque_basic {
    public static void main(String[] args) {
        Deque<Integer> dq = new LinkedList<>();
        dq.add(1);
        dq.add(2);
        dq.add(3);
        dq.addFirst(4);
        dq.addLast(5);
        dq.removeFirst();
        dq.removeLast();
        System.out.println(dq.peekFirst());
        System.out.println(dq.peekLast());
        System.out.println(dq);
    }
}