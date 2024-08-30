package oops_in_java;

public class fracition {
    static int gcd(int num,int den){
        int min = Math.min(num, den);
        for(int i=min;i>=1;i--){
            if(num%i==0 && den%i==0) return i;
        }
        return min;
    }
    static void additon(frac f1,frac f2){
        int ans_num = (f1.num*f2.den)+(f1.den*f2.num);
        int ans_den = f1.den*f2.den;
        System.out.println("addition of f1 and f2 is"+" "+ans_num+"/"+ans_den);
    }
    static void subtraction(frac f1,frac f2){
        int ans_num = (f1.num*f2.den)-(f1.den*f2.num);
        int ans_den = f1.den*f2.den;
        System.out.println("subtraction of f1 and f2 is"+" "+ans_num+"/"+ans_den);
    }
    public static class frac {
        int num;
        int den;

        public frac(int n, int d) {
            num = n;
            den = d;
        }
        public void simplify(frac f1){
            int n = gcd(num, den);
            num /= n;
            den /= n;
            System.out.println("simplifies fraction f1 is"+f1.num+"/"+f1.den);
        }
    }

        public static void main(String[] args) {
            frac f1 = new frac(2, 8);
            frac f2 = new frac(4, 5);
            System.out.println("fraction f1 is"+f1.num+"/"+f1.den);
            System.out.println("simplify of f1 is:");
            f1.simplify(f1);
            System.out.println("fraction f2 is"+f2.num+"/"+f2.den);
            additon(f1,f2);
            subtraction(f1,f2);
        }
    

}
