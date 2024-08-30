import java.util.Stack;

public class display_using_arr {
    public static void Displayrev(Stack<Integer> st){
        if(st.isEmpty()) return;
        System.out.print(st.peek()+" ");
        st.pop();
        Displayrev(st);
    }
    public static void Display(Stack<Integer> st){
        if(st.isEmpty()) return;
        int top = st.pop();
        Display(st);
        System.out.print(top + " ");
        st.push(top);
    }
    public static void Displayrev2(Stack<Integer> st){
        if(st.size()==1) return;
        int top = st.pop();
        Displayrev2(st);
        insertionAtBegin(st, top);
    }
    static void insertionAtBegin(Stack<Integer> st,int val){
        if(st.isEmpty()){
            st.push(val);
            return;
        }
        int top = st.pop();
        insertionAtBegin(st, val);
        st.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        int n = st.size();
        int [] arr = new int[n];
        for(int i = n-1 ; i>=0 ; i--){
            arr[i] = st.pop();
        }
        for(int i=0;i<n;i++){
            int y = arr[i];
            st.push(y);
        }
        // System.out.println(st);
        // Displayrev(st);
        Display(st);
        System.out.println();
        Displayrev2(st);
        Display(st);

    }
}
