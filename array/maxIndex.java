public class maxIndex {
    public static int findMaxIndex(int[] arr) {
        int n = arr.length;
        int maxIndex = -1;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] < arr[j] && j - i > maxIndex) {
                    maxIndex = j - i;
                }
            }
        }

        return maxIndex;
    }

    public static void main(String[] args) {
        int[] arr = { 34, 8, 10, 3, 2, 80, 30, 33, 1 };
        int maxIndex = findMaxIndex(arr);
        System.out.println("Maximum index difference is: " + maxIndex);
    }
}
