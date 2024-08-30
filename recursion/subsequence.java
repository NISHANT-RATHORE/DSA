import java.util.*;

public class subsequence {
    static ArrayList<String> subsequence(String str) {
        ArrayList<String> ans = new ArrayList<>();
        // base case
        if (str == "") {
            ans.add("");
            return ans;
        }
        // recursive work
        char curr = str.charAt(0);
        ArrayList<String> smallans = subsequence(str.substring(1));

        // self work
        for (String ss : smallans) {
            ans.add(ss);
            ans.add(curr + ss);
        }
        return ans;
    }

    static String subsequence2(String str, String currans) {
        if (str.length() == 0) {
            System.out.println(currans);
            return " ";
        }
        char curr = str.charAt(0);
        String remString = str.substring(1);
        subsequence2(remString, currans + curr);
        subsequence2(remString, currans);
        return currans;
    }

    static String printPermutn(String str, String ans)
    {
 
        // If string is empty
        if (str.length() == 0) {
            System.out.print(ans + " ");
            return "";
        }
 
        for (int i = 0; i < str.length(); i++) {
 
            // ith character of str
            char ch = str.charAt(i);
 
            // Rest of the string after excluding
            // the ith character
            String ros = str.substring(0, i) +
                        str.substring(i + 1);
 
            // Recursive call
            printPermutn(ros, ans + ch);
        }
        return ans;
    }
    static void sumOfSSQ(int []arr,int n,int idx,int sum){
        if (idx >= 0) {
            System.out.println(sum);
            return;
        }
        sumOfSSQ(arr, n, idx+1, sum);
        sumOfSSQ(arr, n, idx+1, sum+arr[idx]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] arr = {2,4,5};
        String str = sc.next();
        ArrayList<String> sub = subsequence(str);
        // for(String ss : sub){
        // System.out.println(ss);
        // }
        // subsequence2(str, "");
        System.out.println(printPermutn(str, ""));

        // sumOfSSQ(arr, arr.length, 0, 0);
        
    }

}
