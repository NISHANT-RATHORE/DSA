public class SmallestSubarrayWithSumGreaterThanX {
    public static void main(String[] args) {
        int [] arr = {1, 4, 45, 6, 0, 19};
        int x = 51;
        System.out.println(smallestSubWithSum(x,arr));
    }
    public static int smallestSubWithSum(int x, int[] arr) {
        // Your code goes here
        int minLen = Integer.MAX_VALUE;
        int n = arr.length;
        int len = 0;
        int windowStart = 0;
        int windowEnd = 0;
        int sum = 0;
        while (windowEnd<n){
            //expansion
            sum += arr[windowEnd];
            if(sum > x){
                len = windowEnd - windowStart + 1;
                minLen = Math.min(minLen,len);
                //shrinking
                while (windowStart < windowEnd && sum > x){
                    sum -= arr[windowStart];
                    windowStart++;
                    if(sum>x){
                        len = windowEnd - windowStart + 1;
                        minLen = Math.min(minLen,len);
                    }
                }
            }
            windowEnd++;
        }
        return minLen==Integer.MAX_VALUE ? 0 : minLen;
    }
}
