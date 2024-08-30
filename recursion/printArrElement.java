public class printArrElement {
    static void printArrElement(int []arr,int idx){
        if(idx == arr.length) return;
        System.out.print(arr[idx]+" ");
        printArrElement(arr, idx+1);
    }
    static int maxinarr(int[] arr,int idx){
        if(idx==arr.length-1) return arr[idx];
        int s = maxinarr(arr, idx+1);
        return Math.max(arr[idx],s);
    }
    static int sumofeleinArr(int [] arr,int idx){
        if(idx==arr.length) return 0;
        int s = sumofeleinArr(arr, idx+1);
        return arr[idx]+s;
    }
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7};
        System.out.println("elements in array are:");
        printArrElement(arr, 0);
        System.out.println();
        System.out.println("max element in arr is"+" "+maxinarr(arr, 0));
        System.out.println("sum of elements in array is"+" "+sumofeleinArr(arr, 0));
    }
}
