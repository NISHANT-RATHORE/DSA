import java.util.Scanner;

public class sumOfnaturalNumbers {
    static int sumWithoutAltSign(int n){
        if(n==0) return 0;
        return sumWithoutAltSign(n-1)+n;
    }
    static int sumWithAltSign(int n){
        if(n==0) return 0;
        if(n%2==0) return sumWithAltSign(n-1)-n;
        else return sumWithAltSign(n-1)+n;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        System.out.println(sumWithoutAltSign(n));
        System.out.println(sumWithAltSign(n));
    }
}
