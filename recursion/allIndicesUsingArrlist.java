import java.util.ArrayList;

public class allIndicesUsingArrlist {
    static ArrayList<Integer> allIndicesUsingArrlist(int[]arr,int n,int target,int idx){
        ArrayList <Integer> ans = new ArrayList<>();
        if(idx >= n){
            return new ArrayList<>();
        }
        if(arr[idx]==target){
            ans.add(idx);
        }
        ArrayList<Integer> smallans = allIndicesUsingArrlist(arr, n, target, idx+1);
        ans.addAll(smallans);
        return ans;

    }
    public static void main(String[] args) {
        int [] arr = {2,3,4,2,2,3,2,3,2};
        ArrayList <Integer> ans = allIndicesUsingArrlist(arr,arr.length,2,0); 
        for(Integer i:ans){
            System.out.println(i);
        }      
    }
}