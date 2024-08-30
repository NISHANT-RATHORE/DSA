import java.util.Scanner;

public class transpose {
    static void print2darr(int [][] arr,int r,int c){
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    static void transpose(int [][] arr,int r,int c){
        int [][] transpose = new int[r][c];
        for(int i=0;i<c;i++){
            for(int j=0;j<r;j++){
                transpose[i][j] = arr[j][i];
            }
        }
        print2darr(transpose, r, c);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [][] arr = new int [3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println("transposed array is");
        transpose(arr, 3, 3);
    }
    
}
