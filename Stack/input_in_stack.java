import java.util.*;

public class input_in_stack {
    static Stack<Integer> copyStack(Stack<Integer> st){
        Stack<Integer> rev = new Stack<>();
        while(st.size()>0){
            rev.push(st.pop());
        }
        Stack<Integer> cp = new Stack<>();
        while (rev.size()>0) {
            cp.push(rev.pop());
        }
        return cp;
    }
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-->0){
            int x = sc.nextInt();
            st.push(x);
        }
        System.out.println(st);
        Stack<Integer> copy = copyStack(st);
        System.out.println(copy);
    }
}
