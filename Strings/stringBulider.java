import java.util.*;

public class stringBulider {
    // convert upper -> lower and vice versa
    static StringBuilder toggle(StringBuilder str){
        for(int i=0;i<str.length();i++){

            boolean flag = true; //char is capital
            char ch = str.charAt(i);
            if(Character.isAlphabetic(ch))
            {
                if(ch==' ') continue;
                int ascii = (int)ch;
                if(ch>=97) flag = false;
                if(flag == true){ //if char is capital
                    ascii += 32;
                    char ans = (char)ascii;
                    str.setCharAt(i, ans);
                }
                else{
                    ascii -= 32;
                    char ans = (char)ascii;
                    str.setCharAt(i, ans);
                }
            }
        
        }
        return str;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder str = new StringBuilder(sc.nextLine());
        // str.append("world");
        // System.out.println(str);
        System.out.println(toggle(str));
    }
}
