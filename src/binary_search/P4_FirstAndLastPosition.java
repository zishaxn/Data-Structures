package binary_search;


//34. Find First and Last Position of Element in Sorted Array
/*approach is that we will run the BS twice once for start index and once for end.
 suppose we are running for first position then we found the element instead of returning it
 we will store it in and set the end to mid -1 (to make sure that there is not element behind the current position)
and when we will run for last position , and when we find we will store the result in a variable
 and the set the start to mid +1 so make sure there is no element after this position.*/


import java.util.Arrays;

public class P4_FirstAndLastPosition {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 6, 7};
        int target = 2;
        System.out.println(Arrays.toString(firstAndLastPosition(arr, target)));

    }

    //    optimized 2 * O(logn)

    private static int[] firstAndLastPosition(int[] arr, int target) {
        int[] ans = {-1, -1};
        ans[0] = search(arr, target, true);
        ans[1] = search(arr, target, false);
        return ans;

    }

    private static int search(int[] arr, int target, boolean firstIndex) {
        int ans = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                ans = mid;
                if (firstIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }

    //    brute force 2*O(n)
    private static int[] firstAndLastPositionBrute(int[] arr, int target) {
        int[] ans = {-1, -1};
        int start = searchStart(arr, target);
        if (start >= 0) {
            ans[0] = start;
            ans[1] = start;
        }
        int end = searchEnd(arr, target);
        if (end >= 0) {
            ans[1] = end;
        }

        return ans;
    }

    private static int searchEnd(int[] arr, int target) {
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] == target) {
                return i;
            }
        }
        return Integer.MIN_VALUE;
    }

    private static int searchStart(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return Integer.MIN_VALUE;
    }

}