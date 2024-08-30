import java.util.*;
public class basic{
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(23);
        st.push(90);
        st.push(5);
        System.out.println(st.peek());
        st.pop();
        System.out.println(st);
    }
}