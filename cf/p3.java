import java.util.Scanner;

public class p3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String[] s = { "ABC", "BCA", "ACB", "BAC", "CAB", "CBA" };
        while (t > 0) {
            for (int i = 0; i < 2; i++) {
                String str = sc.next();
                char[] cArray = str.toCharArray();
                for (int j = 0; i < s.length; i++) {
                    if (str == s[j]) {
                        // do nothing;
                    }
                }
                for (int k = 0; k < cArray.length; k++) {
                    if (cArray[0] == '?') {
                        if (cArray[1] == 'A' && cArray[2] == 'B') {
                            System.out.println('C');
                            break;
                        } else if (cArray[1] == 'B' && cArray[2] == 'C') {
                            System.out.println('A');
                            break;
                        } else {
                            System.out.println('B');
                            break;
                        }

                    }
                    if (cArray[1] == '?') {
                        if (cArray[0] == 'A' && cArray[2] == 'B') {
                            System.out.println('C');
                            break;
                        } else if (cArray[0] == 'B' && cArray[2] == 'C') {
                            System.out.println('A');
                            break;
                        } else {
                            System.out.println('B');
                            break;
                        }
                    }
                    if (cArray[2] == '?') {
                        if (cArray[0] == 'A' && cArray[1] == 'B') {
                            System.out.println('C');
                            break;
                        } else if (cArray[0] == 'B' && cArray[1] == 'C') {
                            System.out.println('A');
                            break;
                        } else {
                            System.out.println('B');
                            break;
                        }
                    }
                }
            }
            t--;
        }

    }

}
