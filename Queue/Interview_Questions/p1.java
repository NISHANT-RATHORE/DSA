//reversing the queue
import java.util.*;

public class p1{
    public static Queue<Integer> revQueue(Queue<Integer> q){
        Stack<Integer> st = new Stack<>();
        while(q.size()>0){
            st.push(q.remove());
        }
        while (st.size()>0) {
            q.add(st.pop());
        }
        return q;
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        System.out.println(q);
        Queue<Integer> rev = revQueue(q);
        System.out.println(rev);
    }

}