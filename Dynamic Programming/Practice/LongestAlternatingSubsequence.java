package Practice;

public class LongestAlternatingSubsequence {
    public static void main(String[] args) {
        int [] arr = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        System.out.println(alternatingMaxLength(arr.length-1,arr));
//        System.out.println(zigzag(new int[]{5,1,4}));
    }
    public static int alternatingMaxLength(int idx, int[] arr) {
        if(idx<0) return 0;
        // code here
        int pick = 0;
        if(zigzag(arr)){
            return 1 + alternatingMaxLength(idx-1,arr);
        }
        int notpick = alternatingMaxLength(idx-1,arr);
        return Math.max(pick,notpick);
    }

    private static boolean zigzag(int[] arr) {
        if (arr.length < 2) return true; // Arrays with less than 2 elements are trivially zigzag.
        for (int i = 1; i < arr.length - 1; i++) {
            boolean isGreater = arr[i] > arr[i - 1] && arr[i] > arr[i + 1];
            boolean isSmaller = arr[i] < arr[i - 1] && arr[i] < arr[i + 1];

            if (!isGreater && !isSmaller) {
                return false; // Current element does not satisfy the zigzag condition.
            }
        }
        return true; // The array satisfies the zigzag condition.
}
}
