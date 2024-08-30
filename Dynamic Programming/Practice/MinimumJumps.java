package Practice;

public class MinimumJumps {
    public static void main(String[] args) {
        int [] stairs = {0,10,20};
        System.out.println(ways(stairs,stairs.length-1));
    }

    private static int ways(int[] stairs, int idx) {
    // Base case: If we are at the first step, no jumps are needed
    if (idx == 0) return 0;

    // If the current step is not reachable, return a large number
    if (stairs[idx] == -1) return -1;

    int minJumps = -1;
    // Try jumping from all previous steps within the range allowed by their values
    for (int i = 1; i <= idx; i++) {
        if (idx - i >= 0 && stairs[idx - i] >= i) {
            int jumps = ways(stairs, idx - i);
            // If the step is reachable, update minJumps
            if (jumps != Integer.MAX_VALUE) {
                minJumps = Math.min(minJumps, 1 + jumps);
            }
        }
    }
    return minJumps;
}
}
