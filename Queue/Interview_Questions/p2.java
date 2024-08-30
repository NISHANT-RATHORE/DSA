//reversing the queue
import java.util.*;

public class p2{
    public static Queue<Integer> revQueue(Queue<Integer> q,int k){
        Stack<Integer> st = new Stack<>();
        Queue<Integer> tq = new LinkedList<>();
        while(k-->0){
            st.push(q.remove());
        }
        while(q.size()>0){
            tq.add(q.remove());
        }
        while(st.size()>0){
            q.add(st.pop());
        }
        while(tq.size()>0){
            q.add(tq.remove());
        }
        return q;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        int k = sc.nextInt();
        Queue<Integer> rev = revQueue(q,k);
        System.out.println(rev);
    }

}