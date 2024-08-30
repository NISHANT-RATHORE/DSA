import java.util.Scanner;

public class factorial {
    static int fact(int n){
        if(n==1){
            return 1;
        }
        int fact = fact(n-1) * n;
        return fact;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fact(n));
    }
}
