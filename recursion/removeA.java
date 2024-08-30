import java.util.*;

public class removeA {
    static String removeA2(String str) {
        // base case
        if (str.length() == 0)
            return "";

        // recursive work
        String smallans = removeA2(str.substring(1));

        // self work
        char currchar = str.charAt(0);
        if (currchar != 'a')
            return currchar + smallans;
        else
            return smallans;

    }

    static String removeA(String str, int idx) {
        // base case
        if (idx == str.length())
            return "";

        // recursive work
        String smallans = removeA(str, idx + 1);

        // self work
        char currchar = str.charAt(idx);
        if (currchar != 'a')
            return currchar + smallans;
        else
            return smallans;
    }

    static String reverseStr(String str, int idx) {
        if (idx == str.length())
            return "";
        String smallans = reverseStr(str, idx + 1);
        return smallans + str.charAt(idx);
    }

    static String reverseStr2(String str) {
        if (str.length() == 0)
            return "";
        String smallans = reverseStr2(str.substring(1));
        return smallans + str.charAt(0);
    }

    static boolean palindrome(String str) {
        String reversestr = reverseStr(str, 0);
        if (reversestr.equals(str))
            return true;
        else
            return false;
    }

    static boolean palindrome2(String str, int l, int r) {
        if (l >= r) return true;
        return (str.charAt(l) == str.charAt(r) && palindrome2(str, l + 1, r - 1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(removeA(str, 0));
        System.out.println(removeA2(str));
        System.out.println(reverseStr(str, 0));
        System.out.println(reverseStr2(str));
        System.out.println(palindrome(str));
        System.out.println(palindrome2(str, 0, str.length()-1));
    }
}
