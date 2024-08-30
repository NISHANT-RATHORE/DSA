// package Interview_Questions;
import java.util.*;
public class balanced {
    static boolean isBalanced(String str){
        Stack<Character> ch = new Stack<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('){
                ch.push('(');
            }
            else if(str.charAt(i) == ')'){
                if(ch.size()==0) return false;
                else if(ch.peek()=='('){
                    ch.pop();
                }
            }
        }
        if(ch.isEmpty()) return true;
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(isBalanced(str));
        sc.close();
    }
}
