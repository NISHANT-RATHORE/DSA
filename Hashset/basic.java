import java.util.HashSet;

public class basic {
    public static int maxStreak(int [] arr){
        HashSet<Integer> mp = new HashSet<>();
        int maxStreak=1;
        for(int val:arr) mp.add(val);
        for(int num:mp){
            if(!mp.contains(num-1)){
                int currNum = num;
                int currStreak = 1;
                while (mp.contains(currNum+1)) {
                    currStreak++;
                    currNum++;
                }
                maxStreak = Math.max(currStreak,maxStreak);
            }
        }
        return maxStreak;
    }
    public static void main(String[] args) {
        int [] arr = {100,4,200,1,3,2};
        int max = maxStreak(arr);
        System.out.println(max);
    }
    
}