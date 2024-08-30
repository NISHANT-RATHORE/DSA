import java.util.Arrays;

public class AgressiveCows {
    public static void main(String[] args) {
        int [] stalls = {1, 2, 4, 8, 9};
        int cows = 3;
        System.out.println(solve(stalls.length,cows,stalls));
    }
    public static int solve(int n, int cows, int[] stalls) {
        Arrays.sort(stalls);
        int [] diff = new int[n];
        int st = 1;
        int end = stalls[n-1] - stalls[0];
        int ans = -1;
        while (st <= end){
            int mid = st + (end - st)/2;
            if(isPossible(cows,mid,stalls)){
                ans = mid;
                st = mid + 1;
            }
            else end = mid - 1;
        }
        return ans;
    }

    private static boolean isPossible(int cows, int minDistance, int[] stalls) {
        int cowCount = 1;
        int lastCowDistance = stalls[0];;
        for (int i=0;i<stalls.length;i++){
            if(stalls[i] - lastCowDistance >= minDistance){
                cowCount++;
                lastCowDistance = stalls[i];
            }
        }
        if(cowCount >= cows) return true;
        return false;
    }
}
