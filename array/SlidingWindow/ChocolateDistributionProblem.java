import java.util.*;

public class ChocolateDistributionProblem {
    public static void main(String[] args) {
        ArrayList<Integer> chocolates = new ArrayList<>(Arrays.asList(3, 4, 1, 9, 56, 7, 9, 12));
        int students = 5;
        System.out.println(findMinDiff(chocolates,chocolates.size(),students));
    }
    public static long findMinDiff (ArrayList<Integer> a, int n, int k)
    {
        // your code here
        long res = Integer.MAX_VALUE;
        Collections.sort(a);
        res = Math.min(res,a.get(k-1)-a.getFirst());
        for(int i=1;i<n-k+1;i++){
            res = Math.min(res,a.get(i+k-1)-a.get(i));
        }
        return res;
    }
}
