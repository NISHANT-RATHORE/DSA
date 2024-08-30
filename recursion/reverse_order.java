import java.util.Scanner;

public class reverse_order {
    static void pi(long n){
        if(n==1){
            System.out.print(1+" ");
            return;
        }
        System.out.print(n+" ");
        pi(n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        pi(n);

    }
    
}
