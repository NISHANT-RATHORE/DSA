package Memoiaztion;

// TC: O(2^n) - > O(n) 😘



public class robber_house{
    static int calls2 = 0;
    public static void main(String[] args) {
        int [] house = {1,2,3,1};
        int dp[] = new int[house.length];
        for(int i=0;i<house.length ;i++){
            dp[i] = -1;
        }
        System.out.println(robbery(house,0,dp));
        System.out.println("no of calls "+calls2);

    }

    private static int robbery(int[] house, int idx,int [] dp) {
        calls2++;
        if(idx == house.length - 1) return house[idx];
        if(idx >= house.length) return 0;
        if(dp[idx] != -1) return dp[idx];
        int pick = house[idx] + robbery(house,idx+2,dp);
        int not_pick = robbery(house,idx+1,dp);
        return dp[idx] = Math.max(pick,not_pick);

    }
}