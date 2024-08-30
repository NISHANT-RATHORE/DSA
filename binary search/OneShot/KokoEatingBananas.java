public class KokoEatingBananas {
    public static void main(String[] args) {
        int [] piles = {3,6,7,11};
        int h = 8;
        System.out.println(minEatingSpeed(piles,h));
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int st = 1;
        int ans = 0;
        int end = Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            if(piles[i] > end){
                end = piles[i];
            }
        }
        while(st <= end){
            int mid = st + (end - st)/2;
            if(isPossible(piles,mid,h)){
                ans = mid;
                end = mid - 1;
            }
            else st = mid + 1;
        }
        return ans;
    }
    private static boolean isPossible(int [] piles,int maxSpeed,int hours){
        int hourSpeed = 0;
        for(int i=0;i<piles.length;i++){
            hourSpeed += (piles[i]%maxSpeed!=0) ? piles[i]/maxSpeed + 1 : piles[i]/maxSpeed;
            if(hourSpeed > hours) return false;
        }
        return true;
    }
}
