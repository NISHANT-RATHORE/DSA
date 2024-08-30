import java.util.*;
public class firstMultipleofk {
    static void firstMultipleofk(int n,int k){
        if(k==1){
            System.out.print(n+" ");
            return;
        }
        firstMultipleofk(n, k-1);
        System.out.print(n*k+" ");
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        firstMultipleofk(n,k);
    }
}
