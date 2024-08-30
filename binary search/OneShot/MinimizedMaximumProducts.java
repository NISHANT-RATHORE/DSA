public class MinimizedMaximumProducts {
    public static void main(String[] args) {
        int [] quantities = {11,6};
        int shops = 6;
        System.out.println(minimizedMaximum(shops,quantities));
    }
    public static int minimizedMaximum(int n, int[] quantities) {
        int res = -1;
        int length = quantities.length;
        int st = 1;
        int end = Integer.MIN_VALUE;
        for(int i=0;i<length;i++){
            if(quantities[i] > end){
                end = quantities[i];
            }
        }
        while(st<=end){
            int mid = st + (end - st)/2;
            if(isPossible(quantities,mid,n)){
                res = mid;
                end = mid - 1;
            } else st = mid + 1;
        }
        return res;
    }
    private static boolean isPossible(int [] quantities,int capacity,int shops){
        int currShops = 0;
        for(int i=0;i<quantities.length;i++){
            currShops  += quantities[i]/capacity;
            if(quantities[i]%capacity!=0) currShops++;
            if(currShops > shops) return false;
        }
        return true;
    }
}
