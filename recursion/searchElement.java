import java.util.Scanner;

public class searchElement {
    static int searchElement(int [] arr,int target,int idx){
        if(idx>=arr.length) return -1;
        if(arr[idx]==target) return idx;
        return searchElement(arr, target, idx+1);
    }

    static void allsearchElement(int [] arr,int target,int idx){
        if(idx>=arr.length) return ;
        if(arr[idx]==target) System.out.println(idx+" ");
        allsearchElement(arr, target, idx+1);;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] arr = {2,5,6,8,3,4};
        int [] arr2 = {2,5,2,2,2,4};

        System.out.println(searchElement(arr,10,0));
        allsearchElement(arr2, 2, 0);
    }
}
