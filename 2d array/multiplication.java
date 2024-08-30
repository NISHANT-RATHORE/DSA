// if wala case nhi aa rha hai 
import java.util.Scanner;

public class multiplication {
    static void print2darr(int[][] arr, int r, int c) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void multiply(int[][] a1, int r1, int c1, int[][] a2, int r2, int c2) {
        int [][] mul = new int[r1][c2];
        if(r1!=c2){
            System.out.println("multiplication not possible");
        }
        else{
            for(int i=0;i<r1;i++){
                for(int j=0;j<c2;j++){
                    for(int k=0;k<c1;k++){
                        mul[i][j] += a1[i][k] * a2[k][j];
                        
                    }
                }
            }
            print2darr(mul, r1, c2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a1 data");
        //data for first array
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        int[][] a1 = new int[r1][c1];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                a1[i][j] = sc.nextInt();
            }
        }

        //data for second array
        System.out.println("enter a2 data");
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();
        int[][] a2 = new int[r2][c2];
        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                a2[i][j] = sc.nextInt();
            }
        }
        System.out.println("multipliction of your given array is");
        multiply(a1, r1, c1, a2, r2, c2);
        sc.close();
    }
}
