import java.util.Scanner;

public class powUsingRecursion {
    static int pow1(int p,int q){
        if(q==0) return 1;
        return pow1(p,q-1)*p;
    }
    static int pow2(int p,int q){
        if(q==0) return 1;
        int tmp = pow2(p, q/2);
        if(q%2==0) return tmp*tmp;
        else return p*tmp*tmp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc. nextInt();
        int q = sc.nextInt();
        System.out.println(pow2(p,q));
    }
}
