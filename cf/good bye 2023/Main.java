import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0; i<t; i++){
            int n = sc.nextInt();
            int maxLowerBound = Integer.MIN_VALUE;
            int minUpperBound = Integer.MAX_VALUE;
            HashSet<Integer> notEqual = new HashSet<>();
            for(int j=0; j<n; j++){
                int a = sc.nextInt();
                int x = sc.nextInt();
                if(a == 1){
                    maxLowerBound = Math.max(maxLowerBound, x);
                } else if(a == 2){
                    minUpperBound = Math.min(minUpperBound, x);
                } else if(a == 3){
                    notEqual.add(x);
                }
            }
            int count = 0;
            for(int k=maxLowerBound; k<=minUpperBound; k++){
                if(!notEqual.contains(k)){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
