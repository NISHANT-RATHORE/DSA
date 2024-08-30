// package Interview_Questions;
import java.util.*;
public class removeSubseq {
    static int [] removeSubsQ(int [] arr){
        Stack<Integer> tmp = new Stack<>();
        int n = arr.length,i=0;
        for(i=0;i<n;i++){
            if(tmp.isEmpty() || tmp.peek()!=arr[i]){
                tmp.push(arr[i]);
            }
            else if(tmp.peek()==arr[i]){
                if(i==n-1 || arr[i] != arr[i+1]){
                    tmp.pop();
                }
            }
            
        }
        int [] ans = new int[tmp.size()];
        for(int j = tmp.size()-1;j>=0;j--){
            ans[j] = tmp.pop();
        }
        return ans;
    }
    public static void main(String[] args) {
        int [] arr = {1,2,2,3,10,10,10,4,4,4,5,7,7,2};
        int [] ans = removeSubsQ(arr);
        for(int val:ans){
            System.out.println(val);
        }
    }
}
