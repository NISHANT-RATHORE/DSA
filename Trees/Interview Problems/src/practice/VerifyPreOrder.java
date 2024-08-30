package practice;

public class VerifyPreOrder {
    public static void main(String[] args) {
        String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        System.out.println(isValidSerialization(preorder));
    }
    public static boolean isValidSerialization(String preorder) {
        char [] ch = preorder.toCharArray();
        if(ch[0]=='#') return false;
        for (int i=0;i<preorder.toCharArray().length;i++){
            if(preorder.toCharArray().length>=4 && ch[i]!='#' && ch[i+1]=='#' && ch[i+2]=='#' && ch[i+3]!='#') return false;


        }
        return false;
    }
}
