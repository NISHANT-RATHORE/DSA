import java.util.*;
public class string{
    public static void main(String[] args) {
        // String str = "zbc";
        // String gtr = "bbc";
        // int res = str.compareTo(gtr);
        // System.out.println(res);
        String str = "abcd";
        System.out.println(str.length());
        // int n = str.length();
        for(int i=0;i<=3;i++){
            for(int j=i+1;j<=4;j++){
                System.out.print(str.substring(i, j)+" ");
            }
        }

    }
}