import java.util.Stack;

public class prevGreaterElement {
    static int [] prevGreater(int [] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int [] res = new int[n];
        res[0] = -1;
        st.push(arr[0]);
        for(int i=1;i<n;i++){
            while (!st.isEmpty() && st.peek() < arr[i]) {
                st.pop();
            }
            
            if(st.isEmpty()) res[i] = -1;
            else{
                res[i] = st.peek();
            }
            st.push(arr[i]);
        }
        return res;

    }
    public static void main(String[] args) {
        int [] arr = {1,3,2,1,8,6,3,4};
        int [] ans = prevGreater(arr);
        for(int val:ans){
            System.out.print(val+" ");
        }
    }
}
