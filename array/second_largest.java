import java.util.Scanner;

public class second_largest {
    static void printarr(int [] arr){
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
    static int largest(int[] arr){
        int max = arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }

    static int secondlargest(int [] arr){
        int mx = largest(arr);
        for(int i=0;i<arr.length;i++){
            if(arr[i]==mx){
                arr[i]=Integer.MIN_VALUE;
            }
        }
        int smx = largest(arr);
        return smx;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] arr = new int[5];
        for(int i=0;i<5;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("mx is"+" "+largest(arr));
        System.out.println("smx is"+" "+secondlargest(arr));

    }
}
