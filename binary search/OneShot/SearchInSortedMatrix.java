public class SearchInSortedMatrix {
    //see alternate solution on youtube
    public static void main(String[] args) {
        int [][] arr = {{1,3,5},{2,6,9},{3,6,9}};
        System.out.println(searchMatrix(arr,69));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        for(int [] arr : matrix){
            if(isFound(arr,target)) return true;
        }
        return false;
    }
    private static boolean isFound(int [] arr,int key){
        int st = 0;
        int end = arr.length - 1;
        while (st<=end){
            int mid = st + (end - st)/2;
            if(arr[mid] == key) return true;
            else if(arr[mid] < key) st = mid + 1;
            else end = mid - 1;
        }
        return false;
    }
}
