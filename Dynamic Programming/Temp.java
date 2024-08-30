import java.util.*;

public class Temp {
    public static void main(String[] args) {
        ArrayList<Integer> heights = new ArrayList<>();
        heights.addAll(Arrays.asList(1,1,1,1,1));
        ArrayList<Integer> ans = closestFriends2(heights);
        ArrayList<Integer> ans2 = closestFriends3(heights);
        ans.stream().forEach(x-> System.out.print(x+" "));
        System.out.println();
        ans2.stream().forEach(x-> System.out.print(x+" "));
    }
    public static ArrayList<Integer> closestFriends(ArrayList<Integer> heights){
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        ans.add(-1);
        for(int i=1 ; i < heights.size();i++){
            if(heights.get(i-1) < heights.get(i)){
                if(!st.isEmpty()){
                    st.pop();
                    st.push(i-1);
                    ans.add(st.peek());
                }
                else{
                    st.push(i-1);
                    ans.add(st.peek());
                }
            }
            else if (heights.get(i-1) > heights.get(i)){
                 if (heights.get(st.peek()) < heights.get(i)) {
                        ans.add(st.peek());
                }

                else ans.add(-1);
            }
            else ans.add(-1);
        }
        return ans;
    }

    public static ArrayList<Integer> closestFriends2(ArrayList<Integer> heights) {
        int n = heights.size();
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(-1);
        int min = Integer.MAX_VALUE;
        for(int i=1;i<heights.size();i++){
            min = Math.min(heights.get(i),heights.get(i-1));
            if(min!=heights.get(i-1)) ans.add(-1);
            else if(heights.get(i)==heights.get(i-1)) ans.add(-1);
            else ans.add(i-1);
        }
        return ans;
    }

    public static ArrayList<Integer> closestFriends3(ArrayList<Integer> heights) {
        int n = heights.size();
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(-1);
        for(int i=1;i<heights.size();i++){
            if(heights.get(i) > heights.get(i-1)) ans.add(i-1);
            else ans.add(-1);
        }
        return ans;
    }
}
