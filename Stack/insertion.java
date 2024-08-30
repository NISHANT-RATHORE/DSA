import java.util.*;
public class insertion {
    static Stack<Integer> insertionAtBegin(Stack<Integer> st,int val){
        Stack<Integer> tmp = new Stack<>();
        while (st.size()>0) {
            tmp.push(st.pop());
        }
        st.push(val);
        while(tmp.size()>0){
            st.push(tmp.pop());
        }
        return st;
    }
    static Stack<Integer> insertionAtGivenIdx(Stack<Integer> st,int idx,int val){
        Stack<Integer> tmp = new Stack<>();
        while (st.size()>idx) {
            tmp.push(st.pop());
        }
        st.push(val);
        while(tmp.size()>0){
            st.push(tmp.pop());
        }
        return st;
    }
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        Stack<Integer> newst = insertionAtGivenIdx(st,2,1036);
        System.out.println(newst);


    }
}
