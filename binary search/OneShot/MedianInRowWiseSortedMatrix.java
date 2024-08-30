public class MedianInRowWiseSortedMatrix {
    public static void main(String[] args) {
        int [][] arr = {{1,3,5},{2,6,9},{3,6,9}};
        int R = arr.length;
        int C = arr[0].length;
        System.out.println(median(arr,R,C));
    }
    private static int median(int matrix[][], int R, int C) {
        // code here
        int N = R*C;
        int MedianIndex = N/2;
        int st = 1;
        int end = 2000;
        while(st<=end){
            int assumedMedian = st + (end-st)/2;
            int lesserElements = helper(matrix,assumedMedian);
            if(lesserElements <= MedianIndex) st = assumedMedian + 1;
            else end = assumedMedian - 1;
        }
        return st;
    }
    private static int helper(int [][] matrix,int median){
        int noOfLesserElement = 0;
        for(int i=0;i<matrix.length;i++){
            int st = 0;
            int end = matrix[i].length-1;
            while (st<=end){
                int mid = st + (end - st)/2;
                if(matrix[i][mid] <= median) st = mid+1;
                else end = mid - 1;
            }
            noOfLesserElement += st;
        }
        return noOfLesserElement;
    }
}
