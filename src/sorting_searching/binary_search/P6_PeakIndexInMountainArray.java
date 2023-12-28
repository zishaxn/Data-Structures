package sorting_searching.binary_search;

//https://leetcode.com/problems/peak-index-in-a-mountain-array/
//852. Peak Index in a Mountain Array

//https://leetcode.com/problems/find-peak-element/submissions/  similar
/* Approach:
* We know that its sorted array and first its ascending and then after peak its descending,
* so when we apply BS and the element next to mid is less than mid then it means that we are in descending part ,
* so its possible that our peak element might be the mid or may exist on the left hand of the mid and hence we wil set the end to mid-1;.
*
* Similarly, the element next to mid is greater than mid then it means that we are in ascending part ,
 * so its possible that our peak element might be the mid or may exist on the right hand of the mid. and hence we wil set the start to mid+1;
 *
 * and when we violate the condition we will return the start because that will be the peak element*/




public class P6_PeakIndexInMountainArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4,5,4, 3, 2, 1};
        System.out.println(peakIndexOptimized(arr));
    }

    private static int peakIndexOptimized(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private static int peakIndexBrute(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] < arr[i]) {
                return i;
            }
        }
        return -1;
    }


}
