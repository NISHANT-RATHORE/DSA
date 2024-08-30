import java.util.*;
public class sod {
    static int sod(int n){
        if(n>=0 && n<=9) return n;
        return sod(n/10)+n%10;
    }

    static int count(int n){
        if(n>=0 && n<=9) return 1;
        return count(n/10)+1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc. nextInt();
        System.out.println(count(n));

    }
}
