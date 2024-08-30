public class rotated_arr {
    static int rotatedarr(int[] arr) {
        int st = 0, n = arr.length, end = n - 1, ans = -1;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (arr[mid] > arr[n - 1])
                st = mid + 1;
            else if (arr[mid] <= arr[n - 1]) {
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
    }

    static int findTarget(int[] arr, int target) {
        int st = 0, n = arr.length, end = n - 1;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < arr[end]) {
                if (target > arr[mid] && target <= arr[end])
                    st = mid + 1;
                else
                    end = mid - 1;
            } else {
                if (target >= arr[st] && target < arr[mid])
                    end = mid - 1;
                else
                    st = mid + 1;
            }
        }
        return -1;

    }

    static int findTargetInDA(int[] arr, int target) {
        int st = 0, n = arr.length, end = n - 1;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[st] == arr[mid] && arr[mid] == arr[end]) {
                st++;
                end--;
            } else if (arr[mid] <= arr[end]) {
                if (target > arr[mid] && target <= arr[end])
                    st = mid + 1;
                else
                    end = mid - 1;
            } else {
                if (target >= arr[st] && target < arr[mid])
                    end = mid - 1;
                else
                    st = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 4, 5, 1, 2 };
        int[] arr2 = {  1 ,3, 3, 4, 5 ,8, 9, 11, 15 ,15 };
        // System.out.println(rotatedarr(arr));
        // System.out.println(findTarget(arr, 5));
        System.out.println(findTargetInDA(arr2, 5));
    }
}
