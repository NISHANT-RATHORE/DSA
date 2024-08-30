import java.util.Scanner;

public class prefixsumin_2darray {
    static void print2darr(int [][] arr,int r,int c){
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    static void prefixarralongc(int [][] arr){
        int r = arr.length;
        int c = arr[0].length;
        for(int i=0;i<r;i++){
            for(int j=1;j<c;j++){
                arr[i][j] += arr[i][j-1];
            }
        }

        for(int j=0;j<c;j++){
            for(int i=1;i<r;i++){
                arr[i][j] += arr[i-1][j];
            }
        }
        print2darr(arr, r, c);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [][] arr = new int [4][4];
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        prefixarralongc(arr);
    }
    
}
