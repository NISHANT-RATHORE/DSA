import java.util.*;
// we store unused sumin set and at every sum we delete used and check whether unsed is exist in previous or not
public class isSumExist {
    public static void main(String[] args) {
        int[] arr = {2, 8, 2, 6, -6, 3, 2};
        int k = 5;
        boolean isSum = bruteForce(arr,k);
        System.out.println(isSum);

        boolean isSum2 = optimised(arr,k);
        System.out.println(isSum2);
    }

    private static boolean optimised(int[] arr, int k) {
        int n = arr.length;
        Set<Integer> st = new HashSet<>();
        st.add(0);
        int sum = 0;
        for(int i = 0;i < n ; i++){
            sum += arr[i];
            if(st.contains(sum - k)) return true;
            st.add(sum);
        }
        return false;
    }

    private static boolean bruteForce(int[] arr, int k) {
    for (int i = 0; i < arr.length; i++) {
        int sum = 0;
        for (int j = i; j < arr.length; j++) {
            sum += arr[j];
            if (sum == k) return true;
        }
    }
    return false;
    }
}
