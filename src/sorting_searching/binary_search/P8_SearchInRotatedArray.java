package sorting_searching.binary_search;


/*
 * This is different from prob 7 of search in mountain array even though both are mountain array ,
 * because in that Qs it was explicitly a mountain array and there might be same(duplicate) values!
 * but in this case it is a mountain array and all the values are distinct and in this QS
 * we may have less than 3 values also
 *
 * So the reason we cant use the prob 7 approach directly here is because:
 * in that question we had Explicitly mountain array of at least 3 size
 * so that we have to check left and right of peak index to get the answer and
 * in this question everything is smooth until there is an array that have size one
 * in this case when we get -1 from left size instead or returning we check in right be setting
 * the start as peak+1 which gives out of bound exception.*/



/*APPROACH:
 * Find Pivot:
 * Apply BS */

public class P8_SearchInRotatedArray {
    public static void main(String[] args) {
        int[] arr = {6, 7, 8, 9, 10, 1, 2, 3, 4};
        int target = 4;
        System.out.println(searchInRotatedArray(arr, target));
    }

    public static int searchInRotatedArray(int[] arr, int target) {
        int pivot = findPivot(arr);

        // it means that it is not a rotated sorted array
        if (pivot == -1) {
            return binarySearch(arr, target, 0, arr.length - 1);
        }

        //         now we have 3 cases

        if (arr[pivot] == target) {
            return pivot;
        }
        if (arr[0] > target) {
            return binarySearch(arr, target, pivot + 1, arr.length - 1);
        }
        return binarySearch(arr, target, 0, pivot - 1);
    }

    //     we need to find pivot to decide in which part of the array should we search
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
//           if pivot exist on right of mid
            if (arr[mid] > arr[start]) {
                start = mid + 1;
//                similar to above
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    private static int findPivotDuplicates(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            } else  if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                // skip the duplicates
                // NOTE: what if these elements at start and end were the pivot??
                // check if start is pivot
                if (start < end && arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;

                // check whether end is pivot
                if (end > start && arr[end] < arr[end - 1]) {
                    return end - 1;
                }
                end--;
            } else if (arr[mid] >= arr[start]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    private static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    //    for duplicate elements in array

}
