package binary_search;

public class P9_FindRotationCount {
    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 0, 1, 2, 3, 4};
        //here the array is rotated 3 times , basically return the position of pivot
        System.out.println(findRotation(arr));
    }

    private static int findRotation(int[] arr) {
        int pivot = findPivot(arr);
        return pivot + 1;
    }

    private static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
//            4 cases

//            next element smaller that current in a mountain array
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
//            similar to above
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
//            pivot exist on right of mid
            if (arr[mid] >= arr[start]) {
                start = mid + 1;
//                similar to above
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

}
