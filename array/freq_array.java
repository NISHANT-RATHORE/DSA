import java.util.Scanner;

public class freq_array {
    static int [] Frequency_array(int []arr){
        int [] freq = new int[100005];
        for(int i=0;i<arr.length;i++){
            freq[arr[i]]++;
        }
        return freq;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = {1,2,3,1,5,4,4,5};
        int t = sc.nextInt();
        int [] ans = Frequency_array(arr);
        while(t>0){
            int x = sc.nextInt();
            if(ans[x]>0){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
            t--;
        }
    }
}
