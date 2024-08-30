import java.util.Stack;

public class stockSpan {
    static int [] prevGreater(int [] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int [] res = new int[n];
        st.push(0);
        res[0] = 1;
        for(int i=1;i<n;i++){
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            
            if(st.isEmpty()) res[i] = i+1;
            else{
                res[i] = i-st.peek();
            }
            st.push(i);
        }
        return res;

    }
    public static void main(String[] args) {
        int [] arr = {100,80,60,70,60,75,85};
        int [] ans = prevGreater(arr);
        for(int val:ans){
            System.out.print(val+" ");
        }
    }
}
